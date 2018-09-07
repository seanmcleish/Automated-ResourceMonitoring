package de.tub.qds.rm.controller;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.Memory;
import de.tub.qds.rm.models.consts.repos.HardwareRepo;
import de.tub.qds.rm.models.consts.repos.MeasurementRepo;
import de.tub.qds.rm.models.consts.repos.MemoryRepo;
import de.tub.qds.rm.models.consts.repos.MemoryValueRepo;
import de.tub.qds.rm.models.values.MemoryValue;
import de.tub.qds.rm.models.values.pks.MemoryValuePK;
import de.tub.qds.rm.models.values.wrapper.MemoryValueWrapper;

//FINISHED IMPLEMENTATION & TESTED
@RestController
public class MemoryController {
	
	@Autowired
	MemoryRepo repo;
	@Autowired
	MemoryValueRepo valueRepo;
	@Autowired
	MeasurementRepo measurementRepo;
	@Autowired
	HardwareRepo hardwareRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/memory", produces = "application/json")
	public List<Memory> getMemories() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/memory", produces = "application/json")
	public Memory postMemory(@RequestParam("memoryTotalSpace") Long memoryTotalSpace){
		Memory memory = repo.findById(memoryTotalSpace).orElse(null);
		if(memory != null){
			return memory;
		}
		return repo.save(new Memory(memoryTotalSpace));
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/memory/{memoryTotalSpace}", produces = "application/json")
	public Memory getMemoryByTotalSpace(@PathVariable("memoryTotalSpace") long memoryTotalSpace) {
		return repo.existsById(memoryTotalSpace) ? repo.findById(memoryTotalSpace).get() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/memory/{memoryTotalSpace}/memoryValues", produces = "application/json")
	public Set<MemoryValue> getMemoryByTotalSpaceValues(@PathVariable("memoryTotalSpace") long memoryTotalSpace) {
		Memory memory = repo.findById(memoryTotalSpace).orElse(null);
		if(memory == null){
			return null;
		}
		return valueRepo.findByMemoryValueIdMemoryValueMemoryMemoryTotalSpaceOrderByMemoryValueIdMemoryValueTimestampAsc(memoryTotalSpace);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/memory/{memoryTotalSpace}/memoryValues", produces = "application/json")
	public MemoryValue newMemoryByTotalSpaceValue(
			@PathVariable("memoryTotalSpace") Long memoryTotalSpace,
			@RequestParam("measurementId") Long measurementId,
			@RequestParam(value="timestamp", required=false) Long timestamp,
			@RequestParam(value = "memoryValueAvailable;", required = false) Long memoryValueAvailable,
			@RequestParam(value = "memoryValueSwapTotal;", required = false) Long memoryValueSwapTotal,
			@RequestParam(value = "memoryValueSwapUsed;", required = false) Long memoryValueSwapUsed
			) {
		Memory memory = repo.findById(memoryTotalSpace).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(memory == null || measurement == null){
			return null;
		}
		MemoryValuePK pk = new MemoryValuePK(memory, measurement.getMeasurementId(), new Timestamp(timestamp!=null? timestamp: System.currentTimeMillis()));
		return valueRepo.save(new MemoryValue(pk, memoryValueAvailable, memoryValueSwapTotal, memoryValueSwapUsed));
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/memory/{memoryTotalSpace}/memoryValues/{measurementId}", produces = "application/json")
	public Set<MemoryValue> getMemoryByTotalSpaceValueAndMeasurementId(@PathVariable("memoryTotalSpace") Long memoryTotalSpace, @PathVariable("measurementId") Long measurementId) {
		if(!measurementRepo.existsById(measurementId) || !repo.existsById(memoryTotalSpace)){
			return null;
		}
		return valueRepo.findByMemoryValueIdMemoryValueMemoryMemoryTotalSpaceAndMemoryValueIdMemoryValueMeasurementIdOrderByMemoryValueIdMemoryValueTimestampAsc(memoryTotalSpace, measurementId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/memory/{memoryTotalSpace}/memoryValues/{measurementId}/max", produces = "application/json")
	public MemoryValueWrapper<Long> getMemoryByTotalSpaceValueAndMeasurementIdMax(@PathVariable("memoryTotalSpace") Long memoryTotalSpace, @PathVariable("measurementId") Long measurementId) {
		if(!measurementRepo.existsById(measurementId) || !repo.existsById(memoryTotalSpace)){
			return null;
		}
		Set<MemoryValue> values = valueRepo.findByMemoryValueIdMemoryValueMemoryMemoryTotalSpaceAndMemoryValueIdMemoryValueMeasurementId(memoryTotalSpace, measurementId);
		Long memoryValueAvailableMax = values.stream().max(Comparator.comparing(MemoryValue::getMemoryValueAvailable)).get().getMemoryValueAvailable();
		Long memoryValueSwapTotalMax = values.stream().max(Comparator.comparing(MemoryValue::getMemoryValueSwapTotal)).get().getMemoryValueSwapTotal();
		Long memoryValueSwapUsedMax = values.stream().max(Comparator.comparing(MemoryValue::getMemoryValueSwapUsed)).get().getMemoryValueSwapUsed();
		return new MemoryValueWrapper<Long>(memoryValueAvailableMax, memoryValueSwapTotalMax, memoryValueSwapUsedMax);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/memory/{memoryTotalSpace}/memoryValues/{measurementId}/min", produces = "application/json")
	public MemoryValueWrapper<Long> getMemoryByTotalSpaceValueAndMeasurementIdMin(@PathVariable("memoryTotalSpace") Long memoryTotalSpace, @PathVariable("measurementId") Long measurementId) {
		if(!measurementRepo.existsById(measurementId) || !repo.existsById(memoryTotalSpace)){
			return null;
		}
		Set<MemoryValue> values = valueRepo.findByMemoryValueIdMemoryValueMemoryMemoryTotalSpaceAndMemoryValueIdMemoryValueMeasurementId(memoryTotalSpace, measurementId);
		Long memoryValueAvailableMin = values.stream().min(Comparator.comparing(MemoryValue::getMemoryValueAvailable)).get().getMemoryValueAvailable();
		Long memoryValueSwapTotalMin = values.stream().min(Comparator.comparing(MemoryValue::getMemoryValueSwapTotal)).get().getMemoryValueSwapTotal();
		Long memoryValueSwapUsedMin = values.stream().min(Comparator.comparing(MemoryValue::getMemoryValueSwapUsed)).get().getMemoryValueSwapUsed();
		return new MemoryValueWrapper<Long>(memoryValueAvailableMin, memoryValueSwapTotalMin, memoryValueSwapUsedMin);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/memory/{memoryTotalSpace}/memoryValues/{measurementId}/avg", produces = "application/json")
	public MemoryValueWrapper<Double> getMemoryByTotalSpaceValueAndMeasurementIdAvg(@PathVariable("memoryTotalSpace") Long memoryTotalSpace, @PathVariable("measurementId") Long measurementId) {
		if(!measurementRepo.existsById(measurementId) || !repo.existsById(memoryTotalSpace)){
			return null;
		}
		Set<MemoryValue> values = valueRepo.findByMemoryValueIdMemoryValueMemoryMemoryTotalSpaceAndMemoryValueIdMemoryValueMeasurementId(memoryTotalSpace, measurementId);
		Double memoryValueAvailableAvg = values.stream().map(MemoryValue::getMemoryValueAvailable).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double memoryValueSwapTotalAvg = values.stream().map(MemoryValue::getMemoryValueSwapTotal).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double memoryValueSwapUsedAvg = values.stream().map(MemoryValue::getMemoryValueSwapUsed).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		return new MemoryValueWrapper<Double>(memoryValueAvailableAvg, memoryValueSwapTotalAvg, memoryValueSwapUsedAvg);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/memory/{memoryTotalSpace}/memoryValues/{measurementId}/count", produces = "application/json")
	public MemoryValueWrapper<Long> getMemoryByTotalSpaceValueAndMeasurementIdCount(@PathVariable("memoryTotalSpace") Long memoryTotalSpace, @PathVariable("measurementId") Long measurementId) {
		if(!measurementRepo.existsById(measurementId) || !repo.existsById(memoryTotalSpace)){
			return null;
		}
		Set<MemoryValue> values = valueRepo.findByMemoryValueIdMemoryValueMemoryMemoryTotalSpaceAndMemoryValueIdMemoryValueMeasurementId(memoryTotalSpace, measurementId);
		Long memoryValueAvailableCount = values.stream().map(MemoryValue::getMemoryValueAvailable).filter(x -> x!=null).count();
		Long memoryValueSwapTotalCount= values.stream().map(MemoryValue::getMemoryValueSwapTotal).filter(x -> x!=null).count();
		Long memoryValueSwapUsedCount = values.stream().map(MemoryValue::getMemoryValueSwapUsed).filter(x -> x!=null).count();
		return new MemoryValueWrapper<Long>(memoryValueAvailableCount, memoryValueSwapTotalCount, memoryValueSwapUsedCount);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/memory/{memoryTotalSpace}/memoryHardware", produces = "application/json")
	public Set<Hardware> getMemoryByTotalSpaceHardware(@PathVariable("memoryTotalSpace") long memoryTotalSpace) {
		return repo.existsById(memoryTotalSpace) ? repo.findById(memoryTotalSpace).get().getMemoryHardware() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/memory/{memoryTotalSpace}/memoryHardware", produces = "application/json")
	public Set<Hardware> addMemoryByTotalSpaceHardware(@PathVariable("memoryTotalSpace") long memoryTotalSpace, @RequestParam("hardwareIdentifier") Long hardwareIdentifier) {
		Memory memory = repo.findById(memoryTotalSpace).orElse(null);
		Hardware hardware = hardwareRepo.findById(hardwareIdentifier).orElse(null);
		if(memory == null || hardware == null){
			return null;
		}
		memory.addMemoryHardware(hardware);
		return repo.save(memory).getMemoryHardware();
	}

}
