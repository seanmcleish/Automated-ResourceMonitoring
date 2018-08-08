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
public class SystemModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	String systemModelSerialNumber;
	String systemModelManufacturer;
	String systemModelModel;
	@OneToMany(mappedBy="hardwareId.hardwareSystemModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Hardware> systemModelHardware;

	public SystemModel(){}

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

	public String getSystemModelManufacturer() {
		return systemModelManufacturer;
	}

	public void setSystemModelManufacturer(String manufacturer) {
		this.systemModelManufacturer = manufacturer;
	}

	public String getSystemModelModel() {
		return systemModelModel;
	}

	public void setSystemModelModel(String model) {
		this.systemModelModel = model;
	}


	public Set<Hardware> getSystemModelHardware() {
		return systemModelHardware;
	}
	public void addSystemModelHardware(Hardware hardware){
		this.systemModelHardware.add(hardware);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setSystemModelSerialNumber(String systemModelSerialNumber) {
		this.systemModelSerialNumber = systemModelSerialNumber;
	}

	public void setSystemModelHardware(Set<Hardware> systemModelHardware) {
		this.systemModelHardware = systemModelHardware;
	}

}
