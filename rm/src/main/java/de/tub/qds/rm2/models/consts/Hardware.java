package de.tub.qds.rm2.models.consts;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import de.tub.qds.rm2.models.consts.pks.HardwarePK;

@Entity
public class Hardware implements Serializable {


	@EmbeddedId
	HardwarePK hardwareId;
	@OneToMany(mappedBy = "systemId.systemHardware")
	Set<System> hardwareSystems;

	public Hardware() {

	}

	public Hardware(HardwarePK id) {
		super();
		this.hardwareId = id;
		this.hardwareSystems = new HashSet<System>();
	}

	
	public HardwarePK getHardwareId() {
		return hardwareId;
	}

	public void setHardwareId(HardwarePK id) {
		this.hardwareId = id;
	}

	public Set<System> getHardwareSystems() {
		return hardwareSystems;
	}

	public void addHardwareSystem(System system) {
		this.hardwareSystems.add(system);
	}
}
