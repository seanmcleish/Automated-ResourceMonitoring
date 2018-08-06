package de.tub.qds.rm2.models.values;


import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import de.tub.qds.rm2.models.consts.Processor;
import de.tub.qds.rm2.models.values.pks.ProcessorValuePK;

@Entity
public class ProcessorValue implements Serializable {

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

	public ProcessorValue(){}

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

	public double getSystemCpuLoadBetweenTicks() {
		return processorValueSystemCpuLoadBetweenTicks;
	}

	public void setSystemCpuLoadBetweenTicks(double systemCpuLoadBetweenTicks) {
		this.processorValueSystemCpuLoadBetweenTicks = systemCpuLoadBetweenTicks;
	}

	public int[] getSystemCpuLoadTicks() {
		return processorValueSystemCpuLoadTicks;
	}

	public void setSystemCpuLoadTicks(int[] systemCpuLoadTicks) {
		this.processorValueSystemCpuLoadTicks = systemCpuLoadTicks;
	}

	public double getSystemCpuLoad() {
		return processorValueSystemCpuLoad;
	}

	public void setSystemCpuLoad(double systemCpuLoad) {
		this.processorValueSystemCpuLoad = systemCpuLoad;
	}

	public int[] getSystemLoadAverages() {
		return processorValueSystemLoadAverages;
	}

	public void setSystemLoadAverages(int[] systemLoadAverages) {
		this.processorValueSystemLoadAverages = systemLoadAverages;
	}

	public double[] getProcessorCpuLoadBetweenTicks() {
		return processorValueProcessorCpuLoadBetweenTicks;
	}

	public void setProcessorCpuLoadBetweenTicks(double[] processorCpuLoadBetweenTicks) {
		this.processorValueProcessorCpuLoadBetweenTicks = processorCpuLoadBetweenTicks;
	}

	public long[][] getProcessorCpuLoadTicks() {
		return processorValueProcessorCpuLoadTicks;
	}

	public void setProcessorCpuLoadTicks(long[][] processorCpuLoadTicks) {
		this.processorValueProcessorCpuLoadTicks = processorCpuLoadTicks;
	}

	public long getSystemUpTime() {
		return processorValueSystemUpTime;
	}

	public void setSystemUpTime(long systemUpTime) {
		this.processorValueSystemUpTime = systemUpTime;
	}

	public long getContextSwitches() {
		return processorValueContextSwitches;
	}

	public void setContextSwitches(long contextSwitches) {
		this.processorValueContextSwitches = contextSwitches;
	}

	public long getInterrupts() {
		return processorValueInterrupts;
	}

	public void setInterrupts(long interrupts) {
		this.processorValueInterrupts = interrupts;
	}

	public ProcessorValuePK getId() {
		return processorValueId;
	}

}
