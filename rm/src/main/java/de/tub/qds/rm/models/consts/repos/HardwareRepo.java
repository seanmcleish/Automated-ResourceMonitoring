package de.tub.qds.rm.models.consts.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.consts.Baseboard;
import de.tub.qds.rm.models.consts.Firmware;
import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.Memory;
import de.tub.qds.rm.models.consts.Processor;
import de.tub.qds.rm.models.consts.SystemModel;

public interface HardwareRepo extends JpaRepository<Hardware, Long> {

	Optional<Hardware> findTop1ByHardwareSystemModelAndHardwareBaseboardAndHardwareFirmwareAndHardwareProcessorAndHardwareMemory(SystemModel systemModel, Baseboard baseboard, Firmware firmware, Processor processor, Memory memory);
}
