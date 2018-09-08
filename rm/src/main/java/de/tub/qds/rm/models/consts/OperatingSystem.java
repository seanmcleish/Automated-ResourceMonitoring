package de.tub.qds.rm.models.consts;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OperatingSystem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	Long operatingSystemId;
	@OneToMany(mappedBy = "systemOperatingSystem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<System> operatingSytemSystems;
	String operatingSystemManufacturer;
	String operatingSystemFamily;
	String operatingSystemVersion;
	String operatingSystemCodeName;
	String operatingSystemBuild;

	public OperatingSystem() {
	}

	public OperatingSystem(String operatingSystemManufacturer, String operatingSystemFamily, String operatingSystemVersion, String operatingSystemCodeName, String operatingSystemBuild ) {
		super();
		this.operatingSystemManufacturer = operatingSystemManufacturer;
		this.operatingSystemFamily = operatingSystemFamily;
		this.operatingSystemVersion = operatingSystemVersion;
		this.operatingSystemCodeName = operatingSystemCodeName;
		this.operatingSystemBuild = operatingSystemBuild;
		this.operatingSytemSystems = new HashSet<System>();
	}

	public Long getOperatingSystemId() {
		return operatingSystemId;
	}

	public Set<System> getOperatingSytemSystems() {
		return operatingSytemSystems;
	}

	public void addOperatingSytemSystem(System operatingSytemSystem) {
		this.operatingSytemSystems.add(operatingSytemSystem);
	}

	public String getOperatingSystemManufacturer() {
		return operatingSystemManufacturer;
	}

	public void setOperatingSystemManufacturer(String operatingSystemManufacturer) {
		this.operatingSystemManufacturer = operatingSystemManufacturer;
	}

	public String getOperatingSystemFamily() {
		return operatingSystemFamily;
	}

	public void setOperatingSystemFamily(String operatingSystemFamily) {
		this.operatingSystemFamily = operatingSystemFamily;
	}

	public String getOperatingSystemVersion() {
		return operatingSystemVersion;
	}

	public void setOperatingSystemVersion(String operatingSystemVersion) {
		this.operatingSystemVersion = operatingSystemVersion;
	}

	public String getOperatingSystemCodeName() {
		return operatingSystemCodeName;
	}

	public void setOperatingSystemCodeName(String operatingSystemCodeName) {
		this.operatingSystemCodeName = operatingSystemCodeName;
	}

	public String getOperatingSystemBuild() {
		return operatingSystemBuild;
	}

	public void setOperatingSystemBuild(String operatingSystemBuild) {
		this.operatingSystemBuild = operatingSystemBuild;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
