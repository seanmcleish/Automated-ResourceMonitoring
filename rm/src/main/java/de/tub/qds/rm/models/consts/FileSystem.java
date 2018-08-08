package de.tub.qds.rm.models.consts;






import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import de.tub.qds.rm.models.values.FileSystemValue;


@Entity
public class FileSystem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue 
	int id;
	@OneToOne(mappedBy = "diskFileSystem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Disk fileSystemDisk;
	@OneToMany(mappedBy = "fileStoreFileSystem", targetEntity=FileStore.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<FileStore> fileStores;
	@OneToMany(mappedBy = "fileSystemValueId.fileSystemValueFileSystem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<FileSystemValue> fileSystemValues;

	public FileSystem(){}

	public FileSystem(Disk disk) {
		super();
		this.fileSystemDisk = disk;
		fileStores = new HashSet<FileStore>();
		fileSystemValues = new HashSet<FileSystemValue>();
	}
	
	
	public int getId() {
		return id;
	}

	public Disk getFileSystemDisk() {
		return fileSystemDisk;
	}

	public void setFileSystemDisk(Disk disk) {
		this.fileSystemDisk = disk;
	}

	public Set<FileStore> getFileSystemFileStores() {
		return fileStores;
	}

	public void addFileSystemFileStore(FileStore fileStore) {
		fileStores.add(fileStore);
	}

	public Set<FileSystemValue> getFileSystemValues() {
		return fileSystemValues;
	}

	public void addFileSystemValue(FileSystemValue value) {
		fileSystemValues.add(value);
	}

	public Set<FileStore> getFileStores() {
		return fileStores;
	}

	public void setFileStores(Set<FileStore> fileStores) {
		this.fileStores = fileStores;
	}

	

	public void setFileSystemValues(Set<FileSystemValue> fileSystemValues) {
		this.fileSystemValues = fileSystemValues;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(int id) {
		this.id = id;
	}

}
