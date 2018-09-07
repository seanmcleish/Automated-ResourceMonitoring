package de.tub.qds.rm.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.Network;
import de.tub.qds.rm.models.consts.repos.HardwareRepo;
import de.tub.qds.rm.models.consts.repos.MeasurementRepo;
import de.tub.qds.rm.models.consts.repos.NetworkRepo;
import de.tub.qds.rm.models.consts.repos.NetworkValueRepo;
import de.tub.qds.rm.models.values.NetworkValue;

@RestController
public class NetworkController {
	
	@Autowired
	NetworkRepo repo;
	@Autowired
	NetworkValueRepo valueRepo;
	@Autowired
	HardwareRepo hardwareRepo;
	@Autowired
	MeasurementRepo measurementRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/network", produces = "application/json")
	public List<Network> getNetworks() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/network", produces = "application/json")
	public Network postNetwork(
			@RequestParam("networkMac") String networkMac,
			@RequestParam(value="networkName", required=false) String networkName,
			@RequestParam(value="networkDisplayName", required=false) String networkDisplayName,
			@RequestParam(value="networkIpv4", required=false) String networkIpv4,
			@RequestParam(value="networkIpv6", required=false) String networkIpv6,
			@RequestParam(value="networkMtu", required=false) Long networkMtu,
			@RequestParam(value="networkSpeed", required=false) Long networkSpeed
			) {
		Network network = repo.findById(networkMac).orElse(null);
		if(network != null){
			return network;
		}
		network = new Network(networkMac, networkName, networkDisplayName, networkIpv4, networkIpv6, networkMtu, networkSpeed);
		return repo.save(network);		
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}", produces = "application/json")
	public Network getNetworkByNetworkMac(@PathVariable("networkMac") String networkMac) {
		return repo.existsById(networkMac) ? repo.findById(networkMac).get() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/network/{networkMac}", produces = "application/json")
	public Network updateNetwork(
			@PathVariable("networkMac") String networkMac,
			@RequestParam(value="networkName", required=false) String networkName,
			@RequestParam(value="networkDisplayName", required=false) String networkDisplayName,
			@RequestParam(value="networkIpv4", required=false) String networkIpv4,
			@RequestParam(value="networkIpv6", required=false) String networkIpv6,
			@RequestParam(value="networkMtu", required=false) Long networkMtu,
			@RequestParam(value="networkSpeed", required=false) Long networkSpeed
			) {
		Network network = repo.findById(networkMac).orElse(null);
		if(network == null){
			return null;
		}
		if(networkName != null){
			network.setNetworkName(networkName);
		}
		if(networkDisplayName != null){
			network.setNetworkDisplayName(networkDisplayName);
		}
		if(networkIpv4 != null){
			network.setNetworkIpv4(networkIpv4);
		}
		if(networkIpv6 != null){
			network.setNetworkIpv6(networkIpv6);
		}
		if(networkMtu != null){
			network.setNetworkMtu(networkMtu);
		}
		if(networkSpeed != null){
			network.setNetworkSpeed(networkSpeed);
		}
		return repo.save(network);		
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
		Network network = repo.findById(networkMac).orElse(null);
		if(network == null){
			return null;
		}
		return valueRepo.findByNetworkValueIdNetworkValueNetworkNetworkMacOrderByNetworkValueIdNetworkValueTimestampAsc(networkMac);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkValues/{measurementId}", produces = "application/json")
	public Set<NetworkValue> getNetworkByNetworkMacValuesAndMeasurementId(@PathVariable("networkMac") String networkMac, @PathVariable("measurementId") Long measurementId) {
		Network network = repo.findById(networkMac).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(network == null || measurement == null){
			return null;
		}
		return valueRepo.findByNetworkValueIdNetworkValueNetworkNetworkMacAndNetworkValueIdNetworkValueMeasurementIdOrderByNetworkValueIdNetworkValueTimestampAsc(networkMac, measurementId);
	}

}
