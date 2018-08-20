package de.tub.qds.rm.models.consts.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import de.tub.qds.rm.models.values.MemoryValue;
import de.tub.qds.rm.models.values.pks.MemoryValuePK;

public interface MemoryValueRepo extends JpaRepository<MemoryValue, MemoryValuePK> {

}
