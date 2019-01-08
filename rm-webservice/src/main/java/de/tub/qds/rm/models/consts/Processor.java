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

	private static final long serialVersionUID = 1L;
	@Id
	String processorId;
	String processorName;
	String processorVendor;
	String processorFamily;
	String processorModel;
	String processorStepping;
	Integer processorPhysicalPackageCount;
	Integer processorPhysicalProcessorCount;
	Integer processorLogicalProcessorCount;
	Boolean processorCpu64bit;
	Long processorVendorFreq;
	@OneToMany(mappedBy = "hardwareProcessor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Hardware> processorHardware;
	@OneToMany(mappedBy = "processorValueId.processorValueProcessor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<ProcessorValue> processorValues;

	public Processor() {
	}

	

	public Processor(String processorId, String processorName, String processorVendor, String processorFamily,
			String processorModel, String processorStepping, Integer processorPhysicalPackageCount,
			Integer processorPhysicalProcessorCount, Integer processorLogicalProcessorCount, Boolean processorCpu64bit,
			Long processorVendorFreq) {
		super();
		this.processorId = processorId;
		this.processorName = processorName;
		this.processorVendor = processorVendor;
		this.processorFamily = processorFamily;
		this.processorModel = processorModel;
		this.processorStepping = processorStepping;
		this.processorPhysicalPackageCount = processorPhysicalPackageCount;
		this.processorPhysicalProcessorCount = processorPhysicalProcessorCount;
		this.processorLogicalProcessorCount = processorLogicalProcessorCount;
		this.processorCpu64bit = processorCpu64bit;
		this.processorVendorFreq = processorVendorFreq;
		this.processorHardware = new HashSet<Hardware>();
		this.processorValues = new HashSet<ProcessorValue>();
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

	public Integer getProcessorPhysicalPackageCount() {
		return processorPhysicalPackageCount;
	}

	public void setProcessorPhysicalPackageCount(Integer processorPhysicalPackageCount) {
		this.processorPhysicalPackageCount = processorPhysicalPackageCount;
	}

	public Integer getProcessorPhysicalProcessorCount() {
		return processorPhysicalProcessorCount;
	}

	public void setProcessorPhysicalProcessorCount(Integer processorPhysicalProcessorCount) {
		this.processorPhysicalProcessorCount = processorPhysicalProcessorCount;
	}

	public Integer getProcessorLogicalProcessorCount() {
		return processorLogicalProcessorCount;
	}

	public void setProcessorLogicalProcessorCount(Integer processorLogicalProcessorCount) {
		this.processorLogicalProcessorCount = processorLogicalProcessorCount;
	}

	public Boolean isProcessorCpu64bit() {
		return processorCpu64bit;
	}

	public void setProcessorCpu64bit(Boolean processorIsCpu64bit) {
		this.processorCpu64bit = processorIsCpu64bit;
	}

	public Long getProcessorVendorFreq() {
		return processorVendorFreq;
	}

	public void setProcessorVendorFreq(Long processorVendorFreq) {
		this.processorVendorFreq = processorVendorFreq;
	}

	@JsonIgnore
	public Set<Hardware> getProcessorHardware() {
		return processorHardware;
	}

	public void addProcessorHardware(Hardware processorHardware) {
		this.processorHardware.add(processorHardware);
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
