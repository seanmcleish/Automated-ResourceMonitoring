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

import de.tub.qds.rm.models.values.MemoryValue;

@Entity
public class Memory implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	Long memoryTotalSpace;
	@OneToMany(mappedBy = "memoryValueId.memoryValueMemory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<MemoryValue> memoryValues;
	@OneToMany(mappedBy = "hardwareMemory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Hardware> memoryHardware;

	public Memory() {
	}

	public Memory(Long totalSpace) {
		super();
		this.memoryTotalSpace = totalSpace;
		this.memoryValues = new HashSet<MemoryValue>();
		this.memoryHardware = new HashSet<Hardware>();
	}

	public Long getMemoryTotalSpace() {
		return memoryTotalSpace;
	}

	public void setMemoryTotalSpace(Long memoryTotalSpace) {
		this.memoryTotalSpace = memoryTotalSpace;
	}

	@JsonIgnore
	public Set<MemoryValue> getMemoryValues() {
		return memoryValues;
	}

	public void addMemoryValue(MemoryValue memoryValue) {
		this.memoryValues.add(memoryValue);
	}

	@JsonIgnore
	public Set<Hardware> getMemoryHardware() {
		return memoryHardware;
	}

	public void addMemoryHardware(Hardware memoryHardware) {
		this.memoryHardware.add(memoryHardware);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
