package entities;

import entities.Analyst;
import entities.incident.Incident;
import entities.enums.Risk;
import entities.enums.ResolutionStatus;
import java.time.LocalDateTime;

public class Log
{
    private String logID;
    private Incident incident;
    private LocalDateTime logTime;
    private Analyst loggedBy;
    private String description;
    private String cause;
    private Risk risk;
    private ResolutionStatus resolutionStatus;
}