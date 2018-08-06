package de.tub.qds.rm2.models.values;




import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import de.tub.qds.rm2.models.consts.Disk;
import de.tub.qds.rm2.models.values.pks.DiskValuePK;

@Entity
public class DiskValue implements Serializable {

	@EmbeddedId
	DiskValuePK diskValueId;
	long diskValueReads;
	long diskValueReadBytes;
	long diskValueWrites;
	long diskValueWriteBytes;
	long diskValueTransferTime;
	
	public DiskValue(){}

	public DiskValue(DiskValuePK id, Disk disk, long reads, long readBytes, long writes, long writeBytes, long transferTime) {
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

	public long getDiskValueReads() {
		return diskValueReads;
	}

	public void setDiskValueReads(long reads) {
		this.diskValueReads = reads;
	}

	public long getDiskValueReadBytes() {
		return diskValueReadBytes;
	}

	public void setDiskValueReadBytes(long readBytes) {
		this.diskValueReadBytes = readBytes;
	}

	public long getDiskValueWrites() {
		return diskValueWrites;
	}

	public void setDiskValueWrites(long writes) {
		this.diskValueWrites = writes;
	}

	public long getDiskValueWriteBytes() {
		return diskValueWriteBytes;
	}

	public void setDiskValueWriteBytes(long writeBytes) {
		this.diskValueWriteBytes = writeBytes;
	}

	public long getDiskValueTransferTime() {
		return diskValueTransferTime;
	}

	public void setDiskValueTransferTime(long transferTime) {
		this.diskValueTransferTime = transferTime;
	}

}
