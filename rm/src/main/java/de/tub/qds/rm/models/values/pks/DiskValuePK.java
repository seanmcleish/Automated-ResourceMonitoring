package de.tub.qds.rm.models.values.pks;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tub.qds.rm.models.consts.Disk;

@Embeddable
public class DiskValuePK implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManyToOne(targetEntity = Disk.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Disk diskValueDisk;
	Long diskValueMeasurementId;
	Timestamp diskValueTimestamp;

	public DiskValuePK() {
	}

	public DiskValuePK(Disk disk, Long measurement, Timestamp timestamp) {
		super();
		this.diskValueDisk = disk;
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

	public Long getDiskValueMeasurementId() {
		return diskValueMeasurementId;
	}

	public void setDiskValueMeasurementId(Long diskValueMeasurementId) {
		this.diskValueMeasurementId = diskValueMeasurementId;
	}

	public Timestamp getDiskValueTimestamp() {
		return diskValueTimestamp;
	}

	public void setDiskValueTimestamp(Timestamp diskValueTimestamp) {
		this.diskValueTimestamp = diskValueTimestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
