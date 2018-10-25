package de.tub.qds.rm.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Firmware;
import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.repos.FirmwareRepo;
import de.tub.qds.rm.models.consts.repos.HardwareRepo;


//FINISHED IMPLEMENTATION & TESTED
@RestController
public class FirmwareController {
	
	@Autowired
	FirmwareRepo repo;
	@Autowired
	HardwareRepo hardwareRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/firmware", produces = "application/json")
	public List<Firmware> getFirmwares() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/firmware", produces = "application/json")
	public Firmware postFirmware(
			@RequestParam(value="firmwareManufacturer", required=false) String firmwareManufacturer,
			@RequestParam(value="firmwareName", required=false) String firmwareName,
			@RequestParam(value="firmwareDescription", required=false) String firmwareDescription,
			@RequestParam(value="firmwareVersion", required=false) String firmwareVersion,
			@RequestParam(value="firmwareReleaseDate", required=false) String firmwareReleaseDate) {
		if(!repo.existsByFirmwareManufacturerAndFirmwareNameAndFirmwareDescriptionAndFirmwareVersionAndFirmwareReleaseDate
				(firmwareManufacturer, firmwareName, firmwareDescription, firmwareVersion, firmwareReleaseDate)){
			Firmware firmware = new Firmware(firmwareManufacturer, firmwareName, firmwareDescription, firmwareVersion, firmwareReleaseDate);
			return repo.save(firmware);
		}
		return repo.findByFirmwareManufacturerAndFirmwareNameAndFirmwareDescriptionAndFirmwareVersionAndFirmwareReleaseDate(firmwareManufacturer, firmwareName, firmwareDescription, firmwareVersion, firmwareReleaseDate);
	}	

	@RequestMapping(method = RequestMethod.GET, path = "/firmware/{firmwareIdentifier}", produces = "application/json")
	public Firmware getFirmwareByIdFirmwareIdentifier(@PathVariable("firmwareIdentifier") Long firmwareIdentifier) {
		return repo.findById(firmwareIdentifier).orElse(null);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/firmware/{firmwareIdentifier}", produces = "application/json")
	public Firmware updateFirmware(
			@PathVariable("firmwareIdentifier") Long firmwareIdentifier,
			@RequestParam(value="firmwareManufacturer", required=false) String firmwareManufacturer,
			@RequestParam(value="firmwareName", required=false) String firmwareName,
			@RequestParam(value="firmwareDescription", required=false) String firmwareDescription,
			@RequestParam(value="firmwareVersion", required=false) String firmwareVersion,
			@RequestParam(value="firmwareReleaseDate", required=false) String firmwareReleaseDate) {
		Firmware firmware = repo.findById(firmwareIdentifier).orElse(null);
		if(firmware != null){
			if(firmwareManufacturer != null){
				firmware.setFirmwareManufacturer(firmwareManufacturer);
			}
			if(firmwareName != null){
				firmware.setFirmwareName(firmwareName);
			}
			if(firmwareDescription != null){
				firmware.setFirmwareDescription(firmwareDescription);
			}
			if(firmwareVersion != null){
				firmware.setFirmwareVersion(firmwareVersion);
			}
			if(firmwareReleaseDate != null) {
				firmware.setFirmwareReleaseDate(firmwareReleaseDate);
			}
			return repo.save(firmware);
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/firmware/{firmwareIdentifier}", produces = "application/json")
	public void deleteFirmwareByIdFirmwareIdentifier(@PathVariable("firmwareIdentifier") Long firmwareIdentifier) {
		if(repo.existsById(firmwareIdentifier)){
			repo.deleteById(firmwareIdentifier);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/firmware/{firmwareIdentifier}/firmwareManufacturer", produces = "text/plain")
	public String getFirmwareByIdFirmwareIdentifierManufacturer(@PathVariable("firmwareIdentifier") Long firmwareIdentifier) {
		return repo.existsById(firmwareIdentifier) ? repo.findById(firmwareIdentifier).get().getFirmwareManufacturer() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/firmware/{firmwareIdentifier}/firmwareName", produces = "text/plain")
	public String getFirmwareByIdFirmwareIdentifierName(@PathVariable("firmwareIdentifier") Long firmwareIdentifier) {
		return repo.existsById(firmwareIdentifier) ? repo.findById(firmwareIdentifier).get().getFirmwareName() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/firmware/{firmwareIdentifier}/firmwareDescription", produces = "text/plain")
	public String getFirmwareByIdFirmwareIdentifierDescription(@PathVariable("firmwareIdentifier") Long firmwareIdentifier) {
		return repo.existsById(firmwareIdentifier) ? repo.findById(firmwareIdentifier).get().getFirmwareDescription() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/firmware/{firmwareIdentifier}/firmwareVersion", produces = "text/plain")
	public String getFirmwareByIdFirmwareIdentifierVersion(@PathVariable("firmwareIdentifier") Long firmwareIdentifier) {
		return repo.existsById(firmwareIdentifier) ? repo.findById(firmwareIdentifier).get().getFirmwareVersion() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/firmware/{firmwareIdentifier}/firmwareReleaseDate", produces = "text/plain")
	public String getFirmwareByIdFirmwareIdentifierReleaseDate(@PathVariable("firmwareIdentifier") Long firmwareIdentifier) {
		return repo.existsById(firmwareIdentifier) ? repo.findById(firmwareIdentifier).get().getFirmwareReleaseDate() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/firmware/{firmwareIdentifier}/firmwareHardware", produces = "application/json")
	public Set<Hardware> getFirmwareByIdFirmwareIdentifierHardware(@PathVariable("firmwareIdentifier") Long firmwareIdentifier) {
		return repo.existsById(firmwareIdentifier) ? repo.findById(firmwareIdentifier).get().getHardware(): null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/firmware/{firmwareIdentifier}/firmwareHardware", produces = "application/json")
	public Set<Hardware> addFirmwareByIdFirmwareIdentifierHardware(@PathVariable("firmwareIdentifier") Long firmwareIdentifier, @RequestParam("hardwareIdentifier") Long hardwareIdentifier){
		Firmware firmware = repo.findById(firmwareIdentifier).orElse(null);
		Hardware hardware = hardwareRepo.findById(hardwareIdentifier).orElse(null);
		if(firmware == null || hardware == null){
			return null;
		}
		firmware.addHardware(hardware);
		return repo.save(firmware).getHardware();
	}

}
