package de.tub.qds.rm2.models.consts;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import de.tub.qds.rm2.models.consts.pks.OperatingSystemPK;

@Entity
public class OperatingSystem implements Serializable {

	@EmbeddedId
	OperatingSystemPK operatingSystemId;
	@OneToMany(mappedBy = "systemId.systemOperatingSystem")
	Set<System> operatingSytemSystems;

	public OperatingSystem(){}
	

	public OperatingSystem(OperatingSystemPK id) {
		super();
		this.operatingSystemId = id;
		this.operatingSytemSystems = new HashSet<System>();
	}

	
	public OperatingSystemPK getOperatingSystemId() {
		return operatingSystemId;
	}

	public Set<System> getOperatingSystemSystems() {
		return operatingSytemSystems;
	}
	public void addOperatingSystemSystem (System system){
		this.operatingSytemSystems.add(system);
	}

}
