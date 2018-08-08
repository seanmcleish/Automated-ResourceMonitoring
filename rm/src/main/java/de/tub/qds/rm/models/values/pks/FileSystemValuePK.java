package de.tub.qds.rm.models.values.pks;




import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import de.tub.qds.rm.models.consts.FileSystem;

@Embeddable
public class FileSystemValuePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(targetEntity = FileSystem.class)
	FileSystem fileSystemValueFileSystem;
	int fileSystemValueMeasurementId;
	Date fileSystemValueTimestamp;
	

	public FileSystemValuePK(){}

	public FileSystemValuePK(int measurement, Date timestamp) {
		super();
		this.fileSystemValueMeasurementId = measurement;
		this.fileSystemValueTimestamp = timestamp;
	}

	public int getMeasurement() {
		return fileSystemValueMeasurementId;
	}

	public Date getTimestamp() {
		return fileSystemValueTimestamp;
	}

	public FileSystem getFileSystem() {
		return fileSystemValueFileSystem;
	}

	}
