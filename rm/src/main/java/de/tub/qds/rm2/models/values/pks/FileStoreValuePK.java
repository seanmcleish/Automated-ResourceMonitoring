package de.tub.qds.rm2.models.values.pks;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import de.tub.qds.rm2.models.consts.FileStore;


@Embeddable
public class FileStoreValuePK implements Serializable {

	@ManyToOne(targetEntity = FileStore.class)
	FileStore fileStoreValueFileStore;
	int fileStoreValueMeasurementId;
	Date fileStoreValueTimestamp;

	public FileStoreValuePK(){}

	public FileStoreValuePK(FileStore fileStore, int measurement, Date timestamp) {
		super();
		//this.fileStoreValueFileStore = fileStore;
		this.fileStoreValueMeasurementId = measurement;
		this.fileStoreValueTimestamp = timestamp;
	}
/*
	public FileStore getFileStore() {
		return fileStoreValueFileStore;
	}*/

	public int getMeasurement() {
		return fileStoreValueMeasurementId;
	}

	public Date getTimestamp() {
		return fileStoreValueTimestamp;
	}

}
