package de.tub.qds.rm2.models.consts;






import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import de.tub.qds.rm2.models.values.FileSystemValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class FileSystem implements Serializable {

	@Id @GeneratedValue 
	int id;
	@OneToOne(mappedBy = "diskFileSystem")
	Disk fileSystemDisk;
	@OneToMany(mappedBy = "fileStoreFileSystem", targetEntity=FileStore.class)
	Set<FileStore> fileStores;
	@OneToMany(mappedBy = "fileSystemValueId.fileSystemValueFileSystem")
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

}
