package de.tub.qds.rm2.models.consts;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Measurement implements Serializable {

	@Id
	@GeneratedValue
	long measurementId;
	String measurementIp;
	Date measurementStartDate;
	Date measurementEndDate;
	boolean measurementIsRunning;
	@OneToMany(mappedBy = "processId.processMeasurement")
	Set<Process> measurementProcesses;
	@ManyToOne
	System measurementSystem;

	public Measurement()
	{
		
	}

	public Measurement(String ip, boolean isRunning) {
		super();
		this.measurementIp = ip;
		this.measurementIsRunning = isRunning;
		this.measurementProcesses = new HashSet<Process>();
	}

	
	public long getMeasurementId() {
		return measurementId;
	}

	
	public String getMeasurementIp() {
		return measurementIp;
	}

	public void setMeasurementIp(String ip) {
		this.measurementIp = ip;
	}

	public Date getMeasurementStartDate() {
		return measurementStartDate;
	}

	public void setMeasurementStartDate(Date startDate) {
		this.measurementStartDate = startDate;
	}

	public Date getMeasurementEndDate() {
		return measurementEndDate;
	}

	public void setMeasurementEndDate(Date endDate) {
		this.measurementEndDate = endDate;
	}

	public boolean getMeasurementIsRunning() {
		return measurementIsRunning;
	}

	public void setMeasurementIsRunning(boolean isRunning) {
		this.measurementIsRunning = isRunning;
	}

	public System getMeasurementSystem() {
		return measurementSystem;
	}

	public void setMeasurementSystem(System system) {
		this.measurementSystem = system;
	}

	
	public Set<Process> getMeasurementProcesses() {
		return measurementProcesses;
	}

	public void addMeasurementProcess(Process process) {
		measurementProcesses.add(process);
	}

}
