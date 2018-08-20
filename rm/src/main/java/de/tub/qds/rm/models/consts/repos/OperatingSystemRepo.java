package de.tub.qds.rm.models.consts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.consts.OperatingSystem;
import de.tub.qds.rm.models.consts.pks.OperatingSystemPK;

public interface OperatingSystemRepo extends JpaRepository<OperatingSystem, OperatingSystemPK> {
	
	public OperatingSystem findByOperatingSystemIdOperatingSystemIdentifier(long operatingSystemIdentifier);
	public boolean existsByOperatingSystemIdOperatingSystemIdentifier(long operatingSystemIdentifier);
}
