package de.tub.qds.rm2.models.values.pks;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import de.tub.qds.rm2.models.consts.Network;

@Embeddable
public class NetworkValuePK implements Serializable {

	int networkValueMeasurementId;
	Date networkValueTimestamp;
	@ManyToOne
	Network networkValueNetwork;

	public NetworkValuePK(){}

	public NetworkValuePK(int measurement, Date timestamp, Network network) {
		super();
		this.networkValueMeasurementId = measurement;
		this.networkValueTimestamp = timestamp;
		this.networkValueNetwork = network;
	}

	public int getMeasurement() {
		return networkValueMeasurementId;
	}

	public Date getTimestamp() {
		return networkValueTimestamp;
	}

	public Network getNetwork() {
		return networkValueNetwork;
	}

}
