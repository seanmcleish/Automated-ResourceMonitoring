package de.tub.qds.rm2.models.values;


import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import de.tub.qds.rm2.models.values.pks.NetworkValuePK;

@Entity
public class NetworkValue implements Serializable {

	@EmbeddedId
	NetworkValuePK networkValueId;
	long networkValueBytesRecv;
	long networkValueBytesSent;
	long networkValuePacketsRecv;
	long networkValuePacketsSent;
	long networkValueInErrors;
	long networkValueOutErrors;

	public NetworkValue(){}

	public NetworkValue(NetworkValuePK id, long bytesRecv, long bytesSent, long packetsRecv, long packetsSent,
			long inErrors, long outErrors) {
		super();
		this.networkValueId = id;
		this.networkValueBytesRecv = bytesRecv;
		this.networkValueBytesSent = bytesSent;
		this.networkValuePacketsRecv = packetsRecv;
		this.networkValuePacketsSent = packetsSent;
		this.networkValueInErrors = inErrors;
		this.networkValueOutErrors = outErrors;
	}

	public long getNetworkValueBytesRecv() {
		return networkValueBytesRecv;
	}

	public void setNetworkValueBytesRecv(long bytesRecv) {
		this.networkValueBytesRecv = bytesRecv;
	}

	public long getNetworkValueBytesSent() {
		return networkValueBytesSent;
	}

	public void setNetworkValueBytesSent(long bytesSent) {
		this.networkValueBytesSent = bytesSent;
	}

	public long getNetworkValuePacketsRecv() {
		return networkValuePacketsRecv;
	}

	public void setNetworkValuePacketsRecv(long packetsRecv) {
		this.networkValuePacketsRecv = packetsRecv;
	}

	public long getNetworkValuePacketsSent() {
		return networkValuePacketsSent;
	}

	public void setNetworkValuePacketsSent(long packetsSent) {
		this.networkValuePacketsSent = packetsSent;
	}

	public long getNetworkValueInErrors() {
		return networkValueInErrors;
	}

	public void setNetworkValueInErrors(long inErrors) {
		this.networkValueInErrors = inErrors;
	}

	public long getNetworkValueOutErrors() {
		return networkValueOutErrors;
	}

	public void setNetworkValueOutErrors(long outErrors) {
		this.networkValueOutErrors = outErrors;
	}

	public NetworkValuePK getNetworkValueId() {
		return networkValueId;
	}
	public void setNetworkValueId(NetworkValuePK id){
		this.networkValueId = id;
	}

}
