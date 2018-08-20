package de.tub.qds.rm.models.consts.repos;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.joinClasses.HardwareNetwork;

public interface HardwareNetworkRepo extends JpaRepository<HardwareNetwork, Long> {

	Set<HardwareNetwork>findByHardwareIdentifier(long hardwareIdentifier);
	Set<HardwareNetwork>findByNetworkMac(String networkMac);
}
