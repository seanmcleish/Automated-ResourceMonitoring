package de.tub.qds.rm2.models.consts;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Baseboard implements Serializable {

	@Id
	String baseboardSerialNumber;
	String baseboardManufacturer;
	String baseboardModel;
	String baseboardVersion;
	@OneToMany (mappedBy = "hardwareId.hardwareBaseboard")
	Set<Hardware> baseboardHardware;

	public Baseboard(){}

	public Baseboard(String serialNumber, String manufacturer, String model, String version) {
		super();
		this.baseboardSerialNumber = serialNumber;
		this.baseboardManufacturer = manufacturer;
		this.baseboardModel = model;
		this.baseboardVersion = version;
		this.baseboardHardware = new HashSet<Hardware>();
	}

	
	public String getSerialNumber() {
		return baseboardSerialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.baseboardSerialNumber = serialNumber;
	}

	public String getManufacturer() {
		return baseboardManufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.baseboardManufacturer = manufacturer;
	}

	public String getModel() {
		return baseboardModel;
	}

	public void setModel(String model) {
		this.baseboardModel = model;
	}

	public String getVersion() {
		return baseboardVersion;
	}

	public void setVersion(String version) {
		this.baseboardVersion = version;
	}

	public Set<Hardware> getHardware() {
		return baseboardHardware;
	}

}
