package de.tub.qds.rm2.models.consts.pks;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import de.tub.qds.rm2.models.consts.Hardware;
import de.tub.qds.rm2.models.consts.OperatingSystem;


@Embeddable
public class SystemPK implements Serializable {

	String systemHostName;
	@ManyToOne
	OperatingSystem systemOperatingSystem;
	@ManyToOne
	Hardware systemHardware;

	public SystemPK(){}

	public SystemPK(String hostName, OperatingSystem operatingSystem ,Hardware hardware) {
		super();
		this.systemHostName = hostName;
		this.systemOperatingSystem = operatingSystem;
		this.systemHardware = hardware;
	}



	public String getSystemHostName() {
		return systemHostName;
	}

	public OperatingSystem getSystemOperatingSystem() {
		return systemOperatingSystem;
	}

	public Hardware getSystemHardware() {
		return systemHardware;
	}

}
