package de.tub.qds.rm.models.values.wrapper;

import java.io.Serializable;

public class FileStoreValueWrapper<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	T fileStoreValueUsableSpace;
	
	public FileStoreValueWrapper (T fileStoreValueUsableSpace){
		this.fileStoreValueUsableSpace = fileStoreValueUsableSpace;
	}

	public T getFileStoreValueUsableSpace() {
		return fileStoreValueUsableSpace;
	}

	public void setFileStoreValueUsableSpace(T fileStoreValueUsableSpace) {
		this.fileStoreValueUsableSpace = fileStoreValueUsableSpace;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	

}
