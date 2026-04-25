package entities.incident;

import entities.incident.Incident;

import entities.enums.Severity;

public class DDOS extends Incident
{
    private long trafficVolume;
    private String sourceIPRange;
    private String protocolType;
    private int targetPort;

    public DDOS(Severity severity) 
    {
        super(severity);
    }

    public long getTrafficVolume() 
    {
        return trafficVolume;
    }

    public void setTrafficVolume(long trafficVolume) 
    {
        this.trafficVolume = trafficVolume;
    }

    public String getSourceIPRange() 
    {
        return sourceIPRange;
    }

    public void setSourceIPRange(String sourceIPRange) 
    {
        this.sourceIPRange = sourceIPRange;
    }

    public String getProtocolType() 
    {
        return protocolType;
    }

    public void setProtocolType(String protocolType)
    {
        this.protocolType = protocolType;
    }

    public int getTargetPort() 
    {
        return targetPort;
    }

    public void setTargetPort(int targetPort) 
    {
        this.targetPort = targetPort;
    }
}