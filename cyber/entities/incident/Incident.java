package entities.incident;

import entities.enums.Severity;

public abstract class Incident
{
    private static int counter = 1;
    private String incidentID;
    private Severity severity;

    public Incident(Severity severity)

    {
        this.incidentID = ("INC-" + String.format("%03d", counter++));
        this.severity = severity;
    }

    public static int getCounter() 
    {
        return counter;
    }

    private static void setCounter(int counter) 
    {
        Incident.counter = counter;
    }

    public String getIncidentID() 
    {
        return incidentID;
    }

    private void setIncidentID(String incidentID) 
    {
        this.incidentID = incidentID;
    }

    public Severity getSeverity() 
    {
        return severity;
    }

    public void setSeverity(Severity severity) 
    {
        this.severity = severity;
    }
}