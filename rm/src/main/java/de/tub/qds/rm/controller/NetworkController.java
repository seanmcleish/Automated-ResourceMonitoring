package de.tub.qds.rm.controller;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.Network;
import de.tub.qds.rm.models.consts.repos.HardwareRepo;
import de.tub.qds.rm.models.consts.repos.MeasurementRepo;
import de.tub.qds.rm.models.consts.repos.NetworkRepo;
import de.tub.qds.rm.models.consts.repos.NetworkValueRepo;
import de.tub.qds.rm.models.values.NetworkValue;
import de.tub.qds.rm.models.values.pks.NetworkValuePK;
import de.tub.qds.rm.models.values.wrapper.NetworkValueWrapper;

//FINISHED IMPLEMENTATION & TESTED
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
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkHardware", produces = "application/json")
	public Set<Hardware> getNetworkByNetworkMacHardware(@PathVariable("networkMac") String networkMac) {
		return repo.existsById(networkMac) ? repo.findById(networkMac).get().getNetworkHardware() : null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/network/{networkMac}/networkHardware", produces = "application/json")
	public Set<Hardware> addNetworkByNetworkMacHardware(@PathVariable("networkMac") String networkMac, @RequestParam("hardwareId") Long hardwareId) {
		Network network = repo.findById(networkMac).orElse(null);
		Hardware hardware = hardwareRepo.findById(hardwareId).orElse(null);
		if(network == null || hardware == null){
			return null;
		}
		network.addNetworkHardware(hardware);
		return repo.save(network).getNetworkHardware();
	}
		
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkValues", produces = "application/json")
	public Set<NetworkValue> getNetworkValuesByNetworkMac(@PathVariable("networkMac") String networkMac) {
		Network network = repo.findById(networkMac).orElse(null);
		if(network == null){
			return null;
		}
		return valueRepo.findByNetworkValueIdNetworkValueNetworkNetworkMacOrderByNetworkValueIdNetworkValueTimestampAsc(networkMac);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/network/{networkMac}/networkValues", produces = "application/json")
	public NetworkValue addNetworkValueByNetworkMac(
			@PathVariable("networkMac") String networkMac,
			@RequestParam("measurementId") Long measurementId,
			@RequestParam(value="timestamp", required=false) Long timestamp,
			@RequestParam(value="networkValueBytesRecv", required=false) Long networkValueBytesRecv,
			@RequestParam(value="networkValueBytesSent", required=false) Long networkValueBytesSent,
			@RequestParam(value="networkValuePacketsRecv", required=false) Long networkValuePacketsRecv,
			@RequestParam(value="networkValuePacketsSent", required=false) Long networkValuePacketsSent,
			@RequestParam(value="networkValueInErrors", required=false) Long networkValueInErrors,
			@RequestParam(value="networkValueOutErrors", required=false) Long networkValueOutErrors
			){
		Network network = repo.findById(networkMac).orElse(null);
		if(network == null){
			return null;
		}
		NetworkValuePK pk = new NetworkValuePK(measurementId, new Timestamp(timestamp!=null? timestamp: System.currentTimeMillis()), network);
		return valueRepo.save(new NetworkValue(pk, networkValueBytesRecv,  networkValueBytesSent, networkValuePacketsRecv, networkValuePacketsSent, networkValueInErrors, networkValueOutErrors));
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
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkValues/{measurementId}/first", produces = "application/json")
	public NetworkValue getFirstNetworkValueByNetworkMacAndMeasurementId(@PathVariable("networkMac") String networkMac, @PathVariable("measurementId") Long measurementId) {
		Network network = repo.findById(networkMac).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(network == null || measurement == null){
			return null;
		}
		return valueRepo.findTop1ByNetworkValueIdNetworkValueNetworkNetworkMacAndNetworkValueIdNetworkValueMeasurementIdOrderByNetworkValueIdNetworkValueTimestampAsc(networkMac, measurementId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkValues/{measurementId}/last", produces = "application/json")
	public NetworkValue getLastNetworkValueByNetworkMacAndMeasurementId(@PathVariable("networkMac") String networkMac, @PathVariable("measurementId") Long measurementId) {
		Network network = repo.findById(networkMac).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(network == null || measurement == null){
			return null;
		}
		return valueRepo.findTop1ByNetworkValueIdNetworkValueNetworkNetworkMacAndNetworkValueIdNetworkValueMeasurementIdOrderByNetworkValueIdNetworkValueTimestampDesc(networkMac, measurementId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkValues/{measurementId}/max", produces = "application/json")
	public NetworkValueWrapper<Long> getMaxNetworkValueByNetworkMacAndMeasurementId(@PathVariable("networkMac") String networkMac, @PathVariable("measurementId") Long measurementId) {
		Network network = repo.findById(networkMac).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(network == null || measurement == null){
			return null;
		}
		Set<NetworkValue> values = valueRepo.findByNetworkValueIdNetworkValueNetworkNetworkMacAndNetworkValueIdNetworkValueMeasurementId(networkMac, measurementId);
		Optional<NetworkValue> networkValueBytesRecv = values.stream().max(Comparator.comparing(NetworkValue::getNetworkValueBytesRecv, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<NetworkValue> networkValueBytesSent = values.stream().max(Comparator.comparing(NetworkValue::getNetworkValueBytesSent, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<NetworkValue> networkValuePacketsRecv = values.stream().max(Comparator.comparing(NetworkValue::getNetworkValuePacketsRecv, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<NetworkValue> networkValuePacketsSent = values.stream().max(Comparator.comparing(NetworkValue::getNetworkValuePacketsSent, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<NetworkValue> networkValueInErrors = values.stream().max(Comparator.comparing(NetworkValue::getNetworkValueInErrors, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<NetworkValue> networkValueOutErrors = values.stream().max(Comparator.comparing(NetworkValue::getNetworkValueOutErrors, Comparator.nullsFirst(Comparator.naturalOrder())));
		return new NetworkValueWrapper<Long>(
				networkValueBytesRecv.isPresent() ? networkValueBytesRecv.get().getNetworkValueBytesRecv() : null, 
				networkValueBytesSent.isPresent() ? networkValueBytesSent.get().getNetworkValueBytesSent(): null, 
				networkValuePacketsRecv.isPresent() ? networkValuePacketsRecv.get().getNetworkValuePacketsRecv(): null, 
				networkValuePacketsSent.isPresent() ? networkValuePacketsSent.get().getNetworkValuePacketsSent(): null, 
				networkValueInErrors.isPresent() ? networkValueInErrors.get().getNetworkValueInErrors() : null, 
				networkValueOutErrors.isPresent() ? networkValueOutErrors.get().getNetworkValueOutErrors() : null);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkValues/{measurementId}/min", produces = "application/json")
	public NetworkValueWrapper<Long> getMinNetworkValueByNetworkMacAndMeasurementId(@PathVariable("networkMac") String networkMac, @PathVariable("measurementId") Long measurementId) {
		Network network = repo.findById(networkMac).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(network == null || measurement == null){
			return null;
		}
		Set<NetworkValue> values = valueRepo.findByNetworkValueIdNetworkValueNetworkNetworkMacAndNetworkValueIdNetworkValueMeasurementId(networkMac, measurementId);
		Optional<NetworkValue> networkValueBytesRecv = values.stream().min(Comparator.comparing(NetworkValue::getNetworkValueBytesRecv, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<NetworkValue> networkValueBytesSent = values.stream().min(Comparator.comparing(NetworkValue::getNetworkValueBytesSent, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<NetworkValue> networkValuePacketsRecv = values.stream().min(Comparator.comparing(NetworkValue::getNetworkValuePacketsRecv, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<NetworkValue> networkValuePacketsSent = values.stream().min(Comparator.comparing(NetworkValue::getNetworkValuePacketsSent, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<NetworkValue> networkValueInErrors = values.stream().min(Comparator.comparing(NetworkValue::getNetworkValueInErrors, Comparator.nullsFirst(Comparator.naturalOrder())));
		Optional<NetworkValue> networkValueOutErrors = values.stream().min(Comparator.comparing(NetworkValue::getNetworkValueOutErrors, Comparator.nullsFirst(Comparator.naturalOrder())));
		return new NetworkValueWrapper<Long>(
				networkValueBytesRecv.isPresent() ? networkValueBytesRecv.get().getNetworkValueBytesRecv() : null, 
				networkValueBytesSent.isPresent() ? networkValueBytesSent.get().getNetworkValueBytesSent(): null, 
				networkValuePacketsRecv.isPresent() ? networkValuePacketsRecv.get().getNetworkValuePacketsRecv(): null, 
				networkValuePacketsSent.isPresent() ? networkValuePacketsSent.get().getNetworkValuePacketsSent(): null, 
				networkValueInErrors.isPresent() ? networkValueInErrors.get().getNetworkValueInErrors() : null, 
				networkValueOutErrors.isPresent() ? networkValueOutErrors.get().getNetworkValueOutErrors() : null);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkValues/{measurementId}/avg", produces = "application/json")
	public NetworkValueWrapper<Double> getAvgNetworkValueByNetworkMacAndMeasurementId(@PathVariable("networkMac") String networkMac, @PathVariable("measurementId") Long measurementId) {
		Network network = repo.findById(networkMac).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(network == null || measurement == null){
			return null;
		}
		Set<NetworkValue> values = valueRepo.findByNetworkValueIdNetworkValueNetworkNetworkMacAndNetworkValueIdNetworkValueMeasurementId(networkMac, measurementId);
		Double networkValueBytesRecv = values.stream().map(NetworkValue::getNetworkValueBytesRecv).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double networkValueBytesSent = values.stream().map(NetworkValue::getNetworkValueBytesSent).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double networkValuePacketsRecv = values.stream().map(NetworkValue::getNetworkValuePacketsRecv).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double networkValuePacketsSent = values.stream().map(NetworkValue::getNetworkValuePacketsSent).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double networkValueInErrors = values.stream().map(NetworkValue::getNetworkValueInErrors).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		Double networkValueOutErrors = values.stream().map(NetworkValue::getNetworkValueOutErrors).filter(x -> x!=null).mapToLong(x -> x).average().orElse(Double.NaN);
		networkValueBytesRecv = Double.isNaN(networkValueBytesRecv)? null: networkValueBytesRecv;
		networkValueBytesSent = Double.isNaN(networkValueBytesSent)? null: networkValueBytesSent;
		networkValuePacketsRecv = Double.isNaN(networkValuePacketsRecv)? null: networkValuePacketsRecv;
		networkValuePacketsSent = Double.isNaN(networkValuePacketsSent)? null: networkValuePacketsSent;
		networkValueInErrors = Double.isNaN(networkValueInErrors)? null: networkValueInErrors;
		networkValueOutErrors = Double.isNaN(networkValueOutErrors)? null: networkValueOutErrors;
		return new NetworkValueWrapper<Double>(networkValueBytesRecv, networkValueBytesSent, networkValuePacketsRecv, networkValuePacketsSent, networkValueInErrors, networkValueOutErrors);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/network/{networkMac}/networkValues/{measurementId}/count", produces = "application/json")
	public NetworkValueWrapper<Long> getCountNetworkValueByNetworkMacAndMeasurementId(@PathVariable("networkMac") String networkMac, @PathVariable("measurementId") Long measurementId) {
		Network network = repo.findById(networkMac).orElse(null);
		Measurement measurement = measurementRepo.findById(measurementId).orElse(null);
		if(network == null || measurement == null){
			return null;
		}
		Set<NetworkValue> values = valueRepo.findByNetworkValueIdNetworkValueNetworkNetworkMacAndNetworkValueIdNetworkValueMeasurementId(networkMac, measurementId);
		Long networkValueBytesRecv = values.stream().map(NetworkValue::getNetworkValueBytesRecv).filter(x -> x!=null).count();
		Long networkValueBytesSent = values.stream().map(NetworkValue::getNetworkValueBytesSent).filter(x -> x!=null).count();
		Long networkValuePacketsRecv = values.stream().map(NetworkValue::getNetworkValuePacketsRecv).filter(x -> x!=null).count();
		Long networkValuePacketsSent = values.stream().map(NetworkValue::getNetworkValuePacketsSent).filter(x -> x!=null).count();
		Long networkValueInErrors = values.stream().map(NetworkValue::getNetworkValueInErrors).filter(x -> x!=null).count();
		Long networkValueOutErrors = values.stream().map(NetworkValue::getNetworkValueOutErrors).filter(x -> x!=null).count();
		return new NetworkValueWrapper<Long>(networkValueBytesRecv, networkValueBytesSent, networkValuePacketsRecv, networkValuePacketsSent, networkValueInErrors, networkValueOutErrors);
	}

	
}
