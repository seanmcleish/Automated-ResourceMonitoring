package de.tub.qds.rm2.models.consts;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import de.tub.qds.rm2.models.values.FileStoreValue;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class FileStore implements Serializable {


	@Id
	String fileStoreUuid;
	Long fileStoreTotalSpace;
	String fileStoreName;
	String fileStoreVolume;
	String fileStoreMountPoint;
	String fileStoreDescription;
	String fileStoreFsType;
	@ManyToOne(targetEntity = FileSystem.class)
	FileSystem fileStoreFileSystem;
	@OneToMany (mappedBy = "fileStoreValueId.fileStoreValueFileStore")
	Set<FileStoreValue> fileStoreValues;

	public FileStore(){}

	public FileStore(String uuid, Long totalSpace, String name, String volume, String mountPoint, String description,
			String fsType, FileSystem fileSystem) {
		super();
		this.fileStoreUuid = uuid;
		this.fileStoreTotalSpace = totalSpace;
		this.fileStoreName = name;
		this.fileStoreVolume = volume;
		this.fileStoreMountPoint = mountPoint;
		this.fileStoreDescription = description;
		this.fileStoreFsType = fsType;
		this.fileStoreFileSystem = fileSystem;
		this.fileStoreValues = new HashSet<FileStoreValue>();
	}

	
	public String getFileStoreUuid() {
		return fileStoreUuid;
	}

	public void setFileStoreUuid(String uuid) {
		this.fileStoreUuid = uuid;
	}

	public Long getFileStoreTotalSpace() {
		return fileStoreTotalSpace;
	}

	public void setFileStoreTotalSpace(Long totalSpace) {
		this.fileStoreTotalSpace = totalSpace;
	}

	public String getFileStoreName() {
		return fileStoreName;
	}

	public void setFileStoreName(String name) {
		this.fileStoreName = name;
	}

	public String getFileStoreVolume() {
		return fileStoreVolume;
	}

	public void setFileStoreVolume(String volume) {
		this.fileStoreVolume = volume;
	}

	public String getFileStoreMountPoint() {
		return fileStoreMountPoint;
	}

	public void setFileStoreMountPoint(String mountPoint) {
		this.fileStoreMountPoint = mountPoint;
	}

	public String getFileStoreDescription() {
		return fileStoreDescription;
	}

	public void setFileStoreDescription(String description) {
		this.fileStoreDescription = description;
	}

	public String getFileStoreFsType() {
		return fileStoreFsType;
	}

	public void setFileStoreFsType(String fsType) {
		this.fileStoreFsType = fsType;
	}

	public FileSystem getFileStoreFileSystem() {
		return fileStoreFileSystem;
	}

	public void setFileStoreFileSystem(FileSystem fileSystem) {
		this.fileStoreFileSystem = fileSystem;
	}

	public Set<FileStoreValue> getFileStoreValues() {
		return fileStoreValues;
	}

	public void addFileStoreValue(FileStoreValue value) {
		this.fileStoreValues.add(value);
	}

}
