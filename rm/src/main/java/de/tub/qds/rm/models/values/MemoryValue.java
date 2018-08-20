package de.tub.qds.rm.models.values;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import de.tub.qds.rm.models.values.pks.MemoryValuePK;

@Entity
public class MemoryValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	MemoryValuePK memoryValueId;
	long memoryValueAvailable;
	long memoryValueSwapTotal;
	long memoryValueSwapUsed;

	public MemoryValue() {
	}

	public MemoryValue(MemoryValuePK id, long available, long swapTotal, long swapUsed) {
		super();
		this.memoryValueId = id;
		this.memoryValueAvailable = available;
		this.memoryValueSwapTotal = swapTotal;
		this.memoryValueSwapUsed = swapUsed;
	}

	
	public MemoryValuePK getMemoryValueId() {
		return memoryValueId;
	}

	public void setMemoryValueId(MemoryValuePK memoryValueId) {
		this.memoryValueId = memoryValueId;
	}

	public long getMemoryValueAvailable() {
		return memoryValueAvailable;
	}

	public void setMemoryValueAvailable(long memoryValueAvailable) {
		this.memoryValueAvailable = memoryValueAvailable;
	}

	public long getMemoryValueSwapTotal() {
		return memoryValueSwapTotal;
	}

	public void setMemoryValueSwapTotal(long memoryValueSwapTotal) {
		this.memoryValueSwapTotal = memoryValueSwapTotal;
	}

	public long getMemoryValueSwapUsed() {
		return memoryValueSwapUsed;
	}

	public void setMemoryValueSwapUsed(long memoryValueSwapUsed) {
		this.memoryValueSwapUsed = memoryValueSwapUsed;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
