package de.tub.qds.rm.controller;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Disk;
import de.tub.qds.rm.models.consts.FileStore;
import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.repos.DiskRepo;
import de.tub.qds.rm.models.consts.repos.DiskValueRepo;
import de.tub.qds.rm.models.consts.repos.FileStoreRepo;
import de.tub.qds.rm.models.consts.repos.HardwareRepo;
import de.tub.qds.rm.models.consts.repos.MeasurementRepo;
import de.tub.qds.rm.models.values.DiskValue;
import de.tub.qds.rm.models.values.pks.DiskValuePK;
import de.tub.qds.rm.models.values.wrapper.DiskValueWrapper;

//FINISHED IMPLEMENTATION & TESTED
@RestController
public class DiskController {
	
	@Autowired
	DiskRepo repo;
	@Autowired
	DiskValueRepo valueRepo;
	@Autowired
	HardwareRepo hardwareRepo;
	@Autowired
	FileStoreRepo fileStoreRepo;
	@Autowired
	MeasurementRepo measurementRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/disk", produces = "application/json")
	public List<Disk> getDisks() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/disk", produces = "application/json")
	public Disk postDisk(
			@RequestParam("diskSerialNumber") String diskSerialNumber, 
			@RequestParam(value="diskModel", required=false) String diskModel ,
			@RequestParam(value="diskName", required=false) String diskName,
			@RequestParam(value="diskSize", required=false) Long diskSize,
			HttpServletRequest request, 
			HttpServletResponse response
			) {
		Disk disk = new Disk(diskSerialNumber, diskModel, diskName, diskSize);
		return repo.save(disk);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}", produces = "application/json")
	public Disk getDiskById(@PathVariable("diskSerialNumber") String diskSerialNumber) {
		return repo.existsById(diskSerialNumber) ? repo.findById(diskSerialNumber).get() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/disk/{diskSerialNumber}", produces = "application/json")
	public Disk updateDiskById(
			@PathVariable("diskSerialNumber") String diskSerialNumber, 
			@RequestParam(value = "diskModel", required=false) String diskModel ,
			@RequestParam(value="diskName", required=false) String diskName,
			@RequestParam(value="diskSize", required=false) Long diskSize
			) {
		Disk disk = repo.findById(diskSerialNumber).orElse(null);
		if(disk != null) {
			if(diskModel != null) {
				disk.setDiskModel(diskModel);
			}
			if(diskName != null){
				disk.setDiskName(diskName);
			}
			if(diskSize!=null) {
				disk.setDiskSize(diskSize);
			}
			return repo.save(disk);
		}
		else{
			return null;
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/disk/{diskSerialNumber}", produces = "application/json")
	public void deleteDiskById(@PathVariable("diskSerialNumber") String diskSerialNumber) {
		if(repo.existsById(diskSerialNumber)){
			repo.deleteById(diskSerialNumber);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskModel", produces = "text/plain")
	public String getDiskByIdDiskModel(@PathVariable("diskSerialNumber") String diskSerialNumber) {
		return repo.existsById(diskSerialNumber)
				? repo.findById(diskSerialNumber).get().getDiskModel() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskName", produces = "text/plain")
	public String getDiskByIdDiskName(@PathVariable("diskSerialNumber") String diskSerialNumber) {
		return repo.existsById(diskSerialNumber)
				? repo.findById(diskSerialNumber).get().getDiskName() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskSize", produces = "application/json")
	public Long getDiskByIdDiskSize(@PathVariable("diskSerialNumber") String diskSerialNumber) {
		return repo.existsById(diskSerialNumber)
				? repo.findById(diskSerialNumber).get().getDiskSize() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskValues", produces = "application/json")
	public Set<DiskValue> getDiskByIdDiskValues(@PathVariable("diskSerialNumber") String diskSerialNumber) {
		if(!repo.existsById(diskSerialNumber)){
			return null;
		}
		return valueRepo.findByDiskValueIdDiskValueDiskDiskSerialNumberOrderByDiskValueIdDiskValueTimestampAsc(diskSerialNumber);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskValues/{measurementId}", produces = "application/json")
	public Set<DiskValue> getDiskByIdDiskValuesByMeasurementId(@PathVariable("diskSerialNumber") String diskSerialNumber, @PathVariable("measurementId") Long measurementId) {
		if(!repo.existsById(diskSerialNumber) || !measurementRepo.existsById(measurementId)){
			return null;
		}else{
			return valueRepo.findByDiskValueIdDiskValueDiskDiskSerialNumberAndDiskValueIdDiskValueMeasurementIdOrderByDiskValueIdDiskValueTimestampAsc(diskSerialNumber, measurementId);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskValues/{measurementId}/first", produces = "application/json")
	public DiskValue getDiskByIdDiskValuesByMeasurementIdFirst(@PathVariable("diskSerialNumber") String diskSerialNumber, @PathVariable("measurementId") Long measurementId) {
		if(!repo.existsById(diskSerialNumber) || !measurementRepo.existsById(measurementId)){
			return null;
		}
		return valueRepo.findTop1ByDiskValueIdDiskValueDiskDiskSerialNumberAndDiskValueIdDiskValueMeasurementIdOrderByDiskValueIdDiskValueTimestampAsc(diskSerialNumber, measurementId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskValues/{measurementId}/last", produces = "application/json")
	public DiskValue getDiskByIdDiskValuesByMeasurementIdlast(@PathVariable("diskSerialNumber") String diskSerialNumber, @PathVariable("measurementId") Long measurementId) {
		if(!repo.existsById(diskSerialNumber) || !measurementRepo.existsById(measurementId)){
			return null;
		}
		return valueRepo.findTop1ByDiskValueIdDiskValueDiskDiskSerialNumberAndDiskValueIdDiskValueMeasurementIdOrderByDiskValueIdDiskValueTimestampDesc(diskSerialNumber, measurementId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskValues/{measurementId}/max", produces = "application/json")
	public DiskValueWrapper<Long> getDiskByIdDiskValuesByMeasurementIdMax(@PathVariable("diskSerialNumber") String diskSerialNumber, @PathVariable("measurementId") Long measurementId) {
		if(!repo.existsById(diskSerialNumber) || !measurementRepo.existsById(measurementId)){
			return null;
		}else{
			Set<DiskValue> values = valueRepo.findByDiskValueIdDiskValueDiskDiskSerialNumberAndDiskValueIdDiskValueMeasurementId(diskSerialNumber, measurementId);
			Optional<DiskValue> diskValueReadsMin = values.stream().max(Comparator.comparing(DiskValue::getDiskValueReads, Comparator.nullsFirst(Comparator.naturalOrder())));
			Optional<DiskValue> diskValueReadBytesMin = values.stream().max(Comparator.comparing(DiskValue::getDiskValueReadBytes, Comparator.nullsFirst(Comparator.naturalOrder())));
			Optional<DiskValue> diskValueWritesMin = values.stream().max(Comparator.comparing(DiskValue::getDiskValueWrites, Comparator.nullsFirst(Comparator.naturalOrder())));
			Optional<DiskValue> diskValueWriteBytesMin = values.stream().max(Comparator.comparing(DiskValue::getDiskValueWriteBytes, Comparator.nullsFirst(Comparator.naturalOrder())));
			Optional<DiskValue> diskValueTransferTimeMin = values.stream().max(Comparator.comparing(DiskValue::getDiskValueTransferTime, Comparator.nullsFirst(Comparator.naturalOrder())));
			return new DiskValueWrapper<Long>(
					diskValueReadsMin.isPresent()? diskValueReadsMin.get().getDiskValueReads() : null, 
					diskValueReadBytesMin.isPresent()? diskValueReadBytesMin.get().getDiskValueReadBytes() : null, 
					diskValueWritesMin.isPresent()? diskValueWritesMin.get().getDiskValueWrites() : null, 
					diskValueWriteBytesMin.isPresent()? diskValueWriteBytesMin.get().getDiskValueWriteBytes() : null, 
					diskValueTransferTimeMin.isPresent()?diskValueTransferTimeMin.get().getDiskValueTransferTime() : null );
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskValues/{measurementId}/min", produces = "application/json")
	public DiskValueWrapper<Long> getDiskByIdDiskValuesByMeasurementIdMin(@PathVariable("diskSerialNumber") String diskSerialNumber, @PathVariable("measurementId") Long measurementId) {
		if(!repo.existsById(diskSerialNumber) || !measurementRepo.existsById(measurementId)){
			return null;
		}else{
			Set<DiskValue> values = valueRepo.findByDiskValueIdDiskValueDiskDiskSerialNumberAndDiskValueIdDiskValueMeasurementId(diskSerialNumber, measurementId);
			Optional<DiskValue> diskValueReadsMin = values.stream().min(Comparator.comparing(DiskValue::getDiskValueReads, Comparator.nullsFirst(Comparator.naturalOrder())));
			Optional<DiskValue> diskValueReadBytesMin = values.stream().min(Comparator.comparing(DiskValue::getDiskValueReadBytes, Comparator.nullsFirst(Comparator.naturalOrder())));
			Optional<DiskValue> diskValueWritesMin = values.stream().min(Comparator.comparing(DiskValue::getDiskValueWrites, Comparator.nullsFirst(Comparator.naturalOrder())));
			Optional<DiskValue> diskValueWriteBytesMin = values.stream().min(Comparator.comparing(DiskValue::getDiskValueWriteBytes, Comparator.nullsFirst(Comparator.naturalOrder())));
			Optional<DiskValue> diskValueTransferTimeMin = values.stream().min(Comparator.comparing(DiskValue::getDiskValueTransferTime, Comparator.nullsFirst(Comparator.naturalOrder())));
			return new DiskValueWrapper<Long>(
					diskValueReadsMin.isPresent()? diskValueReadsMin.get().getDiskValueReads() : null, 
					diskValueReadBytesMin.isPresent()? diskValueReadBytesMin.get().getDiskValueReadBytes() : null, 
					diskValueWritesMin.isPresent()? diskValueWritesMin.get().getDiskValueWrites() : null, 
					diskValueWriteBytesMin.isPresent()? diskValueWriteBytesMin.get().getDiskValueWriteBytes() : null, 
					diskValueTransferTimeMin.isPresent()?diskValueTransferTimeMin.get().getDiskValueTransferTime() : null );
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskValues/{measurementId}/avg", produces = "application/json")
	public DiskValueWrapper<Double> getDiskByIdDiskValuesByMeasurementIdAvg(@PathVariable("diskSerialNumber") String diskSerialNumber, @PathVariable("measurementId") Long measurementId) {
		
		if(!repo.existsById(diskSerialNumber) || !measurementRepo.existsById(measurementId)){
			return null;
		}else{
			Set<DiskValue> values = valueRepo.findByDiskValueIdDiskValueDiskDiskSerialNumberAndDiskValueIdDiskValueMeasurementId(diskSerialNumber, measurementId);
			Double diskValueReadsAvg = values.stream().map(DiskValue::getDiskValueReads).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
			Double diskValueReadBytesAvg = values.stream().map(DiskValue::getDiskValueReadBytes).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
			Double diskValueWritesAvg = values.stream().map(DiskValue::getDiskValueWrites).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
			Double diskValueWriteBytesAvg = values.stream().map(DiskValue::getDiskValueWriteBytes).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
			Double diskValueTransferTimeAvg = values.stream().map(DiskValue::getDiskValueTransferTime).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
			diskValueReadsAvg = Double.isNaN(diskValueReadsAvg)? null : diskValueReadsAvg;
			diskValueReadBytesAvg = Double.isNaN(diskValueReadBytesAvg)? null : diskValueReadBytesAvg;
			diskValueWritesAvg = Double.isNaN(diskValueWritesAvg)? null : diskValueWritesAvg;
			diskValueWriteBytesAvg = Double.isNaN(diskValueWriteBytesAvg)? null : diskValueWriteBytesAvg;
			diskValueTransferTimeAvg = Double.isNaN(diskValueTransferTimeAvg)? null : diskValueTransferTimeAvg;
			return new DiskValueWrapper<Double>(diskValueReadsAvg, diskValueReadBytesAvg, diskValueWritesAvg, diskValueWriteBytesAvg, diskValueTransferTimeAvg);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskValues/{measurementId}/count", produces = "application/json")
	public DiskValueWrapper<Long> getDiskByIdDiskValuesByMeasurementIdCount(@PathVariable("diskSerialNumber") String diskSerialNumber, @PathVariable("measurementId") Long measurementId) {
		
		if(!repo.existsById(diskSerialNumber) || !measurementRepo.existsById(measurementId)){
			return null;
		}else{
			Set<DiskValue> values = valueRepo.findByDiskValueIdDiskValueDiskDiskSerialNumberAndDiskValueIdDiskValueMeasurementId(diskSerialNumber, measurementId);
			Long diskValueReadsCount = values.stream().map(DiskValue::getDiskValueReads).filter(x -> x!=null).count();
			Long diskValueReadBytesCount = values.stream().map(DiskValue::getDiskValueReadBytes).filter(x -> x!=null).count();
			Long diskValueWritesCount = values.stream().map(DiskValue::getDiskValueWrites).filter(x -> x!=null).count();
			Long diskValueWriteBytesCount = values.stream().map(DiskValue::getDiskValueWriteBytes).filter(x -> x!=null).count();
			Long diskValueTransferTimeCount = values.stream().map(DiskValue::getDiskValueTransferTime).filter(x -> x!=null).count();
			return new DiskValueWrapper<Long>(diskValueReadsCount, diskValueReadBytesCount, diskValueWritesCount, diskValueWriteBytesCount, diskValueTransferTimeCount);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/disk/{diskSerialNumber}/diskValues", produces = "application/json")
	public DiskValue addDiskValueById(
			@PathVariable("diskSerialNumber") String diskSerialNumber,
			@RequestParam("measurementId") Long measurementId,
			@RequestParam(value="timestamp", required=false) Long timestamp,
			@RequestParam(value = "diskValueReads", required=false) Long diskValueReads,
			@RequestParam(value = "diskValueReadBytes", required=false) Long diskValueReadBytes,
			@RequestParam(value = "diskValueWrites", required=false) Long diskValueWrites,
			@RequestParam(value = "diskValueWriteBytes",required=false) Long diskValueWriteBytes,
			@RequestParam(value = "diskValueTransferTime", required=false) Long diskValueTransferTime
			) {
		Disk disk =  repo.findById(diskSerialNumber).orElse(null);
		if(disk != null) {
			DiskValuePK pk = new DiskValuePK(disk, measurementId, new Timestamp(timestamp!=null? timestamp: System.currentTimeMillis()));
			DiskValue value = new DiskValue(
					pk,
					diskValueReads,
					diskValueReadBytes,
					diskValueWrites,
					diskValueWriteBytes,
					diskValueTransferTime);
			return valueRepo.save(value);
		}
		else{
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskFileStores", produces = "application/json")
	public Set<FileStore> getDiskByIdDiskFileStores(@PathVariable("diskSerialNumber") String diskSerialNumber) {
		return repo.existsById(diskSerialNumber)
				? repo.findById(diskSerialNumber).get().getDiskFileStores() : null;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/disk/{diskSerialNumber}/diskFileStores", produces = "application/json")
	public FileStore addDiskFileStoreByUuid(@PathVariable("diskSerialNumber") String diskSerialNumber, @RequestParam("diskFileStoreUuid") String diskFileStoreUuid) {
		Disk disk = repo.findById(diskSerialNumber).orElse(null);
		FileStore fileStore = fileStoreRepo.findById(diskFileStoreUuid).orElse(null);
		if(disk==null || fileStore == null ){
			return null;
		}
		fileStore.setFileStoreDisk(disk);
		return fileStoreRepo.save(fileStore);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskHardware", produces = "application/json")
	public Set<Hardware> getDiskByIdDiskHardware(@PathVariable("diskSerialNumber") String diskSerialNumber) {
		return repo.existsById(diskSerialNumber)
				? repo.findById(diskSerialNumber).get().getDiskHardware() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/disk/{diskSerialNumber}/diskHardware", produces = "application/json")
	public Set<Hardware> addDiskHardwareById(@PathVariable("diskSerialNumber") String diskSerialNumber, @RequestParam("hardwareIdentifier") Long hardwareIdentifier) {
		Disk disk = repo.findById(diskSerialNumber).orElse(null);
		Hardware hardware = hardwareRepo.findById(hardwareIdentifier).orElse(null);
		if(disk == null || hardware == null){
			return null;
		}
		disk.addDiskHardware(hardware);
		return repo.save(disk).getDiskHardware();
	}
	
}
