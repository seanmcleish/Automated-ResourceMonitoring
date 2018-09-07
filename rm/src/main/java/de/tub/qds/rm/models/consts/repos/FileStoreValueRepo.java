package de.tub.qds.rm.models.consts.repos;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.values.FileStoreValue;
import de.tub.qds.rm.models.values.pks.FileStoreValuePK;

public interface FileStoreValueRepo extends JpaRepository<FileStoreValue, FileStoreValuePK> {

	Set<FileStoreValue> findByFileStoreValueIdFileStoreValueFileStoreFileStoreUuidOrderByFileStoreValueIdFileStoreValueTimestampAsc(String fileStoreUuid);
	Set<FileStoreValue> findByFileStoreValueIdFileStoreValueFileStoreFileStoreUuidAndFileStoreValueIdFileStoreValueMeasurementId(String fileStoreUuid, Long measurementId);
	Set<FileStoreValue> findByFileStoreValueIdFileStoreValueFileStoreFileStoreUuidAndFileStoreValueIdFileStoreValueMeasurementIdOrderByFileStoreValueIdFileStoreValueTimestampAsc(String fileStoreUuid, Long measurementId);
}
