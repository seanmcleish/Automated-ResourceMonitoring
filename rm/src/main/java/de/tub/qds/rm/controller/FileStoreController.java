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
import de.tub.qds.rm.models.consts.repos.DiskRepo;
import de.tub.qds.rm.models.consts.repos.FileStoreRepo;
import de.tub.qds.rm.models.consts.repos.FileStoreValueRepo;
import de.tub.qds.rm.models.consts.repos.MeasurementRepo;
import de.tub.qds.rm.models.values.FileStoreValue;
import de.tub.qds.rm.models.values.pks.FileStoreValuePK;
import de.tub.qds.rm.models.values.wrapper.FileStoreValueWrapper;


//FINISHED IMPLEMENTATION & TESTED
@RestController
public class FileStoreController {

	@Autowired
	FileStoreRepo repo;
	@Autowired
	FileStoreValueRepo valueRepo;
	@Autowired
	DiskRepo diskRepo;
	@Autowired
	MeasurementRepo measurementRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/fileStore", produces = "application/json")
	public List<FileStore> getFileStores() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/fileStore", produces = "application/json")
	public FileStore postFileStore(
			@RequestParam("fileStoreUuid") String fileStoreUuid, 
			@RequestParam(value="fileStoreTotalSpace", required=false) Long fileStoreTotalSpace ,
			@RequestParam(value="fileStoreName", required=false) String fileStoreName,
			@RequestParam(value="fileStoreVolume", required=false) String fileStoreVolume,
			@RequestParam(value="fileStoreMountPoint", required=false) String fileStoreMountPoint,
			@RequestParam(value="fileStoreDescription", required=false) String fileStoreDescription,
			@RequestParam(value="fileStoreFsType", required=false) String fileStoreFsType,
			HttpServletRequest request, 
			HttpServletResponse response
			) {
		try{
			FileStore fileStore = new FileStore(fileStoreUuid, fileStoreTotalSpace, fileStoreName, fileStoreVolume, fileStoreMountPoint, fileStoreDescription, fileStoreFsType);
			return repo.save(fileStore);
		}
		catch(Exception e){
			return  null;
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}", produces = "application/json")
	public FileStore getFileStoreById(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/fileStore/{fileStoreUuid}", produces = "application/json")
	public FileStore updateFileStoreById(
			@PathVariable("fileStoreUuid") String fileStoreUuid,
			@RequestParam(value="fileStoreTotalSpace", required=false) Long fileStoreTotalSpace ,
			@RequestParam(value="fileStoreName", required=false) String fileStoreName,
			@RequestParam(value="fileStoreVolume", required=false) String fileStoreVolume,
			@RequestParam(value="fileStoreMountPoint", required=false) String fileStoreMountPoint,
			@RequestParam(value="fileStoreDescription", required=false) String fileStoreDescription,
			@RequestParam(value="fileStoreFsType", required=false) String fileStoreFsType
			) {
		FileStore fileStore = repo.findById(fileStoreUuid).orElse(null);
		if(fileStore != null){
			if(fileStoreTotalSpace != null){
				fileStore.setFileStoreTotalSpace(fileStoreTotalSpace);
			}
			if(fileStoreName != null){
				fileStore.setFileStoreName(fileStoreName);
			}
			if(fileStoreVolume != null){
				fileStore.setFileStoreVolume(fileStoreVolume);
			}
			if(fileStoreMountPoint != null){
				fileStore.setFileStoreMountPoint(fileStoreMountPoint);
			}
			if(fileStoreDescription != null){
				fileStore.setFileStoreDescription(fileStoreDescription);
			}
			if(fileStoreFsType != null){
				fileStore.setFileStoreFsType(fileStoreFsType);
			}
			return repo.save(fileStore);
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/fileStore/{fileStoreUuid}", produces = "application/json")
	public void deleteFileStoreById(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		if(repo.existsById(fileStoreUuid)){
			repo.deleteById(fileStoreUuid);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid/fileStoreTotalSpace}", produces = "application/json")
	public Long getFileStoreByIdTotalSpace(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get().getFileStoreTotalSpace() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreName", produces = "text/plain")
	public String getFileStoreByIdName(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get().getFileStoreName() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreVolume", produces = "text/plain")
	public String getFileStoreByIdVolume(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get().getFileStoreVolume() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreMountPoint", produces = "text/plain")
	public String getFileStoreByIdMountPoint(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get().getFileStoreMountPoint() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreDescription", produces = "text/plain")
	public String getFileStoreByIdDescription(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get().getFileStoreDescription() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreFsType", produces = "text/plain")
	public String getFileStoreByIdFsType(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get().getFileStoreFsType() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreDisk", produces = "application/json")
	public Disk getFileStoreByIdDisk(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get().getFileStoreDisk() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/fileStore/{fileStoreUuid}/fileStoreDisk", produces = "application/json")
	public Disk setFileStoreByIdDisk(@PathVariable("fileStoreUuid") String fileStoreUuid, @RequestParam("diskSerialNumber") String diskSerialNumber) {
		FileStore fileStore = repo.findById(fileStoreUuid).orElse(null);
		Disk disk = diskRepo.findById(diskSerialNumber).orElse(null);
		if(fileStore == null || disk == null){
			return null;
		}
		fileStore.setFileStoreDisk(disk);
		return repo.save(fileStore).getFileStoreDisk();
	}
		
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreValues", produces = "application/json")
	public Set<FileStoreValue> getFileStoreByIdValues(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		if(!repo.existsById(fileStoreUuid)){
			return null;
		}
		return valueRepo.findByFileStoreValueIdFileStoreValueFileStoreFileStoreUuidOrderByFileStoreValueIdFileStoreValueTimestampAsc(fileStoreUuid);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/fileStore/{fileStoreUuid}/fileStoreValues", produces = "application/json")
	public FileStoreValue addFileStoreValueById(
			@PathVariable("fileStoreUuid") String fileStoreUuid,
			@RequestParam("measurementId") Long measurementId,
			@RequestParam(value = "timestamp", required=false) Long timestamp,
			@RequestParam(value="fileStoreValueUsableSpace", required=false) Long fileStoreValueUsableSpace) {
		
		FileStore fileStore = repo.findById(fileStoreUuid).orElse(null);
		if(fileStore!=null){
			FileStoreValuePK pk = new FileStoreValuePK(fileStore, measurementId, new Timestamp(timestamp!=null? timestamp: System.currentTimeMillis()));
			FileStoreValue value = new FileStoreValue(pk, fileStoreValueUsableSpace);
			return valueRepo.save(value);
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreValues/{measurementId}", produces = "application/json")
	public Set<FileStoreValue> getFileStoreByIdValuesByMeasurementId(@PathVariable("fileStoreUuid") String fileStoreUuid, @PathVariable("measurementId") Long measurementId) {
		if(!repo.existsById(fileStoreUuid) || !measurementRepo.existsById(measurementId)){
			return null;
		}
		return valueRepo.findByFileStoreValueIdFileStoreValueFileStoreFileStoreUuidAndFileStoreValueIdFileStoreValueMeasurementIdOrderByFileStoreValueIdFileStoreValueTimestampAsc(fileStoreUuid, measurementId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreValues/{measurementId}/first", produces = "application/json")
	public FileStoreValue getFileStoreByIdValuesByMeasurementIdFirst(@PathVariable("fileStoreUuid") String fileStoreUuid, @PathVariable("measurementId") Long measurementId) {
		if(!repo.existsById(fileStoreUuid) || !measurementRepo.existsById(measurementId)){
			return null;
		}
		return valueRepo.findTop1ByFileStoreValueIdFileStoreValueFileStoreFileStoreUuidAndFileStoreValueIdFileStoreValueMeasurementIdOrderByFileStoreValueIdFileStoreValueTimestampAsc(fileStoreUuid, measurementId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreValues/{measurementId}/last", produces = "application/json")
	public FileStoreValue getFileStoreByIdValuesByMeasurementIdLast(@PathVariable("fileStoreUuid") String fileStoreUuid, @PathVariable("measurementId") Long measurementId) {
		if(!repo.existsById(fileStoreUuid) || !measurementRepo.existsById(measurementId)){
			return null;
		}
		return valueRepo.findTop1ByFileStoreValueIdFileStoreValueFileStoreFileStoreUuidAndFileStoreValueIdFileStoreValueMeasurementIdOrderByFileStoreValueIdFileStoreValueTimestampDesc(fileStoreUuid, measurementId);
	}
		
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreValues/{measurementId}/max", produces = "application/json")
	public FileStoreValueWrapper<Long> getFileStoreByIdValuesByMeasurementIdMax(@PathVariable("fileStoreUuid") String fileStoreUuid, @PathVariable("measurementId") Long measurementId) {
		if(!repo.existsById(fileStoreUuid) || !measurementRepo.existsById(measurementId)){
			return null;
		}
		Set<FileStoreValue> values = valueRepo.findByFileStoreValueIdFileStoreValueFileStoreFileStoreUuidAndFileStoreValueIdFileStoreValueMeasurementId(fileStoreUuid, measurementId);
		Optional<FileStoreValue> fileStoreValueUsableSpace = values.stream().max(Comparator.comparing(FileStoreValue::getFileStoreValueUsableSpace, Comparator.nullsFirst(Comparator.naturalOrder())));
		return new FileStoreValueWrapper<Long>(fileStoreValueUsableSpace.isPresent()? fileStoreValueUsableSpace.get().getFileStoreValueUsableSpace() : null);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreValues/{measurementId}/min", produces = "application/json")
	public FileStoreValueWrapper<Long> getFileStoreByIdValuesByMeasurementIdMin(@PathVariable("fileStoreUuid") String fileStoreUuid, @PathVariable("measurementId") Long measurementId) {
		if(!repo.existsById(fileStoreUuid) || !measurementRepo.existsById(measurementId)){
			return null;
		}
		Set<FileStoreValue> values = valueRepo.findByFileStoreValueIdFileStoreValueFileStoreFileStoreUuidAndFileStoreValueIdFileStoreValueMeasurementId(fileStoreUuid, measurementId);
		Optional<FileStoreValue> fileStoreValueUsableSpace = values.stream().min(Comparator.comparing(FileStoreValue::getFileStoreValueUsableSpace, Comparator.nullsFirst(Comparator.naturalOrder())));
		return new FileStoreValueWrapper<Long>(fileStoreValueUsableSpace.isPresent()? fileStoreValueUsableSpace.get().getFileStoreValueUsableSpace() : null);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreValues/{measurementId}/avg", produces = "application/json")
	public FileStoreValueWrapper<Double> getFileStoreByIdValuesByMeasurementIdAvg(@PathVariable("fileStoreUuid") String fileStoreUuid, @PathVariable("measurementId") Long measurementId) {
		if(!repo.existsById(fileStoreUuid) || !measurementRepo.existsById(measurementId)){
			return null;
		}
		Set<FileStoreValue> values = valueRepo.findByFileStoreValueIdFileStoreValueFileStoreFileStoreUuidAndFileStoreValueIdFileStoreValueMeasurementId(fileStoreUuid, measurementId);
		Double fileStoreValueUsableSpace = values.stream().map(FileStoreValue::getFileStoreValueUsableSpace).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		fileStoreValueUsableSpace = Double.isNaN(fileStoreValueUsableSpace)? null: fileStoreValueUsableSpace;
		return new FileStoreValueWrapper<Double>(fileStoreValueUsableSpace);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreValues/{measurementId}/count", produces = "application/json")
	public FileStoreValueWrapper<Long> getFileStoreByIdValuesByMeasurementIdCount(@PathVariable("fileStoreUuid") String fileStoreUuid, @PathVariable("measurementId") Long measurementId) {
		if(!repo.existsById(fileStoreUuid) || !measurementRepo.existsById(measurementId)){
			return null;
		}
		Set<FileStoreValue> values = valueRepo.findByFileStoreValueIdFileStoreValueFileStoreFileStoreUuidAndFileStoreValueIdFileStoreValueMeasurementId(fileStoreUuid, measurementId);
		return new FileStoreValueWrapper<Long>(values.stream().map(FileStoreValue::getFileStoreValueUsableSpace).filter(x -> x!=null).count());
	}
	
	
}
