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
import de.tub.qds.rm.models.consts.SystemModel;
import de.tub.qds.rm.models.consts.repos.HardwareRepo;
import de.tub.qds.rm.models.consts.repos.SystemModelRepo;

@RestController
public class SystemModelController {
	
	@Autowired
	SystemModelRepo repo;
	@Autowired
	HardwareRepo hardwareRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/systemModel", produces = "application/json")
	public List<SystemModel> getSystemModels() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/systemModel", produces = "application/json")
	public SystemModel postSystemModels(
			@RequestParam("systemModelSerialNumber") String systemModelSerialNumber,
			@RequestParam(value="systemModelManufacturer", required=false) String systemModelManufacturer,
			@RequestParam(value="systemModelModel", required=false) String systemModelModel
			) {
		SystemModel systemModel = repo.findById(systemModelSerialNumber).orElse(null);
		if(systemModel != null){
			return systemModel;
		}
		return repo.save(new SystemModel(systemModelSerialNumber, systemModelManufacturer, systemModelModel));
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/systemModel/{systemModelSerialNumber}", produces = "application/json")
	public SystemModel getSystemModelById(@PathVariable("systemModelSerialNumber") String systemModelSerialNumber) {
		return repo.existsById(systemModelSerialNumber) ? repo.findById(systemModelSerialNumber).get() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/systemModel/{systemModelSerialNumber}", produces = "application/json")
	public SystemModel updateSystemModels(
			@PathVariable("systemModelSerialNumber") String systemModelSerialNumber,
			@RequestParam(value="systemModelManufacturer", required=false) String systemModelManufacturer,
			@RequestParam(value="systemModelModel", required=false) String systemModelModel
			) {
		SystemModel systemModel = repo.findById(systemModelSerialNumber).orElse(null);
		if(systemModel == null){
			return null;
		}
		if(systemModelManufacturer != null){
			systemModel.setSystemModelManufacturer(systemModelManufacturer);
		}
		if(systemModelModel != null){
			systemModel.setSystemModelModel(systemModelModel);
		}
		return repo.save(systemModel);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/systemModel/{systemModelSerialNumber}", produces = "application/json")
	public void deleteSystemModelById(@PathVariable("systemModelSerialNumber") String systemModelSerialNumber) {
		if(repo.existsById(systemModelSerialNumber)){
			repo.deleteById(systemModelSerialNumber);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/systemModel/{systemModelSerialNumber}/systemModelManufacturer", produces = "text/plain")
	public String getSystemModelByIdManufacturer(@PathVariable("systemModelSerialNumber") String systemModelSerialNumber) {
		return repo.existsById(systemModelSerialNumber) ? repo.findById(systemModelSerialNumber).get().getSystemModelManufacturer() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/systemModel/{systemModelSerialNumber}/systemModelModel", produces = "text/plain")
	public String getSystemModelByIdModel(@PathVariable("systemModelSerialNumber") String systemModelSerialNumber) {
		return repo.existsById(systemModelSerialNumber) ? repo.findById(systemModelSerialNumber).get().getSystemModelModel() : null;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/systemModel/{systemModelSerialNumber}/systemModelHardware", produces = "application/json")
	public Set<Hardware> getSystemModelByIdHardware(@PathVariable("systemModelSerialNumber") String systemModelSerialNumber) {
		return repo.existsById(systemModelSerialNumber) ? repo.findById(systemModelSerialNumber).get().getSystemModelHardware() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/systemModel/{systemModelSerialNumber}/systemModelHardware", produces = "application/json")
	public Set<Hardware> getSystemModelByIdHardware(@PathVariable("systemModelSerialNumber") String systemModelSerialNumber, @RequestParam("hardwareId") Long hardwareId) {
		SystemModel systemModel = repo.findById(systemModelSerialNumber).orElse(null);
		Hardware hardware = hardwareRepo.findById(hardwareId).orElse(null);
		if(systemModel == null || hardware == null){
			return null;
		}
		systemModel.addSystemModelHardware(hardware);
		return repo.save(systemModel).getSystemModelHardware();
	}
}
