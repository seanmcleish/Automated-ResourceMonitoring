package de.tub.qds.rm.models.values.pks;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tub.qds.rm.models.consts.FileStore;

@Embeddable
public class FileStoreValuePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(targetEntity = FileStore.class)
	FileStore fileStoreValueFileStore;
	int fileStoreValueMeasurementId;
	Date fileStoreValueTimestamp;

	public FileStoreValuePK() {
	}

	public FileStoreValuePK(int measurement, Date timestamp) {
		super();
		this.fileStoreValueMeasurementId = measurement;
		this.fileStoreValueTimestamp = timestamp;
	}

	@JsonIgnore
	public FileStore getFileStoreValueFileStore() {
		return fileStoreValueFileStore;
	}

	public void setFileStoreValueFileStore(FileStore fileStoreValueFileStore) {
		this.fileStoreValueFileStore = fileStoreValueFileStore;
	}

	public int getFileStoreValueMeasurementId() {
		return fileStoreValueMeasurementId;
	}

	public void setFileStoreValueMeasurementId(int fileStoreValueMeasurementId) {
		this.fileStoreValueMeasurementId = fileStoreValueMeasurementId;
	}

	public Date getFileStoreValueTimestamp() {
		return fileStoreValueTimestamp;
	}

	public void setFileStoreValueTimestamp(Date fileStoreValueTimestamp) {
		this.fileStoreValueTimestamp = fileStoreValueTimestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
