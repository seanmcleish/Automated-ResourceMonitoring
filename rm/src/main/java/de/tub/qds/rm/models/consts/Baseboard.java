package de.tub.qds.rm.models.consts;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Baseboard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	String baseboardSerialNumber;
	String baseboardManufacturer;
	String baseboardModel;
	String baseboardVersion;
	@OneToMany (mappedBy = "hardwareId.hardwareBaseboard", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

	public String getBaseboardSerialNumber() {
		return baseboardSerialNumber;
	}

	public void setBaseboardSerialNumber(String baseboardSerialNumber) {
		this.baseboardSerialNumber = baseboardSerialNumber;
	}

	public String getBaseboardManufacturer() {
		return baseboardManufacturer;
	}

	public void setBaseboardManufacturer(String baseboardManufacturer) {
		this.baseboardManufacturer = baseboardManufacturer;
	}

	public String getBaseboardModel() {
		return baseboardModel;
	}

	public void setBaseboardModel(String baseboardModel) {
		this.baseboardModel = baseboardModel;
	}

	public String getBaseboardVersion() {
		return baseboardVersion;
	}

	public void setBaseboardVersion(String baseboardVersion) {
		this.baseboardVersion = baseboardVersion;
	}

	public Set<Hardware> getBaseboardHardware() {
		return baseboardHardware;
	}

	public void setBaseboardHardware(Set<Hardware> baseboardHardware) {
		this.baseboardHardware = baseboardHardware;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
