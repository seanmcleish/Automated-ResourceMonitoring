package de.tub.qds.rm.models.consts.pks;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import de.tub.qds.rm.models.consts.Measurement;

@Embeddable
public class ProcessPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String processName;
	int processPid;
	@ManyToOne
	Measurement processMeasurement;

	public ProcessPK(){}

	public ProcessPK(String name, int pid) {
		super();
		this.processName = name;
		this.processPid = pid;
	}

	public String getProcessName() {
		return processName;
	}

	public int getProcessPid() {
		return processPid;
	}

	public Measurement getProcessMeasurement() {
		return processMeasurement;
	}

	public void setProcessMeasurement(Measurement processMeasurement) {
		this.processMeasurement = processMeasurement;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public void setProcessPid(int processPid) {
		this.processPid = processPid;
	}

}
