package de.tub.qds.rm2.models.consts.pks;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import de.tub.qds.rm2.models.consts.Measurement;

@Embeddable
public class ProcessPK implements Serializable {

	@NotNull
	String processName;
	@NotNull
	int processPid;
	@ManyToOne
	Measurement processMeasurement;

	public ProcessPK(){}

	public ProcessPK(@NotNull String name, @NotNull int pid) {
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

}
