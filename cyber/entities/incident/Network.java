package entities.incident;

import entities.enums.Severity;
import entities.incident.Incident;

public class Network extends Incident
{
    private String IP;
    private String MAC;
    private String subnetMask;
    private String networkStatus;
    private double bandwidthUsage;
    private String deviceType;
    private int VLANID;

    public Network(Severity severity) 
    {
        super(severity);
    }

    public String getIP() 
    {
        return IP;
    }

    public void setIP(String IP) 
    {
        this.IP = IP;
    }

    public String getMAC() 
    {
        return MAC;
    }

    public void setMAC(String MAC)
    {
        this.MAC = MAC;
    }

    public String getSubnetMask() 
    {
        return subnetMask;
    }

    public void setSubnetMask(String subnetMask) 
    {
        this.subnetMask = subnetMask;
    }

    public String getNetworkStatus() 
    {
        return networkStatus;
    }

    public void setNetworkStatus(String networkStatus) 
    {
        this.networkStatus = networkStatus;
    }

    public double getBandwidthUsage() 
    {
        return bandwidthUsage;
    }

    public void setBandwidthUsage(double bandwidthUsage) 
    {
        this.bandwidthUsage = bandwidthUsage;
    }

    public String getDeviceType() 
    {
        return deviceType;
    }

    public void setDeviceType(String deviceType) 
    {
        this.deviceType = deviceType;
    }

    public int getVLANID() 
    {
        return VLANID;
    }

    public void setVLANID(int VLANID) 
    {
        this.VLANID = VLANID;
    }
}