package de.tub.qds.rm.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.Processor;
import de.tub.qds.rm.models.consts.repos.ProcessorRepo;
import de.tub.qds.rm.models.values.ProcessorValue;

@RestController
public class ProcessorController {
	
	@Autowired
	ProcessorRepo repo;

	@RequestMapping(method = RequestMethod.GET, path = "/processor", produces = "application/json")
	public List<Processor> getProcessors() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}", produces = "application/json")
	public Processor getProcessorById(@PathVariable("processorId") String processorId) {
		return repo.existsById(processorId) ? repo.findById(processorId).get() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorName", produces = "text/plain")
	public String getProcessorByIdName(@PathVariable("processorId") String processorId) {
		return repo.existsById(processorId) ? repo.findById(processorId).get().getProcessorName() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorVendor", produces = "text/plain")
	public String getProcessorByIdVendor(@PathVariable("processorId") String processorId) {
		return repo.existsById(processorId) ? repo.findById(processorId).get().getProcessorVendor() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorFamily", produces = "text/plain")
	public String getProcessorByIdFamily(@PathVariable("processorId") String processorId) {
		return repo.existsById(processorId) ? repo.findById(processorId).get().getProcessorFamily() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorModel", produces = "text/plain")
	public String getProcessorByIdModel(@PathVariable("processorId") String processorId) {
		return repo.existsById(processorId) ? repo.findById(processorId).get().getProcessorModel() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorStepping", produces = "text/plain")
	public String getProcessorByIdStepping(@PathVariable("processorId") String processorId) {
		return repo.existsById(processorId) ? repo.findById(processorId).get().getProcessorStepping() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorPhysicalPackageCount", produces = "application/json")
	public int getProcessorByIdPhysicalPackageCount(@PathVariable("processorId") String processorId) {
		return repo.existsById(processorId) ? repo.findById(processorId).get().getProcessorPhysicalPackageCount() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorPhysicalProcessorCount", produces = "application/json")
	public int getProcessorByIdPhysicalProcessorCount(@PathVariable("processorId") String processorId) {
		return repo.existsById(processorId) ? repo.findById(processorId).get().getProcessorPhysicalProcessorCount() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorLogicalProcessorCount", produces = "application/json")
	public int getProcessorByIdLogicalProcessorCount(@PathVariable("processorId") String processorId) {
		return repo.existsById(processorId) ? repo.findById(processorId).get().getProcessorLogicalProcessorCount() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorCpu64bit", produces = "application/json")
	public boolean getProcessorByIdCpu64bit(@PathVariable("processorId") String processorId) {
		return repo.existsById(processorId) ? repo.findById(processorId).get().isProcessorCpu64bit() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorVendorFreq", produces = "application/json")
	public long getProcessorByIdVendorFreq(@PathVariable("processorId") String processorId) {
		return repo.existsById(processorId) ? repo.findById(processorId).get().getProcessorVendorFreq() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorHardware", produces = "application/json")
	public Set<Hardware> getProcessorByIdHardware(@PathVariable("processorId") String processorId) {
		return repo.existsById(processorId) ? repo.findById(processorId).get().getProcessorHardware() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorValues", produces = "application/json")
	public Set<ProcessorValue> getProcessorByIdValues(@PathVariable("processorId") String processorId) {
		return repo.existsById(processorId) ? repo.findById(processorId).get().getProcessorValues() : null;
	}

}
