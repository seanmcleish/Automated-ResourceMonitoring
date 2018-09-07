package de.tub.qds.rm.models.values;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import de.tub.qds.rm.models.values.pks.DiskValuePK;

// FINISHED IMPLEMENTATION
@Entity
public class DiskValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	DiskValuePK diskValueId;
	Long diskValueReads;
	Long diskValueReadBytes;
	Long diskValueWrites;
	Long diskValueWriteBytes;
	Long diskValueTransferTime;

	public DiskValue() 
	{
	}

	public DiskValue(DiskValuePK id,Long reads,Long readBytes, Long writes, Long writeBytes, Long transferTime) {
		super();
		this.diskValueId = id;
		this.diskValueReads = reads;
		this.diskValueReadBytes = readBytes;
		this.diskValueWrites = writes;
		this.diskValueWriteBytes = writeBytes;
		this.diskValueTransferTime = transferTime;
	}

	public DiskValuePK getDiskValueId() {
		return diskValueId;
	}

	public void setDiskValueId(DiskValuePK diskValueId) {
		this.diskValueId = diskValueId;
	}

	public Long getDiskValueReads() {
		return diskValueReads;
	}

	public void setDiskValueReads(Long diskValueReads) {
		this.diskValueReads = diskValueReads;
	}

	public Long getDiskValueReadBytes() {
		return diskValueReadBytes;
	}

	public void setDiskValueReadBytes(Long diskValueReadBytes) {
		this.diskValueReadBytes = diskValueReadBytes;
	}

	public Long getDiskValueWrites() {
		return diskValueWrites;
	}

	public void setDiskValueWrites(Long diskValueWrites) {
		this.diskValueWrites = diskValueWrites;
	}

	public Long getDiskValueWriteBytes() {
		return diskValueWriteBytes;
	}

	public void setDiskValueWriteBytes(Long diskValueWriteBytes) {
		this.diskValueWriteBytes = diskValueWriteBytes;
	}

	public Long getDiskValueTransferTime() {
		return diskValueTransferTime;
	}

	public void setDiskValueTransferTime(Long diskValueTransferTime) {
		this.diskValueTransferTime = diskValueTransferTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
