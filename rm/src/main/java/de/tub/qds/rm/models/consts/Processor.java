package de.tub.qds.rm.models.consts;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tub.qds.rm.models.values.ProcessorValue;

@Entity
public class Processor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	boolean processorCpu64bit;
	long processorVendorFreq;
	@OneToMany(mappedBy = "hardwareId.hardwareProcessor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Hardware> processorHardware;
	@OneToMany(mappedBy = "processorValueId.processorValueProcessor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<ProcessorValue> processorValues;

	public Processor() {
	}

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
		this.processorCpu64bit = isCpu64bit;
		this.processorVendorFreq = vendorFreq;
		this.processorValues = new HashSet<ProcessorValue>();
		this.processorHardware = new HashSet<Hardware>();
	}

	public String getProcessorId() {
		return processorId;
	}

	public void setProcessorId(String processorId) {
		this.processorId = processorId;
	}

	public String getProcessorName() {
		return processorName;
	}

	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}

	public String getProcessorVendor() {
		return processorVendor;
	}

	public void setProcessorVendor(String processorVendor) {
		this.processorVendor = processorVendor;
	}

	public String getProcessorFamily() {
		return processorFamily;
	}

	public void setProcessorFamily(String processorFamily) {
		this.processorFamily = processorFamily;
	}

	public String getProcessorModel() {
		return processorModel;
	}

	public void setProcessorModel(String processorModel) {
		this.processorModel = processorModel;
	}

	public String getProcessorStepping() {
		return processorStepping;
	}

	public void setProcessorStepping(String processorStepping) {
		this.processorStepping = processorStepping;
	}

	public int getProcessorPhysicalPackageCount() {
		return processorPhysicalPackageCount;
	}

	public void setProcessorPhysicalPackageCount(int processorPhysicalPackageCount) {
		this.processorPhysicalPackageCount = processorPhysicalPackageCount;
	}

	public int getProcessorPhysicalProcessorCount() {
		return processorPhysicalProcessorCount;
	}

	public void setProcessorPhysicalProcessorCount(int processorPhysicalProcessorCount) {
		this.processorPhysicalProcessorCount = processorPhysicalProcessorCount;
	}

	public int getProcessorLogicalProcessorCount() {
		return processorLogicalProcessorCount;
	}

	public void setProcessorLogicalProcessorCount(int processorLogicalProcessorCount) {
		this.processorLogicalProcessorCount = processorLogicalProcessorCount;
	}

	public boolean isProcessorCpu64bit() {
		return processorCpu64bit;
	}

	public void setProcessorCpu64bit(boolean processorIsCpu64bit) {
		this.processorCpu64bit = processorIsCpu64bit;
	}

	public long getProcessorVendorFreq() {
		return processorVendorFreq;
	}

	public void setProcessorVendorFreq(long processorVendorFreq) {
		this.processorVendorFreq = processorVendorFreq;
	}

	@JsonIgnore
	public Set<Hardware> getProcessorHardware() {
		return processorHardware;
	}

	public void setProcessorHardware(Set<Hardware> processorHardware) {
		this.processorHardware = processorHardware;
	}

	@JsonIgnore
	public Set<ProcessorValue> getProcessorValues() {
		return processorValues;
	}

	public void setProcessorValues(Set<ProcessorValue> processorValues) {
		this.processorValues = processorValues;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
