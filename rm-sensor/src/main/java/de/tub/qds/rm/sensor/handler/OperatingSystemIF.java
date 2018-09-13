package de.tub.qds.rm.sensor.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import oshi.json.SystemInfo;
import oshi.json.software.os.OSFileStore;
import oshi.json.software.os.OperatingSystemVersion;
import oshi.software.os.OSProcess;

public interface OperatingSystemIF {

	/*
	 * GENERAL
	 */
	public static void getOperatingSystem(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		String response = new SystemInfo().getOperatingSystem().toJSON().toString();
		exchange.getResponseSender().send(response);
	}

	public static void getManufacturer(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		String response = new SystemInfo().getOperatingSystem().getManufacturer();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getFamily(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		String response = new SystemInfo().getOperatingSystem().getFamily();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessID(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int response = new SystemInfo().getOperatingSystem().getProcessId();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessCount(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int response = new SystemInfo().getOperatingSystem().getProcessCount();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getThreadCount(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int response = new SystemInfo().getOperatingSystem().getThreadCount();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	/*
	 * VERSION
	 */

	public static void getVersion(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		OperatingSystemVersion response = new SystemInfo().getOperatingSystem().getVersion();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getVersionVersion(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		String response = new SystemInfo().getOperatingSystem().getVersion().getVersion();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getVersionCodeName(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		String response = new SystemInfo().getOperatingSystem().getVersion().getCodeName();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getVersionBuild(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		String response = new SystemInfo().getOperatingSystem().getVersion().getBuildNumber();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	/*
	 * FILESYSTEM
	 */

	public static void getFileSystem(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		String response = new SystemInfo().getOperatingSystem().getFileSystem().toJSON().toString();
		exchange.getResponseSender().send(response);
	}

	public static void getFileSystemOpenFileDescriptors(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		long response = new SystemInfo().getOperatingSystem().getFileSystem().getOpenFileDescriptors();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getFileSystemMaxFileDescriptors(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		long response = new SystemInfo().getOperatingSystem().getFileSystem().getMaxFileDescriptors();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getFileSystemFileStores(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		OSFileStore[] response = new SystemInfo().getOperatingSystem().getFileSystem().getFileStores();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getFileSystemFileStoreByIndex(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		OSFileStore[] fileStores = new SystemInfo().getOperatingSystem().getFileSystem().getFileStores();
		if (index > fileStores.length - 1) {
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = fileStores[index].toJSON().toString();
		exchange.getResponseSender().send(response);
	}

	public static void getFileSystemFileStoreByIndexName(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		OSFileStore[] fileStores = new SystemInfo().getOperatingSystem().getFileSystem().getFileStores();
		if (index > fileStores.length - 1) {
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = fileStores[index].getName();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getFileSystemFileStoreByIndexVolume(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		OSFileStore[] fileStores = new SystemInfo().getOperatingSystem().getFileSystem().getFileStores();
		if (index > fileStores.length - 1) {
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = fileStores[index].getVolume();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getFileSystemFileStoreByIndexMountPoint(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		OSFileStore[] fileStores = new SystemInfo().getOperatingSystem().getFileSystem().getFileStores();
		if (index > fileStores.length - 1) {
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = fileStores[index].getMount();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getFileSystemFileStoreByIndexDescription(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		OSFileStore[] fileStores = new SystemInfo().getOperatingSystem().getFileSystem().getFileStores();
		if (index > fileStores.length - 1) {
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = fileStores[index].getDescription();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getFileSystemFileStoreByIndexFsType(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		OSFileStore[] fileStores = new SystemInfo().getOperatingSystem().getFileSystem().getFileStores();
		if (index > fileStores.length - 1) {
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = fileStores[index].getType();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getFileSystemFileStoreByIndexUUID(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		OSFileStore[] fileStores = new SystemInfo().getOperatingSystem().getFileSystem().getFileStores();
		if (index > fileStores.length - 1) {
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		String response = fileStores[index].getUUID();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getFileSystemFileStoreByIndexUsableSpace(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		OSFileStore[] fileStores = new SystemInfo().getOperatingSystem().getFileSystem().getFileStores();
		if (index > fileStores.length - 1) {
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = fileStores[index].getUsableSpace();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getFileSystemFileStoreByIndexTotalSpace(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int index = Integer.parseInt(exchange.getQueryParameters().get("index").getFirst());
		OSFileStore[] fileStores = new SystemInfo().getOperatingSystem().getFileSystem().getFileStores();
		if (index > fileStores.length - 1) {
			exchange.getResponseSender().send(new Gson().toJson(null));
			return;
		}
		long response = fileStores[index].getTotalSpace();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	/*
	 * PROCESSES
	 */

	public static void getProcesses(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		OSProcess[] response = new oshi.SystemInfo().getOperatingSystem().getProcesses(0, null);
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	public static void getProcessesByNames(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		ArrayList<String> processNames = new ArrayList<String>();
		Arrays.stream(exchange.getQueryParameters().get("processNames").getFirst().split(",")).forEach(processName -> processNames.add(String.valueOf(processName)));
		List<OSProcess> response =  Stream.of(new oshi.SystemInfo().getOperatingSystem().getProcesses(0, null)).filter(x -> processNames.contains(x.getName())).collect(Collectors.toList());
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessesByPid(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		ArrayList<Integer> pids = new ArrayList<Integer>();
		Arrays.stream(exchange.getQueryParameters().get("pid").getFirst().split(",")).forEach(pid -> pids.add(Integer.parseInt(pid)));
		
		List<OSProcess> response = new oshi.SystemInfo().getOperatingSystem().getProcesses(pids);
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidName(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		String response = new SystemInfo().getOperatingSystem().getProcess(pid).getName();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidPriority(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		int response = new SystemInfo().getOperatingSystem().getProcess(pid).getPriority();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidState(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		String response = new SystemInfo().getOperatingSystem().getProcess(pid).getState().toString();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidPath(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		String response = new SystemInfo().getOperatingSystem().getProcess(pid).getPath();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidBytesWritten(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		long response = new SystemInfo().getOperatingSystem().getProcess(pid).getBytesWritten();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidBytesRead(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		long response = new SystemInfo().getOperatingSystem().getProcess(pid).getBytesRead();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidStartTime(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		long response = new SystemInfo().getOperatingSystem().getProcess(pid).getStartTime();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidThreadCount(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		int response = new SystemInfo().getOperatingSystem().getProcess(pid).getThreadCount();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidCommandLine(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		String response = new SystemInfo().getOperatingSystem().getProcess(pid).getCommandLine();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidUserID(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		String response = new SystemInfo().getOperatingSystem().getProcess(pid).getUserID();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidParentProcessID(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		int response = new SystemInfo().getOperatingSystem().getProcess(pid).getParentProcessID();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidResidentSetSize(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		long response = new SystemInfo().getOperatingSystem().getProcess(pid).getResidentSetSize();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidKernelTime(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		long response = new SystemInfo().getOperatingSystem().getProcess(pid).getKernelTime();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidUserTime(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		long response = new SystemInfo().getOperatingSystem().getProcess(pid).getUserTime();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidGroupID(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		String response = new SystemInfo().getOperatingSystem().getProcess(pid).getGroupID();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidVirtualSize(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		long response = new SystemInfo().getOperatingSystem().getProcess(pid).getVirtualSize();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}
	
	public static void getProcessByPidOpenFiles(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		long response = new SystemInfo().getOperatingSystem().getProcess(pid).getOpenFiles();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidUptime(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		long response = new SystemInfo().getOperatingSystem().getProcess(pid).getUpTime();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidGroup(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		String response = new SystemInfo().getOperatingSystem().getProcess(pid).getGroup();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidUser(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		String response = new SystemInfo().getOperatingSystem().getProcess(pid).getUser();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getProcessByPidCurrentWorkingDirectory(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		int pid = Integer.parseInt(exchange.getQueryParameters().get("pid").getFirst());
		String response = new SystemInfo().getOperatingSystem().getProcess(pid).getCurrentWorkingDirectory();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	/*
	 * NETWORKPARAMS
	 */

	public static void getNetworkParams(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		String response = new SystemInfo().getOperatingSystem().getNetworkParams().toJSON().toString();
		exchange.getResponseSender().send(response);
	}

	public static void getNetworkParamsHostName(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		String response = new SystemInfo().getOperatingSystem().getNetworkParams().getHostName();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getNetworkParamsDomainName(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		String response = new SystemInfo().getOperatingSystem().getNetworkParams().getDomainName();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getNetworkParamsDnsServers(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		String[] response = new SystemInfo().getOperatingSystem().getNetworkParams().getDnsServers();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getNetworkParamsIpv4DefaultGateway(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		String response = new SystemInfo().getOperatingSystem().getNetworkParams().getIpv4DefaultGateway();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

	public static void getNetworkParamsIpv6DefaultGateway(HttpServerExchange exchange) {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		String response = new SystemInfo().getOperatingSystem().getNetworkParams().getIpv6DefaultGateway();
		exchange.getResponseSender().send(new Gson().toJson(response));
	}

}
