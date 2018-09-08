package de.tub.qds.rm.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Baseboard;
import de.tub.qds.rm.models.consts.Disk;
import de.tub.qds.rm.models.consts.Firmware;
import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.Memory;
import de.tub.qds.rm.models.consts.Network;
import de.tub.qds.rm.models.consts.Processor;
import de.tub.qds.rm.models.consts.System;
import de.tub.qds.rm.models.consts.SystemModel;
import de.tub.qds.rm.models.consts.repos.BaseboardRepo;
import de.tub.qds.rm.models.consts.repos.DiskRepo;
import de.tub.qds.rm.models.consts.repos.FirmwareRepo;
import de.tub.qds.rm.models.consts.repos.HardwareRepo;
import de.tub.qds.rm.models.consts.repos.MemoryRepo;
import de.tub.qds.rm.models.consts.repos.NetworkRepo;
import de.tub.qds.rm.models.consts.repos.ProcessorRepo;
import de.tub.qds.rm.models.consts.repos.SystemModelRepo;
import de.tub.qds.rm.models.consts.repos.SystemRepo;

//FINISHED IMPLEMENTATION & TESTED
@RestController
public class HardwareController {
	
	@Autowired
	HardwareRepo repo;
	@Autowired
	SystemModelRepo systemModelRepo;
	@Autowired
	BaseboardRepo baseboardRepo;
	@Autowired
	FirmwareRepo firmwareRepo;
	@Autowired
	ProcessorRepo processorRepo;
	@Autowired
	MemoryRepo memoryRepo;
	@Autowired
	SystemRepo systemRepo;
	@Autowired
	NetworkRepo networkRepo;
	@Autowired
	DiskRepo diskRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/hardware", produces = "application/json")
	public List<Hardware> getHardware() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hardware/{hardwareIdentifier}", produces = "application/json")
	public Hardware getHardwareByIdHardwareIdentifier(@PathVariable("hardwareIdentifier") Long hardwareIdentifier) {
		return repo.findById(hardwareIdentifier).orElse(null);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/hardware/{hardwareIdentifier}", produces = "application/json")
	public Hardware updateHardwareById(
			@PathVariable("hardwareIdentifier") Long hardwareIdentifier,
			@RequestParam(value = "systemModelSerialNumber", required=false) String systemModelSerialNumber,
			@RequestParam(value = "baseboardSerialNumber", required=false) String baseboardSerialNumber,
			@RequestParam(value = "firmwareIdentifier", required=false) Long firmwareIdentifier,
			@RequestParam(value = "processorId", required=false) String processorId,
			@RequestParam(value = "memoryTotalSpace", required=false) Long memoryTotalSpace
			){
		Hardware hardware = repo.findById(hardwareIdentifier).orElse(null);
		SystemModel systemModel = systemModelSerialNumber != null? systemModelRepo.findById(systemModelSerialNumber).orElse(null):null;
		Baseboard baseboard = baseboardSerialNumber != null? baseboardRepo.findById(baseboardSerialNumber).orElse(null):null;
		Firmware firmware = firmwareIdentifier != null? firmwareRepo.findById(firmwareIdentifier).orElse(null):null;
		Processor processor = processorId != null? processorRepo.findById(processorId).orElse(null):null;
		Memory memory = memoryTotalSpace != null? memoryRepo.findById(memoryTotalSpace).orElse(null):null;
		
		if(hardware==null){
			return null;
		}
		if(systemModel != null){
			hardware.setHardwareSystemModel(systemModel);
		}
		if(baseboard != null){
			hardware.setHardwareBaseboard(baseboard);
		}
		if(firmware != null){
			hardware.setHardwareFirmware(firmware);
		}
		if(processor != null){
			hardware.setHardwareProcessor(processor);
		}
		if(memory != null){
			hardware.setHardwareMemory(memory);
		}
		return repo.save(hardware);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/hardware/{hardwareIdentifier}", produces = "application/json")
	public void deleteHardwareByIdHardwareIdentifier(@PathVariable("hardwareIdentifier") Long hardwareIdentifier) {
		if(repo.existsById(hardwareIdentifier)){
			repo.deleteById(hardwareIdentifier);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hardware/{hardwareIdentifier}/hardwareSystemModel", produces = "application/json")
	public SystemModel getHardwareByIdHardwareIdentifierSystemModel(@PathVariable("hardwareIdentifier") Long hardwareIdentifier) {
		return repo.existsById(hardwareIdentifier) ? repo.findById(hardwareIdentifier).get().getHardwareSystemModel() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hardware/{hardwareIdentifier}/hardwareBaseboard", produces = "application/json")
	public Baseboard getHardwareByIdHardwareIdentifierBaseboard(@PathVariable("hardwareIdentifier") Long hardwareIdentifier) {
		return repo.existsById(hardwareIdentifier) ? repo.findById(hardwareIdentifier).get().getHardwareBaseboard() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hardware/{hardwareIdentifier}/hardwareFirmware", produces = "application/json")
	public Firmware getHardwareByIdHardwareIdentifierFirmware(@PathVariable("hardwareIdentifier") Long hardwareIdentifier) {
		return repo.existsById(hardwareIdentifier) ? repo.findById(hardwareIdentifier).get().getHardwareFirmware() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hardware/{hardwareIdentifier}/hardwareProcessor", produces = "application/json")
	public Processor getHardwareByIdHardwareIdentifierProcessor(@PathVariable("hardwareIdentifier") Long hardwareIdentifier) {
		return repo.existsById(hardwareIdentifier) ? repo.findById(hardwareIdentifier).get().getHardwareProcessor() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hardware/{hardwareIdentifier}/hardwareMemory", produces = "application/json")
	public Memory getHardwareByIdHardwareIdentifierMemory(@PathVariable("hardwareIdentifier") Long hardwareIdentifier) {
		return repo.existsById(hardwareIdentifier) ? repo.findById(hardwareIdentifier).get().getHardwareMemory() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hardware/{hardwareIdentifier}/hardwareSystems", produces = "application/json")
	public Set<System> getHardwareByIdHardwareIdentifierSystems(@PathVariable("hardwareIdentifier") Long hardwareIdentifier) {
		return repo.existsById(hardwareIdentifier) ? repo.findById(hardwareIdentifier).get().getHardwareSystems() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/hardware/{hardwareIdentifier}/hardwareSystems", produces = "application/json")
	public Set<System> addHardwareByIdHardwareIdentifierSystem(@PathVariable("hardwareIdentifier") Long hardwareIdentifier, @RequestParam("systemId") Long systemId) {
		Hardware hardware = repo.findById(hardwareIdentifier).orElse(null);
		System system = systemRepo.findById(systemId).orElse(null);
		if(hardware == null || system == null){
			return null;
		}
		hardware.addHardwareSystem(system);
		return repo.save(hardware).getHardwareSystems();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hardware/{hardwareIdentifier}/hardwareNetworks", produces = "application/json")
	public Set<Network> getHardwareByIdHardwareIdentifierNetworks(@PathVariable("hardwareIdentifier") Long hardwareIdentifier) {
		return repo.existsById(hardwareIdentifier) ? repo.findById(hardwareIdentifier).get().getHardwareNetworks() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/hardware/{hardwareIdentifier}/hardwareNetworks", produces = "application/json")
	public Set<Network> addHardwareByIdHardwareIdentifierNetwork(@PathVariable("hardwareIdentifier") Long hardwareIdentifier, @RequestParam("networkMac") String networkMac) {
		Hardware hardware = repo.findById(hardwareIdentifier).orElse(null);
		Network network = networkRepo.findById(networkMac).orElse(null);
		if(hardware == null || network == null){
			return null;
		}
		hardware.addHardwareNetwork(network);
		return repo.save(hardware).getHardwareNetworks();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hardware/{hardwareIdentifier}/hardwareDisks", produces = "application/json")
	public Set<Disk> getHardwareByIdHardwareIdentifierDisks(@PathVariable("hardwareIdentifier") Long hardwareIdentifier) {
		return repo.existsById(hardwareIdentifier) ? repo.findById(hardwareIdentifier).get().getHardwareDisks() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/hardware/{hardwareIdentifier}/hardwareDisks", produces = "application/json")
	public Set<Disk> addHardwareByIdHardwareIdentifierDisk(@PathVariable("hardwareIdentifier") Long hardwareIdentifier, @RequestParam("diskSerialNumber") String diskSerialNumber) {
		Hardware hardware = repo.findById(hardwareIdentifier).orElse(null);
		Disk disk = diskRepo.findById(diskSerialNumber).orElse(null);
		if(hardware == null || disk == null){
			return null;
		}
		hardware.addHardwareDisk(disk);
		return repo.save(hardware).getHardwareDisks();
	}

}
