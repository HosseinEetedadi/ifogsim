package org.fog.test.perfeval;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

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
	static List<FogDevice>lowLevelFog = new ArrayList<FogDevice>();
	static List<FogDevice> highLevelFog = new ArrayList<FogDevice>();
	static List<Sensor> sensors = new ArrayList<Sensor>();
	
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
		
		
	}
	
	
}
