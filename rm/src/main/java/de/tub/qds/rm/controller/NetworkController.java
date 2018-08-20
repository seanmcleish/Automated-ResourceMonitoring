package de.tub.qds.rm.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.Network;
import de.tub.qds.rm.models.consts.repos.HardwareNetworkRepo;
import de.tub.qds.rm.models.consts.repos.HardwareRepo;
import de.tub.qds.rm.models.consts.repos.NetworkRepo;
import de.tub.qds.rm.models.values.NetworkValue;

@RestController
public class NetworkController {
	
	@Autowired
	NetworkRepo repo;
	@Autowired
	HardwareRepo hardwareRepo;
	@Autowired
	HardwareNetworkRepo hardwareNetworkRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/network", produces = "application/json")
	public List<Network> getNetworks() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}", produces = "application/json")
	public Network getNetworkByNetworkMac(@PathVariable("networkMac") String networkMac) {
		return repo.existsById(networkMac) ? repo.findById(networkMac).get() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkName", produces = "text/plain")
	public String getNetworkByNetworkMacName(@PathVariable("networkMac") String networkMac) {
		return repo.existsById(networkMac) ? repo.findById(networkMac).get().getNetworkName() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkDisplayName", produces = "text/plain")
	public String getNetworkByNetworkMacDisplayName(@PathVariable("networkMac") String networkMac) {
		return repo.existsById(networkMac) ? repo.findById(networkMac).get().getNetworkDisplayName() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkIpv4", produces = "text/plain")
	public String getNetworkByNetworkMacIpv4(@PathVariable("networkMac") String networkMac) {
		return repo.existsById(networkMac) ? repo.findById(networkMac).get().getNetworkIpv4() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkIpv6", produces = "text/plain")
	public String getNetworkByNetworkMacIpv6(@PathVariable("networkMac") String networkMac) {
		return repo.existsById(networkMac) ? repo.findById(networkMac).get().getNetworkIpv6() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkMtu", produces = "application/json")
	public Long getNetworkByNetworkMacMtu(@PathVariable("networkMac") String networkMac) {
		return repo.existsById(networkMac) ? repo.findById(networkMac).get().getNetworkMtu() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkSpeed", produces = "application/json")
	public Long getNetworkByNetworkMacSpeed(@PathVariable("networkMac") String networkMac) {
		return repo.existsById(networkMac) ? repo.findById(networkMac).get().getNetworkSpeed() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkValues", produces = "application/json")
	public Set<NetworkValue> getNetworkByNetworkMacValues(@PathVariable("networkMac") String networkMac) {
		return repo.existsById(networkMac) ? repo.findById(networkMac).get().getNetworkValues() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkHardware", produces = "application/json")
	public Set<Hardware> getNetworkByNetworkMacHardware(@PathVariable("networkMac") String networkMac) {
		Set<Hardware> hardware = new HashSet<Hardware>();
		hardwareNetworkRepo.findByNetworkMac(networkMac).forEach(x -> hardware.add(hardwareRepo.findByHardwareIdHardwareIdentifier(x.getHardwareIdentifier())));
		return hardware;
	}


}
