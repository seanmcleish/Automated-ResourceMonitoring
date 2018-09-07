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
import de.tub.qds.rm.models.consts.System;
import de.tub.qds.rm.models.consts.repos.MeasurementRepo;
import de.tub.qds.rm.models.consts.repos.ProcessRepo;
import de.tub.qds.rm.models.consts.repos.SystemRepo;

//FINISHED IMPLEMENTATION & TESTED
@RestController
public class MeasurementController {
	
	@Autowired
	MeasurementRepo repo;
	@Autowired
	SystemRepo systemRepo;
	@Autowired
	ProcessRepo processRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/measurement", produces = "application/json")
	public List<Measurement> getMeasurements() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/measurement", produces = "application/json")
	public Measurement postMeasurement(@RequestParam(value = "measurementIp", required=false) String measurementIp) {
		if(measurementIp == null){
			return repo.save(new Measurement());
		}
		return repo.save(new Measurement(measurementIp));
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/measurement/{measurementId}", produces = "application/json")
	public Measurement getMeasurementById(@PathVariable("measurementId") long measurementId) {
		return repo.existsById(measurementId) ? repo.findById(measurementId).get() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/measurement/{measurementId}", produces = "application/json")
	public Measurement updateMeasurementById(
			@PathVariable("measurementId") Long measurementId,
			@RequestParam(value="measurementIp", required=false) String measurementIp,
			@RequestParam(value="measurementRunning", required=false) Boolean measurementRunning,
			@RequestParam(value="measurementSystem", required=false) Long systemId
			) {
		Measurement measurement = repo.findById(measurementId).orElse(null);
		System system = systemRepo.findById(systemId).orElse(null);
		if(measurement == null){
			return null;
		}
		if(system != null){
			measurement.setMeasurementSystem(system);
		}
		if(measurementIp != null){
			measurement.setMeasurementIp(measurementIp);
		}
		if(measurementRunning != null){
			boolean isCurrentlyRunning = measurement.isMeasurementRunning();
			if(isCurrentlyRunning && !measurementRunning){
				measurement.setMeasurementEndDate(new Timestamp(java.lang.System.currentTimeMillis()));
			}
			else if(!isCurrentlyRunning && measurementRunning){
				measurement.setMeasurementStartDate(new Timestamp(java.lang.System.currentTimeMillis()));
				measurement.setMeasurementEndDate(null);
			}
		}
		return repo.save(measurement);
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
	
	@RequestMapping(method = RequestMethod.GET, path = "/measurement/{measurementId}/measurementSystem", produces = "application/json")
	public System getMeasurementByIdSystem(@PathVariable("measurementId") long measurementId) {
		return repo.existsById(measurementId) ? repo.findById(measurementId).get().getMeasurementSystem() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/measurement/{measurementId}/measurmentProcesses", produces = "application/json")
	public Set<Process> getMeasurementByIdProcesses(@PathVariable("measurementId") long measurementId) {
		return repo.existsById(measurementId) ? repo.findById(measurementId).get().getMeasurementProcesses() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/measurement/{measurementId}/measurmentProcesses", produces = "application/json")
	public Set<Process> addMeasurementByIdProcess(@PathVariable("measurementId") long measurementId, @RequestParam("processId") Long processId) {
		Measurement measurement = repo.findById(measurementId).orElse(null);
		Process process = processRepo.findById(processId).orElse(null);
		if(measurement == null || process == null){
			return null;
		}
		measurement.addMeasurementProcess(process);
		return repo.save(measurement).getMeasurementProcesses();
	}

}
