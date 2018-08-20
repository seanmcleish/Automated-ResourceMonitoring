package de.tub.qds.rm.models.consts;

import java.io.Serializable;
import java.sql.Timestamp;
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

@Entity
public class Measurement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	long measurementId;
	String measurementIp;
	Timestamp measurementStartDate;
	Timestamp measurementEndDate;
	boolean measurementRunning;
	@OneToMany(mappedBy = "processId.processMeasurement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Process> measurementProcesses;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	System measurementSystem;

	public Measurement() {

	}

	public Measurement(String ip) {
		super();
		this.measurementIp = ip;;
		this.measurementProcesses = new HashSet<Process>();
	}

	public long getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(long measurementId) {
		this.measurementId = measurementId;
	}

	public String getMeasurementIp() {
		return measurementIp;
	}

	public void setMeasurementIp(String measurementIp) {
		this.measurementIp = measurementIp;
	}

	public Timestamp getMeasurementStartDate() {
		return measurementStartDate;
	}

	public void setMeasurementStartDate(Timestamp measurementStartDate) {
		this.measurementStartDate = measurementStartDate;
	}

	public Timestamp getMeasurementEndDate() {
		return measurementEndDate;
	}

	public void setMeasurementEndDate(Timestamp measurementEndDate) {
		this.measurementEndDate = measurementEndDate;
	}

	public boolean isMeasurementRunning() {
		return measurementRunning;
	}

	public void setMeasurementRunning(boolean measurementRunning) {
		this.measurementRunning = measurementRunning;
	}

	public Set<Process> getMeasurementProcesses() {
		return measurementProcesses;
	}

	@JsonIgnore
	public void setMeasurementProcesses(Set<Process> measurementProcesses) {
		this.measurementProcesses = measurementProcesses;
	}

	@JsonIgnore
	public System getMeasurementSystem() {
		return measurementSystem;
	}

	public void setMeasurementSystem(System measurementSystem) {
		this.measurementSystem = measurementSystem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
