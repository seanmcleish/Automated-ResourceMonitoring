package de.tub.qds.rm.models.values.wrapper;

import java.io.Serializable;

public class ProcessValueWrapper<T, U> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	T processValueThreadCount;
	T processValuePriority;
	U processValueVirtualSize;
	U processValueResidentSetSize;
	U processValueKernelTime;
	U processValueUserTime;
	U processValueUpTime;
	U processValueStartTime;
	U processValueBytesRead;
	U processValueBytesWritten;
	U processValueHandles;
	
	public ProcessValueWrapper(T processValueThreadCount, T processValuePriority, U processValueVirtualSize,
			U processValueResidentSetSize, U processValueKernelTime, U processValueUserTime, U processValueUpTime,
			U processValueStartTime, U processValueBytesRead, U processValueBytesWritten, U processValueHandles) {
		super();
		this.processValueThreadCount = processValueThreadCount;
		this.processValuePriority = processValuePriority;
		this.processValueVirtualSize = processValueVirtualSize;
		this.processValueResidentSetSize = processValueResidentSetSize;
		this.processValueKernelTime = processValueKernelTime;
		this.processValueUserTime = processValueUserTime;
		this.processValueUpTime = processValueUpTime;
		this.processValueStartTime = processValueStartTime;
		this.processValueBytesRead = processValueBytesRead;
		this.processValueBytesWritten = processValueBytesWritten;
		this.processValueHandles = processValueHandles;
	}

	public T getProcessValueThreadCount() {
		return processValueThreadCount;
	}

	public void setProcessValueThreadCount(T processValueThreadCount) {
		this.processValueThreadCount = processValueThreadCount;
	}

	public T getProcessValuePriority() {
		return processValuePriority;
	}

	public void setProcessValuePriority(T processValuePriority) {
		this.processValuePriority = processValuePriority;
	}

	public U getProcessValueVirtualSize() {
		return processValueVirtualSize;
	}

	public void setProcessValueVirtualSize(U processValueVirtualSize) {
		this.processValueVirtualSize = processValueVirtualSize;
	}

	public U getProcessValueResidentSetSize() {
		return processValueResidentSetSize;
	}

	public void setProcessValueResidentSetSize(U processValueResidentSetSize) {
		this.processValueResidentSetSize = processValueResidentSetSize;
	}

	public U getProcessValueKernelTime() {
		return processValueKernelTime;
	}

	public void setProcessValueKernelTime(U processValueKernelTime) {
		this.processValueKernelTime = processValueKernelTime;
	}

	public U getProcessValueUserTime() {
		return processValueUserTime;
	}

	public void setProcessValueUserTime(U processValueUserTime) {
		this.processValueUserTime = processValueUserTime;
	}

	public U getProcessValueUpTime() {
		return processValueUpTime;
	}

	public void setProcessValueUpTime(U processValueUpTime) {
		this.processValueUpTime = processValueUpTime;
	}

	public U getProcessValueStartTime() {
		return processValueStartTime;
	}

	public void setProcessValueStartTime(U processValueStartTime) {
		this.processValueStartTime = processValueStartTime;
	}

	public U getProcessValueBytesRead() {
		return processValueBytesRead;
	}

	public void setProcessValueBytesRead(U processValueBytesRead) {
		this.processValueBytesRead = processValueBytesRead;
	}

	public U getProcessValueBytesWritten() {
		return processValueBytesWritten;
	}

	public void setProcessValueBytesWritten(U processValueBytesWritten) {
		this.processValueBytesWritten = processValueBytesWritten;
	}

	public U getProcessValueHandles() {
		return processValueHandles;
	}

	public void setProcessValueHandles(U processValueHandles) {
		this.processValueHandles = processValueHandles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
