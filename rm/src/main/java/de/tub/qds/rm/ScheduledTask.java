package de.tub.qds.rm;

import java.sql.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.Memory;
import de.tub.qds.rm.models.consts.repos.MeasurementRepo;
import de.tub.qds.rm.models.consts.repos.MemoryRepo;
import de.tub.qds.rm.models.values.MemoryValue;
import de.tub.qds.rm.models.values.pks.MemoryValuePK;

@Component
public class ScheduledTask {
	@Autowired
	MemoryRepo memRepo;
	@Autowired
	MeasurementRepo measurementRepo;

	@Scheduled(fixedRate = 1000)
	public void execute() {
		
		List<Measurement> measurements = measurementRepo.findByMeasurementIsRunningTrue();
		for(Measurement measurement: measurements){
			//System.out.println("Messung gefunden!: "+ measurement.getMeasurementId());
			JSONObject obj;
			try {
				obj = Unirest.get("http://localhost:8090/systemInfo/hardware/memory").asJson().getBody().getObject();
				long total = obj.optLong("total");
				long available = obj.optLong("available");
				long swapTotal = obj.optLong("swapTotal");
				long swapUsed = obj.optLong("swapUsed");
				Memory memory = memRepo.findById(total).get();
				MemoryValuePK pk = new MemoryValuePK( memory, measurement.getMeasurementId(), new Date(System.currentTimeMillis()));
				memory.addMemoryValue(new MemoryValue(pk, available, swapTotal, swapUsed));
				memRepo.save(memory);
			} catch (UnirestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*JSONObject obj;
		long total;
		long available;
		long swapTotal;
		long swapUsed;
		Memory memory;
		
		try {
			obj = Unirest.get("http://localhost:8090/systemInfo/hardware/memory").asJson().getBody().getObject();
			total = obj.optLong("total");
			available = obj.optLong("available");
			swapTotal = obj.optLong("swapTotal");
			swapUsed = obj.optLong("swapUsed");
			if(memRepo.existsById(total)){
				memory=memRepo.getOne(total);
			}else{
				memory = memRepo.save(new Memory(total));
			}
			memory.values.add(new MemoryValue(available));
			memRepo.save(memory);
			System.out.println("Current Memory: " + memory.getMemorySize());
			System.out.println("Saved values: ");
			for(MemoryValue value : memory.values){
				System.out.println("Value: [ID] "+ value.getId()+ ", [TIMESTAMP] "+ value.getTimestamp() + ", [VALUE] "+ value.getValue());
			}
			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}*/
		
		/*System.out.println("Test");
		//Memory mem = memRepo.save(new Memory());
		System.out.println(memRepo.count());
		JSONObject obj;
		try {
			obj = Unirest.get("http://localhost:8090/systemInfo/hardware/memory").asJson().getBody().getObject();
			obj.optLong("total");
			System.out.println("Total: " + obj.optLong("total")+ " Available: "+ obj.optLong("available"));
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}*/
		
		

	}
	/*
	 * memory.addMemoryValue( new MemoryValue(new MemoryValuePK(1, new Date(),
	 * memory), available, swapTotal, swapUsed));
	 * System.out.println("Current collected values: "); Set<MemoryValue> list =
	 * memory.getMemoryValues(); for (MemoryValue value : list) {
	 * 
	 * System.out.println("Timestamp: " + new Date().toString() + " " +
	 * "available: " + available + " " + "swapTotal: " + swapTotal + " " +
	 * "swapUsed: " + swapUsed); System.out.println("");
	 * if(memRepo.findById(total).isPresent()){ memory =
	 * memRepo.findById(total).get(); }else{ memory = new Memory(total); }
	 * memRepo.save(memory); //memory.addMemoryValue(new MemoryValue());
	 *
	 * Memory mem; if(memRepo.existsById(10000L)){ mem =
	 * memRepo.findById(10000L).get(); } mem = memRepo.save(new Memory(10000));
	 * mem.addValue(new MemoryValue(System.currentTimeMillis()));
	 * System.out.println("Current values: "); for(MemoryValue val :
	 * mem.getValues()){ System.out.println("ValueId: "+ val.value +
	 * " Value: "+val.value); }
	 */
	// }

	public void add(String s) {
		// arr.add(s);
	}

	public void enable() {
		// enabled = true;
	}

	public void disable() {
		// abled = false;
	}
}
