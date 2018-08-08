package de.tub.qds.rm.models.consts.pks;



import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FirmwarePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String firmwareManufacturer;
	String firmwareName;
	String firmwareDescription;
	String firmwareVersion;
	String firmwareReleaseDate;

	public FirmwarePK(){}
	
	public FirmwarePK(String manufacturer, String name, String description,
			String version, String releaseDate) {
		super();
		this.firmwareManufacturer = manufacturer;
		this.firmwareName = name;
		this.firmwareDescription = description;
		this.firmwareVersion = version;
		this.firmwareReleaseDate = releaseDate;
	}

	public String getFirmwareManufacturer() {
		return firmwareManufacturer;
	}

	public String getFirmwareName() {
		return firmwareName;
	}

	public String geFirmwaretDescription() {
		return firmwareDescription;
	}

	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	public String getFirmwareReleaseDate() {
		return firmwareReleaseDate;
	}

	public String getFirmwareDescription() {
		return firmwareDescription;
	}

	public void setFirmwareDescription(String firmwareDescription) {
		this.firmwareDescription = firmwareDescription;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setFirmwareManufacturer(String firmwareManufacturer) {
		this.firmwareManufacturer = firmwareManufacturer;
	}

	public void setFirmwareName(String firmwareName) {
		this.firmwareName = firmwareName;
	}

	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}

	public void setFirmwareReleaseDate(String firmwareReleaseDate) {
		this.firmwareReleaseDate = firmwareReleaseDate;
	}
}
