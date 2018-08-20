package de.tub.qds.rm.models.consts;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tub.qds.rm.models.consts.pks.OperatingSystemPK;

@Entity
public class OperatingSystem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	OperatingSystemPK operatingSystemId;
	@OneToMany(mappedBy = "systemId.systemOperatingSystem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<System> operatingSytemSystems;

	public OperatingSystem() {
	}

	public OperatingSystem(OperatingSystemPK id) {
		super();
		this.operatingSystemId = id;
		this.operatingSytemSystems = new HashSet<System>();
	}

	public OperatingSystemPK getOperatingSystemId() {
		return operatingSystemId;
	}

	public void setOperatingSystemId(OperatingSystemPK operatingSystemId) {
		this.operatingSystemId = operatingSystemId;
	}

	@JsonIgnore
	public Set<System> getOperatingSytemSystems() {
		return operatingSytemSystems;
	}

	public void setOperatingSytemSystems(Set<System> operatingSytemSystems) {
		this.operatingSytemSystems = operatingSytemSystems;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
