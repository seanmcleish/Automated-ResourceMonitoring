package de.tub.qds.rm.models.values.wrapper;

import java.io.Serializable;

public class ProcessorValueWrapper<T, U> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	T processorValueSystemCpuLoadBetweenTicks;
	T processorValueSystemCpuLoad;
	U processorValueSystemUpTime;
	U processorValueContextSwitches;
	U processorValueInterrupts;
	
	public ProcessorValueWrapper(T processorValueSystemCpuLoadBetweenTicks, T processorValueSystemCpuLoad,
			U processorValueSystemUpTime, U processorValueContextSwitches, U processorValueInterrupts) {
		super();
		this.processorValueSystemCpuLoadBetweenTicks = processorValueSystemCpuLoadBetweenTicks;
		this.processorValueSystemCpuLoad = processorValueSystemCpuLoad;
		this.processorValueSystemUpTime = processorValueSystemUpTime;
		this.processorValueContextSwitches = processorValueContextSwitches;
		this.processorValueInterrupts = processorValueInterrupts;
	}
	public T getProcessorValueSystemCpuLoadBetweenTicks() {
		return processorValueSystemCpuLoadBetweenTicks;
	}
	public void setProcessorValueSystemCpuLoadBetweenTicks(T processorValueSystemCpuLoadBetweenTicks) {
		this.processorValueSystemCpuLoadBetweenTicks = processorValueSystemCpuLoadBetweenTicks;
	}
	public T getProcessorValueSystemCpuLoad() {
		return processorValueSystemCpuLoad;
	}
	public void setProcessorValueSystemCpuLoad(T processorValueSystemCpuLoad) {
		this.processorValueSystemCpuLoad = processorValueSystemCpuLoad;
	}
	public U getProcessorValueSystemUpTime() {
		return processorValueSystemUpTime;
	}
	public void setProcessorValueSystemUpTime(U processorValueSystemUpTime) {
		this.processorValueSystemUpTime = processorValueSystemUpTime;
	}
	public U getProcessorValueContextSwitches() {
		return processorValueContextSwitches;
	}
	public void setProcessorValueContextSwitches(U processorValueContextSwitches) {
		this.processorValueContextSwitches = processorValueContextSwitches;
	}
	public U getProcessorValueInterrupts() {
		return processorValueInterrupts;
	}
	public void setProcessorValueInterrupts(U processorValueInterrupts) {
		this.processorValueInterrupts = processorValueInterrupts;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
