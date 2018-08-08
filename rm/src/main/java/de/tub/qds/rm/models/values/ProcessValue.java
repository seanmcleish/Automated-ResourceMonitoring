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
	int processValueThreadCount;
	int processValuePriority;
	long processValuevirtualSize;
	long processValueResidentSetSize;
	long processValueKernelTime;
	long processValueUserTime;
	long processValueUpTime;
	long processValueStartTime;
	long processValueBytesRead;
	long processValueBytesWritten;
	long processValueHandles;

	public ProcessValue(){}

	public ProcessValue(ProcessValuePK id, int threadCount, int priority, long virtualSize, long residentSetSize,
			long kernelTime, long userTime, long upTime, long startTime, long bytesRead, long bytesWritten,
			long handles) {
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

	public int getProcessValueThreadCount() {
		return processValueThreadCount;
	}

	public void setProcessValueThreadCount(int threadCount) {
		this.processValueThreadCount = threadCount;
	}

	public int getProcessValuePriority() {
		return processValuePriority;
	}

	public void setProcessValuePriority(int priority) {
		this.processValuePriority = priority;
	}

	public long getProcessValueVirtualSize() {
		return processValuevirtualSize;
	}

	public void setProcessValueVirtualSize(long virtualSize) {
		this.processValuevirtualSize = virtualSize;
	}

	public long getProcessValueResidentSetSize() {
		return processValueResidentSetSize;
	}

	public void setProcessValueResidentSetSize(long residentSetSize) {
		this.processValueResidentSetSize = residentSetSize;
	}

	public long getProcessValueKernelTime() {
		return processValueKernelTime;
	}

	public void setProcessValueKernelTime(long kernelTime) {
		this.processValueKernelTime = kernelTime;
	}

	public long getProcessValueUserTime() {
		return processValueUserTime;
	}

	public void setProcessValueUserTime(long userTime) {
		this.processValueUserTime = userTime;
	}

	public long getProcessValueUpTime() {
		return processValueUpTime;
	}

	public void setProcessValueUpTime(long upTime) {
		this.processValueUpTime = upTime;
	}

	public long getProcessValueStartTime() {
		return processValueStartTime;
	}

	public void setProcessValueStartTime(long startTime) {
		this.processValueStartTime = startTime;
	}

	public long getProcessValueBytesRead() {
		return processValueBytesRead;
	}

	public void setProcessValueBytesRead(long bytesRead) {
		this.processValueBytesRead = bytesRead;
	}

	public long getProcessValueBytesWritten() {
		return processValueBytesWritten;
	}

	public void setProcessValueBytesWritten(long bytesWritten) {
		this.processValueBytesWritten = bytesWritten;
	}

	public long getProcessValueHandles() {
		return processValueHandles;
	}

	public void setProcessValueHandles(long handles) {
		this.processValueHandles = handles;
	}

	public ProcessValuePK getProcessValueId() {
		return processValueId;
	}
	public void setProcessValueId(ProcessValuePK id){
		this.processValueId = id;
	}

}
