package de.tub.qds.rm.models.values;





import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import de.tub.qds.rm.models.values.pks.FileSystemValuePK;


@Entity
public class FileSystemValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	FileSystemValuePK fileSystemValueId;
	long fileSystemValueOpenFileDescriptors;
	long fileSystemValueMaxFileDescriptors;
	
	public FileSystemValue(){}

	public FileSystemValue(FileSystemValuePK id, long openFileDescriptors, long maxFileDescriptors) {
		super();
		this.fileSystemValueId = id;
		this.fileSystemValueOpenFileDescriptors = openFileDescriptors;
		this.fileSystemValueMaxFileDescriptors = maxFileDescriptors;
	}

	public long getFileSystemValueOpenFileDescriptors() {
		return fileSystemValueOpenFileDescriptors;
	}

	public void setFileSystemValueOpenFileDescriptors(long openFileDescriptors) {
		this.fileSystemValueOpenFileDescriptors = openFileDescriptors;
	}

	public long getFileSystemValueMaxFileDescriptors() {
		return fileSystemValueMaxFileDescriptors;
	}

	public void setFileSystemValueMaxFileDescriptors(long maxFileDescriptors) {
		this.fileSystemValueMaxFileDescriptors = maxFileDescriptors;
	}

	public FileSystemValuePK getFileSystemValueId() {
		return fileSystemValueId;
	}
	public void setFileSystemValueId(FileSystemValuePK id){
		this.fileSystemValueId = id;
	}
}
