package org.fog.entities;
import org.cloudbus.cloudsim.core.CloudSim;
import org.fog.entities.FogDevice;
import org.fog.entities.Sensor;
import org.fog.gui.core.SensorGui;
import org.cloudbus.cloudsim.distributions.UniformDistr;
import org.fog.utils.FogLinearPowerModel;
import org.fog.utils.distribution.DeterministicDistribution;
import org.fog.utils.distribution.Distribution;
import org.fog.utils.distribution.UniformDistribution;

public class alaki {
    public static void main(String[] args) throws Exception {
        Sensor sensor1 = new Sensor("hossein","123",12, "56", new DeterministicDistribution(5));
        Sensor sensor2 = new Sensor("ali", "camera", 234, "dsfsd", new UniformDistribution(12, 23));

        FogDevice fog1 = new FogDevice("fog1", 2134, 1000, 1000, 1000, 0.4, new FogLinearPowerModel(13,14));
        FogDevice fogDevice = (FogDevice) CloudSim.getEntity(2);
    }
}
