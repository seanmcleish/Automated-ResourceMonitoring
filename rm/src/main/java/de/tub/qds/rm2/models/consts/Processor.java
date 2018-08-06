package de.tub.qds.rm2.models.consts;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import de.tub.qds.rm2.models.values.ProcessorValue;

@Entity
public class Processor implements Serializable {

	@Id
	String processorId;
	String processorName;
	String processorVendor;
	String processorFamily;
	String processorModel;
	String processorStepping;
	int processorPhysicalPackageCount;
	int processorPhysicalProcessorCount;
	int processorLogicalProcessorCount;
	boolean processorIsCpu64bit;
	long processorVendorFreq;
	@OneToMany(mappedBy="hardwareId.hardwareProcessor")
	Set<Hardware> processorHardware;
	@OneToMany(mappedBy="processorValueId.processorValueProcessor")
	Set<ProcessorValue> processorValues;

	public Processor(){}

	public Processor(String id, String name, String vendor, String family, String model, String stepping,
			int physicalPackageCount, int physicalProcessorCount, int logicalProcessorCount, boolean isCpu64bit,
			long vendorFreq) {
		super();
		this.processorId = id;
		this.processorName = name;
		this.processorVendor = vendor;
		this.processorFamily = family;
		this.processorModel = model;
		this.processorStepping = stepping;
		this.processorPhysicalPackageCount = physicalPackageCount;
		this.processorPhysicalProcessorCount = physicalProcessorCount;
		this.processorLogicalProcessorCount = logicalProcessorCount;
		this.processorIsCpu64bit = isCpu64bit;
		this.processorVendorFreq = vendorFreq;
		this.processorValues = new HashSet<ProcessorValue>();
		this.processorHardware = new HashSet<Hardware>();
	}

	
	public String getProcessorId() {
		return processorId;
	}
	
	public String getProcessorName() {
		return processorName;
	}

	public void setProcessorName(String name) {
		this.processorName = name;
	}

	public String getProcessorVendor() {
		return processorVendor;
	}

	public void setProcessorVendor(String vendor) {
		this.processorVendor = vendor;
	}

	public String getProcessorFamily() {
		return processorFamily;
	}

	public void setProcessorFamily(String family) {
		this.processorFamily = family;
	}

	public String getProcessorModel() {
		return processorModel;
	}

	public void setProcessorModel(String model) {
		this.processorModel = model;
	}

	public String getProcessorStepping() {
		return processorStepping;
	}

	public void setProcessorStepping(String stepping) {
		this.processorStepping = stepping;
	}

	public int getProcessorPhysicalPackageCount() {
		return processorPhysicalPackageCount;
	}

	public void setProcessorPhysicalPackageCount(int physicalPackageCount) {
		this.processorPhysicalPackageCount = physicalPackageCount;
	}

	public int getProcessorPhysicalProcessorCount() {
		return processorPhysicalProcessorCount;
	}

	public void setProcessorPhysicalProcessorCount(int physicalProcessorCount) {
		this.processorPhysicalProcessorCount = physicalProcessorCount;
	}

	public int getProcessorLogicalProcessorCount() {
		return processorLogicalProcessorCount;
	}

	public void setProcessorLogicalProcessorCount(int logicalProcessorCount) {
		this.processorLogicalProcessorCount = logicalProcessorCount;
	}

	public boolean getProcessorIsCpu64bit() {
		return processorIsCpu64bit;
	}

	public void setProcessorIsCpu64bit(boolean isCpu64bit) {
		this.processorIsCpu64bit = isCpu64bit;
	}

	public long getProcessorVendorFreq() {
		return processorVendorFreq;
	}

	public void setProcessorVendorFreq(long vendorFreq) {
		this.processorVendorFreq = vendorFreq;
	}
	
	
	

	/*public Set<Hardware> getProcessorHardware() {
		return processorHardware;
	}*/

	public Set<ProcessorValue> getProcessorValues() {
		return processorValues;
	}

	public void addProcessorValue(ProcessorValue value) {
		processorValues.add(value);
	}

}
