package de.tub.qds.rm.models.consts;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class System implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue
	Long systemIdentifier;
	String systemHostName;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	OperatingSystem systemOperatingSystem;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Hardware systemHardware;
	@OneToMany(mappedBy = "measurementSystem", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	Set<Measurement> systemMeasurements;

	public System() {
		
	}

	public System(String systemHostName, OperatingSystem systemOperatingSystem) {
		super();
		this.systemHostName = systemHostName;
		this.systemOperatingSystem = systemOperatingSystem;
		this.systemMeasurements = new HashSet<Measurement>();
	}

	public Long getSystemIdentifier() {
		return systemIdentifier;
	}

	public String getSystemHostName() {
		return systemHostName;
	}

	public void setSystemHostName(String systemHostName) {
		this.systemHostName = systemHostName;
	}

	public OperatingSystem getSystemOperatingSystem() {
		return systemOperatingSystem;
	}

	public void setSystemOperatingSystem(OperatingSystem systemOperatingSystem) {
		this.systemOperatingSystem = systemOperatingSystem;
	}

	public Hardware getSystemHardware() {
		return systemHardware;
	}

	public void setSystemHardware(Hardware systemHardware) {
		this.systemHardware = systemHardware;
	}

	public Set<Measurement> getSystemMeasurements() {
		return systemMeasurements;
	}

	public void setSystemMeasurements(Set<Measurement> systemMeasurements) {
		this.systemMeasurements = systemMeasurements;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
