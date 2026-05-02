package entities.incident;

import entities.enums.Severity;

public abstract class Incident
{
    // Used to generate unique incident IDs.
    private static int counter = 1;

    // Unique identifier for this incident, such as INC-001.
    private String incidentID;

    // Severity level assigned to this incident.
    private Severity severity;

    public Incident(Severity severity)
    {
        // Generate a formatted incident ID and then increase the counter.
        this.incidentID = ("INC-" + String.format("%03d", counter++));

        // Store the incident severity selected by the user.
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