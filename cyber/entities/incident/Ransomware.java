package entities.incident;

import entities.enums.Severity;
import entities.incident.Incident;

public class Ransomware extends Incident
{
    private String encryptionAlgorithm;
    private String extensionName;
    private double ransomAmount;

    public Ransomware(Severity severity) 
    {
        super(severity);
    }

    public String getEncryptionAlgorithm() 
    {
        return encryptionAlgorithm;
    }

    public void setEncryptionAlgorithm(String encryptionAlgorithm) 
    {
        this.encryptionAlgorithm = encryptionAlgorithm;
    }

    public String getExtensionName() 
    {
        return extensionName;
    }

    public void setExtensionName(String extensionName) 
    {
        this.extensionName = extensionName;
    }

    public double getRansomAmount() 
    {
        return ransomAmount;
    }

    public void setRansomAmount(double ransomAmount) 
    {
        this.ransomAmount = ransomAmount;
    }
}