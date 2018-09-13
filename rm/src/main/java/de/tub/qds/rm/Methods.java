package de.tub.qds.rm;

import java.net.InetAddress;

public interface Methods {
	
	public static String ipResolve(String hostName){
		InetAddress response = null;
		try{
			response = InetAddress.getByName(hostName);
		}catch(Exception e){
			java.lang.System.out.println(e.getMessage());
		}
		return response.getHostAddress();
	}
}
