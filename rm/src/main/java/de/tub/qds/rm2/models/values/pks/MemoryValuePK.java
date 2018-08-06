package de.tub.qds.rm2.models.values.pks;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import de.tub.qds.rm2.models.consts.Memory;


@Embeddable
public class MemoryValuePK implements Serializable {

	long memoryValueMeasurementId;
	Date memoryValueTimestamp;
	@ManyToOne
	Memory memoryValueMemory;

	public MemoryValuePK(){}

	public MemoryValuePK(long measurement, Date timestamp, Memory memory) {
		super();
		this.memoryValueMeasurementId = measurement;
		this.memoryValueTimestamp = timestamp;
		this.memoryValueMemory = memory;
	}

	public long getMeasurement() {
		return memoryValueMeasurementId;
	}

	public Date getTimestamp() {
		return memoryValueTimestamp;
	}

	public Memory getMemory() {
		return memoryValueMemory;
	}
}
