package de.tub.qds.rm.models.values.pks;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	public ProcessValuePK() {
	}

	public ProcessValuePK(int measurement, Date timestamp, Process process) {
		super();
		this.processValueMeasurementId = measurement;
		this.processValueTimestamp = timestamp;
		this.processValueProcess = process;
	}

	public int getProcessValueMeasurementId() {
		return processValueMeasurementId;
	}

	public void setProcessValueMeasurementId(int processValueMeasurementId) {
		this.processValueMeasurementId = processValueMeasurementId;
	}

	public Date getProcessValueTimestamp() {
		return processValueTimestamp;
	}

	public void setProcessValueTimestamp(Date processValueTimestamp) {
		this.processValueTimestamp = processValueTimestamp;
	}

	@JsonIgnore
	public Process getProcessValueProcess() {
		return processValueProcess;
	}

	public void setProcessValueProcess(Process processValueProcess) {
		this.processValueProcess = processValueProcess;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
