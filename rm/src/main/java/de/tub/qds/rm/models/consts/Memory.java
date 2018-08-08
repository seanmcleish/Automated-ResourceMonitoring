package de.tub.qds.rm.models.consts;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import de.tub.qds.rm.models.values.MemoryValue;


@Entity
public class Memory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	long memoryTotalSpace;
	@OneToMany(mappedBy = "memoryValueId.memoryValueMemory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<MemoryValue> memoryValues;
	@OneToMany(mappedBy = "hardwareId.hardwareMemory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Hardware> memoryHardware;

	public Memory(){}

	public Memory(long totalSpace) {
		super();
		this.memoryTotalSpace = totalSpace;
		this.memoryValues = new HashSet<MemoryValue>();
		this.memoryHardware = new HashSet<Hardware>();
	}

	
	public long getMemoryTotalSpace() {
		return memoryTotalSpace;
	}

	public void setMemoryTotalSpace(long totalSpace) {
		this.memoryTotalSpace = totalSpace;
	}

	public Set<MemoryValue> getMemoryValues() {
		return memoryValues;
	}

	public void addMemoryValue(MemoryValue value) {
		memoryValues.add(value);
	}

	public Set<Hardware> getMemoryHardware() {
		return memoryHardware;
	}
	public void addMemoryHardware(Hardware hardware){
		this.memoryHardware.add(hardware);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setMemoryValues(Set<MemoryValue> memoryValues) {
		this.memoryValues = memoryValues;
	}

	public void setMemoryHardware(Set<Hardware> memoryHardware) {
		this.memoryHardware = memoryHardware;
	}

}
