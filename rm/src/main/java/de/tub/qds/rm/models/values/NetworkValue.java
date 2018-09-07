package de.tub.qds.rm.models.values;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import de.tub.qds.rm.models.values.pks.NetworkValuePK;

@Entity
public class NetworkValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	NetworkValuePK networkValueId;
	Long networkValueBytesRecv;
	Long networkValueBytesSent;
	Long networkValuePacketsRecv;
	Long networkValuePacketsSent;
	Long networkValueInErrors;
	Long networkValueOutErrors;

	public NetworkValue() {
	}

	public NetworkValue(NetworkValuePK id, Long bytesRecv, Long bytesSent, Long packetsRecv, Long packetsSent,
			Long inErrors, Long outErrors) {
		super();
		this.networkValueId = id;
		this.networkValueBytesRecv = bytesRecv;
		this.networkValueBytesSent = bytesSent;
		this.networkValuePacketsRecv = packetsRecv;
		this.networkValuePacketsSent = packetsSent;
		this.networkValueInErrors = inErrors;
		this.networkValueOutErrors = outErrors;
	}

	
	public NetworkValuePK getNetworkValueId() {
		return networkValueId;
	}

	public void setNetworkValueId(NetworkValuePK networkValueId) {
		this.networkValueId = networkValueId;
	}

	public Long getNetworkValueBytesRecv() {
		return networkValueBytesRecv;
	}

	public void setNetworkValueBytesRecv(Long networkValueBytesRecv) {
		this.networkValueBytesRecv = networkValueBytesRecv;
	}

	public Long getNetworkValueBytesSent() {
		return networkValueBytesSent;
	}

	public void setNetworkValueBytesSent(Long networkValueBytesSent) {
		this.networkValueBytesSent = networkValueBytesSent;
	}

	public Long getNetworkValuePacketsRecv() {
		return networkValuePacketsRecv;
	}

	public void setNetworkValuePacketsRecv(Long networkValuePacketsRecv) {
		this.networkValuePacketsRecv = networkValuePacketsRecv;
	}

	public Long getNetworkValuePacketsSent() {
		return networkValuePacketsSent;
	}

	public void setNetworkValuePacketsSent(Long networkValuePacketsSent) {
		this.networkValuePacketsSent = networkValuePacketsSent;
	}

	public Long getNetworkValueInErrors() {
		return networkValueInErrors;
	}

	public void setNetworkValueInErrors(Long networkValueInErrors) {
		this.networkValueInErrors = networkValueInErrors;
	}

	public Long getNetworkValueOutErrors() {
		return networkValueOutErrors;
	}

	public void setNetworkValueOutErrors(Long networkValueOutErrors) {
		this.networkValueOutErrors = networkValueOutErrors;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
