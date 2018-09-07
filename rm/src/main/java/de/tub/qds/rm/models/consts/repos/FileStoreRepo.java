package de.tub.qds.rm.models.consts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.consts.FileStore;

public interface FileStoreRepo extends JpaRepository<FileStore, String> {
	
	

}
