package de.tub.qds.rm.models.consts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.consts.Firmware;

public interface FirmwareRepo extends JpaRepository<Firmware, Long> {
	
	Firmware findByFirmwareManufacturerAndFirmwareNameAndFirmwareDescriptionAndFirmwareVersionAndFirmwareReleaseDate
	(String firmwareManufacturer, String firmwareName, String firmwareDescription, String firmwareVersion, String firmwareReleaseDate);
	Boolean existsByFirmwareManufacturerAndFirmwareNameAndFirmwareDescriptionAndFirmwareVersionAndFirmwareReleaseDate
	(String firmwareManufacturer, String firmwareName, String firmwareDescription, String firmwareVersion, String firmwareReleaseDate);
}
