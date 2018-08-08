package de.tub.qds.rm.models.values.pks;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import de.tub.qds.rm.models.consts.Process;


@Embeddable
public class ProcessValuePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int processValueMeasurementId;
	Date processValueTimestamp;
	@ManyToOne
	Process processValueProcess;

	public ProcessValuePK(){}

	public ProcessValuePK(int measurement, Date timestamp, Process process) {
		super();
		this.processValueMeasurementId = measurement;
		this.processValueTimestamp = timestamp;
		this.processValueProcess = process;
	}

	public int getMeasurement() {
		return processValueMeasurementId;
	}

	public Date getTimestamp() {
		return processValueTimestamp;
	}

	public Process getProcess() {
		return processValueProcess;
	}

}
