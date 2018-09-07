package de.tub.qds.rm.models.values.pks;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tub.qds.rm.models.consts.Process;

@Embeddable
public class ProcessValuePK implements Serializable {

	private static final long serialVersionUID = 1L;
	Long processValueMeasurementId;
	Timestamp processValueTimestamp;
	@ManyToOne(targetEntity=Process.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Process processValueProcess;

	public ProcessValuePK() {
	}

	public ProcessValuePK(Long measurement, Timestamp timestamp, Process process) {
		super();
		this.processValueMeasurementId = measurement;
		this.processValueTimestamp = timestamp;
		this.processValueProcess = process;
	}

	public Long getProcessValueMeasurementId() {
		return processValueMeasurementId;
	}

	public void setProcessValueMeasurementId(Long processValueMeasurementId) {
		this.processValueMeasurementId = processValueMeasurementId;
	}

	public Timestamp getProcessValueTimestamp() {
		return processValueTimestamp;
	}

	public void setProcessValueTimestamp(Timestamp processValueTimestamp) {
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
