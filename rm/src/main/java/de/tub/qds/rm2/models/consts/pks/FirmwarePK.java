package de.tub.qds.rm2.models.consts.pks;



import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Embeddable
public class FirmwarePK implements Serializable {

	@NotNull
	String firmwareManufacturer;
	@NotNull
	String firmwareName;
	@NotNull
	String firmwareDescription;
	@NotNull
	String firmwareVersion;
	@NotNull
	String firmwareReleaseDate;

	public FirmwarePK(){}
	
	public FirmwarePK(@NotNull String manufacturer, @NotNull String name, @NotNull String description,
			@NotNull String version, @NotNull String releaseDate) {
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
}
