package de.tub.qds.rm.models.consts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.pks.HardwarePK;



public interface HardwareRepo extends JpaRepository<Hardware, HardwarePK> {

}
