package de.tub.qds.rm2.models.consts.pks;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class OperatingSystemPK implements Serializable {

	String opratingSystemManufacturer;
	String operatingSystemfamily;
	String operatingSystemVersion;
	String operatingSystemCodeName;
	String operatingSystemBuild;

	 @GeneratedValue int id;
	public OperatingSystemPK(){}

	public OperatingSystemPK(String manufacturer, String family, String version, String codeName, String build) {
		super();
		this.opratingSystemManufacturer = manufacturer;
		this.operatingSystemfamily = family;
		this.operatingSystemVersion = version;
		this.operatingSystemCodeName = codeName;
		this.operatingSystemBuild = build;
	}

	public String getOperatingSystemManufacturer() {
		return opratingSystemManufacturer;
	}

	public String getOperatingSystemFamily() {
		return operatingSystemfamily;
	}

	public String getOperatingSystemVersion() {
		return operatingSystemVersion;
	}

	public String getOperatingSystemCodeName() {
		return operatingSystemCodeName;
	}

	public String getOperatingSystemBuild() {
		return operatingSystemBuild;
	}

}
