package de.tub.qds.rm.sensor.handler;

import com.google.gson.Gson;

import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import oshi.json.SystemInfo;




public interface SystemIF {
	
	public static void getSystemInfo(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new SystemInfo().toJSON().toString();
		exchange.getResponseSender().send(response);
    }
	
	public static void getSystemInfoPlatform(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new Gson().toJson(SystemInfo.getCurrentPlatformEnum().toString());
		exchange.getResponseSender().send(response);
    }
	
	public static void getError(HttpServerExchange exchange)
	{
		exchange.getResponseHeaders().add(new HttpString("Content-Type"),"application/json");
		String response = new Gson().toJson(null);
		exchange.getResponseSender().send(response);
    }

	
	
}
