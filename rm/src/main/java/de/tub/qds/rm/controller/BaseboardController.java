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
import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.repos.BaseboardRepo;

@RestController
public class BaseboardController {

	@Autowired
	BaseboardRepo repo;

	@RequestMapping(method = RequestMethod.GET, path = "/baseboard", produces = "application/json")
	public List<Baseboard> getBaseboards() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/baseboard", produces = "application/json")
	public Baseboard postBaseboard(
			@RequestParam("baseboardSerialNumber") String baseboardSerialNumber, 
			@RequestParam("baseboardManufacturer") String baseboardManufacturer ,
			@RequestParam("baseboardModel") String baseboardModel,
			@RequestParam("baseboardVersion") String baseboardVersion
			) {
		return repo.save(new Baseboard(baseboardSerialNumber, baseboardManufacturer, baseboardModel, baseboardVersion));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/baseboard/{baseboardSerialNumber}", produces = "application/json")
	public Baseboard getBaseboardById(@PathVariable("baseboardSerialNumber") String baseboardSerialNumber) {
		return repo.existsById(baseboardSerialNumber) ? repo.findById(baseboardSerialNumber).get() : null;
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

}
