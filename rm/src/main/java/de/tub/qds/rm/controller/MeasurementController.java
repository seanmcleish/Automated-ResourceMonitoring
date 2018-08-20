package de.tub.qds.rm.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.Process;
import de.tub.qds.rm.models.consts.repos.MeasurementRepo;

@RestController
public class MeasurementController {
	
	@Autowired
	MeasurementRepo repo;

	@RequestMapping(method = RequestMethod.GET, path = "/measurement", produces = "application/json")
	public List<Measurement> getMeasurements() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/measurement", produces = "application/json")
	public Measurement postMeasurement() {
		return repo.save(new Measurement());
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/measurement/{measurementId}", produces = "application/json")
	public Measurement getMeasurementById(@PathVariable("measurementId") long measurementId) {
		return repo.existsById(measurementId) ? repo.findById(measurementId).get() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/measurement/{measurementId}/measurementIp", produces = "text/plain")
	public String getMeasurementByIdMeasurementIp(@PathVariable("measurementId") long measurementId) {
		return repo.existsById(measurementId) ? repo.findById(measurementId).get().getMeasurementIp() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/measurement/{measurementId}/measurementStartDate", produces = "application/json")
	public Timestamp getMeasurementByIdStartDate(@PathVariable("measurementId") long measurementId) {
		return repo.existsById(measurementId) ? repo.findById(measurementId).get().getMeasurementStartDate() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/measurement/{measurementId}/measurementEndDate", produces = "application/json")
	public Timestamp getMeasurementByIdEndDate(@PathVariable("measurementId") long measurementId) {
		return repo.existsById(measurementId) ? repo.findById(measurementId).get().getMeasurementEndDate() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/measurement/{measurementId}/measurementRunning", produces = "application/json")
	public boolean getMeasurementByIdRunning(@PathVariable("measurementId") long measurementId) {
		return repo.existsById(measurementId) ? repo.findById(measurementId).get().isMeasurementRunning() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/measurement/{measurementId}/measurementRunning", produces = "application/json")
	public Measurement putMeasurementByIdRunning(@PathVariable("measurementId") long measurementId, @RequestParam("value") boolean value) {
		if(repo.existsById(measurementId)){
			Measurement measurement = repo.findById(measurementId).get();
			boolean isCurrentlyRunning = measurement.isMeasurementRunning();
			if(isCurrentlyRunning && !value){
				measurement.setMeasurementEndDate(new Timestamp(System.currentTimeMillis()));
			}
			else if(!isCurrentlyRunning && value){
				measurement.setMeasurementStartDate(new Timestamp(System.currentTimeMillis()));
				measurement.setMeasurementEndDate(null);
			}
			measurement.setMeasurementRunning(value);
			return repo.save(measurement);
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/measurement/{measurementId}/measurmentProcesses", produces = "application/json")
	public Set<Process> getMeasurementByIdProcesses(@PathVariable("measurementId") long measurementId) {
		return repo.existsById(measurementId) ? repo.findById(measurementId).get().getMeasurementProcesses() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/measurement/{measurementId}/measurementSystem", produces = "application/json")
	public de.tub.qds.rm.models.consts.System getMeasurementByIdSystem(@PathVariable("measurementId") long measurementId) {
		return repo.existsById(measurementId) ? repo.findById(measurementId).get().getMeasurementSystem() : null;
	}

}
