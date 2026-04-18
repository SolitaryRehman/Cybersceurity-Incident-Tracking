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

    public Network(Severity severity) {
        super(severity);
    }
}