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
    }
}