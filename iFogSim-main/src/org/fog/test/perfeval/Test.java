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
 * Simulation setup for case study 2 - Intelligent Surveillance
 * @author Harshit Gupta
 *
 */
public class Test {
    static List<FogDevice> highLevelFog = new ArrayList<FogDevice>();
    static List<FogDevice> lowLevelFog = new ArrayList<FogDevice>();
    static List<Sensor> sensors = new ArrayList<Sensor>();
    static int numOfDepts = 1;
    static boolean diffResource = true;
    static Integer deviceNum = 0;
    //    static int numOfAreas = 1;

    private static boolean CLOUD = false;

    public static void main(String[] args) throws Exception {
        Log.printLine("Believe it or not, your simulation process has been started .... ");
        try {
            Log.disable();


        } catch (Exception e) {
            e.printStackTrace();
            Log.printLine("Unwanted errors happen");
            int num_user = 1;
            Calendar calendar = Calendar.getInstance();
            boolean trace_flag = false;

            CloudSim.init(num_user, calendar, trace_flag);
            String appId = "task-rep";
            FogBroker broker = new FogBroker("broker");


        }
    }


    private static void createFogDevices(int userId) {
        FogDevice cloud = createFogDevice("cloud", 80000000, 49152000, 100, 12500000,
                0, 0.01, 16 * 103, 16 * 83.25, MicroserviceFogDevice.CLOUD);
    }


    private static MicroserviceFogDevice createFogDevice(String nodeName, long mips, int ram, long upBw, long downBW, int level, double ratePerMips,
                                                         double busyPower, double idlePower, String deviceType) {
        List<Pe> peList = new ArrayList<Pe>();
        peList.add((new Pe(0, new PeProvisionerOverbooking(mips))));
        int hostId = FogUtils.generateEntityId();
        long storage = 1000000;
        int bw = 100000;
        PowerHost host = new PowerHost(
                hostId,
                new RamProvisionerSimple(ram),
                new BwProvisionerOverbooking(bw),
                storage,
                peList,
                new StreamOperatorScheduler(peList),
                new FogLinearPowerModel(busyPower, idlePower)
        );
    List<Host> hostList = new ArrayList<Host>();
    hostList.add(host);
    String arch = "x86";
    String os = "Linux";
    String vmm = "Xen";
    double time_zone = 10;
    double cost = 3;
    double costPerMem = 0.05;
    double costPerStorage = 0.01;
    double costPerBw = 0.0;

    LinkedList<Storage> storageList = new LinkedList<Storage>();
FogDeviceCharacteristics characteristics = new FogDeviceCharacteristics(
        arch, os, vmm, host, time_zone, cost, costPerMem, costPerStorage, costPerBw
);
MicroserviceFogDevice fogDevice = null;
try{
    fogDevice  = new MicroserviceFogDevice(nodeName, characteristics, new AppModuleAllocationPolicy(hostList), storageList, 10, upBw, downBW,
            1250000, 0, ratePerMips, deviceType);
}catch (Exception e){
    e.printStackTrace();
}
fogDevice.setLevel(level);
return fogDevice;
    }

}









