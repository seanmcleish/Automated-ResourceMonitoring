package de.tub.qds.rm.models.consts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.values.ProcessValue;
import de.tub.qds.rm.models.values.pks.ProcessValuePK;

public interface ProcessValueRepo extends JpaRepository<ProcessValue, ProcessValuePK> {

}
