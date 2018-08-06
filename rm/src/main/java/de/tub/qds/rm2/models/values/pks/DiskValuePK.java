package de.tub.qds.rm2.models.values.pks;




import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import de.tub.qds.rm2.models.consts.Disk;

@Embeddable
public class DiskValuePK implements Serializable {

	@ManyToOne(targetEntity = Disk.class)
	Disk diskValueDisk;
	int diskValueMeasurementId;
	Date diskValueTimestamp;

	public DiskValuePK(){}

	public DiskValuePK(Disk disk, int measurement, Date timestamp) {
		super();
		this.diskValueDisk = disk;
		this.diskValueMeasurementId = measurement;
		this.diskValueTimestamp = timestamp;
	}

	public Disk getDiskValueDisk() {
		return diskValueDisk;
	}

	public int getDiskValueMeasurement() {
		return diskValueMeasurementId;
	}

	public Date getDiskValueTimestamp() {
		return diskValueTimestamp;
	}
}
