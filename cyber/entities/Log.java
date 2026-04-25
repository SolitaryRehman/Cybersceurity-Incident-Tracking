package entities;

import entities.Analyst;
import entities.incident.Incident;
import entities.enums.Risk;
import entities.enums.ResolutionStatus;
import java.time.LocalDateTime;

public class Log
{
    private static int counter = 1;
    private String logID;
    private Incident incident;
    private LocalDateTime logTime;
    private Analyst loggedBy;
    private String description;
    private String cause;
    private Risk risk;
    private ResolutionStatus resolutionStatus;

    public Log(Incident incident, Analyst loggedBy, String desc,
               String cause, Risk risk, ResolutionStatus status)
    {
        this.logID = ("LOG-" + String.format("%02d", counter++));
        this.incident = incident;
        this.loggedBy = loggedBy;
        this.logTime = LocalDateTime.now();
        this.description = desc;
        this.cause = cause;
        this.risk = risk;
        this.resolutionStatus =  status;
    }

    public String getLogID() {
        return logID;
    }

    public void setLogID(String logID) {
        this.logID = logID;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public LocalDateTime getLogTime() {
        return logTime;
    }

    public void setLogTime(LocalDateTime logTime) {
        this.logTime = logTime;
    }

    public Analyst getLoggedBy() {
        return loggedBy;
    }

    public void setLoggedBy(Analyst loggedBy) {
        this.loggedBy = loggedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }

    public ResolutionStatus getResolutionStatus() {
        return resolutionStatus;
    }

    public void setResolutionStatus(ResolutionStatus resolutionStatus) {
        this.resolutionStatus = resolutionStatus;
    }

}