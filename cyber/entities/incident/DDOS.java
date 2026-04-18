import entities.incident.Incident;

import entities.enums.Severity;

public class DDOS extends Incident
{
    private long trafficVolume;
    private String sourceIPRange;
    private String protocolType;
    private int targetPort;

    public DDOS(Severity severity) {
        super(severity);
    }
}