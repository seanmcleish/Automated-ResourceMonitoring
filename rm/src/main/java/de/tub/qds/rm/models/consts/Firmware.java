package de.tub.qds.rm.models.consts;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	public Firmware() {
	}

	public Firmware(FirmwarePK id) {
		super();
		this.firmwareId = id;
		this.hardware = new HashSet<Hardware>();
	}

	public FirmwarePK getFirmwareId() {
		return firmwareId;
	}

	public void setFirmwareId(FirmwarePK firmwareId) {
		this.firmwareId = firmwareId;
	}

	@JsonIgnore
	public Set<Hardware> getHardware() {
		return hardware;
	}

	public void setHardware(Set<Hardware> hardware) {
		this.hardware = hardware;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
