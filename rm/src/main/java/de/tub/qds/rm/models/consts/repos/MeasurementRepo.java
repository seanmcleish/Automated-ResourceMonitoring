package de.tub.qds.rm.models.consts.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.Rate;

public interface MeasurementRepo extends JpaRepository<Measurement, Long> {
	List<Measurement> findByMeasurementRunningTrue();
	List<Measurement> findByMeasurementRunningTrueAndMeasurementRate(Rate rate);
}
