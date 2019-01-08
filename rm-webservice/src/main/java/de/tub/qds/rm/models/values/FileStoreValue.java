package de.tub.qds.rm.models.values;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import de.tub.qds.rm.models.values.pks.FileStoreValuePK;

@Entity
public class FileStoreValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	FileStoreValuePK fileStoreValueId;
	Long fileStoreValueUsableSpace;

	public FileStoreValue() {
	}

	public FileStoreValue(FileStoreValuePK id, Long usableSpace) {
		super();
		this.fileStoreValueId = id;
		this.fileStoreValueUsableSpace = usableSpace;
	}

	
	public FileStoreValuePK getFileStoreValueId() {
		return fileStoreValueId;
	}

	public void setFileStoreValueId(FileStoreValuePK fileStoreValueId) {
		this.fileStoreValueId = fileStoreValueId;
	}

	public Long getFileStoreValueUsableSpace() {
		return fileStoreValueUsableSpace;
	}

	public void setFileStoreValueUsableSpace(Long fileStoreValueUsableSpace) {
		this.fileStoreValueUsableSpace = fileStoreValueUsableSpace;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
