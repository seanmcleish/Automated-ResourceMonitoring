package de.tub.qds.rm.models.consts;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import de.tub.qds.rm.models.consts.pks.HardwarePK;

@Entity
public class Hardware implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	HardwarePK hardwareId;
	@OneToMany(mappedBy = "systemId.systemHardware", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setHardwareSystems(Set<System> hardwareSystems) {
		this.hardwareSystems = hardwareSystems;
	}
}
