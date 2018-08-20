package de.tub.qds.rm.models.consts;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@OneToMany(mappedBy = "hardwareId.hardwareBaseboard", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Hardware> baseboardHardware;

	public Baseboard() {
	}

	public Baseboard(String serialNumber, String manufacturer, String model, String version) {
		super();
		this.baseboardSerialNumber = serialNumber;
		this.baseboardManufacturer = manufacturer;
		this.baseboardModel = model;
		this.baseboardVersion = version;
		this.baseboardHardware = new HashSet<Hardware>();
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

	@JsonIgnore
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
