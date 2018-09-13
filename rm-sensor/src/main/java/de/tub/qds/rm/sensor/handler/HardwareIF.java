package de.tub.qds.rm.sensor.handler;

import org.threeten.bp.LocalDate;

import com.google.gson.Gson;

import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import oshi.json.SystemInfo;
import oshi.json.hardware.Display;
import oshi.json.hardware.HWDiskStore;
import oshi.json.hardware.HWPartition;
import oshi.json.hardware.PowerSource;

public interface HardwareIF {

	/*
	 * GENERAL
	 */
	
	public static void getHardware(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().toJSON().toString();
		exchange.getResponseSender().send(response);
    }
	
	/*
	 * COMPUTERSYSTEM
	 */
	
	
	public static void getComputerSystem(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getComputerSystem().toJSON().toString();
		exchange.getResponseSender().send(response);
	}

	public static void getComputerSystemManufacturer(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getComputerSystem().getManufacturer();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getComputerSystemModel(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getComputerSystem().getModel();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getComputerSystemSerialNumber(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getComputerSystem().getSerialNumber();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	/*
	 * COMPUTERSYSTEM-FIRMWARE
	 */

	public static void getComputerSystemFirmware(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getComputerSystem().getFirmware().toJSON().toString();
		exchange.getResponseSender().send(response);
	}

	public static void getComputerSystemFirmwareManufacturer(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getComputerSystem().getFirmware().getManufacturer();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getComputerSystemFirmwareName(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getComputerSystem().getFirmware().getName();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getComputerSystemFirmwareDescription(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getComputerSystem().getFirmware().getDescription();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getComputerSystemFirmwareVersion(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getComputerSystem().getFirmware().getVersion();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getComputerSystemFirmwareReleaseDate(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		LocalDate response = new SystemInfo().getHardware().getComputerSystem().getFirmware().getReleaseDate();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	/*
	 * COMPUTERSYSTEM-BASEBOARD
	 */

	public static void getComputerSystemBaseboard(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getComputerSystem().getBaseboard().toJSON().toString();
		exchange.getResponseSender().send(response);
	}

	public static void getComputerSystemBaseboardManufacturer(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getComputerSystem().getBaseboard().getManufacturer();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getComputerSystemBaseboardModel(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getComputerSystem().getBaseboard().getModel();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getComputerSystemBaseboardVersion(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getComputerSystem().getBaseboard().getVersion();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getComputerSystemBaseboardSerialNumber(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getComputerSystem().getBaseboard().getSerialNumber();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	/*
	 * PROCESSOR
	 */
	
	public static void getProcessor(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getProcessor().toJSON().toString();
		exchange.getResponseSender().send(response);
    }
	
	public static void getProcessorName(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getProcessor().getName();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getProcessorVendor(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getProcessor().getVendor();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getProcessorProcessorID(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getProcessor().getProcessorID();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getProcessorIdentifier(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getProcessor().getIdentifier();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	public static void getProcessorFamily(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getProcessor().getFamily();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	public static void getProcessorModel(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getProcessor().getModel();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	public static void getProcessorStepping(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getProcessor().getStepping();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	public static void getProcessorPhysicalPackageCount(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int response = new SystemInfo().getHardware().getProcessor().getPhysicalPackageCount();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	public static void getProcessorPhysicalProcessorCount(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int response = new SystemInfo().getHardware().getProcessor().getPhysicalProcessorCount();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	public static void getProcessorLogicalProcessorCount(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int response = new SystemInfo().getHardware().getProcessor().getLogicalProcessorCount();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	public static void getProcessorVendorFreq(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		long response = new SystemInfo().getHardware().getProcessor().getVendorFreq();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	public static void getProcessorIsCpu64bit(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		boolean response = new SystemInfo().getHardware().getProcessor().isCpu64bit();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	public static void getProcessorSystemCpuLoadBetweenTicks(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		double response = new SystemInfo().getHardware().getProcessor().getSystemCpuLoadBetweenTicks();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	public static void getProcessorSystemCpuLoad(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		double response = new SystemInfo().getHardware().getProcessor().getSystemCpuLoad();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	public static void getProcessorSystemLoadAverage(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		double response = new SystemInfo().getHardware().getProcessor().getSystemLoadAverage();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	public static void getProcessorSystemUpTime(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		long response = new SystemInfo().getHardware().getProcessor().getSystemUptime();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	public static void getProcessorContextSwitches(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		long response = new SystemInfo().getHardware().getProcessor().getContextSwitches();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	public static void getProcessorInterrupts(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		long response = new SystemInfo().getHardware().getProcessor().getInterrupts();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	public static void getProcessorSystemCpuLoadTicks(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		long[] response = new SystemInfo().getHardware().getProcessor().getSystemCpuLoadTicks();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	public static void getProcessorProcessorCpuLoadBetweenTicks(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		double[] response = new SystemInfo().getHardware().getProcessor().getProcessorCpuLoadBetweenTicks();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	public static void getProcessorProcessorCpuLoadTicks(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		long[][] response = new SystemInfo().getHardware().getProcessor().getProcessorCpuLoadTicks();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	/*
	 * MEMORY
	 */
	
	public static void getMemory(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getMemory().toJSON().toString();
		exchange.getResponseSender().send(response);
	}
	public static void getMemoryAvailable(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		long response = new SystemInfo().getHardware().getMemory().getAvailable();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	public static void getMemoryTotal(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		long response = new SystemInfo().getHardware().getMemory().getTotal();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	public static void getMemorySwapTotal(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		long response = new SystemInfo().getHardware().getMemory().getSwapTotal();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	public static void getMemorySwapUsed(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		long response = new SystemInfo().getHardware().getMemory().getSwapUsed();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	/*
	 * POWERSOURCES
	 */
	
	public static void getPowerSources(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		PowerSource[] response = new SystemInfo().getHardware().getPowerSources();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getPowerSourceByIndex(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		PowerSource[] powersources = new SystemInfo().getHardware().getPowerSources();
        if(index > powersources.length-1){
        	exchange.getResponseSender().send(new Gson().toJson(null));
        	return;
        }
		PowerSource response = powersources[index];
		exchange.getResponseSender().send(new Gson().toJson(response));
		
    }
	public static void getPowerSourceByIndexName(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		PowerSource[] powersources = new SystemInfo().getHardware().getPowerSources();
        if(index > powersources.length-1){
        	exchange.getResponseSender().send(new Gson().toJson(null));
        	return;
        }
		String response = powersources[index].getName();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getPowerSourceByIndexRemainingCapacity(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		PowerSource[] powersources = new SystemInfo().getHardware().getPowerSources();
        if(index > powersources.length-1){
        	exchange.getResponseSender().send(new Gson().toJson(null));
        	return;
        }
		double response = powersources[index].getRemainingCapacity();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getPowerSourceByIndexTimeRemaining(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		PowerSource[] powersources = new SystemInfo().getHardware().getPowerSources();
        if(index > powersources.length-1){
        	exchange.getResponseSender().send(new Gson().toJson(null));
        	return;
        }
		double response = powersources[index].getTimeRemaining();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	/*
	 * DISKS
	 */
	
	public static void getDisks(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		HWDiskStore[] response =  new SystemInfo().getHardware().getDiskStores();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getDiskByIndex(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		HWDiskStore[] result =  new SystemInfo().getHardware().getDiskStores();
		if(index > result.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = result[index].toJSON().toString();
		exchange.getResponseSender().send(response);
    }
	public static void getDiskByIndexName(HttpServerExchange exchange)
	{
		
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		HWDiskStore[] result =  new SystemInfo().getHardware().getDiskStores();
		if(index > result.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = result[index].getName();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getDiskByIndexModel(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		HWDiskStore[] result =  new SystemInfo().getHardware().getDiskStores();
		if(index > result.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = result[index].getModel();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getDiskByIndexSerial(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		HWDiskStore[] result =  new SystemInfo().getHardware().getDiskStores();
		if(index > result.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = result[index].getSerial();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getDiskByIndexSize(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		HWDiskStore[] result =  new SystemInfo().getHardware().getDiskStores();
		if(index > result.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = result[index].getSize();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getDiskByIndexReads(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		HWDiskStore[] result =  new SystemInfo().getHardware().getDiskStores();
		if(index > result.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = result[index].getReads();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getDiskByIndexReadBytes(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		HWDiskStore[] result =  new SystemInfo().getHardware().getDiskStores();
		if(index > result.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = result[index].getReadBytes();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getDiskByIndexWrites(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		HWDiskStore[] result =  new SystemInfo().getHardware().getDiskStores();
		if(index > result.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = result[index].getWrites();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getDiskByIndexWriteBytes(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		HWDiskStore[] result =  new SystemInfo().getHardware().getDiskStores();
		if(index > result.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = result[index].getWriteBytes();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getDiskByIndexTransferTime(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		HWDiskStore[] result =  new SystemInfo().getHardware().getDiskStores();
		if(index > result.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = result[index].getTransferTime();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getDiskByIndexTimeStamp(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		HWDiskStore[] result =  new SystemInfo().getHardware().getDiskStores();
		if(index > result.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = result[index].getTimeStamp();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	/*
	 * DISKPARTITIONS
	 */
	
	public static void getDiskByIndexPartitions(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		oshi.hardware.HWDiskStore[] result =  new oshi.SystemInfo().getHardware().getDiskStores();
		if(index > result.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		oshi.hardware.HWPartition[] response = result[index].getPartitions();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getDiskByIndexPartitionByIndex(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int diskIndex = Integer.parseInt(exchange.getQueryParameters().get("diskIndex").getFirst());
		int partitionIndex = Integer.parseInt(exchange.getQueryParameters().get("partitionIndex").getFirst());
		HWDiskStore[] resultDisks =  new SystemInfo().getHardware().getDiskStores();
		if(diskIndex > resultDisks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		HWPartition[] resultPartitions = resultDisks[diskIndex].getPartitions();
		if(partitionIndex > resultPartitions.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = resultPartitions[partitionIndex].toJSON().toString();
		exchange.getResponseSender().send(response);
    }
	public static void getDiskByIndexPartitionByIndexIdentification(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int diskIndex = Integer.parseInt(exchange.getQueryParameters().get("diskIndex").getFirst());
		int partitionIndex = Integer.parseInt(exchange.getQueryParameters().get("partitionIndex").getFirst());
		HWDiskStore[] resultDisks =  new SystemInfo().getHardware().getDiskStores();
		if(diskIndex > resultDisks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		HWPartition[] resultPartitions = resultDisks[diskIndex].getPartitions();
		if(partitionIndex > resultPartitions.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = resultPartitions[partitionIndex].getIdentification();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getDiskByIndexPartitionByIndexName(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int diskIndex = Integer.parseInt(exchange.getQueryParameters().get("diskIndex").getFirst());
		int partitionIndex = Integer.parseInt(exchange.getQueryParameters().get("partitionIndex").getFirst());
		HWDiskStore[] resultDisks =  new SystemInfo().getHardware().getDiskStores();
		if(diskIndex > resultDisks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		HWPartition[] resultPartitions = resultDisks[diskIndex].getPartitions();
		if(partitionIndex > resultPartitions.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = resultPartitions[partitionIndex].getName();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getDiskByIndexPartitionByIndexType(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int diskIndex = Integer.parseInt(exchange.getQueryParameters().get("diskIndex").getFirst());
		int partitionIndex = Integer.parseInt(exchange.getQueryParameters().get("partitionIndex").getFirst());
		HWDiskStore[] resultDisks =  new SystemInfo().getHardware().getDiskStores();
		if(diskIndex > resultDisks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		HWPartition[] resultPartitions = resultDisks[diskIndex].getPartitions();
		if(partitionIndex > resultPartitions.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = resultPartitions[partitionIndex].getType();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getDiskByIndexPartitionByIndexUuid(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int diskIndex = Integer.parseInt(exchange.getQueryParameters().get("diskIndex").getFirst());
		int partitionIndex = Integer.parseInt(exchange.getQueryParameters().get("partitionIndex").getFirst());
		HWDiskStore[] resultDisks =  new SystemInfo().getHardware().getDiskStores();
		if(diskIndex > resultDisks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		HWPartition[] resultPartitions = resultDisks[diskIndex].getPartitions();
		if(partitionIndex > resultPartitions.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = resultPartitions[partitionIndex].getUuid();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getDiskByIndexPartitionByIndexMountPoint(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int diskIndex = Integer.parseInt(exchange.getQueryParameters().get("diskIndex").getFirst());
		int partitionIndex = Integer.parseInt(exchange.getQueryParameters().get("partitionIndex").getFirst());
		HWDiskStore[] resultDisks =  new SystemInfo().getHardware().getDiskStores();
		if(diskIndex > resultDisks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		HWPartition[] resultPartitions = resultDisks[diskIndex].getPartitions();
		if(partitionIndex > resultPartitions.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = resultPartitions[partitionIndex].getMountPoint();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getDiskByIndexPartitionByIndexSize(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int diskIndex = Integer.parseInt(exchange.getQueryParameters().get("diskIndex").getFirst());
		int partitionIndex = Integer.parseInt(exchange.getQueryParameters().get("partitionIndex").getFirst());
		HWDiskStore[] resultDisks =  new SystemInfo().getHardware().getDiskStores();
		if(diskIndex > resultDisks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		HWPartition[] resultPartitions = resultDisks[diskIndex].getPartitions();
		if(partitionIndex > resultPartitions.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = resultPartitions[partitionIndex].getSize();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getDiskByIndexPartitionByIndexMajor(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int diskIndex = Integer.parseInt(exchange.getQueryParameters().get("diskIndex").getFirst());
		int partitionIndex = Integer.parseInt(exchange.getQueryParameters().get("partitionIndex").getFirst());
		HWDiskStore[] resultDisks =  new SystemInfo().getHardware().getDiskStores();
		if(diskIndex > resultDisks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		HWPartition[] resultPartitions = resultDisks[diskIndex].getPartitions();
		if(partitionIndex > resultPartitions.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		int response = resultPartitions[partitionIndex].getMajor();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getDiskByIndexPartitionByIndexMinor(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int diskIndex = Integer.parseInt(exchange.getQueryParameters().get("diskIndex").getFirst());
		int partitionIndex = Integer.parseInt(exchange.getQueryParameters().get("partitionIndex").getFirst());
		HWDiskStore[] resultDisks =  new SystemInfo().getHardware().getDiskStores();
		if(diskIndex > resultDisks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		HWPartition[] resultPartitions = resultDisks[diskIndex].getPartitions();
		if(partitionIndex > resultPartitions.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		int response = resultPartitions[partitionIndex].getMinor();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	/*
	 * NETWORKS
	 */
	
	public static void getNetworks(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		oshi.hardware.NetworkIF[] response = new oshi.SystemInfo().getHardware().getNetworkIFs();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getNetworkByIndex(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(index > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		oshi.hardware.NetworkIF response = networks[index];
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getNetworkByIndexName(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(index > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = networks[index].getName();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getNetworkByIndexDisplayName(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(index > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = networks[index].getDisplayName();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getNetworkByIndexMac(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(index > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = networks[index].getMacaddr();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getNetworkByIndexIpv4(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(index > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String[] response = networks[index].getIPv4addr();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getNetworkByIndexIpv4ByIndex(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int networkIndex = Integer.parseInt(exchange.getQueryParameters().get("networkIndex").getFirst());
		int ipv4Index = Integer.parseInt(exchange.getQueryParameters().get("ipv4Index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(networkIndex > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String[] ipv4s = networks[networkIndex].getIPv4addr();
		if(ipv4Index > ipv4s.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = ipv4s[ipv4Index];
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getNetworkByIndexIpv6(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(index > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String[] response = networks[index].getIPv6addr();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getNetworkByIndexIpv6ByIndex(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int networkIndex = Integer.parseInt(exchange.getQueryParameters().get("networkIndex").getFirst());
		int ipv6Index = Integer.parseInt(exchange.getQueryParameters().get("ipv6Index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(networkIndex > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String[] ipv6s = networks[networkIndex].getIPv6addr();
		if(ipv6Index > ipv6s.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = ipv6s[ipv6Index];
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getNetworkByIndexMtu(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(index > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		int response = networks[index].getMTU();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getNetworkByIndexBytesRecv(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(index > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = networks[index].getBytesRecv();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getNetworkByIndexBytesSent(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(index > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = networks[index].getBytesSent();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getNetworkByIndexPacketsRecv(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(index > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = networks[index].getPacketsRecv();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getNetworkByIndexPacketsSent(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(index > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = networks[index].getPacketsSent();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getNetworkByIndexInErrors(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(index > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = networks[index].getInErrors();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getNetworkByIndexOutErrors(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(index > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = networks[index].getOutErrors();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getNetworkByIndexSpeed(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(index > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = networks[index].getSpeed();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getNetworkByIndexTimestamp(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		oshi.hardware.NetworkIF[] networks = new oshi.SystemInfo().getHardware().getNetworkIFs();
		if(index > networks.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = networks[index].getTimeStamp();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	/*
	 * DISPLAYS
	 */
	
	public static void getDisplays(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		Display[] response = new SystemInfo().getHardware().getDisplays();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	public static void getDisplayByIndex(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		Display[] displays = new SystemInfo().getHardware().getDisplays();
		if(index > displays.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		Display response = displays[index];
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getDisplayByIndexEdid(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		Display[] displays = new SystemInfo().getHardware().getDisplays();
		if(index > displays.length-1){
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		byte[] response = displays[index].getEdid();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	/*
	 * SENSORS
	 */
	public static void getSensors(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().getHardware().getSensors().toJSON().toString();
		exchange.getResponseSender().send(response);
    }
	
	public static void getSensorCpuTemperature(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		double response = new SystemInfo().getHardware().getSensors().getCpuTemperature();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getSensorFanSpeeds(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		int[] response = new SystemInfo().getHardware().getSensors().getFanSpeeds();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
	public static void getSensorCpuVoltage(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		double response = new SystemInfo().getHardware().getSensors().getCpuVoltage();
		exchange.getResponseSender().send(new Gson().toJson(response));
    }
	
}
