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
	Long measurementId;
	String measurementIp;
	Timestamp measurementStartDate;
	Timestamp measurementEndDate;
	boolean measurementRunning;
	@OneToMany(mappedBy = "processMeasurement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Process> measurementProcesses;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	System measurementSystem;

	public Measurement() {

	}

	public Measurement(String ip) {
		super();
		this.measurementIp = ip;
		this.measurementProcesses = new HashSet<Process>();
	}

	public Long getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(Long measurementId) {
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

	@JsonIgnore
	public Set<Process> getMeasurementProcesses() {
		return measurementProcesses;
	}

	public void addMeasurementProcess(Process measurementProcess) {
		this.measurementProcesses.add(measurementProcess);
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
