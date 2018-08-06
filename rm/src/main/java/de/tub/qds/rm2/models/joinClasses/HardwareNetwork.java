package de.tub.qds.rm2.models.joinClasses;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import de.tub.qds.rm2.models.consts.pks.HardwarePK;

@Entity
public class HardwareNetwork implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id@GeneratedValue int id;
	HardwarePK hardwareId;
	String networkMac;
	
	public HardwareNetwork(){}
	
	public HardwareNetwork(HardwarePK hardwareId, String networkMac){
		this.hardwareId = hardwareId;
		this.networkMac = networkMac;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HardwarePK getHardwareId() {
		return hardwareId;
	}

	public void setHardwareId(HardwarePK hardwareId) {
		this.hardwareId = hardwareId;
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
