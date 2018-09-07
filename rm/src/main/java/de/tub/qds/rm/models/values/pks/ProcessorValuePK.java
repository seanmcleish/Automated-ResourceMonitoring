package de.tub.qds.rm.models.values.pks;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tub.qds.rm.models.consts.Processor;

@Embeddable
public class ProcessorValuePK implements Serializable {

	private static final long serialVersionUID = 1L;
	Long processorValueMeasurementId;
	Timestamp processorValueTimestamp;
	@ManyToOne(targetEntity=Processor.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Processor processorValueProcessor;

	public ProcessorValuePK() {
	}

	public ProcessorValuePK(Long measurement, Timestamp timestamp, Processor processor) {
		super();
		this.processorValueMeasurementId = measurement;
		this.processorValueTimestamp = timestamp;
		this.processorValueProcessor = processor;
	}

	public Long getProcessorValueMeasurementId() {
		return processorValueMeasurementId;
	}

	public void setProcessorValueMeasurementId(Long processorValueMeasurementId) {
		this.processorValueMeasurementId = processorValueMeasurementId;
	}

	public Timestamp getProcessorValueTimestamp() {
		return processorValueTimestamp;
	}

	public void setProcessorValueTimestamp(Timestamp processorValueTimestamp) {
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
