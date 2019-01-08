package de.tub.qds.rm.models.values.pks;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tub.qds.rm.models.consts.Network;

@Embeddable
public class NetworkValuePK implements Serializable {

	private static final long serialVersionUID = 1L;
	Long networkValueMeasurementId;
	Timestamp networkValueTimestamp;
	@ManyToOne(targetEntity=Network.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Network networkValueNetwork;

	public NetworkValuePK() {
	}

	public NetworkValuePK(Long measurement, Timestamp timestamp, Network network) {
		super();
		this.networkValueMeasurementId = measurement;
		this.networkValueTimestamp = timestamp;
		this.networkValueNetwork = network;
	}

	public Long getNetworkValueMeasurementId() {
		return networkValueMeasurementId;
	}

	public void setNetworkValueMeasurementId(Long networkValueMeasurementId) {
		this.networkValueMeasurementId = networkValueMeasurementId;
	}

	public Timestamp getNetworkValueTimestamp() {
		return networkValueTimestamp;
	}

	public void setNetworkValueTimestamp(Timestamp networkValueTimestamp) {
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
