package de.tub.qds.rm.sensor;

import de.tub.qds.rm.sensor.handler.HardwareIF;
import de.tub.qds.rm.sensor.handler.OperatingSystemIF;
import de.tub.qds.rm.sensor.handler.SystemIF;
import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.Undertow.Builder;
import io.undertow.server.RoutingHandler;
import io.undertow.util.Methods;


public class App {
	public static void main( String[] args )
    {
    	
    	Builder server = Undertow.builder();
    	int port;
    	if(args.length == 1){
    		port = Integer.parseInt(args[0]);
    	}
    	else
    	{
    		port = 10005;
    	}
    	
    	RoutingHandler handler = new RoutingHandler()
    		/*
    		 * SYSTEMIF
    		 */
			.add(Methods.GET, "/error", SystemIF::getError)
    		.add(Methods.GET, "/systemInfo", SystemIF::getSystemInfo)
    		.add(Methods.GET, "/systemInfo/platform", SystemIF::getSystemInfoPlatform)
    		
    		/*
    		 *  HARDWAREIF
    		 */
    		// Hardware
    		.add(Methods.GET, "/systemInfo/hardware", HardwareIF::getHardware)
    		// ComputerSystem
    		.add(Methods.GET, "/systemInfo/hardware/computerSystem", HardwareIF::getComputerSystem)
    		.add(Methods.GET, "/systemInfo/hardware/computerSystem/manufacturer", HardwareIF::getComputerSystemManufacturer)
    		.add(Methods.GET, "/systemInfo/hardware/computerSystem/model", HardwareIF::getComputerSystemModel)
    		.add(Methods.GET, "/systemInfo/hardware/computerSystem/serialNumber", HardwareIF::getComputerSystemSerialNumber)
    		.add(Methods.GET, "/systemInfo/hardware/computerSystem/firmware", HardwareIF::getComputerSystemFirmware)
    		.add(Methods.GET, "/systemInfo/hardware/computerSystem/firmware/manufacturer", HardwareIF::getComputerSystemFirmwareManufacturer)
    		.add(Methods.GET, "/systemInfo/hardware/computerSystem/firmware/name", HardwareIF::getComputerSystemFirmwareName)
    		.add(Methods.GET, "/systemInfo/hardware/computerSystem/firmware/description", HardwareIF::getComputerSystemFirmwareDescription)
    		.add(Methods.GET, "/systemInfo/hardware/computerSystem/firmware/version", HardwareIF::getComputerSystemFirmwareVersion)
    		.add(Methods.GET, "/systemInfo/hardware/computerSystem/firmware/releaseDate", HardwareIF::getComputerSystemFirmwareReleaseDate)
    		.add(Methods.GET, "/systemInfo/hardware/computerSystem/baseboard", HardwareIF::getComputerSystemBaseboard)
    		.add(Methods.GET, "/systemInfo/hardware/computerSystem/baseboard/manufacturer", HardwareIF::getComputerSystemBaseboardManufacturer)
    		.add(Methods.GET, "/systemInfo/hardware/computerSystem/baseboard/model", HardwareIF::getComputerSystemBaseboardModel)
    		.add(Methods.GET, "/systemInfo/hardware/computerSystem/baseboard/version", HardwareIF::getComputerSystemBaseboardVersion)
    		.add(Methods.GET, "/systemInfo/hardware/computerSystem/baseboard/serialNumber", HardwareIF::getComputerSystemBaseboardSerialNumber)
    		// Processor
    		.add(Methods.GET, "/systemInfo/hardware/processor", HardwareIF::getProcessor)
    		.add(Methods.GET, "/systemInfo/hardware/processor/name", HardwareIF::getProcessorName)
    		.add(Methods.GET, "/systemInfo/hardware/processor/vendor", HardwareIF::getProcessorVendor)
    		.add(Methods.GET, "/systemInfo/hardware/processor/processorID", HardwareIF::getProcessorProcessorID)
    		.add(Methods.GET, "/systemInfo/hardware/processor/identifier", HardwareIF::getProcessorIdentifier)
    		.add(Methods.GET, "/systemInfo/hardware/processor/family", HardwareIF::getProcessorFamily)
    		.add(Methods.GET, "/systemInfo/hardware/processor/model", HardwareIF::getProcessorModel)
    		.add(Methods.GET, "/systemInfo/hardware/processor/stepping", HardwareIF::getProcessorStepping)
    		.add(Methods.GET, "/systemInfo/hardware/processor/physicalPackageCount", HardwareIF::getProcessorPhysicalPackageCount)
    		.add(Methods.GET, "/systemInfo/hardware/processor/physicalProcessorCount", HardwareIF::getProcessorPhysicalProcessorCount)
    		.add(Methods.GET, "/systemInfo/hardware/processor/logicalProcessorCount", HardwareIF::getProcessorLogicalProcessorCount)
    		.add(Methods.GET, "/systemInfo/hardware/processo/vendorFreqr", HardwareIF::getProcessorVendorFreq)
    		.add(Methods.GET, "/systemInfo/hardware/processor/isCpu64bit", HardwareIF::getProcessorIsCpu64bit)
    		.add(Methods.GET, "/systemInfo/hardware/processor/systemCpuLoadBetweenTicks", HardwareIF::getProcessorSystemCpuLoadBetweenTicks)
    		.add(Methods.GET, "/systemInfo/hardware/processor/systemCpuLoad", HardwareIF::getProcessorSystemCpuLoad)
    		.add(Methods.GET, "/systemInfo/hardware/processor/systemLoadAverage", HardwareIF::getProcessorSystemLoadAverage)
    		.add(Methods.GET, "/systemInfo/hardware/processor/systemUptime", HardwareIF::getProcessorSystemUpTime)
    		.add(Methods.GET, "/systemInfo/hardware/processor/contextSwitches", HardwareIF::getProcessorContextSwitches)
    		.add(Methods.GET, "/systemInfo/hardware/processor/interrupts", HardwareIF::getProcessorInterrupts)
    		.add(Methods.GET, "/systemInfo/hardware/processor/systemCpuLoadTicks", HardwareIF::getProcessorSystemCpuLoadTicks)
    		.add(Methods.GET, "/systemInfo/hardware/processor/processorCpuLoadBetweenTicks", HardwareIF::getProcessorProcessorCpuLoadBetweenTicks)
    		.add(Methods.GET, "/systemInfo/hardware/processor/processorCpuLoadTicks", HardwareIF::getProcessorProcessorCpuLoadTicks)
    		// Memory
    		.add(Methods.GET, "/systemInfo/hardware/memory", HardwareIF::getMemory)
    		.add(Methods.GET, "/systemInfo/hardware/memory/systemInfo/hardware/memory", HardwareIF::getMemoryAvailable)
    		.add(Methods.GET, "/systemInfo/hardware/memory/total", HardwareIF::getMemoryTotal)
    		.add(Methods.GET, "/systemInfo/hardware/memory/swapTotal", HardwareIF::getMemorySwapTotal)
    		.add(Methods.GET, "/systemInfo/hardware/memory/swapUsed", HardwareIF::getMemorySwapUsed)
    		// PowerSources
    		.add(Methods.GET, "/systemInfo/hardware/powerSources", HardwareIF::getPowerSources)
    		.add(Methods.GET, "/systemInfo/hardware/powerSources/{index}", HardwareIF::getPowerSourceByIndex)
    		.add(Methods.GET, "/systemInfo/hardware/powerSources/{index}/name", HardwareIF::getPowerSourceByIndexName)
    		.add(Methods.GET, "/systemInfo/hardware/powerSources/{index}/remainingCapacity", HardwareIF::getPowerSourceByIndexRemainingCapacity)
    		.add(Methods.GET, "/systemInfo/hardware/powerSources/{index}/timeRemaining", HardwareIF::getPowerSourceByIndexTimeRemaining)
    		// Disks
    		.add(Methods.GET, "/systemInfo/hardware/disks", HardwareIF::getDisks)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{index}", HardwareIF::getDiskByIndex)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{index}/name", HardwareIF::getDiskByIndexName)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{index}/model", HardwareIF::getDiskByIndexModel)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{index}/serial", HardwareIF::getDiskByIndexSerial)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{index}/size", HardwareIF::getDiskByIndexSize)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{index}/reads", HardwareIF::getDiskByIndexReads)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{index}/readBytes", HardwareIF::getDiskByIndexReadBytes)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{index}/writes", HardwareIF::getDiskByIndexWrites)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{index}/writeBytes", HardwareIF::getDiskByIndexWriteBytes)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{index}/transferTime", HardwareIF::getDiskByIndexTransferTime)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{index}/timeStamp", HardwareIF::getDiskByIndexTimeStamp)
    		// DiskPartitions
    		.add(Methods.GET, "/systemInfo/hardware/disks/{index}/partitions", HardwareIF::getDiskByIndexPartitions)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{diskIndex}/partitions/{partitionIndex}", HardwareIF::getDiskByIndexPartitionByIndex)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{diskIndex}/partitions/{partitionIndex}/identification", HardwareIF::getDiskByIndexPartitionByIndexIdentification)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{diskIndex}/partitions/{partitionIndex}/name", HardwareIF::getDiskByIndexPartitionByIndexName)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{diskIndex}/partitions/{partitionIndex}/type", HardwareIF::getDiskByIndexPartitionByIndexType)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{diskIndex}/partitions/{partitionIndex}/uuid", HardwareIF::getDiskByIndexPartitionByIndexUuid)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{diskIndex}/partitions/{partitionIndex}/mountPoint", HardwareIF::getDiskByIndexPartitionByIndexMountPoint)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{diskIndex}/partitions/{partitionIndex}/size", HardwareIF::getDiskByIndexPartitionByIndexSize)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{diskIndex}/partitions/{partitionIndex}/major", HardwareIF::getDiskByIndexPartitionByIndexMajor)
    		.add(Methods.GET, "/systemInfo/hardware/disks/{diskIndex}/partitions/{partitionIndex}/minor", HardwareIF::getDiskByIndexPartitionByIndexMinor)
    		// Networks
    		.add(Methods.GET, "/systemInfo/hardware/networks", HardwareIF::getNetworks)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{index}", HardwareIF::getNetworkByIndex)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{index}/name", HardwareIF::getNetworkByIndexName)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{index}/displayName", HardwareIF::getNetworkByIndexDisplayName)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{index}/mac", HardwareIF::getNetworkByIndexMac)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{index}/ipv4", HardwareIF::getNetworkByIndexIpv4)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{networkIndex}/ipv4/{ipv4Index}", HardwareIF::getNetworkByIndexIpv4ByIndex)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{index}/ipv6", HardwareIF::getNetworkByIndexIpv6)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{networkIndex}/ipv6/{ipv6Index}", HardwareIF::getNetworkByIndexIpv6ByIndex)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{index}/mtu", HardwareIF::getNetworkByIndexMtu)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{index}/bytesRecv", HardwareIF::getNetworkByIndexBytesRecv)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{index}/bytesSent", HardwareIF::getNetworkByIndexBytesSent)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{index}/packetsRecv", HardwareIF::getNetworkByIndexPacketsRecv)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{index}/packetsSent", HardwareIF::getNetworkByIndexPacketsSent)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{index}/inErrors", HardwareIF::getNetworkByIndexInErrors)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{index}/outErrors", HardwareIF::getNetworkByIndexOutErrors)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{index}/speed", HardwareIF::getNetworkByIndexSpeed)
    		.add(Methods.GET, "/systemInfo/hardware/networks/{index}/timestamp", HardwareIF::getNetworkByIndexTimestamp)
    		// Displays
    		.add(Methods.GET, "/systemInfo/hardware/displays", HardwareIF::getDisplays)
    		.add(Methods.GET, "/systemInfo/hardware/displays/{index}", HardwareIF::getDisplayByIndex)
    		.add(Methods.GET, "/systemInfo/hardware/displays/{index}/edid", HardwareIF::getDisplayByIndexEdid)
    		// Sensors
    		.add(Methods.GET, "/systemInfo/hardware/sensors", HardwareIF::getSensors)
    		.add(Methods.GET, "/systemInfo/hardware/sensors/cpuTemperature", HardwareIF::getSensorCpuTemperature)
    		.add(Methods.GET, "/systemInfo/hardware/sensors/fanSpeeds", HardwareIF::getSensorFanSpeeds)
    		.add(Methods.GET, "/systemInfo/hardware/sensors/cpuVoltage", HardwareIF::getSensorCpuVoltage)
    		
    		/*
    		 * OPERATINGSYSTEMIF
    		 */
    		// OS
    		.add(Methods.GET, "/systemInfo/operatingSystem", OperatingSystemIF::getOperatingSystem)
    		.add(Methods.GET, "/systemInfo/operatingSystem/manufacturer", OperatingSystemIF::getManufacturer)
    		.add(Methods.GET, "/systemInfo/operatingSystem/family", OperatingSystemIF::getFamily)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processID", OperatingSystemIF::getProcessID)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processCount", OperatingSystemIF::getProcessCount)
    		.add(Methods.GET, "/systemInfo/operatingSystem/threadCount", OperatingSystemIF::getThreadCount)
    		.add(Methods.GET, "/systemInfo/operatingSystem/version", OperatingSystemIF::getVersion)
    		.add(Methods.GET, "/systemInfo/operatingSystem/version/version", OperatingSystemIF::getVersionVersion)
    		.add(Methods.GET, "/systemInfo/operatingSystem/version/codeName", OperatingSystemIF::getVersionCodeName)
    		.add(Methods.GET, "/systemInfo/operatingSystem/version/build", OperatingSystemIF::getVersionBuild)
    		// FileSystem
    		.add(Methods.GET, "/systemInfo/operatingSystem/fileSystem", OperatingSystemIF::getFileSystem)
    		.add(Methods.GET, "/systemInfo/operatingSystem/fileSystem/openFileDescriptors", OperatingSystemIF::getFileSystemOpenFileDescriptors)
    		.add(Methods.GET, "/systemInfo/operatingSystem/fileSystem/maxFileDescriptors", OperatingSystemIF::getFileSystemMaxFileDescriptors)
    		.add(Methods.GET, "/systemInfo/operatingSystem/fileSystem/fileStores", OperatingSystemIF::getFileSystemFileStores)
    		.add(Methods.GET, "/systemInfo/operatingSystem/fileSystem/fileStores/{index}", OperatingSystemIF::getFileSystemFileStoreByIndex)
    		.add(Methods.GET, "/systemInfo/operatingSystem/fileSystem/fileStores/{index}/name", OperatingSystemIF::getFileSystemFileStoreByIndexName)
    		.add(Methods.GET, "/systemInfo/operatingSystem/fileSystem/fileStores/{index}/volume", OperatingSystemIF::getFileSystemFileStoreByIndexVolume)
    		.add(Methods.GET, "/systemInfo/operatingSystem/fileSystem/fileStores/{index}/mountPoint", OperatingSystemIF::getFileSystemFileStoreByIndexMountPoint)
    		.add(Methods.GET, "/systemInfo/operatingSystem/fileSystem/fileStores/{index}/description", OperatingSystemIF::getFileSystemFileStoreByIndexDescription)
    		.add(Methods.GET, "/systemInfo/operatingSystem/fileSystem/fileStores/{index}/fsType", OperatingSystemIF::getFileSystemFileStoreByIndexFsType)
    		.add(Methods.GET, "/systemInfo/operatingSystem/fileSystem/fileStores/{index}/uuid", OperatingSystemIF::getFileSystemFileStoreByIndexUUID)
    		.add(Methods.GET, "/systemInfo/operatingSystem/fileSystem/fileStores/{index}/usableSpace", OperatingSystemIF::getFileSystemFileStoreByIndexUsableSpace)
    		.add(Methods.GET, "/systemInfo/operatingSystem/fileSystem/fileStores/{index}/totalSpace", OperatingSystemIF::getFileSystemFileStoreByIndexTotalSpace)
    		// Processes
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes", OperatingSystemIF::getProcesses)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/byName/{processNames}", OperatingSystemIF::getProcessesByNames)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}", OperatingSystemIF::getProcessesByPid)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/name", OperatingSystemIF::getProcessByPidName)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/priority", OperatingSystemIF::getProcessByPidPriority)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/state", OperatingSystemIF::getProcessByPidState)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/path", OperatingSystemIF::getProcessByPidPath)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/bytesWritten", OperatingSystemIF::getProcessByPidBytesWritten)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/bytesRead", OperatingSystemIF::getProcessByPidBytesRead)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/startTime", OperatingSystemIF::getProcessByPidStartTime)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/threadCount", OperatingSystemIF::getProcessByPidThreadCount)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/commandLine", OperatingSystemIF::getProcessByPidCommandLine)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/userID", OperatingSystemIF::getProcessByPidUserID)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/parentProcessID", OperatingSystemIF::getProcessByPidParentProcessID)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/residentSetSize", OperatingSystemIF::getProcessByPidResidentSetSize)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/kernelTime", OperatingSystemIF::getProcessByPidKernelTime)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/userTime", OperatingSystemIF::getProcessByPidUserTime)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/groupID", OperatingSystemIF::getProcessByPidGroupID)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/virtualSize", OperatingSystemIF::getProcessByPidVirtualSize)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/openFiles", OperatingSystemIF::getProcessByPidOpenFiles)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/upTime", OperatingSystemIF::getProcessByPidUptime)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/group", OperatingSystemIF::getProcessByPidGroup)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/user", OperatingSystemIF::getProcessByPidUser)
    		.add(Methods.GET, "/systemInfo/operatingSystem/processes/{pid}/currentWorkingDirectory", OperatingSystemIF::getProcessByPidCurrentWorkingDirectory)
    		// NetworkParams
    		.add(Methods.GET, "/systemInfo/operatingSystem/networkParams", OperatingSystemIF::getNetworkParams)
    		.add(Methods.GET, "/systemInfo/operatingSystem/networkParams/hostName", OperatingSystemIF::getNetworkParamsHostName)
    		.add(Methods.GET, "/systemInfo/operatingSystem/networkParams/domainName", OperatingSystemIF::getNetworkParamsDomainName)
    		.add(Methods.GET, "/systemInfo/operatingSystem/networkParams/dnsServers", OperatingSystemIF::getNetworkParamsDnsServers)
    		.add(Methods.GET, "/systemInfo/operatingSystem/networkParams/ipv4DefaultGateway", OperatingSystemIF::getNetworkParamsIpv4DefaultGateway)
    		.add(Methods.GET, "/systemInfo/operatingSystem/networkParams/ipv6DefaultGateway", OperatingSystemIF::getNetworkParamsIpv6DefaultGateway)
    		.setFallbackHandler(Handlers.redirect("/error"));
    	

    	server.addHttpListener(port, "0.0.0.0", handler);
		server.build().start();
    			
    }
}
