package de.tub.qds.rm.models.values.wrapper;

import java.io.Serializable;


public class DiskPartitionFileStoreWrapper implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String diskSerialNumber;
	String uuid;
	
	public DiskPartitionFileStoreWrapper (String diskSerialNumber, String uuid){
		this.diskSerialNumber = diskSerialNumber;
		this.uuid = uuid;
	}

	public String getDiskSerialNumber() {
		return diskSerialNumber;
	}

	public void setDiskSerialNumber(String diskSerialNumber) {
		this.diskSerialNumber = diskSerialNumber;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
