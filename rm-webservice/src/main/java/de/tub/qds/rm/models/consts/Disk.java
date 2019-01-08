package de.tub.qds.rm.models.consts;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tub.qds.rm.models.values.DiskValue;

@Entity
public class Disk implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	String diskSerialNumber;
	String diskModel;
	String diskName;
	Long diskSize;
	@OneToMany(mappedBy = "diskValueId.diskValueDisk", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<DiskValue> diskValues;
	@OneToMany(mappedBy = "fileStoreDisk", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<FileStore> diskFileStores;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="hardwareDisks")
	Set<Hardware> diskHardware;

	public Disk() {
	}

	public Disk(String serialNumber, String model, String name, Long size) {
		super();
		this.diskSerialNumber = serialNumber;
		this.diskModel = model;
		this.diskName = name;
		this.diskSize = size;
		this.diskValues = new HashSet<DiskValue>();
		this.diskHardware = new HashSet<Hardware>();
	}

	public String getDiskSerialNumber() {
		return diskSerialNumber;
	}

	public void setDiskSerialNumber(String diskSerialNumber) {
		this.diskSerialNumber = diskSerialNumber;
	}

	public String getDiskModel() {
		return diskModel;
	}

	public void setDiskModel(String diskModel) {
		this.diskModel = diskModel;
	}

	public String getDiskName() {
		return diskName;
	}

	public void setDiskName(String diskName) {
		this.diskName = diskName;
	}

	public Long getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(Long diskSize) {
		this.diskSize = diskSize;
	}

	public Set<FileStore> getDiskFileStores() {
		return diskFileStores;
	}

	public void setDiskFileStores(Set<FileStore> diskFileStores) {
		this.diskFileStores = diskFileStores;
	}

	@JsonIgnore
	public Set<DiskValue> getDiskValues() {
		return diskValues;
	}

	public void addDiskValues(DiskValue diskValue) {
		this.diskValues.add(diskValue);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@JsonIgnore
	public Set<Hardware> getDiskHardware() {
		return diskHardware;
	}

	public void addDiskHardware(Hardware diskHardware) {
		this.diskHardware.add(diskHardware);
	}

	public void addDiskValue(DiskValue diskValue) {
		this.diskValues.add(diskValue);
	}
	
	

}
