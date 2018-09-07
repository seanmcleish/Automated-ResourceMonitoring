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
	Long memoryValueAvailable;
	Long memoryValueSwapTotal;
	Long memoryValueSwapUsed;

	public MemoryValue() {
	}

	public MemoryValue(MemoryValuePK id, Long available, Long swapTotal, Long swapUsed) {
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

	public Long getMemoryValueAvailable() {
		return memoryValueAvailable;
	}

	public void setMemoryValueAvailable(Long memoryValueAvailable) {
		this.memoryValueAvailable = memoryValueAvailable;
	}

	public Long getMemoryValueSwapTotal() {
		return memoryValueSwapTotal;
	}

	public void setMemoryValueSwapTotal(Long memoryValueSwapTotal) {
		this.memoryValueSwapTotal = memoryValueSwapTotal;
	}

	public Long getMemoryValueSwapUsed() {
		return memoryValueSwapUsed;
	}

	public void setMemoryValueSwapUsed(Long memoryValueSwapUsed) {
		this.memoryValueSwapUsed = memoryValueSwapUsed;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
