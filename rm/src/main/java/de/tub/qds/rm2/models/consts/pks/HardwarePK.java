package de.tub.qds.rm2.models.consts.pks;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import de.tub.qds.rm2.models.consts.Baseboard;
import de.tub.qds.rm2.models.consts.Disk;
import de.tub.qds.rm2.models.consts.Firmware;
import de.tub.qds.rm2.models.consts.Memory;
import de.tub.qds.rm2.models.consts.Network;
import de.tub.qds.rm2.models.consts.Processor;
import de.tub.qds.rm2.models.consts.SystemModel;

@Embeddable
public class HardwarePK implements Serializable {

	@ManyToOne
	SystemModel hardwareSystemModel;
	@ManyToOne
	Baseboard hardwareBaseboard;
	@ManyToOne
	Firmware hardwareFirmware;
	@ManyToOne
	Processor hardwareProcessor;
	@ManyToOne
	Memory hardwareMemory;
	
	public HardwarePK(){}

	public HardwarePK(Firmware firmware, Processor processor, Memory memory) {
		super();
		this.hardwareFirmware = firmware;
		this.hardwareProcessor = processor;
		/*this.hardwareNetworks = new HashSet<Network>();
		this.hardwareMemory = memory;
		this.hardwareDisks = new HashSet<Disk>();*/
	}


	public Firmware getHardwareFirmware() {
		return hardwareFirmware;
	}

	public Processor getHardwareProcessor() {
		return hardwareProcessor;
	}
/*
	public Set<Network> getHardwareNetworks() {
		return hardwareNetworks;
	}
	public void addHardwareNetwork(Network network){
		this.hardwareNetworks.add(network);
	}*/
/*
	public Memory getHardwareMemory() {
		return hardwareMemory;
	}

	public Set<Disk> getHardwareDisks() {
		return hardwareDisks;
	}
	public void addHardwareDisk(Disk disk){
		this.hardwareDisks.add(disk);
	}
*/

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


	public void setHardwareFirmware(Firmware hardwareFirmware) {
		this.hardwareFirmware = hardwareFirmware;
	}

	public void setHardwareProcessor(Processor hardwareProcessor) {
		this.hardwareProcessor = hardwareProcessor;
	}


}
