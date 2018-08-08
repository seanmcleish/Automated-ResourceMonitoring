package de.tub.qds.rm.models.consts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.joinClasses.HardwareDisk;

public interface HardwareDiskRepo extends JpaRepository<HardwareDisk, Integer> {

}
