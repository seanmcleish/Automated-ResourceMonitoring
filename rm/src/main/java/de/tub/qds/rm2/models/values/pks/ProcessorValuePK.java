package de.tub.qds.rm2.models.values.pks;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import de.tub.qds.rm2.models.consts.Processor;

@Embeddable
public class ProcessorValuePK implements Serializable {

	int processorValueMeasurementId;
	Date processorValueTimestamp;
	@ManyToOne
	Processor processorValueProcessor;

	public ProcessorValuePK(){}

	public ProcessorValuePK(int measurement, Date timestamp, Processor processor) {
		super();
		this.processorValueMeasurementId = measurement;
		this.processorValueTimestamp = timestamp;
		this.processorValueProcessor = processor;
	}

	public int getMeasurement() {
		return processorValueMeasurementId;
	}

	public Date getTimestamp() {
		return processorValueTimestamp;
	}

	public Processor getProcessor() {
		return processorValueProcessor;
	}

	}
