package de.tub.qds.rm.models.values.pks;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tub.qds.rm.models.consts.Memory;


@Embeddable
public class MemoryValuePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long memoryValueMeasurementId;
	Date memoryValueTimestamp;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Memory memoryValueMemory;

	public MemoryValuePK(){}

	public MemoryValuePK(Memory memory, long measurement, Date timestamp) {
		super();
		this.memoryValueMemory = memory;
		this.memoryValueMeasurementId = measurement;
		this.memoryValueTimestamp = timestamp;
	}

	public long getMeasurement() {
		return memoryValueMeasurementId;
	}

	public Date getTimestamp() {
		return memoryValueTimestamp;
	}

	@JsonIgnore
	public Memory getMemory() {
		return memoryValueMemory;
	}
}
