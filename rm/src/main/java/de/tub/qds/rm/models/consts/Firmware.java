package de.tub.qds.rm.models.consts;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import de.tub.qds.rm.models.consts.pks.FirmwarePK;

@Entity
public class Firmware implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	FirmwarePK firmwareId;
	@OneToMany(mappedBy = "hardwareId.hardwareFirmware", targetEntity = Hardware.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

	public Set<Hardware> getHardware() {
		return hardware;
	}

	public void setHardware(Set<Hardware> hardware) {
		this.hardware = hardware;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public FirmwarePK getFirmwareId() {
		return firmwareId;
	}

}
