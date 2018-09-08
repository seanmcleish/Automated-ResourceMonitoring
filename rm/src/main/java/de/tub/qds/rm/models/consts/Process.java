package de.tub.qds.rm.models.consts;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import de.tub.qds.rm.models.values.ProcessValue;

@Entity
public class Process implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue
	Long processId;
	Boolean processIsParentProcess;
	String processName;
	Long processPid;
	@ManyToOne(fetch = FetchType.LAZY)
	Measurement processMeasurement;
	@OneToMany(mappedBy = "processValueId.processValueProcess", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<ProcessValue> processValues;

	public Process() {
	}

	public Process(Boolean processIsParentProcess, String processName, Long processPid, Measurement measurement) {
		super();
		this.processIsParentProcess = processIsParentProcess;
		this.processName = processName;
		this.processPid = processPid;
		this.processMeasurement = measurement;
		this.processValues = new HashSet<ProcessValue>();
	}

	public Long getProcessId() {
		return processId;
	}

	public Boolean getProcessIsParentProcess() {
		return processIsParentProcess;
	}

	public void setProcessIsParentProcess(Boolean processIsParentProcess) {
		this.processIsParentProcess = processIsParentProcess;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public Long getProcessPid() {
		return processPid;
	}

	public void setProcessPid(Long processPid) {
		this.processPid = processPid;
	}

	public Measurement getProcessMeasurement() {
		return processMeasurement;
	}

	public void setProcessMeasurement(Measurement processMeasurement) {
		this.processMeasurement = processMeasurement;
	}

	public Set<ProcessValue> getProcessValues() {
		return processValues;
	}

	public void setProcessValues(Set<ProcessValue> processValues) {
		this.processValues = processValues;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
