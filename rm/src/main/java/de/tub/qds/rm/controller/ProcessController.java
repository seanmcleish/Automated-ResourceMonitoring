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

import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.Process;
import de.tub.qds.rm.models.consts.repos.MeasurementRepo;
import de.tub.qds.rm.models.consts.repos.ProcessRepo;
import de.tub.qds.rm.models.consts.repos.ProcessValueRepo;
import de.tub.qds.rm.models.values.ProcessValue;
import de.tub.qds.rm.models.values.pks.ProcessValuePK;
import de.tub.qds.rm.models.values.wrapper.ProcessValueWrapper;

//FINISHED IMPLEMENTATION & TESTED
@RestController
public class ProcessController {
	

	@Autowired
	ProcessRepo repo;
	@Autowired
	ProcessValueRepo valueRepo;
	@Autowired
	MeasurementRepo measurementRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/process", produces = "application/json")
	public List<Process> getProcesses() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/process", produces = "application/json")
	public Process postProcess(
			@RequestParam(value="processIsParentProcess", required=false) boolean processIsParentProcess,
			@RequestParam(value="processName", required=false) String processName,
			@RequestParam(value="processPid", required=false) Long processPid,
			@RequestParam(value="measurementId", required=false) Long measurementId
			) {
		Measurement measurement = null;
		if(measurementId != null){
			measurement = measurementRepo.findById(measurementId).orElse(null);
		} 
		return repo.save(new Process(processIsParentProcess, processName, processPid, measurement));
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processId}", produces = "application/json")
	public Process getProcessByProcessIdprocessId(@PathVariable("processId") long processId) {
		Process process = repo.findById(processId).orElse(null);
		return process;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/process/{processId}", produces = "application/json")
	public Process updateProcess(
			@PathVariable("processId") Long processId,
			@RequestParam(value="processIsParentProcess", required=false) Boolean processIsParentProcess,
			@RequestParam(value="processName", required=false) String processName,
			@RequestParam(value="processPid", required=false) Long processPid,
			@RequestParam(value="measurementId", required=false) Long measurementId
			) {
		Measurement measurement = null;
		if(measurementId != null){
			measurement = measurementRepo.findById(measurementId).orElse(null);
		}
		Process process = repo.findById(processId).orElse(null);
		if(process == null){
			return null;
		}
		if(processIsParentProcess != null){
			process.setProcessIsParentProcess(processIsParentProcess);
		}
		if(processName != null){
			process.setProcessName(processName);
		}
		if(processPid != null){
			process.setProcessPid(processPid);
		}
		if(measurement != null){
			process.setProcessMeasurement(measurement);
		}
		return repo.save(process);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processId}/processName", produces = "text/plain")
	public String getProcessByProcessIdprocessIdName(@PathVariable("processId") Long processId) {
		Process process = repo.findById(processId).orElse(null);
		if(process == null){
			return null;
		}
		return process.getProcessName();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processId}/processPid", produces = "application/json")
	public Long getProcessByProcessIdprocessIdPid(@PathVariable("processId") Long processId) {
		Process process = repo.findById(processId).orElse(null);
		if(process == null){
			return null;
		}
		return process.getProcessPid();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processId}/processMeasurement", produces = "application/json")
	public Measurement getProcessByProcessIdprocessIdMeasurement(@PathVariable("processId") Long processId) {
		Process process = repo.findById(processId).orElse(null);
		if(process == null){
			return null;
		}
		return process.getProcessMeasurement();
	
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processId}/processValues", produces = "application/json")
	public Set<ProcessValue> getProcessByProcessIdprocessIdValues(@PathVariable("processId") Long processId) {
		Process process = repo.findById(processId).orElse(null);
		if(process == null){
			return null;
		}
		return valueRepo.findByProcessValueIdProcessValueProcessProcessIdOrderByProcessValueIdProcessValueTimestampAsc(processId);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/process/{processId}/processValues", produces = "application/json")
	public ProcessValue addProcessByProcessIdprocessIdValue(
			@PathVariable("processId") Long processId,
			@RequestParam("measurementId") Long measurementId,
			@RequestParam(value="timestamp", required=false) Long timestamp,
			@RequestParam(value="processValueThreadCount", required=false) Integer processValueThreadCount,
			@RequestParam(value="processValuePriority", required=false) Integer processValuePriority,
			@RequestParam(value="processValueVirtualSize", required=false) Long processValueVirtualSize,
			@RequestParam(value="processValueResidentSetSize", required=false) Long processValueResidentSetSize,
			@RequestParam(value="processValueKernelTime", required=false) Long processValueKernelTime,
			@RequestParam(value="processValueUserTime", required=false) Long processValueUserTime,
			@RequestParam(value="processValueUpTime", required=false) Long processValueUpTime,
			@RequestParam(value="processValueStartTime", required=false) Long processValueStartTime,
			@RequestParam(value="processValueBytesRead", required=false) Long processValueBytesRead,
			@RequestParam(value="processValueBytesWritten", required=false) Long processValueBytesWritten,
			@RequestParam(value="processValueHandles", required=false) Long processValueHandles
			) {
		Process process = repo.findById(processId).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(process == null || measurement == null){
			return null;
		}
		ProcessValuePK pk = new ProcessValuePK(measurementId, new Timestamp(timestamp!=null? timestamp : System.currentTimeMillis()), process);
		ProcessValue value= new ProcessValue(pk, processValueThreadCount, processValuePriority, processValueVirtualSize, processValueResidentSetSize, processValueKernelTime, processValueUserTime, processValueUpTime, processValueStartTime, processValueBytesRead, processValueBytesWritten, processValueHandles);
		return valueRepo.save(value);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processId}/processValues/{measurementId}", produces = "application/json")
	public Set<ProcessValue> getProcessValuesByProcessIdAndMeasurementId(@PathVariable("processId") Long processId, @PathVariable("measurementId") Long measurementId) {
		Process process = repo.findById(processId).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(process == null || measurement == null){
			return null;
		}
		return valueRepo.findByProcessValueIdProcessValueProcessProcessIdAndProcessValueIdProcessValueMeasurementIdOrderByProcessValueIdProcessValueTimestampAsc(processId, measurementId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processId}/processValues/{measurementId}/first", produces = "application/json")
	public ProcessValue getProcessByProcessIdprocessIdValueFirst(@PathVariable("processId") Long processId, @PathVariable("measurementId") Long measurementId) {
		
		Process process = repo.findById(processId).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(process == null || measurement == null){
			return null;
		}
		return valueRepo.findTop1ByProcessValueIdProcessValueProcessProcessIdAndProcessValueIdProcessValueMeasurementIdOrderByProcessValueIdProcessValueTimestampAsc(processId, measurementId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processId}/processValues/{measurementId}/last", produces = "application/json")
	public ProcessValue getProcessByProcessIdprocessIdValueLast(@PathVariable("processId") Long processId, @PathVariable("measurementId") Long measurementId) {
		
		Process process = repo.findById(processId).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(process == null || measurement == null){
			return null;
		}
		return valueRepo.findTop1ByProcessValueIdProcessValueProcessProcessIdAndProcessValueIdProcessValueMeasurementIdOrderByProcessValueIdProcessValueTimestampDesc(processId, measurementId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processId}/processValues/{measurementId}/max", produces = "application/json")
	public ProcessValueWrapper<Integer, Long> getProcessByProcessIdprocessIdValueMax(@PathVariable("processId") Long processId, @PathVariable("measurementId") Long measurementId) {
		
		Process process = repo.findById(processId).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(process == null || measurement == null){
			return null;
		}
		Set<ProcessValue> values = valueRepo.findByProcessValueIdProcessValueProcessProcessIdAndProcessValueIdProcessValueMeasurementId(processId, measurementId);
		Optional<ProcessValue> processValueThreadCount = values.stream().max(Comparator.comparing(ProcessValue::getProcessValueThreadCount, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValuePriority = values.stream().max(Comparator.comparing(ProcessValue::getProcessValuePriority, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueVirtualSize = values.stream().max(Comparator.comparing(ProcessValue::getProcessValueVirtualSize, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueResidentSetSize = values.stream().max(Comparator.comparing(ProcessValue::getProcessValueResidentSetSize, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueKernelTime = values.stream().max(Comparator.comparing(ProcessValue::getProcessValueKernelTime, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueUserTime = values.stream().max(Comparator.comparing(ProcessValue::getProcessValueUserTime, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueUpTime = values.stream().max(Comparator.comparing(ProcessValue::getProcessValueUpTime, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueStartTime = values.stream().max(Comparator.comparing(ProcessValue::getProcessValueStartTime, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueBytesRead = values.stream().max(Comparator.comparing(ProcessValue::getProcessValueBytesRead, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueBytesWritten = values.stream().max(Comparator.comparing(ProcessValue::getProcessValueBytesWritten, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueHandles = values.stream().max(Comparator.comparing(ProcessValue::getProcessValueHandles, Comparator.nullsFirst(Comparator.naturalOrder())));
		
		return new ProcessValueWrapper<Integer, Long>(
				processValueThreadCount.isPresent()? processValueThreadCount.get().getProcessValueThreadCount() : null,
				processValuePriority.isPresent()? processValuePriority.get().getProcessValuePriority() : null,
				processValueVirtualSize.isPresent()?processValueVirtualSize.get().getProcessValueVirtualSize() : null, 
				processValueResidentSetSize.isPresent()?processValueResidentSetSize.get().getProcessValueResidentSetSize() : null, 
				processValueKernelTime.isPresent()?processValueKernelTime.get().getProcessValueKernelTime() : null, 
				processValueUserTime.isPresent()?processValueUserTime.get().getProcessValueUserTime() : null, 
				processValueUpTime.isPresent()?processValueUpTime.get().getProcessValueUpTime() : null, 
				processValueStartTime.isPresent()?processValueStartTime.get().getProcessValueStartTime() : null, 
				processValueBytesRead.isPresent()?processValueBytesRead.get().getProcessValueBytesRead() : null, 
				processValueBytesWritten.isPresent()?processValueBytesWritten.get().getProcessValueBytesWritten() : null, 
				processValueHandles.isPresent()?processValueHandles.get().getProcessValueHandles(): null);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processId}/processValues/{measurementId}/min", produces = "application/json")
	public ProcessValueWrapper<Integer, Long> getProcessByProcessIdprocessIdValueMin(@PathVariable("processId") Long processId, @PathVariable("measurementId") Long measurementId) {
		
		Process process = repo.findById(processId).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(process == null || measurement == null){
			return null;
		}
		Set<ProcessValue> values = valueRepo.findByProcessValueIdProcessValueProcessProcessIdAndProcessValueIdProcessValueMeasurementId(processId, measurementId);
		Optional<ProcessValue> processValueThreadCount = values.stream().min(Comparator.comparing(ProcessValue::getProcessValueThreadCount, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValuePriority = values.stream().min(Comparator.comparing(ProcessValue::getProcessValuePriority, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueVirtualSize = values.stream().min(Comparator.comparing(ProcessValue::getProcessValueVirtualSize, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueResidentSetSize = values.stream().min(Comparator.comparing(ProcessValue::getProcessValueResidentSetSize, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueKernelTime = values.stream().min(Comparator.comparing(ProcessValue::getProcessValueKernelTime, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueUserTime = values.stream().min(Comparator.comparing(ProcessValue::getProcessValueUserTime, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueUpTime = values.stream().min(Comparator.comparing(ProcessValue::getProcessValueUpTime, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueStartTime = values.stream().min(Comparator.comparing(ProcessValue::getProcessValueStartTime, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueBytesRead = values.stream().min(Comparator.comparing(ProcessValue::getProcessValueBytesRead, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueBytesWritten = values.stream().min(Comparator.comparing(ProcessValue::getProcessValueBytesWritten, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<ProcessValue> processValueHandles = values.stream().min(Comparator.comparing(ProcessValue::getProcessValueHandles, Comparator.nullsFirst(Comparator.naturalOrder())));
		
		return new ProcessValueWrapper<Integer, Long>(
				processValueThreadCount.isPresent()? processValueThreadCount.get().getProcessValueThreadCount() : null,
				processValuePriority.isPresent()? processValuePriority.get().getProcessValuePriority() : null,
				processValueVirtualSize.isPresent()?processValueVirtualSize.get().getProcessValueVirtualSize() : null, 
				processValueResidentSetSize.isPresent()?processValueResidentSetSize.get().getProcessValueResidentSetSize() : null, 
				processValueKernelTime.isPresent()?processValueKernelTime.get().getProcessValueKernelTime() : null, 
				processValueUserTime.isPresent()?processValueUserTime.get().getProcessValueUserTime() : null, 
				processValueUpTime.isPresent()?processValueUpTime.get().getProcessValueUpTime() : null, 
				processValueStartTime.isPresent()?processValueStartTime.get().getProcessValueStartTime() : null, 
				processValueBytesRead.isPresent()?processValueBytesRead.get().getProcessValueBytesRead() : null, 
				processValueBytesWritten.isPresent()?processValueBytesWritten.get().getProcessValueBytesWritten() : null, 
				processValueHandles.isPresent()?processValueHandles.get().getProcessValueHandles(): null);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processId}/processValues/{measurementId}/avg", produces = "application/json")
	public ProcessValueWrapper<Double, Double> getProcessByProcessIdprocessIdValueAvg(@PathVariable("processId") Long processId, @PathVariable("measurementId") Long measurementId) {
		
		Process process = repo.findById(processId).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(process == null || measurement == null){
			return null;
		}
		Set<ProcessValue> values = valueRepo.findByProcessValueIdProcessValueProcessProcessIdAndProcessValueIdProcessValueMeasurementId(processId, measurementId);
		Double processValueThreadCount = values.stream().map(ProcessValue::getProcessValueThreadCount).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double processValuePriority = values.stream().map(ProcessValue::getProcessValuePriority).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double processValueVirtualSize = values.stream().map(ProcessValue::getProcessValueVirtualSize).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double processValueResidentSetSize = values.stream().map(ProcessValue::getProcessValueResidentSetSize).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double processValueKernelTime = values.stream().map(ProcessValue::getProcessValueKernelTime).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double processValueUserTime = values.stream().map(ProcessValue::getProcessValueUserTime).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double processValueUpTime = values.stream().map(ProcessValue::getProcessValueUpTime).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double processValueStartTime = values.stream().map(ProcessValue::getProcessValueStartTime).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double processValueBytesRead = values.stream().map(ProcessValue::getProcessValueBytesRead).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double processValueBytesWritten = values.stream().map(ProcessValue::getProcessValueBytesWritten).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double processValueHandles = values.stream().map(ProcessValue::getProcessValueHandles).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		processValueThreadCount = Double.isNaN(processValueThreadCount) ? null : processValueThreadCount;
		processValuePriority = Double.isNaN(processValuePriority) ? null : processValuePriority;
		processValueVirtualSize = Double.isNaN(processValueVirtualSize) ? null : processValueVirtualSize;
		processValueResidentSetSize = Double.isNaN(processValueResidentSetSize) ? null : processValueResidentSetSize;
		processValueKernelTime = Double.isNaN(processValueKernelTime) ? null : processValueKernelTime;
		processValueUserTime = Double.isNaN(processValueUserTime) ? null : processValueUserTime;
		processValueUpTime = Double.isNaN(processValueUpTime) ? null : processValueUpTime;
		processValueStartTime = Double.isNaN(processValueStartTime) ? null : processValueStartTime;
		processValueBytesRead = Double.isNaN(processValueBytesRead) ? null : processValueBytesRead;
		processValueBytesWritten = Double.isNaN(processValueBytesWritten) ? null : processValueBytesWritten;
		processValueHandles = Double.isNaN(processValueHandles) ? null : processValueHandles;
		
		
		return new ProcessValueWrapper<Double, Double>(
				processValueThreadCount, 
				processValuePriority, 
				processValueVirtualSize,
				processValueResidentSetSize, 
				processValueKernelTime, 
				processValueUserTime, 
				processValueUpTime,
				processValueStartTime,
				processValueBytesRead,
				processValueBytesWritten,
				processValueHandles);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processId}/processValues/{measurementId}/count", produces = "application/json")
	public ProcessValueWrapper<Long, Long> getProcessByProcessIdprocessIdValueCount(@PathVariable("processId") Long processId, @PathVariable("measurementId") Long measurementId) {
		
		Process process = repo.findById(processId).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(process == null || measurement == null){
			return null;
		}
		Set<ProcessValue> values = valueRepo.findByProcessValueIdProcessValueProcessProcessIdAndProcessValueIdProcessValueMeasurementId(processId, measurementId);
		Long processValueThreadCount = values.stream().map(ProcessValue::getProcessValueThreadCount).filter(x -> x!=null).count();
		Long processValuePriority = values.stream().map(ProcessValue::getProcessValuePriority).filter(x -> x!=null).count();
		Long processValueVirtualSize = values.stream().map(ProcessValue::getProcessValueVirtualSize).filter(x -> x!=null).count();
		Long processValueResidentSetSize = values.stream().map(ProcessValue::getProcessValueResidentSetSize).filter(x -> x!=null).count();
		Long processValueKernelTime = values.stream().map(ProcessValue::getProcessValueKernelTime).filter(x -> x!=null).count();
		Long processValueUserTime = values.stream().map(ProcessValue::getProcessValueUserTime).filter(x -> x!=null).count();
		Long processValueUpTime = values.stream().map(ProcessValue::getProcessValueUpTime).filter(x -> x!=null).count();
		Long processValueStartTime = values.stream().map(ProcessValue::getProcessValueStartTime).filter(x -> x!=null).count();
		Long processValueBytesRead = values.stream().map(ProcessValue::getProcessValueBytesRead).filter(x -> x!=null).count();
		Long processValueBytesWritten = values.stream().map(ProcessValue::getProcessValueBytesWritten).filter(x -> x!=null).count();
		Long processValueHandles = values.stream().map(ProcessValue::getProcessValueHandles).filter(x -> x!=null).count();

		return new ProcessValueWrapper<Long, Long>(
				processValueThreadCount, 
				processValuePriority, 
				processValueVirtualSize,
				processValueResidentSetSize, 
				processValueKernelTime, 
				processValueUserTime, 
				processValueUpTime,
				processValueStartTime,
				processValueBytesRead,
				processValueBytesWritten,
				processValueHandles);
	}

}
