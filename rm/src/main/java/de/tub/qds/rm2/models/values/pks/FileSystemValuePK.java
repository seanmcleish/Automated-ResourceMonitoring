package de.tub.qds.rm2.models.values.pks;




import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import de.tub.qds.rm2.models.consts.FileSystem;

@Embeddable
public class FileSystemValuePK implements Serializable {

	@ManyToOne(targetEntity = FileSystem.class)
	FileSystem fileSystemValueFileSystem;
	int fileSystemValueMeasurementId;
	Date fileSystemValueTimestamp;
	

	public FileSystemValuePK(){}

	public FileSystemValuePK(int measurement, Date timestamp, FileSystem fileSystem) {
		super();
		this.fileSystemValueMeasurementId = measurement;
		this.fileSystemValueTimestamp = timestamp;
		this.fileSystemValueFileSystem = fileSystem;
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
