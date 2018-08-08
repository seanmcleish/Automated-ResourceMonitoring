package de.tub.qds.rm.models.consts;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import de.tub.qds.rm.models.consts.pks.SystemPK;

@Entity
public class System implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	SystemPK systemId;
	@OneToMany(mappedBy = "measurementSystem",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Measurement> systemMeasurements;
	
	public System(){}

	public System(SystemPK id) {
		super();
		this.systemId = id;
		this.systemMeasurements = new HashSet<Measurement>();
	}

	
	public SystemPK getSystemId() {
		return systemId;
	}
	public void setSystemId(SystemPK id){
		this.systemId = id;
	}

	public Set<Measurement> getSystemMeasurements() {
		return systemMeasurements;
	}
	
	public void addSystemMeasurement(Measurement measurement){
		this.systemMeasurements.add(measurement);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setSystemMeasurements(Set<Measurement> systemMeasurements) {
		this.systemMeasurements = systemMeasurements;
	}	

}
