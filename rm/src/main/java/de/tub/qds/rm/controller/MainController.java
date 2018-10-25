package de.tub.qds.rm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import de.tub.qds.rm.Methods;
import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.Rate;
import de.tub.qds.rm.models.consts.repos.BaseboardRepo;
import de.tub.qds.rm.models.consts.repos.DiskRepo;
import de.tub.qds.rm.models.consts.repos.FileStoreRepo;
import de.tub.qds.rm.models.consts.repos.FirmwareRepo;
import de.tub.qds.rm.models.consts.repos.HardwareRepo;
import de.tub.qds.rm.models.consts.repos.MeasurementRepo;
import de.tub.qds.rm.models.consts.repos.MemoryRepo;
import de.tub.qds.rm.models.consts.repos.NetworkRepo;
import de.tub.qds.rm.models.consts.repos.OperatingSystemRepo;
import de.tub.qds.rm.models.consts.repos.ProcessRepo;
import de.tub.qds.rm.models.consts.repos.ProcessorRepo;
import de.tub.qds.rm.models.consts.repos.SystemModelRepo;
import de.tub.qds.rm.models.consts.repos.SystemRepo;
import de.tub.qds.rm.models.values.wrapper.DiskPartitionFileStoreWrapper;
import org.springframework.core.env.Environment;

@RestController
public class MainController {
	
	@Autowired BaseboardRepo baseboardRepo;
	@Autowired DiskRepo diskRepo;
	@Autowired FileStoreRepo fileStoreRepo;
	@Autowired FirmwareRepo firmwareRepo;
	@Autowired HardwareRepo hardwareRepo;
	@Autowired MeasurementRepo measurementRepo;
	@Autowired MemoryRepo memoryRepo;
	@Autowired NetworkRepo networkRepo;
	@Autowired OperatingSystemRepo operatingSystemRepo;
	@Autowired ProcessRepo processRepo;
	@Autowired ProcessorRepo processorRepo;
	@Autowired SystemModelRepo systemModelRepo;
	@Autowired SystemRepo systemRepo;
	@Autowired Environment environment;

	@RequestMapping(method = RequestMethod.GET, path = "/")
	public void getIndex(HttpServletRequest request, HttpServletResponse response){
	    try {
			response.sendRedirect(request.getContextPath() + "/swagger-ui.html");
		} catch (IOException e) {
			return;
		}
	  }
	
	@RequestMapping(method = RequestMethod.GET, path = "/api")
	public void getApi(HttpServletRequest request, HttpServletResponse response){
	    try {
			response.sendRedirect(request.getContextPath() + "/swagger-ui.html");
		} catch (IOException e) {
			return;
		}
	  }
	
	@RequestMapping(method = RequestMethod.POST, path = "/createDataByHostName", produces = "application/json")
	public Measurement createTestDataWithLocalhost(@RequestParam("hostName") String hostName, @RequestParam("remotePort") String remotePort) throws UnirestException{
		String ip = Methods.ipResolve(hostName);
		String url = String.format("http://%s:%s/systemInfo", ip, remotePort);
		String localPort = environment.getProperty("local.server.port");
		String testData = null;
		try {
			testData = Unirest.get(url).asJson().getBody().toString();
		} catch (UnirestException e) {
			return null;
		}
		
		DocumentContext context = JsonPath.parse(testData);
		
		String systemModelSerialNumber 	=	context.read("$.hardware.computerSystem.serialNumber").toString();
		String systemModelManufacturer	=	context.read("$.hardware.computerSystem.manufacturer").toString();
		String systemModelModel			=	context.read("$.hardware.computerSystem.model").toString();
		String responseSystemModelId = Unirest.post(String.format("http://localhost:%s/systemModel", localPort))
			.field("systemModelSerialNumber", systemModelSerialNumber)
			.field("systemModelManufacturer", systemModelManufacturer)
			.field("systemModelModel", systemModelModel)
			.getHttpRequest().asJson().getBody().getObject().optString("systemModelSerialNumber");
		/*SystemModel systemModel = systemModelRepo.findById(responseSystemModelId).orElse(null);*/
				
		String baseboardSerialNumber	=	context.read("$.hardware.computerSystem.baseboard.serialNumber").toString();
		String baseboardManufacturer	=	context.read("$.hardware.computerSystem.baseboard.manufacturer").toString();
		String baseboardModel			=	context.read("$.hardware.computerSystem.baseboard.model").toString();
		String baseboardVersion			=	context.read("$.hardware.computerSystem.baseboard.version").toString();
		String responseBaseboardId = Unirest.post(String.format("http://localhost:%s/baseboard", localPort))
				.field("baseboardSerialNumber", baseboardSerialNumber)
				.field("baseboardManufacturer", baseboardManufacturer)
				.field("baseboardModel", baseboardModel)
				.field("baseboardVersion", baseboardVersion)
				.getHttpRequest().asJson().getBody().getObject().optString("baseboardSerialNumber");
		/*Baseboard baseboard = baseboardRepo.findById(responseBaseboardId).orElse(null);*/
		
		String firmwareManufacturer		=	context.read("$.hardware.computerSystem.firmware.manufacturer").toString();
		String firmwareName				=	context.read("$.hardware.computerSystem.firmware.name").toString();
		String firmwareDescription		=	context.read("$.hardware.computerSystem.firmware.description").toString();
		String firmwareVersion			=	context.read("$.hardware.computerSystem.firmware.version").toString();
		String firmwareReleaseDate		=	context.read("$.hardware.computerSystem.firmware.releaseDate").toString();
		Long responseFirmwareId = Unirest.post(String.format("http://localhost:%s/firmware", localPort))
				.field("firmwareManufacturer", firmwareManufacturer)
				.field("firmwareName", firmwareName)
				.field("firmwareDescription", firmwareDescription)
				.field("firmwareVersion", firmwareVersion)
				.field("firmwareReleaseDate", firmwareReleaseDate)
				.getHttpRequest().asJson().getBody().getObject().optLong("firmwareIdentifier");
		
		/*Firmware firmware = firmwareRepo.findById(responseFirmwareId).orElse(null);*/
		
		String processorId					=	context.read("$.hardware.processor.processorID").toString();
		String processorName				=	context.read("$.hardware.processor.name").toString();
		String processorVendor				=	context.read("$.hardware.processor.vendor").toString();
		String processorFamily				=	context.read("$.hardware.processor.family").toString();
		String processorModel				=	context.read("$.hardware.processor.model").toString();
		String processorStepping			=	context.read("$.hardware.processor.stepping").toString();
		int processorPhysicalPackageCount	=	Integer.parseInt(context.read("$.hardware.processor.physicalPackageCount").toString());
		int processorPhysicalProcessorCount =	Integer.parseInt(context.read("$.hardware.processor.physicalProcessorCount").toString());
		int processorLogicalProcessorCount	=	Integer.parseInt(context.read("$.hardware.processor.logicalProcessorCount").toString());
		boolean processorCpu64bit			=	Boolean.getBoolean(context.read("$.hardware.processor.cpu64bit").toString());
		long processorVendorFreq			=	Long.parseLong(context.read("$.hardware.processor.logicalProcessorCount").toString());
		String responseProcessorId = Unirest.post(String.format("http://localhost:%s/processor", localPort))
				.field("processorId", processorId)
				.field("processorName", processorName)
				.field("processorVendor", processorVendor)
				.field("processorFamily", processorFamily)
				.field("processorModel", processorModel)
				.field("processorStepping", processorStepping)
				.field("processorPhysicalPackageCount", processorPhysicalPackageCount)
				.field("processorPhysicalProcessorCount", processorPhysicalProcessorCount)
				.field("processorLogicalProcessorCount", processorLogicalProcessorCount)
				.field("processorCpu64bit", processorCpu64bit)
				.field("processorVendorFreq", processorVendorFreq)
				.getHttpRequest().asJson().getBody().getObject().optString("processorId");
		
		long memoryTotalSpace =	Long.parseLong(context.read("$.hardware.memory.total").toString());
		Long responseMemoryId = Unirest.post(String.format("http://localhost:%s/memory", localPort))
				.field("memoryTotalSpace", memoryTotalSpace)
				.getHttpRequest().asJson().getBody().getObject().optLong("memoryTotalSpace");
		
		List<DiskPartitionFileStoreWrapper> partitions = new ArrayList<DiskPartitionFileStoreWrapper>();
		List<String> responseDiskIds = new ArrayList<String>();
		for(int i = 0; i<Integer.parseInt(context.read("$.hardware.disks.length()").toString()) ; i++)
		{
			String diskSerialNumber	=	context.read("$.hardware.disks["+i+"].serial").toString();
			String diskModel		=	context.read("$.hardware.disks["+i+"].model").toString();
			String diskName			=	context.read("$.hardware.disks["+i+"].name").toString();
			Long diskSize			=	Long.parseLong(context.read("$.hardware.disks["+i+"].size").toString());
			String responseDiskId = Unirest.post(String.format("http://localhost:%s/disk", localPort))
					.field("diskSerialNumber", diskSerialNumber)
					.field("diskModel", diskModel)
					.field("diskName", diskName)
					.field("diskSize", diskSize)
					.getHttpRequest().asJson().getBody().getObject().optString("diskSerialNumber");
			if(!responseDiskId.isEmpty()){
				responseDiskIds.add(responseDiskId);
			}
			
			for(int j = 0; j< Integer.parseInt(context.read("$.hardware.disks["+i+"].partitions.length()").toString()); j++){
				String uuid = context.read("$.hardware.disks["+i+"].partitions["+j+"].uuid").toString();
				partitions.add(new DiskPartitionFileStoreWrapper(responseDiskId, uuid));
			}
		}
		List<String> responseFileStoreIds = new ArrayList<String>();
		for(int i = 0; i<Integer.parseInt(context.read("$.operatingSystem.fileSystem.fileStores.length()").toString()) ; i++)
		{
			String fileStoreUuid		=	context.read("$.operatingSystem.fileSystem.fileStores["+i+"].uuid").toString();
			Long fileStoreTotalSpace	=	Long.parseLong(context.read("$.operatingSystem.fileSystem.fileStores["+i+"].totalSpace").toString());
			String fileStoreName		=	context.read("$.operatingSystem.fileSystem.fileStores["+i+"].name").toString();
			String fileStoreVolume		=	context.read("$.operatingSystem.fileSystem.fileStores["+i+"].volume").toString();
			String fileStoreMountPoint	=	context.read("$.operatingSystem.fileSystem.fileStores["+i+"].mountPoint").toString();
			String fileStoreDescription	=	context.read("$.operatingSystem.fileSystem.fileStores["+i+"].description").toString();
			String fileStoreFsType		=	context.read("$.operatingSystem.fileSystem.fileStores["+i+"].fsType").toString();
			String responseFileStoreId = Unirest.post(String.format("http://localhost:%s/fileStore", localPort))
					.field("fileStoreUuid", fileStoreUuid)
					.field("fileStoreTotalSpace", fileStoreTotalSpace)
					.field("fileStoreName", fileStoreName)
					.field("fileStoreVolume", fileStoreVolume)
					.field("fileStoreMountPoint", fileStoreMountPoint)
					.field("fileStoreDescription", fileStoreDescription)
					.field("fileStoreFsType", fileStoreFsType)
					.getHttpRequest().asJson().getBody().getObject().optString("fileStoreUuid");
			if(!responseFileStoreId.isEmpty()){
				responseFileStoreIds.add(responseFileStoreId);
			}
			DiskPartitionFileStoreWrapper partition = partitions.stream().filter(p -> p.getUuid().equals(responseFileStoreId)).findAny().orElse(null);
			if(partition != null){
				Unirest.put(String.format("http://localhost:%s/fileStore/%s/fileStoreDisk", localPort, responseFileStoreId))
						.field("diskSerialNumber", partition.getDiskSerialNumber()).asJson();
			}
		}
		
		List<String> responseNetworkIds = new ArrayList<String>();
		for(int i = 0; i<Integer.parseInt(context.read("$.hardware.networks.length()").toString()) ; i++)
		{
			String networkIpv4 = "";
			String networkIpv6 = "";
			String networkMac			=	context.read("$.hardware.networks["+i+"].mac").toString();
			String networkName			=	context.read("$.hardware.networks["+i+"].name").toString();
			String networkDisplayName	=	context.read("$.hardware.networks["+i+"].displayName").toString();
			if(Integer.parseInt(context.read("$.hardware.networks["+i+"].ipv4.length()").toString()) > 0){
				networkIpv4			=	context.read("$.hardware.networks["+i+"].ipv4[0]").toString();
			}
			if(Integer.parseInt(context.read("$.hardware.networks["+i+"].ipv6.length()").toString()) > 0){
				networkIpv6			=	context.read("$.hardware.networks["+i+"].ipv6[0]").toString();
			}
			Long networkMtu				=	Long.parseLong(context.read("$.hardware.networks["+i+"].mtu").toString());
			Long networkSpeed			=	Long.parseLong(context.read("$.hardware.networks["+i+"].speed").toString());
			String responseNetworkId = Unirest.post(String.format("http://localhost:%s/network", localPort))
					.field("networkMac", networkMac)
					.field("networkName", networkName)
					.field("networkDisplayName", networkDisplayName)
					.field("networkIpv4", networkIpv4)
					.field("networkIpv6", networkIpv6)
					.field("networkMtu", networkMtu)
					.field("networkSpeed", networkSpeed)
					.getHttpRequest().asJson().getBody().getObject().optString("networkMac");
			if(!responseNetworkId.isEmpty()){
				responseNetworkIds.add(responseNetworkId);
			}
		}
	
		String operatingSystemManufacturer	=	context.read("$.operatingSystem.manufacturer").toString();
		String operatingSystemFamily		=	context.read("$.operatingSystem.family").toString();
		String operatingSystemVersion		=	context.read("$.operatingSystem.version.version").toString();
		String operatingSystemCodeName		=	context.read("$.operatingSystem.version.codeName").toString();
		String operatingSystemBuild			=	context.read("$.operatingSystem.version.build").toString();
		Long responseOperatingSystemId = Unirest.post(String.format("http://localhost:%s/operatingSystem", localPort))
				.field("operatingSystemManufacturer", operatingSystemManufacturer)
				.field("operatingSystemFamily", operatingSystemFamily)
				.field("operatingSystemVersion", operatingSystemVersion)
				.field("operatingSystemCodeName", operatingSystemCodeName)
				.field("operatingSystemBuild", operatingSystemBuild)
				.getHttpRequest().asJson().getBody().getObject().optLong("operatingSystemId");
		
		Long responseHardwareId = Unirest.post(String.format("http://localhost:%s/hardware", localPort))
				.field("systemModelSerialNumber", responseSystemModelId)
				.field("baseboardSerialNumber", responseBaseboardId)
				.field("firmwareIdentifier", responseFirmwareId)
				.field("processorId", responseProcessorId)
				.field("memoryTotalSpace", responseMemoryId)
				.getHttpRequest().asJson().getBody().getObject().optLong("hardwareId");
				
		for(String networkId : responseNetworkIds){
			Unirest.put(String.format("http://localhost:%s/hardware/%d/hardwareNetworks", localPort, responseHardwareId))
				.field("networkMac", networkId)
				.asJson();
		}
		
		for(String diskId : responseDiskIds){
			Unirest.put(String.format("http://localhost:%s/hardware/%d/hardwareDisks", localPort, responseHardwareId))
				.field("diskSerialNumber", diskId)
				.asJson();
		}
		
		Long responseSystemId = Unirest.post(String.format("http://localhost:%s/system", localPort))
			.field("systemHostName", hostName)
			.field("systemOperatingSystemId", responseOperatingSystemId)
			.field("systemHardwareId", responseHardwareId)
			.getHttpRequest().asJson().getBody().getObject().optLong("systemIdentifier");
		
		 Long measurementId = Unirest.post(String.format("http://localhost:%s/measurement", localPort))
					.field("measurementRate", Rate.FIVE_SECONDS)
					.field("measurementRemotePort", remotePort)
					.field("measurementSystem", responseSystemId)
					.getHttpRequest().asJson().getBody().getObject().optLong("measurementId");

		 Unirest.put(String.format("http://localhost:%s/measurement/%d", localPort, measurementId))
			.field("measurementRunning", true)
			.getHttpRequest().asJson();

		 return measurementRepo.findById(measurementId).orElse(null);
		}
	}
