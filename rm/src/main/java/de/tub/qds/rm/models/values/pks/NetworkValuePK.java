package de.tub.qds.rm.models.values.pks;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tub.qds.rm.models.consts.Network;

@Embeddable
public class NetworkValuePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int networkValueMeasurementId;
	Date networkValueTimestamp;
	@ManyToOne
	Network networkValueNetwork;

	public NetworkValuePK() {
	}

	public NetworkValuePK(int measurement, Date timestamp, Network network) {
		super();
		this.networkValueMeasurementId = measurement;
		this.networkValueTimestamp = timestamp;
		this.networkValueNetwork = network;
	}

	public int getNetworkValueMeasurementId() {
		return networkValueMeasurementId;
	}

	public void setNetworkValueMeasurementId(int networkValueMeasurementId) {
		this.networkValueMeasurementId = networkValueMeasurementId;
	}

	public Date getNetworkValueTimestamp() {
		return networkValueTimestamp;
	}

	public void setNetworkValueTimestamp(Date networkValueTimestamp) {
		this.networkValueTimestamp = networkValueTimestamp;
	}

	@JsonIgnore
	public Network getNetworkValueNetwork() {
		return networkValueNetwork;
	}

	public void setNetworkValueNetwork(Network networkValueNetwork) {
		this.networkValueNetwork = networkValueNetwork;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
