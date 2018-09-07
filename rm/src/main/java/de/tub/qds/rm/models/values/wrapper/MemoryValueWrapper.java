package de.tub.qds.rm.models.values.wrapper;

import java.io.Serializable;

public class MemoryValueWrapper<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	T memoryValueAvailable;
	T memoryValueSwapTotal;;
	T memoryValueSwapUsed;
	
	public MemoryValueWrapper(T memoryValueAvailable, T memoryValueSwapTotal, T memoryValueSwapUsed) {
		super();
		this.memoryValueAvailable = memoryValueAvailable;
		this.memoryValueSwapTotal = memoryValueSwapTotal;
		this.memoryValueSwapUsed = memoryValueSwapUsed;
	}
	public T getMemoryValueAvailable() {
		return memoryValueAvailable;
	}
	public void setMemoryValueAvailable(T memoryValueAvailable) {
		this.memoryValueAvailable = memoryValueAvailable;
	}
	public T getMemoryValueSwapTotal() {
		return memoryValueSwapTotal;
	}
	public void setMemoryValueSwapTotal(T memoryValueSwapTotal) {
		this.memoryValueSwapTotal = memoryValueSwapTotal;
	}
	public T getMemoryValueSwapUsed() {
		return memoryValueSwapUsed;
	}
	public void setMemoryValueSwapUsed(T memoryValueSwapUsed) {
		this.memoryValueSwapUsed = memoryValueSwapUsed;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
