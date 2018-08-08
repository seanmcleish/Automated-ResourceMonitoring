package de.tub.qds.rm.models.consts.pks;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

@Embeddable
public class OperatingSystemPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public String getOpratingSystemManufacturer() {
		return opratingSystemManufacturer;
	}

	public void setOpratingSystemManufacturer(String opratingSystemManufacturer) {
		this.opratingSystemManufacturer = opratingSystemManufacturer;
	}

	public String getOperatingSystemfamily() {
		return operatingSystemfamily;
	}

	public void setOperatingSystemfamily(String operatingSystemfamily) {
		this.operatingSystemfamily = operatingSystemfamily;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setOperatingSystemVersion(String operatingSystemVersion) {
		this.operatingSystemVersion = operatingSystemVersion;
	}

	public void setOperatingSystemCodeName(String operatingSystemCodeName) {
		this.operatingSystemCodeName = operatingSystemCodeName;
	}

	public void setOperatingSystemBuild(String operatingSystemBuild) {
		this.operatingSystemBuild = operatingSystemBuild;
	}

}
