package de.tub.qds.rm.models.consts;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Firmware implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	Long firmwareIdentifier;
	String firmwareManufacturer;
	String firmwareName;
	String firmwareDescription;
	String firmwareVersion;
	String firmwareReleaseDate;
	@OneToMany(mappedBy = "hardwareFirmware", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Hardware> hardware;

	public Firmware() {
	}

	public Firmware(String firmwareManufacturer, String firmwareName, String firmwareDescription, String firmwareVersion, String firmwareReleaseDate) {
		super();
		this.firmwareManufacturer = firmwareManufacturer;
		this.firmwareName = firmwareName;
		this.firmwareDescription = firmwareDescription;
		this.firmwareVersion = firmwareVersion;
		this.firmwareReleaseDate = firmwareReleaseDate;
		this.hardware = new HashSet<Hardware>();
	}

	public Long getFirmwareIdentifier() {
		return firmwareIdentifier;
	}

	public String getFirmwareManufacturer() {
		return firmwareManufacturer;
	}

	public void setFirmwareManufacturer(String firmwareManufacturer) {
		this.firmwareManufacturer = firmwareManufacturer;
	}

	public String getFirmwareName() {
		return firmwareName;
	}

	public void setFirmwareName(String firmwareName) {
		this.firmwareName = firmwareName;
	}

	public String getFirmwareDescription() {
		return firmwareDescription;
	}

	public void setFirmwareDescription(String firmwareDescription) {
		this.firmwareDescription = firmwareDescription;
	}

	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}

	public String getFirmwareReleaseDate() {
		return firmwareReleaseDate;
	}

	public void setFirmwareReleaseDate(String firmwareReleaseDate) {
		this.firmwareReleaseDate = firmwareReleaseDate;
	}

	@JsonIgnore
	public Set<Hardware> getHardware() {
		return hardware;
	}

	public void addHardware(Hardware hardware) {
		this.hardware.add(hardware);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
