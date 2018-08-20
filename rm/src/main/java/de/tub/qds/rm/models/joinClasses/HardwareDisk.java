package de.tub.qds.rm.models.joinClasses;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HardwareDisk implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	long hardwareDiskId;
	long hardwareIdentifier;
	String diskSerialNumber;

	public HardwareDisk() {
	}

	public HardwareDisk(long hardwareIdentifier, String diskSerialNumber) {
		this.hardwareIdentifier = hardwareIdentifier;
		this.diskSerialNumber = diskSerialNumber;
	}

	public long getHardwareDiskId() {
		return hardwareDiskId;
	}

	public void setHardwareDiskId(long hardwareDiskId) {
		this.hardwareDiskId = hardwareDiskId;
	}

	public long getHardwareIdentifier() {
		return hardwareIdentifier;
	}

	public void setHardwareIdentifier(long hardwareIdentifier) {
		this.hardwareIdentifier = hardwareIdentifier;
	}

	public String getDiskSerialNumber() {
		return diskSerialNumber;
	}

	public void setDiskSerialNumber(String diskSerialNumber) {
		this.diskSerialNumber = diskSerialNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
