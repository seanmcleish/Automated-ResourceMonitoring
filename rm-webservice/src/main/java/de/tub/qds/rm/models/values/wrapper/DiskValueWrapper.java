package de.tub.qds.rm.models.values.wrapper;

import java.io.Serializable;

public class DiskValueWrapper<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	T diskValueReads;
	T diskValueReadBytes;
	T diskValueWrites;
	T diskValueWriteBytes;
	T diskValueTransferTime;
	
	public DiskValueWrapper (T diskValueReads, T diskValueReadBytes, T diskValueWrites, T diskValueWriteBytes, T diskValueTransferTime){
		this.diskValueReads = diskValueReads;
		this.diskValueReadBytes = diskValueReadBytes;
		this.diskValueWrites = diskValueWrites;
		this.diskValueWriteBytes = diskValueWriteBytes;
		this.diskValueTransferTime = diskValueTransferTime;
	}

	public T getDiskValueReads() {
		return diskValueReads;
	}

	public void setDiskValueReads(T diskValueReads) {
		this.diskValueReads = diskValueReads;
	}

	public T getDiskValueReadBytes() {
		return diskValueReadBytes;
	}

	public void setDiskValueReadBytes(T diskValueReadBytes) {
		this.diskValueReadBytes = diskValueReadBytes;
	}

	public T getDiskValueWrites() {
		return diskValueWrites;
	}

	public void setDiskValueWrites(T diskValueWrites) {
		this.diskValueWrites = diskValueWrites;
	}

	public T getDiskValueWriteBytes() {
		return diskValueWriteBytes;
	}

	public void setDiskValueWriteBytes(T diskValueWriteBytes) {
		this.diskValueWriteBytes = diskValueWriteBytes;
	}

	public T getDiskValueTransferTime() {
		return diskValueTransferTime;
	}

	public void setDiskValueTransferTime(T diskValueTransferTime) {
		this.diskValueTransferTime = diskValueTransferTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
