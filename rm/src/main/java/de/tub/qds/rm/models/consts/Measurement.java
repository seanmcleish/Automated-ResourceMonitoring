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

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	Long measurementId;
	String measurementIp;
	String measurementRemotePort;
	Rate measurementRate;
	Timestamp measurementStartDate;
	Timestamp measurementEndDate;
	boolean measurementRunning;
	@OneToMany(mappedBy = "processMeasurement", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<Process> measurementProcesses;
	@ManyToOne(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
	System measurementSystem;

	public Measurement() {
		this.measurementProcesses = new HashSet<Process>();

	}
	
	public Measurement(String remotePort, System system ) {
		super();
		this.measurementRemotePort = remotePort;
		this.measurementSystem = system;
		this.measurementProcesses = new HashSet<Process>();
	}

	public Measurement(String ip, String remotePort, Rate rate, System system ) {
		super();
		this.measurementIp = ip;
		this.measurementRemotePort = remotePort;
		this.measurementRate = rate;
		this.measurementSystem = system;
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
	
	public Rate getMeasurementRate() {
		return measurementRate;
	}

	public void setMeasurementRate(Rate measurementRate) {
		this.measurementRate = measurementRate;
	}

	public void setMeasurementProcesses(Set<Process> measurementProcesses) {
		this.measurementProcesses = measurementProcesses;
	}
	
	public String getMeasurementRemotePort() {
		return measurementRemotePort;
	}

	public void setMeasurementRemotePort(String measurementRemotePort) {
		this.measurementRemotePort = measurementRemotePort;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
