package de.tub.qds.rm.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Baseboard;
import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.repos.BaseboardRepo;
import de.tub.qds.rm.models.consts.repos.HardwareRepo;

//FINISHED IMPLEMENTATION & TESTED
@RestController
public class BaseboardController {

	@Autowired
	BaseboardRepo repo;
	
	@Autowired
	HardwareRepo hardwareRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/baseboard", produces = "application/json")
	public List<Baseboard> getBaseboards() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/baseboard", produces = "application/json")
	public Baseboard postBaseboard(
			@RequestParam("baseboardSerialNumber") String baseboardSerialNumber, 
			@RequestParam(value = "baseboardManufacturer", required=false) String baseboardManufacturer ,
			@RequestParam(value = "baseboardModel", required=false) String baseboardModel,
			@RequestParam(value = "baseboardVersion", required=false) String baseboardVersion,
			HttpServletRequest request, 
			HttpServletResponse response) {
		if(repo.existsById(baseboardSerialNumber)){
			return repo.findById(baseboardSerialNumber).get();
		}
		Baseboard baseboard = new Baseboard(baseboardSerialNumber, baseboardManufacturer, baseboardModel, baseboardVersion);
		return repo.save(baseboard);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/baseboard/{baseboardSerialNumber}", produces = "application/json")
	public Baseboard getBaseboardById(@PathVariable("baseboardSerialNumber") String baseboardSerialNumber) {
		return repo.findById(baseboardSerialNumber).orElse(null);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/baseboard/{baseboardSerialNumber}", produces = "application/json")
	public Baseboard updateBaseboardById(
			@PathVariable("baseboardSerialNumber") String baseboardSerialNumber,
			@RequestParam(value="baseboardManufacturer", required=false) String baseboardManufacturer ,
			@RequestParam(value="baseboardModel", required=false) String baseboardModel,
			@RequestParam(value="baseboardVersion", required=false) String baseboardVersion
			) {
		Baseboard baseboard = repo.findById(baseboardSerialNumber).orElse(null);
		if(baseboard != null){
			if(baseboardManufacturer != null) {
				baseboard.setBaseboardManufacturer(baseboardManufacturer);
			}
			if(baseboardModel != null) {
				baseboard.setBaseboardModel(baseboardModel);
			}
			if(baseboardVersion != null) {
				baseboard.setBaseboardVersion(baseboardVersion);
			}
			return repo.save(baseboard);
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/baseboard/{baseboardSerialNumber}", produces = "application/json")
	public void deleteBaseboardById(@PathVariable("baseboardSerialNumber") String baseboardSerialNumber) {
		if(repo.existsById(baseboardSerialNumber)){
			repo.deleteById(baseboardSerialNumber);
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/baseboard/{baseboardSerialNumber}/baseboardManufacturer", produces = "text/plain")
	public String getBaseboardByIdManufacturer(@PathVariable("baseboardSerialNumber") String baseboardSerialNumber) {
		return repo.existsById(baseboardSerialNumber)
				? repo.findById(baseboardSerialNumber).get().getBaseboardManufacturer() : null;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/baseboard/{baseboardSerialNumber}/baseboardModel", produces = "text/plain")
	public String getBaseboardByIdModel(@PathVariable("baseboardSerialNumber") String baseboardSerialNumber) {
		return repo.existsById(baseboardSerialNumber) ? repo.findById(baseboardSerialNumber).get().getBaseboardModel()
				: null;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/baseboard/{baseboardSerialNumber}/baseboardVersion", produces = "text/plain")
	public String getBaseboardByIdVersion(@PathVariable("baseboardSerialNumber") String baseboardSerialNumber) {
		return repo.existsById(baseboardSerialNumber) ? repo.findById(baseboardSerialNumber).get().getBaseboardVersion()
				: null;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/baseboard/{baseboardSerialNumber}/baseboardHardware", produces = "application/json")
	public Set<Hardware> getBaseboardByIdHardware(@PathVariable("baseboardSerialNumber") String baseboardSerialNumber) {
		return repo.existsById(baseboardSerialNumber)
				? repo.findById(baseboardSerialNumber).get().getBaseboardHardware() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/baseboard/{baseboardSerialNumber}/baseboardHardware", produces = "application/json")
	public Set<Hardware> addBaseboardByIdHardware(@PathVariable("baseboardSerialNumber") String baseboardSerialNumber, @RequestParam("hardwareIdentifier") Long hardwareIdentifier) {
		Baseboard baseboard = repo.findById(baseboardSerialNumber).orElse(null);
		Hardware hardware = hardwareRepo.findById(hardwareIdentifier).orElse(null);
		if(baseboard == null || hardware == null){
			return null;
		}
		baseboard.addBaseboardHardware(hardware);
		return repo.save(baseboard).getBaseboardHardware();
	}

}
