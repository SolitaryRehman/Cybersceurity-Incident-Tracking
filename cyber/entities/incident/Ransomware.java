import entities.enums.Severity;
import entities.incident.Incident;

public class Ransomware extends Incident
{
    private String encryptionAlgorithm;
    private String extensionName;
    private double ransomAmount;

    public Ransomware(Severity severity) {
        super(severity);
    }
}