package de.tub.qds.rm.models.consts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.consts.System;
import de.tub.qds.rm.models.consts.pks.SystemPK;;

public interface SystemRepo extends JpaRepository<System, SystemPK> {

}
