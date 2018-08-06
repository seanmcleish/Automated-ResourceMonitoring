package de.tub.qds.rm2.models.consts;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import de.tub.qds.rm2.models.consts.pks.FirmwarePK;

@Entity
public class Firmware implements Serializable {

	@EmbeddedId
	FirmwarePK firmwareId;
	@OneToMany(mappedBy = "hardwareId.hardwareFirmware", targetEntity = Hardware.class)
	Set<Hardware> hardware;
	
	public Firmware(){}

	public Firmware(FirmwarePK id) {
		super();
		this.firmwareId = id;
		this.hardware = new HashSet<Hardware>();
	}

	
	public FirmwarePK getId() {
		return firmwareId;
	}

	public void setFirmwareId(FirmwarePK id) {
		this.firmwareId = id;
	}

	public Set<Hardware> getFirmwareHardware() {
		return hardware;
	}

	public void addFirmwareHardware(Hardware hardware) {
		this.hardware.add(hardware);
	}

}
