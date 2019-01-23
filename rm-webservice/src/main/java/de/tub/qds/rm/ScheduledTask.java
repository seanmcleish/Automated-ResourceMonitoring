package de.tub.qds.rm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import de.tub.qds.rm.models.consts.Disk;
import de.tub.qds.rm.models.consts.FileStore;
import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.Memory;
import de.tub.qds.rm.models.consts.Network;
import de.tub.qds.rm.models.consts.Processor;
import de.tub.qds.rm.models.consts.Process;
import de.tub.qds.rm.models.consts.Rate;
import de.tub.qds.rm.models.consts.System;
import de.tub.qds.rm.models.consts.repos.DiskValueRepo;
import de.tub.qds.rm.models.consts.repos.FileStoreRepo;
import de.tub.qds.rm.models.consts.repos.FileStoreValueRepo;
import de.tub.qds.rm.models.consts.repos.MeasurementRepo;
import de.tub.qds.rm.models.consts.repos.MemoryValueRepo;
import de.tub.qds.rm.models.consts.repos.NetworkValueRepo;
import de.tub.qds.rm.models.consts.repos.ProcessRepo;
import de.tub.qds.rm.models.consts.repos.ProcessValueRepo;
import de.tub.qds.rm.models.consts.repos.ProcessorValueRepo;
import de.tub.qds.rm.models.values.wrapper.ProcessJsonWrapper;

@Component
public class ScheduledTask {
	
	@Autowired
	MeasurementRepo measurementRepo;
	@Autowired
	DiskValueRepo diskValueRepo;
	@Autowired
	FileStoreRepo fileStoreRepo;
	@Autowired
	FileStoreValueRepo fileStoreValueRepo;
	@Autowired
	MemoryValueRepo memoryValueRepo;
	@Autowired
	NetworkValueRepo networkValueRepo;
	@Autowired
	ProcessorValueRepo processorValueRepo;
	@Autowired
	ProcessRepo processRepo;
	@Autowired
	ProcessValueRepo processValueRepo;
	@Autowired
	Environment environment;
	

	@Scheduled(fixedRate = 5000)
	public void execute_FIVE_SECONDS() {
		measure(Rate.FIVE_SECONDS);
	}
	
	@Scheduled(fixedRate = 10000)
	public void execute_TEN_SECONDS() {
		measure(Rate.TEN_SECONDS);
	}
	
	@Scheduled(fixedRate = 15000)
	public void execute_FIFTEEN_SECONDS() {
		measure(Rate.FIFTEEN_SECONDS);
	}
	
	@Scheduled(fixedRate = (30000))
	public void execute_THIRTY_SECONDS() {
		measure(Rate.THIRTY_SECONDS);
		
	}
	
	@Scheduled(fixedRate = 60000)
	public void execute_ONE_MINUTE() {
		measure(Rate.ONE_MINUTE);
		
	}
	
	@Scheduled(fixedRate = 300000)
	public void execute_FIVE_MINUTES() {
		measure(Rate.FIVE_MINUTES);
		
	}
	
	@Scheduled(fixedRate = 900000)
	public void execute_FIFTEEN_MINUTES() {
		measure(Rate.FIFTEEN_MINUTES);
		
	}
	
	@Scheduled(fixedRate = 1800000)
	public void execute_THIRTY_MINUTES() {
		measure(Rate.THIRTY_MINUTES);
		
	}
	
	@Scheduled(fixedRate = 3600000)
	public void execute_ONE_HOUR() {
		measure(Rate.ONE_HOUR);
		
	}
	
	@Scheduled(fixedRate = 7200000)
	public void execute_TWO_HOURS() {
		measure(Rate.TWO_HOURS);
		
	}
	@Scheduled(fixedRate = 21600000)
	public void execute_SIX_HOURS() {
		measure(Rate.SIX_HOURS);
		
	}
	
	@Scheduled(fixedRate = 43200000)
	public void execute_TWELVE_HOURS() {
		measure(Rate.TWELVE_HOURS);
		
	}
	
	@Scheduled(fixedRate = 64800000)
	public void execute_EIGHTEEN_HOURS() {
		measure(Rate.EIGHTEEN_HOURS);
		
	}
	
	@Scheduled(fixedRate = 86400000)
	public void execute_ONE_DAY() {
		measure(Rate.ONE_DAY);
		
	}
	
	public void measure(Rate rate){
		List<Measurement> measurements = measurementRepo.findByMeasurementRunningTrueAndMeasurementRate(rate);
		for (Measurement measurement : measurements) {
			try {
				readValues(measurement);
			} catch (UnirestException e) {
				java.lang.System.out.println("Error reading values: "+ e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	public void refreshPidsByMeasurement(Measurement measurement) throws UnirestException{
		// Find all measurement-processes with pid==null
		Set<Process> processes = processRepo.findByProcessMeasurementAndProcessPidIsNull(measurement);
		if(!processes.isEmpty()){
			List<ProcessJsonWrapper> processJsonWraps = new ArrayList<ProcessJsonWrapper>();
			JSONArray processInfos = null;
			// Get all possible processes on SUT with selected processname
			String queryString = processes.stream().map(p -> p.getProcessName()).collect(Collectors.joining(","));
			try {
				processInfos = Unirest.get(String.format("http://%s:%s/systemInfo/operatingSystem/processes/byName/%s", measurement.getMeasurementIp(), measurement.getMeasurementRemotePort(), queryString)).asJson().getBody().getArray();
			} catch (UnirestException e) {
				processInfos = null;
			};
			// Read processinfos and adds them to a dictionary
			if(processInfos != null){
				for(int i = 0; i<processInfos.length(); i++){
					JSONObject obj = processInfos.getJSONObject(i);
					java.lang.System.out.println("Adding process: " + obj.getString("name")+ " | PID " + obj.getLong("processID") );
					processJsonWraps.add(new ProcessJsonWrapper(obj.getString("name"), obj.getLong("processID")));
				}
			}
			for(Process process : processes){
				List<ProcessJsonWrapper> filtered = processJsonWraps.stream().filter(p -> p.getProcessName().equals(process.getProcessName())).collect(Collectors.toList());
				if(filtered.size() == 0){
					continue;
				}
				else if(filtered.size() >= 1){
					process.setProcessPid( filtered.get(0).getProcessId());
					processRepo.save(process);
					// Use current instance as first process to update
					java.lang.System.out.println("Updated main process (index 0)");
					// if there are more processes than one, new instances will be added to the database
					for(int i = 1; i<filtered.size(); i++){
						processRepo.save(
								new Process(filtered.get(i).getProcessName(), filtered.get(i).getProcessId(), measurement));
						java.lang.System.out.println("Posted process on index " + i + " with pid " + filtered.get(i).getProcessId());
					}
				}
			}
		}
	}
	
	public void readValues(Measurement measurement) throws UnirestException{
		
		Long startTime = java.lang.System.currentTimeMillis();
		String ip = measurement.getMeasurementIp();
		String port = measurement.getMeasurementRemotePort();
		String remotePort = environment.getProperty("local.server.port");
		String hardwareUrl = String.format("http://%s:%s/systemInfo/hardware", ip, port);
		refreshPidsByMeasurement(measurement);
		String processesPids = processRepo.findByProcessMeasurement(measurement).stream().filter(p -> p.getProcessPid() != null).map(p -> p.getProcessPid().toString()).collect(Collectors.joining(","));
		String processesUrl = String.format("http://%s:%s/systemInfo/operatingSystem/processes/%s", ip, port, processesPids);
		String fileStoresUrl = String.format("http://%s:%s/systemInfo/operatingSystem/fileSystem/fileStores", ip, port);
		
		DocumentContext hardwareContext = JsonPath.parse(Unirest.get(hardwareUrl).asJson().getBody().toString());
		DocumentContext fileStoresData = JsonPath.parse(Unirest.get(fileStoresUrl).asJson().getBody().toString());
		DocumentContext processesData = null;
		if(!processesPids.isEmpty()){
			processesData =  JsonPath.parse(Unirest.get(processesUrl).asJson().getBody().toString());
		}
		Long timestamp = java.lang.System.currentTimeMillis();
		System system = measurement.getMeasurementSystem();
		Hardware hardware = system.getSystemHardware();
		Set<Disk> disks = hardware.getHardwareDisks();
		Memory memory = hardware.getHardwareMemory();
		Set<Network> networks = hardware.getHardwareNetworks();
		Processor processor = hardware.getHardwareProcessor();
		Set<Process> processes = measurement.getMeasurementProcesses();
		Set<FileStore> fileStores = new HashSet<FileStore>();
		for(Disk disk : disks){
			fileStores.addAll(disk.getDiskFileStores());
		}
		//ADD PROCESSDATA
		Integer processesDataCount=0; 
		if(processesData != null){
			processesDataCount = processesData.read("$.length()");
		}
		for(int i = 0; i < processesDataCount; i++){
			if(processes == null){
				break;
			}
			int currentPid = processesData.read(String.format("$.[%d].processID", i));
			Process currentProcess = processes.stream().filter(p -> p.getProcessPid() != null).filter(p -> p.getProcessPid() == currentPid).findFirst().orElse(null);
			if(currentProcess != null){
				Integer processValueThreadCount = (processesData.read("$.["+i+"].threadCount"));
				Integer processValuePriority = Integer.parseInt(processesData.read("$.["+i+"].priority").toString());
				Long processValueVirtualSize = Long.parseLong(processesData.read("$.["+i+"].virtualSize").toString());
				Long processValueResidentSetSize = Long.parseLong(processesData.read("$.["+i+"].residentSetSize").toString());
				Long processValueKernelTime = Long.parseLong(processesData.read("$.["+i+"].kernelTime").toString());
				Long processValueUserTime = Long.parseLong(processesData.read("$.["+i+"].userTime").toString());
				Long processValueUpTime = Long.parseLong(processesData.read("$.["+i+"].upTime").toString());
				Long processValueStartTime = Long.parseLong(processesData.read("$.["+i+"].startTime").toString());
				Long processValueBytesRead = Long.parseLong(processesData.read("$.["+i+"].bytesRead").toString());
				Long processValueBytesWritten = Long.parseLong(processesData.read("$.["+i+"].bytesWritten").toString());
				Long processValueHandles = Long.parseLong(processesData.read("$.["+i+"].openFiles").toString());
				Unirest.post(String.format("http://localhost:%s/process/%d/processValues", remotePort, currentProcess.getProcessId()))
					.field("measurementId", measurement.getMeasurementId())
					.field("timestamp", timestamp)
					.field("processValueThreadCount", processValueThreadCount)
					.field("processValuePriority", processValuePriority)
					.field("processValueVirtualSize", processValueVirtualSize)
					.field("processValueResidentSetSize", processValueResidentSetSize)
					.field("processValueKernelTime", processValueKernelTime)
					.field("processValueUserTime", processValueUserTime)
					.field("processValueUpTime", processValueUpTime)
					.field("processValueStartTime", processValueStartTime)
					.field("processValueBytesRead", processValueBytesRead)
					.field("processValueBytesWritten", processValueBytesWritten)
					.field("processValueHandles", processValueHandles)
					.asJson()
					.getBody();
			}
		}
		
		Integer diskDataCount = hardwareContext.read("$.disks.length()");
		//ADD DISKDATA
		for(int i = 0; i< diskDataCount; i++){
			int currentIndex = i;
			Disk currentDisk = disks.stream().filter(d -> d.getDiskSerialNumber().equals(hardwareContext.read("$.disks["+currentIndex+"].serial"))).findFirst().orElse(null);
			if(currentDisk != null){
				Long diskValueReads = Long.parseLong(hardwareContext.read("$.disks["+i+"].reads").toString());
				Long diskValueReadBytes = Long.parseLong(hardwareContext.read("$.disks["+i+"].readBytes").toString());
				Long diskValueWrites = Long.parseLong(hardwareContext.read("$.disks["+i+"].writes").toString());
				Long diskValueWriteBytes = Long.parseLong(hardwareContext.read("$.disks["+i+"].writeBytes").toString());
				Long diskValueTransferTime = Long.parseLong(hardwareContext.read("$.disks["+i+"].transferTime").toString());
				Unirest.post(String.format("http://localhost:%s/disk/%s/diskValues", remotePort,currentDisk.getDiskSerialNumber()))
					.field("measurementId", measurement.getMeasurementId())
					.field("timestamp", timestamp)
					.field("diskValueReads", diskValueReads)
					.field("diskValueReadBytes", diskValueReadBytes)
					.field("diskValueWrites", diskValueWrites)
					.field("diskValueWriteBytes", diskValueWriteBytes)
					.field("diskValueTransferTime", diskValueTransferTime)
					.asJson();
			}
		}

		Integer fileStoreDataCount = fileStoresData.read("$.length()");
		//ADD FILESTOREDATA
		for(int i = 0; i< fileStoreDataCount; i++){
			int currentIndex = i;
			FileStore currentFileStore = fileStores.stream().filter(f -> f.getFileStoreUuid().equals(fileStoresData.read("$.["+currentIndex+"].fileStore.uuid"))).findFirst().orElse(null);
			if(currentFileStore != null){
				Long fileStoreValueUsableSpace = Long.parseLong((fileStoresData.read("$.["+i+"].fileStore.usableSpace").toString()));
				Unirest.post(String.format("http://localhost:%s/fileStore/%s/fileStoreValues",remotePort,currentFileStore.getFileStoreUuid()))
					.field("measurementId", measurement.getMeasurementId())
					.field("timestamp", timestamp)
					.field("fileStoreValueUsableSpace", fileStoreValueUsableSpace)
					.asJson();
			}
		}
		
		Integer networkDataCount = hardwareContext.read("$.networks.length()");
		//ADD NETWORKDATA
		for(int i = 0; i< networkDataCount; i++){
			int currentIndex = i;
			Network currentNetwork = networks.stream().filter(n -> n.getNetworkMac().equals(hardwareContext.read("$.networks["+currentIndex+"].mac"))).findFirst().orElse(null);
			if(currentNetwork != null){
				Long networkValueBytesRecv = Long.parseLong(hardwareContext.read("$.networks["+i+"].bytesRecv").toString());
				Long networkValueBytesSent = Long.parseLong(hardwareContext.read("$.networks["+i+"].bytesSent").toString());
				Long networkValuePacketsRecv = Long.parseLong(hardwareContext.read("$.networks["+i+"].packetsRecv").toString());
				Long networkValuePacketsSent = Long.parseLong(hardwareContext.read("$.networks["+i+"].packetsSent").toString());
				Long networkValueInErrors = Long.parseLong(hardwareContext.read("$.networks["+i+"].inErrors").toString());
				Long networkValueOutErrors = Long.parseLong(hardwareContext.read("$.networks["+i+"].outErrors").toString());
				Unirest.post(String.format("http://localhost:%s/network/%s/networkValues", remotePort,currentNetwork.getNetworkMac()))
					.field("measurementId", measurement.getMeasurementId())
					.field("timestamp", timestamp)
					.field("networkValueBytesRecv", networkValueBytesRecv)
					.field("networkValueBytesSent", networkValueBytesSent)
					.field("networkValuePacketsRecv", networkValuePacketsRecv)
					.field("networkValuePacketsSent", networkValuePacketsSent)
					.field("networkValueInErrors", networkValueInErrors)
					.field("networkValueOutErrors", networkValueOutErrors)
					.asJson();
			}
		}
		
		//ADD MEMORYDATA
		Long memoryValueAvailable = Long.parseLong(hardwareContext.read("$.memory.available").toString());
		Long memoryValueSwapTotal = Long.parseLong(hardwareContext.read("$.memory.swapTotal").toString());
		Long memoryValueSwapUsed = Long.parseLong(hardwareContext.read("$.memory.swapUsed").toString());
		
		Unirest.post(String.format("http://localhost:%s/memory/%d/memoryValues", remotePort, memory.getMemoryTotalSpace()))
			.field("measurementId", measurement.getMeasurementId())
			.field("timestamp", timestamp)
			.field("memoryValueAvailable", memoryValueAvailable)
			.field("memoryValueSwapTotal", memoryValueSwapTotal)
			.field("memoryValueSwapUsed", memoryValueSwapUsed)
			.asJson();

		//ADD PROCESSORDATA

		Double processorValueSystemCpuLoadBetweenTicks = Double.parseDouble(hardwareContext.read("$.processor.systemCpuLoadBetweenTicks").toString());
		/*Integer[] processorValueSystemCpuLoadTicks = hardwareContext.("$.processor.systemCpuLoadTicks", String);*/
		Double processorValueSystemCpuLoad= Double.parseDouble(hardwareContext.read("$.processor.systemCpuLoad").toString());
		/*Integer[] processorValueSystemLoadAverages = hardwareContext.read("$.processor.systemCpuLoadTicks", Integer[].class);
		Double[] processorValueProcessorCpuLoadBetweenTicks = hardwareContext.read("$.processor.processorCpuLoadBetweenTicks", Double[].class);
		Long[][] processorValueProcessorCpuLoadTicks = hardwareContext.read("$.processor.processorCpuLoadTicks", Long[][].class);*/
		Long processorValueSystemUpTime= Long.parseLong(hardwareContext.read("$.processor.systemUptime").toString());
		Long processorValueContextSwitches = Long.parseLong(hardwareContext.read("$.processor.contextSwitches").toString());
		Long processorValueInterrupts = Long.parseLong(hardwareContext.read("$.processor.interrupts").toString());
		Unirest.post(String.format("http://localhost:%s/processor/%s/processorValues", remotePort, processor.getProcessorId()))
			.field("measurementId", measurement.getMeasurementId())
			.field("timestamp", timestamp)
			.field("processorValueSystemCpuLoadBetweenTicks", processorValueSystemCpuLoadBetweenTicks)
			/*.field("processorValueSystemCpuLoadTicks", processorValueSystemCpuLoadTicks)*/
			.field("processorValueSystemCpuLoad", processorValueSystemCpuLoad)
			/*.field("processorValueSystemLoadAverages", processorValueSystemLoadAverages)
			.field("processorValueProcessorCpuLoadBetweenTicks", processorValueProcessorCpuLoadBetweenTicks)
			.field("processorValueProcessorCpuLoadTicks", processorValueProcessorCpuLoadTicks)*/
			.field("processorValueSystemUpTime", processorValueSystemUpTime)
			.field("processorValueContextSwitches", processorValueContextSwitches)
			.field("processorValueInterrupts", processorValueInterrupts)
			.asJson();

		java.lang.System.out.println("BENCHMARKING MEASUREMENT (QUERY + DB-INSERT): " + (java.lang.System.currentTimeMillis() - startTime));
	}
}
	
	




