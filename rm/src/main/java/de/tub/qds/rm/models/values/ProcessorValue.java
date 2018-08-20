package de.tub.qds.rm.models.values;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import de.tub.qds.rm.models.values.pks.ProcessorValuePK;

@Entity
public class ProcessorValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	ProcessorValuePK processorValueId;
	double processorValueSystemCpuLoadBetweenTicks;
	int[] processorValueSystemCpuLoadTicks;
	double processorValueSystemCpuLoad;
	int[] processorValueSystemLoadAverages;
	double[] processorValueProcessorCpuLoadBetweenTicks;
	long[][] processorValueProcessorCpuLoadTicks;
	long processorValueSystemUpTime;
	long processorValueContextSwitches;
	long processorValueInterrupts;

	public ProcessorValue() {
	}

	public ProcessorValue(ProcessorValuePK id, double systemCpuLoadBetweenTicks, int[] systemCpuLoadTicks,
			double systemCpuLoad, int[] systemLoadAverages, double[] processorCpuLoadBetweenTicks,
			long[][] processorCpuLoadTicks, long systemUpTime, long contextSwitches, long interrupts) {
		super();
		this.processorValueId = id;
		this.processorValueSystemCpuLoadBetweenTicks = systemCpuLoadBetweenTicks;
		this.processorValueSystemCpuLoadTicks = systemCpuLoadTicks;
		this.processorValueSystemCpuLoad = systemCpuLoad;
		this.processorValueSystemLoadAverages = systemLoadAverages;
		this.processorValueProcessorCpuLoadBetweenTicks = processorCpuLoadBetweenTicks;
		this.processorValueProcessorCpuLoadTicks = processorCpuLoadTicks;
		this.processorValueSystemUpTime = systemUpTime;
		this.processorValueContextSwitches = contextSwitches;
		this.processorValueInterrupts = interrupts;
	}

	
	public ProcessorValuePK getProcessorValueId() {
		return processorValueId;
	}

	public void setProcessorValueId(ProcessorValuePK processorValueId) {
		this.processorValueId = processorValueId;
	}

	public double getProcessorValueSystemCpuLoadBetweenTicks() {
		return processorValueSystemCpuLoadBetweenTicks;
	}

	public void setProcessorValueSystemCpuLoadBetweenTicks(double processorValueSystemCpuLoadBetweenTicks) {
		this.processorValueSystemCpuLoadBetweenTicks = processorValueSystemCpuLoadBetweenTicks;
	}

	public int[] getProcessorValueSystemCpuLoadTicks() {
		return processorValueSystemCpuLoadTicks;
	}

	public void setProcessorValueSystemCpuLoadTicks(int[] processorValueSystemCpuLoadTicks) {
		this.processorValueSystemCpuLoadTicks = processorValueSystemCpuLoadTicks;
	}

	public double getProcessorValueSystemCpuLoad() {
		return processorValueSystemCpuLoad;
	}

	public void setProcessorValueSystemCpuLoad(double processorValueSystemCpuLoad) {
		this.processorValueSystemCpuLoad = processorValueSystemCpuLoad;
	}

	public int[] getProcessorValueSystemLoadAverages() {
		return processorValueSystemLoadAverages;
	}

	public void setProcessorValueSystemLoadAverages(int[] processorValueSystemLoadAverages) {
		this.processorValueSystemLoadAverages = processorValueSystemLoadAverages;
	}

	public double[] getProcessorValueProcessorCpuLoadBetweenTicks() {
		return processorValueProcessorCpuLoadBetweenTicks;
	}

	public void setProcessorValueProcessorCpuLoadBetweenTicks(double[] processorValueProcessorCpuLoadBetweenTicks) {
		this.processorValueProcessorCpuLoadBetweenTicks = processorValueProcessorCpuLoadBetweenTicks;
	}

	public long[][] getProcessorValueProcessorCpuLoadTicks() {
		return processorValueProcessorCpuLoadTicks;
	}

	public void setProcessorValueProcessorCpuLoadTicks(long[][] processorValueProcessorCpuLoadTicks) {
		this.processorValueProcessorCpuLoadTicks = processorValueProcessorCpuLoadTicks;
	}

	public long getProcessorValueSystemUpTime() {
		return processorValueSystemUpTime;
	}

	public void setProcessorValueSystemUpTime(long processorValueSystemUpTime) {
		this.processorValueSystemUpTime = processorValueSystemUpTime;
	}

	public long getProcessorValueContextSwitches() {
		return processorValueContextSwitches;
	}

	public void setProcessorValueContextSwitches(long processorValueContextSwitches) {
		this.processorValueContextSwitches = processorValueContextSwitches;
	}

	public long getProcessorValueInterrupts() {
		return processorValueInterrupts;
	}

	public void setProcessorValueInterrupts(long processorValueInterrupts) {
		this.processorValueInterrupts = processorValueInterrupts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
