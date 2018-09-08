package de.tub.qds.rm.models.consts.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.consts.OperatingSystem;


public interface OperatingSystemRepo extends JpaRepository<OperatingSystem, Long> {
	Optional<OperatingSystem> findByOperatingSystemManufacturerAndOperatingSystemFamilyAndOperatingSystemVersionAndOperatingSystemCodeNameAndOperatingSystemBuild(
			String operatingSystemManufacturer,String operatingSystemFamily,
			String operatingSystemVersion,
			String operatingSystemCodeName,
			String operatingSystemBuild);
	
}
