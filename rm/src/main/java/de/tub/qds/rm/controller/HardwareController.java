package de.tub.qds.rm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Baseboard;
import de.tub.qds.rm.models.consts.Firmware;
import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.Memory;
import de.tub.qds.rm.models.consts.Processor;
import de.tub.qds.rm.models.consts.SystemModel;
import de.tub.qds.rm.models.consts.repos.HardwareRepo;

@RestController
public class HardwareController {
	
	@Autowired
	HardwareRepo repo;

	@RequestMapping(method = RequestMethod.GET, path = "/hardware", produces = "application/json")
	public List<Hardware> getHardware() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hardware/{hardwareIdentifier}", produces = "application/json")
	public Hardware getHardwareByIdHardwareIdentifier(@PathVariable("hardwareIdentifier") int hardwareIdentifier) {
		return repo.existsByHardwareIdHardwareIdentifier(hardwareIdentifier) ? repo.findByHardwareIdHardwareIdentifier(hardwareIdentifier) : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hardware/{hardwareIdentifier}/hardwareSystemModel", produces = "application/json")
	public SystemModel getHardwareByIdHardwareIdentifierSystemModel(@PathVariable("hardwareIdentifier") int hardwareIdentifier) {
		return repo.existsByHardwareIdHardwareIdentifier(hardwareIdentifier) ? repo.findByHardwareIdHardwareIdentifier(hardwareIdentifier).getHardwareId().getHardwareSystemModel() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hardware/{hardwareIdentifier}/hardwareBaseboard", produces = "application/json")
	public Baseboard getHardwareByIdHardwareIdentifierBaseboard(@PathVariable("hardwareIdentifier") int hardwareIdentifier) {
		return repo.existsByHardwareIdHardwareIdentifier(hardwareIdentifier) ? repo.findByHardwareIdHardwareIdentifier(hardwareIdentifier).getHardwareId().getHardwareBaseboard() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hardware/{hardwareIdentifier}/hardwareFirmware", produces = "application/json")
	public Firmware getHardwareByIdHardwareIdentifierFirmware(@PathVariable("hardwareIdentifier") int hardwareIdentifier) {
		return repo.existsByHardwareIdHardwareIdentifier(hardwareIdentifier) ? repo.findByHardwareIdHardwareIdentifier(hardwareIdentifier).getHardwareId().getHardwareFirmware() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hardware/{hardwareIdentifier}/hardwareProcessor", produces = "application/json")
	public Processor getHardwareByIdHardwareIdentifierProcessor(@PathVariable("hardwareIdentifier") int hardwareIdentifier) {
		return repo.existsByHardwareIdHardwareIdentifier(hardwareIdentifier) ? repo.findByHardwareIdHardwareIdentifier(hardwareIdentifier).getHardwareId().getHardwareProcessor() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hardware/{hardwareIdentifier}/hardwareMemory", produces = "application/json")
	public Memory getHardwareByIdHardwareIdentifierMemory(@PathVariable("hardwareIdentifier") int hardwareIdentifier) {
		return repo.existsByHardwareIdHardwareIdentifier(hardwareIdentifier) ? repo.findByHardwareIdHardwareIdentifier(hardwareIdentifier).getHardwareId().getHardwareMemory() : null;
	}

}
