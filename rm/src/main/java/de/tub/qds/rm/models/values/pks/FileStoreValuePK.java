package de.tub.qds.rm.models.values.pks;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

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

	public FileStoreValuePK(){}

	public FileStoreValuePK(int measurement, Date timestamp) {
		super();
		this.fileStoreValueMeasurementId = measurement;
		this.fileStoreValueTimestamp = timestamp;
	}

	public FileStore getFileStore() {
		return fileStoreValueFileStore;
	}

	public int getMeasurement() {
		return fileStoreValueMeasurementId;
	}

	public Date getTimestamp() {
		return fileStoreValueTimestamp;
	}

}
