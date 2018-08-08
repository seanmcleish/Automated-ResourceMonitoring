package de.tub.qds.rm.models.consts;




import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import de.tub.qds.rm.models.values.DiskValue;


@Entity
public class Disk implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	String diskSerialNumber;
	String diskModel;
	String diskName;
	Long diskSize;
	@OneToMany(mappedBy = "diskValueId.diskValueDisk", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<DiskValue> diskValues;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	FileSystem diskFileSystem;

	public Disk(){}

	public Disk(String serialNumber, FileSystem fileSystem,String model, String name, Long size) {
		super();
		this.diskSerialNumber = serialNumber;
		this.diskModel = model;
		this.diskName = name;
		this.diskSize = size;
		this.diskFileSystem = fileSystem;
		this.diskValues = new HashSet<DiskValue>();
	}

	
	public String getDiskSerialNumber() {
		return diskSerialNumber;
	}

	public void setDiskSerialNumber(String serialNumber) {
		this.diskSerialNumber = serialNumber;
	}

	public String getDiskModel() {
		return diskModel;
	}

	public void setDiskModel(String model) {
		this.diskModel = model;
	}

	public String getDiskName() {
		return diskName;
	}

	public void setDiskName(String name) {
		this.diskName = name;	}

	public Long getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(Long size) {
		this.diskSize = size;
	}

	public Set<DiskValue> getDiskValues() {
		return diskValues;
	}

	public void addDiskValue(DiskValue value) {
		this.diskValues.add(value);
	}

	public FileSystem getDiskFileSysten() {
		return diskFileSystem;
	}

	public FileSystem getDiskFileSystem() {
		return diskFileSystem;
	}

	public void setDiskFileSystem(FileSystem diskFileSystem) {
		this.diskFileSystem = diskFileSystem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setDiskValues(Set<DiskValue> diskValues) {
		this.diskValues = diskValues;
	}

}
