package de.tub.qds.rm2.models.consts;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import de.tub.qds.rm2.models.joinClasses.HardwareNetwork;
import de.tub.qds.rm2.models.values.NetworkValue;

@Entity
public class Network implements Serializable {

	@Id
	String networkMac;
	String networkName;
	String networkDisplayName;
	String networkIpv4;
	String networkIpv6;
	Long networkMtu;
	Long networkSpeed;
	@OneToMany(mappedBy = "networkValueId.networkValueNetwork")
	Set<NetworkValue> networkValues;

	public Network(){}

	public Network(String mac, String name, String displayName, String ipv4, String ipv6, Long mtu, Long speed) {
		super();
		this.networkMac = mac;
		this.networkName = name;
		this.networkDisplayName = displayName;
		this.networkIpv4 = ipv4;
		this.networkIpv6 = ipv6;
		this.networkMtu = mtu;
		this.networkSpeed = speed;
		this.networkValues = new HashSet<NetworkValue>();
	}
	
	public String getNetworkMac() {
		return networkMac;
	}

	public String getNetworkName() {
		return networkName;
	}

	public void setNetworkName(String name) {
		this.networkName = name;
	}

	public String getNetworkDisplayName() {
		return networkDisplayName;
	}

	public void setNetworkDisplayName(String displayName) {
		this.networkDisplayName = displayName;
	}

	public String getNetworkIpv4() {
		return networkIpv4;
	}

	public void setNetworkIpv4(String ipv4) {
		this.networkIpv4 = ipv4;
	}

	public String getNetworkIpv6() {
		return networkIpv6;
	}

	public void setNetworkIpv6(String ipv6) {
		this.networkIpv6 = ipv6;
	}

	public Long getNetworkMtu() {
		return networkMtu;
	}

	public void setNetworkMtu(Long mtu) {
		this.networkMtu = mtu;
	}

	public Long getNetworkSpeed() {
		return networkSpeed;
	}

	public void setNetworkSpeed(Long speed) {
		this.networkSpeed = speed;
	}

	public Set<NetworkValue> getNetworkValues() {
		return networkValues;
	}

	public void addNetworkValue(NetworkValue value) {
		networkValues.add(value);
	}

}
