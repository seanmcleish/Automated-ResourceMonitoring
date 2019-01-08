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
public class SystemModel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	String systemModelSerialNumber;
	String systemModelManufacturer;
	String systemModelModel;
	@OneToMany(mappedBy = "hardwareSystemModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Hardware> systemModelHardware;

	public SystemModel() {
	}

	public SystemModel(String serialNumber, String manufacturer, String model) {
		super();
		this.systemModelSerialNumber = serialNumber;
		this.systemModelManufacturer = manufacturer;
		this.systemModelModel = model;
		this.systemModelHardware = new HashSet<Hardware>();
	}

	public String getSystemModelSerialNumber() {
		return systemModelSerialNumber;
	}

	public void setSystemModelSerialNumber(String systemModelSerialNumber) {
		this.systemModelSerialNumber = systemModelSerialNumber;
	}

	public String getSystemModelManufacturer() {
		return systemModelManufacturer;
	}

	public void setSystemModelManufacturer(String systemModelManufacturer) {
		this.systemModelManufacturer = systemModelManufacturer;
	}

	public String getSystemModelModel() {
		return systemModelModel;
	}

	public void setSystemModelModel(String systemModelModel) {
		this.systemModelModel = systemModelModel;
	}

	@JsonIgnore
	public Set<Hardware> getSystemModelHardware() {
		return systemModelHardware;
	}

	public void addSystemModelHardware(Hardware systemModelHardware) {
		this.systemModelHardware.add(systemModelHardware);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
