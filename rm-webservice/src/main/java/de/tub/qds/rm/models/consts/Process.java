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

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tub.qds.rm.models.values.ProcessValue;

@Entity
public class Process implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue
	Long processId;
	String processName;
	Long processPid;
	@ManyToOne(fetch = FetchType.LAZY)
	Measurement processMeasurement;
	@OneToMany(mappedBy = "processValueId.processValueProcess", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<ProcessValue> processValues;

	public Process() {
	}

	public Process(String processName, Long processPid, Measurement measurement) {
		super();
		this.processName = processName;
		this.processPid = processPid;
		this.processMeasurement = measurement;
		this.processValues = new HashSet<ProcessValue>();
	}

	public Long getProcessId() {
		return processId;
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
	
	@JsonIgnore
	public Measurement getProcessMeasurement() {
		return processMeasurement;
	}

	public void setProcessMeasurement(Measurement processMeasurement) {
		this.processMeasurement = processMeasurement;
	}

	@JsonIgnore
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
