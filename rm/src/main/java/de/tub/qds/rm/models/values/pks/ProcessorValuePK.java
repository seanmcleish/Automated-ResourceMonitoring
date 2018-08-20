package de.tub.qds.rm.models.values.pks;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tub.qds.rm.models.consts.Processor;

@Embeddable
public class ProcessorValuePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int processorValueMeasurementId;
	Date processorValueTimestamp;
	@ManyToOne
	Processor processorValueProcessor;

	public ProcessorValuePK() {
	}

	public ProcessorValuePK(int measurement, Date timestamp, Processor processor) {
		super();
		this.processorValueMeasurementId = measurement;
		this.processorValueTimestamp = timestamp;
		this.processorValueProcessor = processor;
	}

	public int getProcessorValueMeasurementId() {
		return processorValueMeasurementId;
	}

	public void setProcessorValueMeasurementId(int processorValueMeasurementId) {
		this.processorValueMeasurementId = processorValueMeasurementId;
	}

	public Date getProcessorValueTimestamp() {
		return processorValueTimestamp;
	}

	public void setProcessorValueTimestamp(Date processorValueTimestamp) {
		this.processorValueTimestamp = processorValueTimestamp;
	}

	@JsonIgnore
	public Processor getProcessorValueProcessor() {
		return processorValueProcessor;
	}

	public void setProcessorValueProcessor(Processor processorValueProcessor) {
		this.processorValueProcessor = processorValueProcessor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
