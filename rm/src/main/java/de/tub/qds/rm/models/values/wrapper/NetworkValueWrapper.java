package de.tub.qds.rm.models.values.wrapper;

import java.io.Serializable;

public class NetworkValueWrapper<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	T networkValueBytesRecv;
	T networkValueBytesSent;
	T networkValuePacketsRecv;
	T networkValuePacketsSent;
	T networkValueInErrors;
	T networkValueOutErrors;
	
	public NetworkValueWrapper(T networkValueBytesRecv, T networkValueBytesSent, T networkValuePacketsRecv,
			T networkValuePacketsSent, T networkValueInErrors, T networkValueOutErrors) {
		super();
		this.networkValueBytesRecv = networkValueBytesRecv;
		this.networkValueBytesSent = networkValueBytesSent;
		this.networkValuePacketsRecv = networkValuePacketsRecv;
		this.networkValuePacketsSent = networkValuePacketsSent;
		this.networkValueInErrors = networkValueInErrors;
		this.networkValueOutErrors = networkValueOutErrors;
	}

	public T getNetworkValueBytesRecv() {
		return networkValueBytesRecv;
	}

	public void setNetworkValueBytesRecv(T networkValueBytesRecv) {
		this.networkValueBytesRecv = networkValueBytesRecv;
	}

	public T getNetworkValueBytesSent() {
		return networkValueBytesSent;
	}

	public void setNetworkValueBytesSent(T networkValueBytesSent) {
		this.networkValueBytesSent = networkValueBytesSent;
	}

	public T getNetworkValuePacketsRecv() {
		return networkValuePacketsRecv;
	}

	public void setNetworkValuePacketsRecv(T networkValuePacketsRecv) {
		this.networkValuePacketsRecv = networkValuePacketsRecv;
	}

	public T getNetworkValuePacketsSent() {
		return networkValuePacketsSent;
	}

	public void setNetworkValuePacketsSent(T networkValuePacketsSent) {
		this.networkValuePacketsSent = networkValuePacketsSent;
	}

	public T getNetworkValueInErrors() {
		return networkValueInErrors;
	}

	public void setNetworkValueInErrors(T networkValueInErrors) {
		this.networkValueInErrors = networkValueInErrors;
	}

	public T getNetworkValueOutErrors() {
		return networkValueOutErrors;
	}

	public void setNetworkValueOutErrors(T networkValueOutErrors) {
		this.networkValueOutErrors = networkValueOutErrors;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
