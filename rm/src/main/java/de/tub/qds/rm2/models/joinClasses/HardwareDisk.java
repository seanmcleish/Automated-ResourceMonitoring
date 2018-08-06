package de.tub.qds.rm2.models.joinClasses;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import de.tub.qds.rm2.models.consts.pks.HardwarePK;

@Entity
public class HardwareDisk implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue int id;
	HardwarePK hardwareId;
	String diskSerialNumber;
	
	public HardwareDisk(){}
	
	public HardwareDisk(HardwarePK hardwareId, String diskSerialNumber){
		this.hardwareId = hardwareId;
		this.diskSerialNumber = diskSerialNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HardwarePK getHardwareId() {
		return hardwareId;
	}

	public void setHardwareId(HardwarePK hardwareId) {
		this.hardwareId = hardwareId;
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
