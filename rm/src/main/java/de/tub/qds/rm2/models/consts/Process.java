package de.tub.qds.rm2.models.consts;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import de.tub.qds.rm2.models.consts.pks.ProcessPK;
import de.tub.qds.rm2.models.values.ProcessValue;

@Entity
public class Process implements Serializable {

	@EmbeddedId
	ProcessPK processId;
	boolean processIsParentProcess;
	@OneToMany(mappedBy="processValueId.processValueProcess")
	Set<ProcessValue> processValues;

	public Process(){}

	public Process(ProcessPK id, boolean isParentProcess) {
		super();
		this.processId = id;
		this.processIsParentProcess = isParentProcess;
		this.processValues = new HashSet<ProcessValue>();
	}

	public boolean getProcessIsParentProcess() {
		return processIsParentProcess;
	}

	public void setProcessParentProcess(boolean isParentProcess) {
		this.processIsParentProcess = isParentProcess;
	}
	
	public ProcessPK getProcessId() {
		return processId;
	}

	public Set<ProcessValue> getProcessValues() {
		return processValues;
	}

	public void addValue(ProcessValue value) {
		processValues.add(value);
	}

	public void setProcessId(ProcessPK processId) {
		this.processId = processId;
	}

	public void setProcessIsParentProcess(boolean processIsParentProcess) {
		this.processIsParentProcess = processIsParentProcess;
	}

	public void setProcessValues(Set<ProcessValue> processValues) {
		this.processValues = processValues;
	}


}
