package de.tub.qds.rm.controller;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.Processor;
import de.tub.qds.rm.models.consts.repos.HardwareRepo;
import de.tub.qds.rm.models.consts.repos.MeasurementRepo;
import de.tub.qds.rm.models.consts.repos.ProcessorRepo;
import de.tub.qds.rm.models.consts.repos.ProcessorValueRepo;
import de.tub.qds.rm.models.values.ProcessorValue;
import de.tub.qds.rm.models.values.pks.ProcessorValuePK;
import de.tub.qds.rm.models.values.wrapper.ProcessorValueWrapper;

@RestController
public class ProcessorController {
	
	@Autowired
	ProcessorRepo repo;
	@Autowired
	ProcessorValueRepo valueRepo;
	@Autowired
	MeasurementRepo measurementRepo;
	@Autowired
	HardwareRepo hardwareRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/processor", produces = "application/json")
	public List<Processor> getProcessors() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/processor", produces = "application/json")
	public Processor postProcessors(
			@RequestParam("processorId") String processorId,
			@RequestParam(value="processorName", required=false) String processorName,
			@RequestParam(value="processorVendor", required=false) String processorVendor,
			@RequestParam(value="processorFamily", required=false) String processorFamily,
			@RequestParam(value="processorModel", required=false) String processorModel,
			@RequestParam(value="processorStepping", required=false) String processorStepping,
			@RequestParam(value="processorPhysicalPackageCount", required=false) Integer processorPhysicalPackageCount,
			@RequestParam(value="processorPhysicalProcessorCount", required=false) Integer processorPhysicalProcessorCount,
			@RequestParam(value="processorLogicalProcessorCount", required=false) Integer processorLogicalProcessorCount,
			@RequestParam(value="processorCpu64bit", required=false) Boolean processorCpu64bit,
			@RequestParam(value="", required=false)	Long processorVendorFreq
			) {
		Processor processor = repo.findById(processorId).orElse(null);
		if(processor != null){
			return processor;
		}
		return repo.save(new Processor(processorId, processorName, processorVendor, processorFamily, processorModel, processorStepping, processorPhysicalPackageCount, processorPhysicalProcessorCount, processorLogicalProcessorCount, processorCpu64bit, processorVendorFreq));
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}", produces = "application/json")
	public Processor getProcessorById(@PathVariable("processorId") String processorId) {
		return repo.existsById(processorId) ? repo.findById(processorId).get() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/processor/{processorId}", produces = "application/json")
	public Processor updateProcessors(
			@PathVariable("processorId") String processorId,
			@RequestParam(value="processorName", required=false) String processorName,
			@RequestParam(value="processorVendor", required=false) String processorVendor,
			@RequestParam(value="processorFamily", required=false) String processorFamily,
			@RequestParam(value="processorModel", required=false) String processorModel,
			@RequestParam(value="processorStepping", required=false) String processorStepping,
			@RequestParam(value="processorPhysicalPackageCount", required=false) Integer processorPhysicalPackageCount,
			@RequestParam(value="processorPhysicalProcessorCount", required=false) Integer processorPhysicalProcessorCount,
			@RequestParam(value="processorLogicalProcessorCount", required=false) Integer processorLogicalProcessorCount,
			@RequestParam(value="processorCpu64bit", required=false) Boolean processorCpu64bit,
			@RequestParam(value="", required=false)	Long processorVendorFreq
			) {
		Processor processor = repo.findById(processorId).orElse(null);
		if(processor == null){
			return null;
		}
		if(processorName != null){
			processor.setProcessorName(processorName);
		}
		if(processorVendor != null){
			processor.setProcessorVendor(processorVendor);
		}
		if(processorFamily != null){
			processor.setProcessorVendor(processorVendor);
		}
		if(processorModel != null){
			processor.setProcessorModel(processorModel);
		}
		if(processorStepping != null){
			processor.setProcessorStepping(processorStepping);
		}
		if(processorPhysicalPackageCount != null){
			processor.setProcessorPhysicalPackageCount(processorPhysicalPackageCount);
		}
		if(processorPhysicalProcessorCount != null){
			processor.setProcessorPhysicalProcessorCount(processorPhysicalProcessorCount);
		}
		if(processorLogicalProcessorCount != null){
			processor.setProcessorLogicalProcessorCount(processorLogicalProcessorCount);
		}
		if(processorCpu64bit != null){
			processor.setProcessorCpu64bit(processorCpu64bit);
		}
		return repo.save(processor);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/processor/{processorId}", produces = "application/json")
	public void deleteProcessorById(@PathVariable("processorId") String processorId) {
		if(repo.existsById(processorId)){
			repo.deleteById(processorId);
		}
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
	
	@RequestMapping(method = RequestMethod.PUT, path = "/processor/{processorId}/processorHardware", produces = "application/json")
	public Set<Hardware> setProcessorHardwareByIdAndHardwareId(@PathVariable("processorId") String processorId, @RequestParam("hardwareIdentifier") Long hardwareIdentifier) {
		Processor processor = repo.findById(processorId).orElse(null);
		Hardware hardware = hardwareRepo.findById(hardwareIdentifier).orElse(null);
		if(processor == null || hardware == null){
			return null;
		}
		processor.addProcessorHardware(hardware);
		return repo.save(processor).getProcessorHardware();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorValues", produces = "application/json")
	public Set<ProcessorValue> getProcessorByIdValues(@PathVariable("processorId") String processorId) {
		Processor processor = repo.findById(processorId).orElse(null);
		if(processor==null){
			return null;
		}
		return valueRepo.findByProcessorValueIdProcessorValueProcessorProcessorIdOrderByProcessorValueIdAsc(processorId);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/processor/{processorId}/processorValues", produces = "application/json")
	public ProcessorValue addProcessorByIdValue(
			@PathVariable("processorId") String processorId,
			@RequestParam("measurementId") Long measurementId,
			@RequestParam(value="timestamp", required=false) Long timestamp,
			@RequestParam(value="processorValueSystemCpuLoadBetweenTicks", required=false) Double processorValueSystemCpuLoadBetweenTicks,
			@RequestParam(value="processorValueSystemCpuLoadTicks", required=false) Long[] processorValueSystemCpuLoadTicks,
			@RequestParam(value="processorValueSystemCpuLoad", required=false) Double processorValueSystemCpuLoad,
			@RequestParam(value="processorValueSystemLoadAverages", required=false) Integer[] processorValueSystemLoadAverages,
			@RequestParam(value="processorValueProcessorCpuLoadBetweenTicks", required=false) Double[] processorValueProcessorCpuLoadBetweenTicks,
			@RequestParam(value="processorValueProcessorCpuLoadTicks", required=false) Long[][] processorValueProcessorCpuLoadTicks,
			@RequestParam(value="processorValueSystemUpTime", required=false) Long processorValueSystemUpTime,
			@RequestParam(value="processorValueContextSwitches", required=false) Long processorValueContextSwitches,
			@RequestParam(value="processorValueInterrupts", required=false) Long processorValueInterrupts) {
		
		Processor processor = repo.findById(processorId).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(processor == null || measurement == null){
			return null;
		}
		ProcessorValuePK pk = new ProcessorValuePK(measurementId, new Timestamp(timestamp!=null? timestamp: System.currentTimeMillis()), processor);
		
		
		return valueRepo.save(new ProcessorValue(pk, processorValueSystemCpuLoadBetweenTicks, processorValueSystemCpuLoadTicks, 
				processorValueSystemCpuLoad, processorValueSystemLoadAverages, processorValueProcessorCpuLoadBetweenTicks,processorValueProcessorCpuLoadTicks, 
				processorValueSystemUpTime, processorValueContextSwitches, processorValueInterrupts ));
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorValues/{measurementId}", produces = "application/json")
	public Set<ProcessorValue> getProcessorValuesByIdAndMeasurementId(@PathVariable("processorId") String processorId, @PathVariable("measurementId") Long measurementId) {
		Processor processor = repo.findById(processorId).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(processor==null || measurement == null){
			return null;
		}
		return valueRepo.findByProcessorValueIdProcessorValueProcessorProcessorIdAndProcessorValueIdProcessorValueMeasurementIdOrderByProcessorValueIdProcessorValueTimestampAsc(processorId, measurementId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorValues/{measurementId}/first", produces = "application/json")
	public ProcessorValue getFirstProcessorValueByIdAndMeasurementId(@PathVariable("processorId") String processorId, @PathVariable("measurementId") Long measurementId) {
		Processor processor = repo.findById(processorId).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(processor==null || measurement == null){
			return null;
		}
		return valueRepo.findTop1ByProcessorValueIdProcessorValueProcessorProcessorIdAndProcessorValueIdProcessorValueMeasurementIdOrderByProcessorValueIdProcessorValueTimestampAsc(processorId, measurementId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorValues/{measurementId}/last", produces = "application/json")
	public ProcessorValue getLastProcessorValueByIdAndMeasurementId(@PathVariable("processorId") String processorId, @PathVariable("measurementId") Long measurementId) {
		Processor processor = repo.findById(processorId).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(processor==null || measurement == null){
			return null;
		}
		return valueRepo.findTop1ByProcessorValueIdProcessorValueProcessorProcessorIdAndProcessorValueIdProcessorValueMeasurementIdOrderByProcessorValueIdProcessorValueTimestampDesc(processorId, measurementId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorValues/{measurementId}/max", produces = "application/json")
	public ProcessorValueWrapper<Double, Long> getMaxProcessorValuesByIdAndMeasurementId(@PathVariable("processorId") String processorId, @PathVariable("measurementId") Long measurementId) {
		Processor processor = repo.findById(processorId).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(processor==null || measurement == null){
			return null;
		}
		Set<ProcessorValue> values = valueRepo.findByProcessorValueIdProcessorValueProcessorProcessorIdAndProcessorValueIdProcessorValueMeasurementId(processorId, measurementId);
		Optional<ProcessorValue> processorValueSystemCpuLoadBetweenTicks = values.stream().max(Comparator.comparing(ProcessorValue::getProcessorValueSystemCpuLoadBetweenTicks, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessorValue> processorValueSystemCpuLoad = values.stream().max(Comparator.comparing(ProcessorValue::getProcessorValueSystemCpuLoad, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessorValue> processorValueSystemUpTime = values.stream().max(Comparator.comparing(ProcessorValue::getProcessorValueSystemUpTime, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessorValue> processorValueContextSwitches = values.stream().max(Comparator.comparing(ProcessorValue::getProcessorValueContextSwitches, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessorValue> processorValueInterrupts = values.stream().max(Comparator.comparing(ProcessorValue::getProcessorValueInterrupts, Comparator.nullsFirst(Comparator.naturalOrder())));
		return new ProcessorValueWrapper<Double, Long>(
				processorValueSystemCpuLoadBetweenTicks.isPresent()? processorValueSystemCpuLoadBetweenTicks.get().getProcessorValueSystemCpuLoadBetweenTicks() : null ,
				processorValueSystemCpuLoad.isPresent()? processorValueSystemCpuLoad.get().getProcessorValueSystemCpuLoad() : null ,
				processorValueSystemUpTime.isPresent()? processorValueSystemUpTime.get().getProcessorValueSystemUpTime() : null ,
				processorValueContextSwitches.isPresent()? processorValueContextSwitches.get().getProcessorValueContextSwitches(): null ,
				processorValueInterrupts.isPresent()? processorValueInterrupts.get().getProcessorValueInterrupts(): null 
			);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorValues/{measurementId}/min", produces = "application/json")
	public ProcessorValueWrapper<Double, Long> getMinProcessorValuesByIdAndMeasurementId(@PathVariable("processorId") String processorId, @PathVariable("measurementId") Long measurementId) {
		Processor processor = repo.findById(processorId).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(processor==null || measurement == null){
			return null;
		}
		Set<ProcessorValue> values = valueRepo.findByProcessorValueIdProcessorValueProcessorProcessorIdAndProcessorValueIdProcessorValueMeasurementId(processorId, measurementId);
		Optional<ProcessorValue> processorValueSystemCpuLoadBetweenTicks = values.stream().min(Comparator.comparing(ProcessorValue::getProcessorValueSystemCpuLoadBetweenTicks, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessorValue> processorValueSystemCpuLoad = values.stream().min(Comparator.comparing(ProcessorValue::getProcessorValueSystemCpuLoad, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessorValue> processorValueSystemUpTime = values.stream().min(Comparator.comparing(ProcessorValue::getProcessorValueSystemUpTime, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessorValue> processorValueContextSwitches = values.stream().min(Comparator.comparing(ProcessorValue::getProcessorValueContextSwitches, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessorValue> processorValueInterrupts = values.stream().min(Comparator.comparing(ProcessorValue::getProcessorValueInterrupts, Comparator.nullsFirst(Comparator.naturalOrder())));
		return new ProcessorValueWrapper<Double, Long>(
				processorValueSystemCpuLoadBetweenTicks.isPresent()? processorValueSystemCpuLoadBetweenTicks.get().getProcessorValueSystemCpuLoadBetweenTicks() : null ,
				processorValueSystemCpuLoad.isPresent()? processorValueSystemCpuLoad.get().getProcessorValueSystemCpuLoad() : null ,
				processorValueSystemUpTime.isPresent()? processorValueSystemUpTime.get().getProcessorValueSystemUpTime() : null ,
				processorValueContextSwitches.isPresent()? processorValueContextSwitches.get().getProcessorValueContextSwitches(): null ,
				processorValueInterrupts.isPresent()? processorValueInterrupts.get().getProcessorValueInterrupts(): null 
			);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorValues/{measurementId}/avg", produces = "application/json")
	public ProcessorValueWrapper<Double, Double> getAvgProcessorValuesByIdAndMeasurementId(@PathVariable("processorId") String processorId, @PathVariable("measurementId") Long measurementId) {
		Processor processor = repo.findById(processorId).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(processor==null || measurement == null){
			return null;
		}
		Set<ProcessorValue> values = valueRepo.findByProcessorValueIdProcessorValueProcessorProcessorIdAndProcessorValueIdProcessorValueMeasurementId(processorId, measurementId);
		Double processorValueSystemCpuLoadBetweenTicks = values.stream().map(ProcessorValue::getProcessorValueSystemCpuLoadBetweenTicks).filter(x -> x!=null).mapToDouble(x -> x).average().orElse(Double.NaN);
		Double processorValueSystemCpuLoad = values.stream().map(ProcessorValue::getProcessorValueSystemCpuLoad).filter(x -> x!=null).mapToDouble(x -> x).average().orElse(Double.NaN);
		Double processorValueSystemUpTime = values.stream().map(ProcessorValue::getProcessorValueSystemUpTime).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double processorValueContextSwitches = values.stream().map(ProcessorValue::getProcessorValueContextSwitches).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double processorValueInterrupts = values.stream().map(ProcessorValue::getProcessorValueInterrupts).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		return new ProcessorValueWrapper<Double, Double>(
				Double.isNaN(processorValueSystemCpuLoadBetweenTicks) ? null : processorValueSystemCpuLoadBetweenTicks ,
				Double.isNaN(processorValueSystemCpuLoad) ? null : processorValueSystemCpuLoad ,
				Double.isNaN(processorValueSystemUpTime) ? null : processorValueSystemUpTime ,
				Double.isNaN(processorValueContextSwitches) ? null: processorValueContextSwitches ,
				Double.isNaN(processorValueInterrupts) ? null: processorValueInterrupts
			);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/processor/{processorId}/processorValues/{measurementId}/count", produces = "application/json")
	public ProcessorValueWrapper<Long, Long> getCountProcessorValuesByIdAndMeasurementId(@PathVariable("processorId") String processorId, @PathVariable("measurementId") Long measurementId) {
		Processor processor = repo.findById(processorId).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(processor==null || measurement == null){
			return null;
		}
		Set<ProcessorValue> values = valueRepo.findByProcessorValueIdProcessorValueProcessorProcessorIdAndProcessorValueIdProcessorValueMeasurementId(processorId, measurementId);
		Long processorValueSystemCpuLoadBetweenTicks = values.stream().map(ProcessorValue::getProcessorValueSystemCpuLoadBetweenTicks).filter(x -> x!=null).count();
		Long processorValueSystemCpuLoad = values.stream().map(ProcessorValue::getProcessorValueSystemCpuLoad).filter(x -> x!=null).count();
		Long processorValueSystemUpTime = values.stream().map(ProcessorValue::getProcessorValueSystemUpTime).filter(x -> x!=null).count();
		Long processorValueContextSwitches = values.stream().map(ProcessorValue::getProcessorValueContextSwitches).filter(x -> x!=null).count();
		Long processorValueInterrupts = values.stream().map(ProcessorValue::getProcessorValueInterrupts).filter(x -> x!=null).count();
		return new ProcessorValueWrapper<Long, Long>(
				processorValueSystemCpuLoadBetweenTicks ,
				processorValueSystemCpuLoad ,
				processorValueSystemUpTime ,
				processorValueContextSwitches ,
				processorValueInterrupts
			);
	}
}
