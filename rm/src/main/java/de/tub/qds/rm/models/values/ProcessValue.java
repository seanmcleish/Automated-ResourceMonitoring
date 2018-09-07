package de.tub.qds.rm.models.values;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import de.tub.qds.rm.models.values.pks.ProcessValuePK;

@Entity
public class ProcessValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	ProcessValuePK processValueId;
	Integer processValueThreadCount;
	Integer processValuePriority;
	Long processValuevirtualSize;
	Long processValueResidentSetSize;
	Long processValueKernelTime;
	Long processValueUserTime;
	Long processValueUpTime;
	Long processValueStartTime;
	Long processValueBytesRead;
	Long processValueBytesWritten;
	Long processValueHandles;

	public ProcessValue() {
	}

	public ProcessValue(ProcessValuePK id, Integer threadCount, Integer priority, Long virtualSize, Long residentSetSize,
			Long kernelTime, Long userTime, Long upTime, Long startTime, Long bytesRead, Long bytesWritten,
			Long handles) {
		super();
		this.processValueId = id;
		this.processValueThreadCount = threadCount;
		this.processValuePriority = priority;
		this.processValuevirtualSize = virtualSize;
		this.processValueResidentSetSize = residentSetSize;
		this.processValueKernelTime = kernelTime;
		this.processValueUserTime = userTime;
		this.processValueUpTime = upTime;
		this.processValueStartTime = startTime;
		this.processValueBytesRead = bytesRead;
		this.processValueBytesWritten = bytesWritten;
		this.processValueHandles = handles;
	}

	
	public ProcessValuePK getProcessValueId() {
		return processValueId;
	}

	public void setProcessValueId(ProcessValuePK processValueId) {
		this.processValueId = processValueId;
	}

	public Integer getProcessValueThreadCount() {
		return processValueThreadCount;
	}

	public void setProcessValueThreadCount(Integer processValueThreadCount) {
		this.processValueThreadCount = processValueThreadCount;
	}

	public Integer getProcessValuePriority() {
		return processValuePriority;
	}

	public void setProcessValuePriority(Integer processValuePriority) {
		this.processValuePriority = processValuePriority;
	}

	public Long getProcessValuevirtualSize() {
		return processValuevirtualSize;
	}

	public void setProcessValuevirtualSize(Long processValuevirtualSize) {
		this.processValuevirtualSize = processValuevirtualSize;
	}

	public Long getProcessValueResidentSetSize() {
		return processValueResidentSetSize;
	}

	public void setProcessValueResidentSetSize(Long processValueResidentSetSize) {
		this.processValueResidentSetSize = processValueResidentSetSize;
	}

	public Long getProcessValueKernelTime() {
		return processValueKernelTime;
	}

	public void setProcessValueKernelTime(Long processValueKernelTime) {
		this.processValueKernelTime = processValueKernelTime;
	}

	public Long getProcessValueUserTime() {
		return processValueUserTime;
	}

	public void setProcessValueUserTime(Long processValueUserTime) {
		this.processValueUserTime = processValueUserTime;
	}

	public Long getProcessValueUpTime() {
		return processValueUpTime;
	}

	public void setProcessValueUpTime(Long processValueUpTime) {
		this.processValueUpTime = processValueUpTime;
	}

	public Long getProcessValueStartTime() {
		return processValueStartTime;
	}

	public void setProcessValueStartTime(Long processValueStartTime) {
		this.processValueStartTime = processValueStartTime;
	}

	public Long getProcessValueBytesRead() {
		return processValueBytesRead;
	}

	public void setProcessValueBytesRead(Long processValueBytesRead) {
		this.processValueBytesRead = processValueBytesRead;
	}

	public Long getProcessValueBytesWritten() {
		return processValueBytesWritten;
	}

	public void setProcessValueBytesWritten(Long processValueBytesWritten) {
		this.processValueBytesWritten = processValueBytesWritten;
	}

	public Long getProcessValueHandles() {
		return processValueHandles;
	}

	public void setProcessValueHandles(Long processValueHandles) {
		this.processValueHandles = processValueHandles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
