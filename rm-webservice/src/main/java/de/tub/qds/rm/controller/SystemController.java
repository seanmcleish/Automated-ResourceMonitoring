package de.tub.qds.rm.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.OperatingSystem;
import de.tub.qds.rm.models.consts.System;
import de.tub.qds.rm.models.consts.repos.HardwareRepo;
import de.tub.qds.rm.models.consts.repos.OperatingSystemRepo;
import de.tub.qds.rm.models.consts.repos.SystemRepo;

@RestController
public class SystemController {
	
	@Autowired
	SystemRepo repo;
	@Autowired
	HardwareRepo hardwareRepo;
	@Autowired
	OperatingSystemRepo operatingSystemRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/system", produces = "application/json")
	public List<System> getSystems() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/system", produces = "application/json")
	public System postSystem(
			@RequestParam(value="systemHostName", required= false) String systemHostName,
			@RequestParam(value="systemOperatingSystemId", required= false) Long systemOperatingSystemId,
			@RequestParam(value="systemHardwareId", required= false) Long systemHardwareId
			) {
		OperatingSystem os = null;
		Hardware hardware = null;
		if(systemOperatingSystemId != null){
			os = operatingSystemRepo.findById(systemOperatingSystemId).orElse(null);
		}
		if(systemHardwareId != null){
			hardware = hardwareRepo.findById(systemHardwareId).orElse(null);
		}
		return repo.save(new System(systemHostName, os, hardware));		
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/system/{systemIdentifier}", produces = "application/json")
	public System getSystenBySystemIdSystemIdentifier(@PathVariable("systemIdentifier") long systemIdentifier) {
		return repo.existsById(systemIdentifier) ? repo.findById(systemIdentifier).get() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/system/{systemIdentifier}", produces = "application/json")
	public System updateSystem(
			@PathVariable("systemIdentifier") Long systemIdentifier,
			@RequestParam(value="systemHostName", required= false) String systemHostName,
			@RequestParam(value="systemOperatingSystemId", required= false) Long systemOperatingSystemId,
			@RequestParam(value="systemHardwareId", required= false) Long systemHardwareId
			) {
		System system = repo.findById(systemIdentifier).orElse(null);
		if(system == null){
			return null;
		}
		if(systemOperatingSystemId != null){
			system.setSystemOperatingSystem(operatingSystemRepo.findById(systemOperatingSystemId).orElse(null));
			
		}
		if(systemHardwareId != null){
			system.setSystemHardware(hardwareRepo.findById(systemHardwareId).orElse(null));
		}
		if(systemHostName != null){
			system.setSystemHostName(systemHostName);
		}
		return repo.save(system);		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/system/{systemIdentifier}", produces = "application/json")
	public void deleteSystenBySystemIdSystemIdentifier(@PathVariable("systemIdentifier") long systemIdentifier) {
		if(repo.existsById(systemIdentifier)){
			repo.deleteById(systemIdentifier);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/system/{systemIdentifier}/systemHostName", produces = "text/plain")
	public String getSystenBySystemIdSystemIdentifierHostName(@PathVariable("systemIdentifier") long systemIdentifier) {
		return repo.existsById(systemIdentifier) ? repo.findById(systemIdentifier).get().getSystemHostName() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/system/{systemIdentifier}/systemOperatingSystem", produces = "application/json")
	public OperatingSystem getSystenBySystemIdSystemIdentifierOperatingSystem(@PathVariable("systemIdentifier") long systemIdentifier) {
		return repo.existsById(systemIdentifier) ? repo.findById(systemIdentifier).get().getSystemOperatingSystem() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/system/{systemIdentifier}/systemHardware", produces = "application/json")
	public Hardware getSystenBySystemIdSystemIdentifierHardware(@PathVariable("systemIdentifier") long systemIdentifier) {
		return repo.existsById(systemIdentifier) ? repo.findById(systemIdentifier).get().getSystemHardware() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/system/{systemIdentifier}/systemMeasurements", produces = "application/json")
	public Set<Measurement> getSystenBySystemIdSystemIdentifierMeasurements(@PathVariable("systemIdentifier") long systemIdentifier) {
		return repo.existsById(systemIdentifier) ? repo.findById(systemIdentifier).get().getSystemMeasurements(): null;
	}


}
