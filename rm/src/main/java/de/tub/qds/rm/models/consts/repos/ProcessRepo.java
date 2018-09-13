package de.tub.qds.rm.models.consts.repos;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.Process;

public interface ProcessRepo extends JpaRepository<Process, Long> {
	
	Set<Process> findByProcessMeasurement(Measurement measurement);
	Set<Process> findByProcessMeasurementAndProcessPidIsNull(Measurement measurement);

}
