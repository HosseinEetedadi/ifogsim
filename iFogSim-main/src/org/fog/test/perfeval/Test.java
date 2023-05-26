package org.fog.test.perfeval;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.Pe;
import org.cloudbus.cloudsim.Storage;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.power.PowerHost;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;
import org.cloudbus.cloudsim.sdn.overbooking.BwProvisionerOverbooking;
import org.cloudbus.cloudsim.sdn.overbooking.PeProvisionerOverbooking;
import org.fog.application.AppEdge;
import org.fog.application.AppLoop;
import org.fog.application.Application;
import org.fog.application.selectivity.FractionalSelectivity;
import org.fog.entities.*;
import org.fog.placement.Controller;
import org.fog.placement.ModuleMapping;
import org.fog.placement.ModulePlacementEdgewards;
import org.fog.placement.ModulePlacementMapping;
import org.fog.policy.AppModuleAllocationPolicy;
import org.fog.scheduler.StreamOperatorScheduler;
import org.fog.utils.FogLinearPowerModel;
import org.fog.utils.FogUtils;
import org.fog.utils.TimeKeeper;
import org.fog.utils.distribution.DeterministicDistribution;

/**
 * Simulation setup for case study 2 - for test
 * 
 * @author Hossein Etedadi
 *
 */
public class Test {
	static List<FogDevice> fogDevice;
//	static List<FogDevice> highLevelFog = new ArrayList<FogDevice>();
	static List<Cloudlet> cloudletList = new ArrayList<Cloudlet>();

	static boolean CLOUD = false;

	static int numOfIoTDevices = 20;

	public static void main(String[] args) throws Exception {
		Log.printLine("Simulating process has started....");

		int num_user = 1;
		Calendar calendar = Calendar.getInstance();
		boolean trace_flag = false;
		CloudSim.init(num_user, calendar, trace_flag);

		String appId = "Task_Scheduling";
		FogBroker broker = new FogBroker("broker");
		fogDevice = createFogDevices(broker.getId(), 4);
		cloudletList = createCloudlet(broker.getId(), 60);
		
		broker.submitCloudletList(cloudletList);

	}

	public static List<FogDevice> createFogDevices(int brokerId, int fogNumber) {
		
		for(int i=0; i<fogNumber;i++) {
			
		}
		return fogDevice;
	}
	
public static List<Cloudlet> createCloudlet(int brokerId, int cloudletNumber) {
		
		return cloudletList;
	}







public static FogDevice createFogDevice(String nodeName, long mips, int ram, long upBw, long downBw, int level,
		double ratePerMips, double busyPower, double idlePower) {
	List<Pe> peList = new ArrayList<Pe>();
	peList.add(new Pe(0, new PeProvisionerOverbooking(mips))); // need to store Pe id and MIPS Rating
	
	int hostId = FogUtils.generateEntityId();
	long storage = 1000000; // host storage
	int bw = 10000;

	PowerHost host = new PowerHost(hostId, new RamProvisionerSimple(ram), new BwProvisionerOverbooking(bw), storage,
			peList, new StreamOperatorScheduler(peList), new FogLinearPowerModel(busyPower, idlePower));
	List<Host> hostList = new ArrayList<Host>();
	hostList.add(host);
	String arch = "x86"; // system architecture
	String os = "Linux"; // operating system
	String vmm = "Xen";
	double time_zone = 10.0; // time zone this resource located
	double cost = 3.0; // the cost of using processing in this resource
	double costPerMem = 0.05; // the cost of using memory in this resource
	double costPerStorage = 0.001; // the cost of using storage in this
	// resource
	double costPerBw = 0.0; // the cost of using bw in this resource
	LinkedList<Storage> storageList = new LinkedList<Storage>(); // we are not adding SAN
	// devices by now
	FogDeviceCharacteristics characteristics = new FogDeviceCharacteristics(arch, os, vmm, host, time_zone, cost,
			costPerMem, costPerStorage, costPerBw);
	FogDevice fogdevice = null;
	try {
		fogdevice = new FogDevice(nodeName, characteristics, new AppModuleAllocationPolicy(hostList), storageList,
				10, upBw, downBw, 0, ratePerMips);
	} catch (Exception e) {
		e.printStackTrace();
	}
	fogdevice.setLevel(level); 
	return fogdevice;
}
}


