package de.tub.qds.rm.models.values.pks;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tub.qds.rm.models.consts.Disk;

@Embeddable
public class DiskValuePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(targetEntity = Disk.class)
	Disk diskValueDisk;
	int diskValueMeasurementId;
	Date diskValueTimestamp;

	public DiskValuePK() {
	}

	public DiskValuePK(int measurement, Date timestamp) {
		super();
		this.diskValueMeasurementId = measurement;
		this.diskValueTimestamp = timestamp;
	}

	@JsonIgnore
	public Disk getDiskValueDisk() {
		return diskValueDisk;
	}

	public void setDiskValueDisk(Disk diskValueDisk) {
		this.diskValueDisk = diskValueDisk;
	}

	public int getDiskValueMeasurementId() {
		return diskValueMeasurementId;
	}

	public void setDiskValueMeasurementId(int diskValueMeasurementId) {
		this.diskValueMeasurementId = diskValueMeasurementId;
	}

	public Date getDiskValueTimestamp() {
		return diskValueTimestamp;
	}

	public void setDiskValueTimestamp(Date diskValueTimestamp) {
		this.diskValueTimestamp = diskValueTimestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
