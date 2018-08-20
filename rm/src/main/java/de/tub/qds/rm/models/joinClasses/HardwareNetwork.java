package de.tub.qds.rm.models.joinClasses;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HardwareNetwork implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	long hardwareNetworkId;
	long hardwareIdentifier;
	String networkMac;

	public HardwareNetwork() {
	}

	public HardwareNetwork(long hardwareIdentifier, String networkMac) {
		this.hardwareIdentifier = hardwareIdentifier;
		this.networkMac = networkMac;
	}

	public long getHardwareNetworkId() {
		return hardwareNetworkId;
	}

	public void setHardwareNetworkId(long hardwareNetworkId) {
		this.hardwareNetworkId = hardwareNetworkId;
	}

	public long getHardwareIdentifier() {
		return hardwareIdentifier;
	}

	public void setHardwareIdentifier(long hardwareIdentifier) {
		this.hardwareIdentifier = hardwareIdentifier;
	}

	public String getNetworkMac() {
		return networkMac;
	}

	public void setNetworkMac(String networkMac) {
		this.networkMac = networkMac;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
