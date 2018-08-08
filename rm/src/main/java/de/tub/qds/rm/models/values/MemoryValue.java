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
	
	public MemoryValue(){}

	public MemoryValue(MemoryValuePK id, long available, long swapTotal, long swapUsed) {
		super();
		this.memoryValueId = id;
		this.memoryValueAvailable = available;
		this.memoryValueSwapTotal = swapTotal;
		this.memoryValueSwapUsed = swapUsed;
	}

	public long getMemoryValueAvailable() {
		return memoryValueAvailable;
	}

	public void setMemoryValueAvailable(long available) {
		this.memoryValueAvailable = available;
	}

	public long getMemoryValueSwapTotal() {
		return memoryValueSwapTotal;
	}

	public void setMemoryValueSwapTotal(long swapTotal) {
		this.memoryValueSwapTotal = swapTotal;
	}

	public long getMemoryValueSwapUsed() {
		return memoryValueSwapUsed;
	}

	public void setMemoryValueSwapUsed(long swapUsed) {
		this.memoryValueSwapUsed = swapUsed;
	}

	public MemoryValuePK getMemoryValueId() {
		return memoryValueId;
	}

}
