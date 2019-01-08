package de.tub.qds.rm.models.consts;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Hardware implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	Long hardwareId;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	SystemModel hardwareSystemModel;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Baseboard hardwareBaseboard;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Firmware hardwareFirmware;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Processor hardwareProcessor;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Memory hardwareMemory;
	@OneToMany(mappedBy = "systemHardware", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<System> hardwareSystems;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<Network> hardwareNetworks;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<Disk> hardwareDisks;
	public Hardware() 
	{

	}

	public Hardware(SystemModel hardwareSystemModel, Baseboard hardwareBaseboard, Firmware hardwareFirmware, Processor hardwareProcessor, Memory hardwareMemory ) {
		super();
		this.hardwareSystemModel = hardwareSystemModel;
		this.hardwareBaseboard = hardwareBaseboard;
		this.hardwareFirmware = hardwareFirmware;
		this.hardwareProcessor = hardwareProcessor;
		this.hardwareMemory = hardwareMemory;
		this.hardwareSystems = new HashSet<System>();
		this.hardwareNetworks = new HashSet<Network>();
		this.hardwareDisks = new HashSet<Disk>();
	}

	public Long getHardwareId() {
		return hardwareId;
	}

	public SystemModel getHardwareSystemModel() {
		return hardwareSystemModel;
	}

	public void setHardwareSystemModel(SystemModel hardwareSystemModel) {
		this.hardwareSystemModel = hardwareSystemModel;
	}

	public Baseboard getHardwareBaseboard() {
		return hardwareBaseboard;
	}

	public void setHardwareBaseboard(Baseboard hardwareBaseboard) {
		this.hardwareBaseboard = hardwareBaseboard;
	}

	public Firmware getHardwareFirmware() {
		return hardwareFirmware;
	}

	public void setHardwareFirmware(Firmware hardwareFirmware) {
		this.hardwareFirmware = hardwareFirmware;
	}

	public Processor getHardwareProcessor() {
		return hardwareProcessor;
	}

	public void setHardwareProcessor(Processor hardwareProcessor) {
		this.hardwareProcessor = hardwareProcessor;
	}

	public Memory getHardwareMemory() {
		return hardwareMemory;
	}

	public void setHardwareMemory(Memory hardwareMemory) {
		this.hardwareMemory = hardwareMemory;
	}

	@JsonIgnore
	public Set<System> getHardwareSystems() {
		return hardwareSystems;
	}

	public void addHardwareSystem(System hardwareSystem) {
		this.hardwareSystems.add(hardwareSystem);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Network> getHardwareNetworks() {
		return hardwareNetworks;
	}

	public void addHardwareNetwork(Network hardwareNetwork) {
		this.hardwareNetworks.add(hardwareNetwork);
	}

	public Set<Disk> getHardwareDisks() {
		return hardwareDisks;
	}

	public void addHardwareDisk(Disk hardwareDisk) {
		this.hardwareDisks.add(hardwareDisk);
	}
		
}
