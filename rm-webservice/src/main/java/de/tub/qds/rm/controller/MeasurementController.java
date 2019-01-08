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
import org.springframework.core.env.Environment;

import com.mashape.unirest.http.exceptions.UnirestException;

import de.tub.qds.rm.Methods;
import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.Process;
import de.tub.qds.rm.models.consts.Rate;
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
	@Autowired 
	Environment environment;

	@RequestMapping(method = RequestMethod.GET, path = "/measurement", produces = "application/json")
	public List<Measurement> getMeasurements() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/measurement", produces = "application/json")
	public Measurement postMeasurement(
			@RequestParam(value = "measurementRate", required=false) Rate measurementRate,
			@RequestParam(value = "measurementRemotePort", required=false) String measurementRemotePort,
			@RequestParam(value="measurementSystem", required=false) Long systemId
			) {
		System measurementSystem = null;
		if(systemId!= null){
			measurementSystem = systemRepo.findById(systemId).orElse(null);
		}
		return repo.save(new Measurement(null, measurementRemotePort, measurementRate, measurementSystem));
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/measurement/{measurementId}", produces = "application/json")
	public Measurement getMeasurementById(@PathVariable("measurementId") long measurementId) {
		return repo.existsById(measurementId) ? repo.findById(measurementId).get() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/measurement/{measurementId}", produces = "application/json")
	public Measurement updateMeasurementById(
			@PathVariable("measurementId") Long measurementId,
			@RequestParam(value="measurementIp", required=false) String measurementIp,
			@RequestParam(value = "measurementRate", required=false) Rate measurementRate,
			@RequestParam(value = "measurementRemotePort", required=false) String measurementRemotePort,
			@RequestParam(value="measurementRunning", required=false) Boolean measurementRunning,
			@RequestParam(value="measurementSystem", required=false) Long systemId
			) throws UnirestException {
		System system = null;
		Measurement measurement = repo.findById(measurementId).orElse(null);
		if(systemId!= null){
			system = systemRepo.findById(systemId).orElse(null);
		}
		if(measurement == null){
			return null;
		}
		if(system != null){
			measurement.setMeasurementSystem(system);
		}
		if(measurementIp != null){
			measurement.setMeasurementIp(measurementIp);
		}
		if(measurementRate != null){
			measurement.setMeasurementRate(measurementRate);
		}
		if(measurementRemotePort != null){
			measurement.setMeasurementRemotePort(measurementRemotePort);
		}
		if(measurementRunning != null){
			
			boolean isCurrentlyRunning = measurement.isMeasurementRunning();
			if(isCurrentlyRunning && !measurementRunning){
				measurement.setMeasurementEndDate(new Timestamp(java.lang.System.currentTimeMillis()));
				measurement.setMeasurementRunning(false);
			}
			else if(!isCurrentlyRunning && measurementRunning){
				if(measurement.getMeasurementIp() == null){
					measurement.setMeasurementIp(Methods.ipResolve(measurement.getMeasurementSystem().getSystemHostName()));
				}
				measurement.setMeasurementStartDate(new Timestamp(java.lang.System.currentTimeMillis()));
				measurement.setMeasurementRunning(true);
				measurement.setMeasurementEndDate(null);
			}
		}
		return repo.save(measurement);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/measurement/{measurementId}", produces = "application/json")
	public void deleteMeasurementById(@PathVariable("measurementId") long measurementId) {
		if(repo.existsById(measurementId)){
			repo.deleteById(measurementId);
		}
	}
		
	@RequestMapping(method = RequestMethod.GET, path = "/measurement/{measurementId}/measurementIp", produces = "text/plain")
	public String getMeasurementByIdMeasurementIp(@PathVariable("measurementId") long measurementId) {
		return repo.existsById(measurementId) ? repo.findById(measurementId).get().getMeasurementIp() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/measurement/{measurementId}/measurementRate", produces = "text/plain")
	public Rate getMeasurementByIdMeasurementRate(@PathVariable("measurementId") long measurementId) {
		return repo.existsById(measurementId) ? repo.findById(measurementId).get().getMeasurementRate() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/measurement/{measurementId}/measurementRemotePort", produces = "text/plain")
	public String getMeasurementByIdMeasurementRemotePort(@PathVariable("measurementId") long measurementId) {
		return repo.existsById(measurementId) ? repo.findById(measurementId).get().getMeasurementRemotePort() : null;
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
		Measurement measurement = repo.findById(measurementId).orElse(null);
		if(measurement == null){
			return null;
		}
		Long systemRepoId = measurement.getMeasurementSystem().getSystemIdentifier();
		if(systemRepoId == null){
			return null;
		}
		return systemRepo.findById(systemRepoId).orElse(null);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/measurement/{measurementId}/measurementProcesses", produces = "application/json")
	public Set<Process> getMeasurementByIdProcesses(@PathVariable("measurementId") long measurementId) {
		Measurement measurement = repo.findById(measurementId).orElse(null);
		if(measurement == null){
			return null;
		}
		return processRepo.findByProcessMeasurement(measurement);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/measurement/{measurementId}/measurementProcesses", produces = "application/json")
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
