package de.tub.qds.rm.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.OperatingSystem;
import de.tub.qds.rm.models.consts.System;
import de.tub.qds.rm.models.consts.repos.OperatingSystemRepo;

@RestController
public class OperatingSystemController {
	
	@Autowired
	OperatingSystemRepo repo;

	@RequestMapping(method = RequestMethod.GET, path = "/operatingSystem", produces = "application/json")
	public List<OperatingSystem> getOperatingSystem() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/operatingSystem/{operatingSystemIdentifier}", produces = "application/json")
	public OperatingSystem getOperatingSystemByIdOperatingSystemIdentifier(@PathVariable("operatingSystemIdentifier") int operatingSystemIdentifier) {
		return repo.existsByOperatingSystemIdOperatingSystemIdentifier(operatingSystemIdentifier) ? repo.findByOperatingSystemIdOperatingSystemIdentifier(operatingSystemIdentifier) : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/operatingSystem/{operatingSystemIdentifier}/operatingSystemManufacturer", produces = "text/plain")
	public String getOperatingSystemByIdOperatingSystemIdentifierManufacturer(@PathVariable("operatingSystemIdentifier") int operatingSystemIdentifier) {
		return repo.existsByOperatingSystemIdOperatingSystemIdentifier(operatingSystemIdentifier) 
				? repo.findByOperatingSystemIdOperatingSystemIdentifier(operatingSystemIdentifier)
						.getOperatingSystemId().getOperatingSystemManufacturer()
				: null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/operatingSystem/{operatingSystemIdentifier}/operatingSystemFamily", produces = "text/plain")
	public String getOperatingSystemByIdOperatingSystemIdentifierFamily(@PathVariable("operatingSystemIdentifier") int operatingSystemIdentifier) {
		return repo.existsByOperatingSystemIdOperatingSystemIdentifier(operatingSystemIdentifier) 
				? repo.findByOperatingSystemIdOperatingSystemIdentifier(operatingSystemIdentifier)
						.getOperatingSystemId().getOperatingSystemFamily()
				: null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/operatingSystem/{operatingSystemIdentifier}/operatingSystemVersion", produces = "text/plain")
	public String getOperatingSystemByIdOperatingSystemIdentifierVersion(@PathVariable("operatingSystemIdentifier") int operatingSystemIdentifier) {
		return repo.existsByOperatingSystemIdOperatingSystemIdentifier(operatingSystemIdentifier) 
				? repo.findByOperatingSystemIdOperatingSystemIdentifier(operatingSystemIdentifier)
						.getOperatingSystemId().getOperatingSystemVersion()
				: null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/operatingSystem/{operatingSystemIdentifier}/operatingSystemCodeName", produces = "text/plain")
	public String getOperatingSystemByIdOperatingSystemIdentifierCodeName(@PathVariable("operatingSystemIdentifier") int operatingSystemIdentifier) {
		return repo.existsByOperatingSystemIdOperatingSystemIdentifier(operatingSystemIdentifier) 
				? repo.findByOperatingSystemIdOperatingSystemIdentifier(operatingSystemIdentifier)
						.getOperatingSystemId().getOperatingSystemCodeName()
				: null;
	}
		
	@RequestMapping(method = RequestMethod.GET, path = "/operatingSystem/{operatingSystemIdentifier}/operatingSystemBuild", produces = "text/plain")
	public String getOperatingSystemByIdOperatingSystemIdentifierBuild(@PathVariable("operatingSystemIdentifier") int operatingSystemIdentifier) {
		return repo.existsByOperatingSystemIdOperatingSystemIdentifier(operatingSystemIdentifier) 
				? repo.findByOperatingSystemIdOperatingSystemIdentifier(operatingSystemIdentifier)
						.getOperatingSystemId().getOperatingSystemBuild()
				: null;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/operatingSystem/{operatingSystemIdentifier}/operatingSystemSystems", produces = "application/json")
	public Set<System> getOperatingSystemByIdOperatingSystemIdentifierSystems(@PathVariable("operatingSystemIdentifier") int operatingSystemIdentifier) {
		return repo.existsByOperatingSystemIdOperatingSystemIdentifier(operatingSystemIdentifier) ? repo.findByOperatingSystemIdOperatingSystemIdentifier(operatingSystemIdentifier).getOperatingSytemSystems() : null;
	}

}
