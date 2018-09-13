package de.tub.qds.rm.models.values.wrapper;

import java.io.Serializable;

public class ProcessJsonWrapper implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String processName;
	Long processId;
	
	public ProcessJsonWrapper(String processName, Long processId){
		this.processName = processName;
		this.processId = processId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public Long getProcessId() {
		return processId;
	}

	public void setProcessId(Long processId) {
		this.processId = processId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
