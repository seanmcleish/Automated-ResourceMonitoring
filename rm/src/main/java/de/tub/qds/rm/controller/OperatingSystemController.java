package de.tub.qds.rm.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.OperatingSystem;
import de.tub.qds.rm.models.consts.System;
import de.tub.qds.rm.models.consts.repos.OperatingSystemRepo;
import de.tub.qds.rm.models.consts.repos.SystemRepo;

//FINISHED IMPLEMENTATION & TESTED
@RestController
public class OperatingSystemController {
	
	@Autowired
	OperatingSystemRepo repo;
	@Autowired
	SystemRepo systemRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/operatingSystem", produces = "application/json")
	public List<OperatingSystem> getOperatingSystem() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/operatingSystem", produces = "application/json")
	public OperatingSystem postOperatingSystem(
			@RequestParam(value="operatingSystemManufacturer", required=false) String operatingSystemManufacturer,
			@RequestParam(value="operatingSystemFamily", required=false) String operatingSystemFamily,
			@RequestParam(value="operatingSystemVersion", required=false) String operatingSystemVersion,
			@RequestParam(value="operatingSystemCodeName", required=false) String operatingSystemCodeName,
			@RequestParam(value="operatingSystemBuild", required=false) String operatingSystemBuild
			) 
	{
		OperatingSystem os = repo.findByOperatingSystemManufacturerAndOperatingSystemFamilyAndOperatingSystemVersionAndOperatingSystemCodeNameAndOperatingSystemBuild(operatingSystemManufacturer, operatingSystemFamily, operatingSystemVersion, operatingSystemCodeName, operatingSystemBuild).orElse(null);
		if(os != null){
			return os;
		}
		return repo.save(new OperatingSystem(operatingSystemManufacturer, operatingSystemFamily, operatingSystemVersion, operatingSystemCodeName, operatingSystemBuild));
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/operatingSystem/{operatingSystemIdentifier}", produces = "application/json")
	public OperatingSystem getOperatingSystemByIdOperatingSystemIdentifier(@PathVariable("operatingSystemIdentifier") Long operatingSystemIdentifier) {
		return repo.findById(operatingSystemIdentifier).orElse(null);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/operatingSystem/{operatingSystemIdentifier}", produces = "application/json")
	public OperatingSystem updateOperatingSystemByIdOperatingSystemIdentifier(
			@PathVariable("operatingSystemIdentifier") Long operatingSystemIdentifier,
			@RequestParam(value="operatingSystemManufacturer", required=false) String operatingSystemManufacturer,
			@RequestParam(value="operatingSystemFamily", required=false) String operatingSystemFamily,
			@RequestParam(value="operatingSystemVersion", required=false) String operatingSystemVersion,
			@RequestParam(value="operatingSystemCodeName", required=false) String operatingSystemCodeName,
			@RequestParam(value="operatingSystemBuild", required=false) String operatingSystemBuild
			) 
	{
		OperatingSystem os = repo.findById(operatingSystemIdentifier).orElse(null);
		if(os == null){
			return null;
		}
		if(operatingSystemManufacturer != null){
			os.setOperatingSystemManufacturer(operatingSystemManufacturer);
		}
		if(operatingSystemFamily != null){
			os.setOperatingSystemFamily(operatingSystemFamily);
		}
		if(operatingSystemVersion != null){
			os.setOperatingSystemVersion(operatingSystemVersion);
		}
		if(operatingSystemCodeName != null){
			os.setOperatingSystemCodeName(operatingSystemCodeName);
		}
		if(operatingSystemBuild != null){
			os.setOperatingSystemBuild(operatingSystemBuild);
		}
		return repo.save(os);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/operatingSystem/{operatingSystemIdentifier}/operatingSystemManufacturer", produces = "text/plain")
	public String getOperatingSystemByIdOperatingSystemIdentifierManufacturer(@PathVariable("operatingSystemIdentifier") Long operatingSystemIdentifier) {
		OperatingSystem os = repo.findById(operatingSystemIdentifier).orElse(null);
		if(os == null) {
			return null;
		}
		return os.getOperatingSystemManufacturer();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/operatingSystem/{operatingSystemIdentifier}/operatingSystemFamily", produces = "text/plain")
	public String getOperatingSystemByIdOperatingSystemIdentifierFamily(@PathVariable("operatingSystemIdentifier") Long operatingSystemIdentifier) {
		OperatingSystem os = repo.findById(operatingSystemIdentifier).orElse(null);
		if(os == null) {
			return null;
		}
		return os.getOperatingSystemFamily();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/operatingSystem/{operatingSystemIdentifier}/operatingSystemVersion", produces = "text/plain")
	public String getOperatingSystemByIdOperatingSystemIdentifierVersion(@PathVariable("operatingSystemIdentifier") Long operatingSystemIdentifier) {
		OperatingSystem os = repo.findById(operatingSystemIdentifier).orElse(null);
		if(os == null) {
			return null;
		}
		return os.getOperatingSystemVersion();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/operatingSystem/{operatingSystemIdentifier}/operatingSystemCodeName", produces = "text/plain")
	public String getOperatingSystemByIdOperatingSystemIdentifierCodeName(@PathVariable("operatingSystemIdentifier") Long operatingSystemIdentifier) {
		OperatingSystem os = repo.findById(operatingSystemIdentifier).orElse(null);
		if(os == null) {
			return null;
		}
		return os.getOperatingSystemCodeName();
	}
		
	@RequestMapping(method = RequestMethod.GET, path = "/operatingSystem/{operatingSystemIdentifier}/operatingSystemBuild", produces = "text/plain")
	public String getOperatingSystemByIdOperatingSystemIdentifierBuild(@PathVariable("operatingSystemIdentifier") Long operatingSystemIdentifier) {
		OperatingSystem os = repo.findById(operatingSystemIdentifier).orElse(null);
		if(os == null) {
			return null;
		}
		return os.getOperatingSystemBuild();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/operatingSystem/{operatingSystemIdentifier}/operatingSystemSystems", produces = "text/plain")
	public Set<System> getOperatingSystemByIdOperatingSystemIdentifierSystems(@PathVariable("operatingSystemIdentifier") Long operatingSystemIdentifier) {
		OperatingSystem os = repo.findById(operatingSystemIdentifier).orElse(null);
		if(os == null) {
			return null;
		}
		return os.getOperatingSytemSystems();
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/operatingSystem/{operatingSystemIdentifier}/operatingSystemSystems", produces = "text/plain")
	public Set<System> addOperatingSystemByIdOperatingSystemIdentifierSystem(
			@PathVariable("operatingSystemIdentifier") Long operatingSystemIdentifier,
			@RequestParam("systemIdentifier") Long systemIdentifier) {
		OperatingSystem os = repo.findById(operatingSystemIdentifier).orElse(null);
		System system = systemRepo.findById(systemIdentifier).orElse(null);
		if(os == null || system == null) {
			return null;
		}
		os.addOperatingSytemSystem(system);
		return repo.save(os).getOperatingSytemSystems();
	}
}
