package org.fog.gui.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cloudbus.cloudsim.Cloudlet;
import org.fog.entities.FogDevice;

public class alaki {
	static List<FogDevice> fogDevice = new ArrayList<FogDevice>();
	static List<Cloudlet> tasks = new ArrayList<Cloudlet>();
	public static void main(String[] args) {
    tasks.add(new Cloudlet(1, 12, 10, 20, 30, null, null, null, false, null));
    System.out.println(tasks.get(0).getCostPerSec());
    }
}
