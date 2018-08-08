package de.tub.qds.rm.models.consts.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.consts.Measurement;

public interface MeasurementRepo extends JpaRepository<Measurement, Integer> {
	List<Measurement> findByMeasurementIsRunningTrue();
}
