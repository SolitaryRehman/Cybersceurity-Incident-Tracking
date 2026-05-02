package entities;

import entities.Analyst;
import entities.incident.Incident;
import entities.enums.Risk;
import entities.enums.ResolutionStatus;
import java.time.LocalDateTime;

public class Log
{
    // Used to generate unique log IDs.
    private static int counter = 1;

    // Unique identifier for this log, such as LOG-01.
    private String logID;

    // The cybersecurity incident recorded in this log.
    private Incident incident;

    // Date and time when the log was created.
    private LocalDateTime logTime;

    // Analyst who created or updated this log.
    private Analyst loggedBy;

    // Human-readable explanation of what happened.
    private String description;

    // Reason or suspected cause of the incident.
    private String cause;

    // Risk level assigned to this incident log.
    private Risk risk;

    // Current progress/status of the incident resolution.
    private ResolutionStatus resolutionStatus;

    public Log(Incident incident, Analyst loggedBy, String desc,
               String cause, Risk risk, ResolutionStatus status)
    {
        // Generate a formatted log ID and then increase the counter.
        this.logID = ("LOG-" + String.format("%02d", counter++));

        // Store the incident and analyst connected to this log.
        this.incident = incident;
        this.loggedBy = loggedBy;

        // Record the current time as the log creation time.
        this.logTime = LocalDateTime.now();

        // Store the log details entered by the analyst.
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