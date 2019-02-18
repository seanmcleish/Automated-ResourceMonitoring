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
	Double processorValueSystemCpuLoadBetweenTicks;
	Long[] processorValueSystemCpuLoadTicks;
	Double processorValueSystemCpuLoad;
	Integer[] processorValueSystemLoadAverages;
	Double[] processorValueProcessorCpuLoadBetweenTicks;
	Long[][] processorValueProcessorCpuLoadTicks;
	Long processorValueSystemUpTime;
	Long processorValueContextSwitches;
	Long processorValueInterrupts;

	public ProcessorValue() {
	}

	public ProcessorValue(ProcessorValuePK id, Double systemCpuLoadBetweenTicks, Long[] systemCpuLoadTicks,
			Double systemCpuLoad, Integer[] systemLoadAverages, Double[] processorCpuLoadBetweenTicks,
			Long[][] processorCpuLoadTicks, Long systemUpTime, Long contextSwitches, Long interrupts) {
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

	public Double getProcessorValueSystemCpuLoadBetweenTicks() {
		return processorValueSystemCpuLoadBetweenTicks;
	}

	public void setProcessorValueSystemCpuLoadBetweenTicks(Double processorValueSystemCpuLoadBetweenTicks) {
		this.processorValueSystemCpuLoadBetweenTicks = processorValueSystemCpuLoadBetweenTicks;
	}

	public Long[] getProcessorValueSystemCpuLoadTicks() {
		return processorValueSystemCpuLoadTicks;
	}

	public void setProcessorValueSystemCpuLoadTicks(Long[] processorValueSystemCpuLoadTicks) {
		this.processorValueSystemCpuLoadTicks = processorValueSystemCpuLoadTicks;
	}

	public Double getProcessorValueSystemCpuLoad() {
		return processorValueSystemCpuLoad;
	}

	public void setProcessorValueSystemCpuLoad(Double processorValueSystemCpuLoad) {
		this.processorValueSystemCpuLoad = processorValueSystemCpuLoad;
	}

	public Integer[] getProcessorValueSystemLoadAverages() {
		return processorValueSystemLoadAverages;
	}

	public void setProcessorValueSystemLoadAverages(Integer[] processorValueSystemLoadAverages) {
		this.processorValueSystemLoadAverages = processorValueSystemLoadAverages;
	}

	public Double[] getProcessorValueProcessorCpuLoadBetweenTicks() {
		return processorValueProcessorCpuLoadBetweenTicks;
	}

	public void setProcessorValueProcessorCpuLoadBetweenTicks(Double[] processorValueProcessorCpuLoadBetweenTicks) {
		this.processorValueProcessorCpuLoadBetweenTicks = processorValueProcessorCpuLoadBetweenTicks;
	}

	public Long[][] getProcessorValueProcessorCpuLoadTicks() {
		return processorValueProcessorCpuLoadTicks;
	}

	public void setProcessorValueProcessorCpuLoadTicks(Long[][] processorValueProcessorCpuLoadTicks) {
		this.processorValueProcessorCpuLoadTicks = processorValueProcessorCpuLoadTicks;
	}

	public Long getProcessorValueSystemUpTime() {
		return processorValueSystemUpTime;
	}

	public void setProcessorValueSystemUpTime(Long processorValueSystemUpTime) {
		this.processorValueSystemUpTime = processorValueSystemUpTime;
	}

	public Long getProcessorValueContextSwitches() {
		return processorValueContextSwitches;
	}

	public void setProcessorValueContextSwitches(Long processorValueContextSwitches) {
		this.processorValueContextSwitches = processorValueContextSwitches;
	}

	public Long getProcessorValueInterrupts() {
		return processorValueInterrupts;
	}

	public void setProcessorValueInterrupts(Long processorValueInterrupts) {
		this.processorValueInterrupts = processorValueInterrupts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
