package entities;

import entities.enums.AlertLevel;
import entities.enums.AlertType;
import java.time.LocalDateTime;

public class Alert
{
    // Used to generate unique alert IDs for each new alert.
    private static int counter = 1;

    // Unique identifier for this alert, such as A-01.
    private String alertID;

    // The log that caused or is connected to this alert.
    private Log log;

    // The seriousness level of the alert: LOW, MEDIUM, or HIGH.
    private AlertLevel level;

    // Shows whether the alert was created manually or automatically.
    private AlertType type;

    // Stores the date and time when this alert was created.
    private LocalDateTime triggerTime;

    public Alert(Log log, AlertType type, AlertLevel level)
    {
        // Connect this alert to the related incident log.
        this.log = log;

        // Generate a formatted alert ID and then increase the counter.
        this.alertID = ("A-" + String.format("%02d", counter++));

        // Store alert type and level.
        this.type = type;
        this.level = level;

        // Record the exact time the alert was triggered.
        this.triggerTime = LocalDateTime.now();
    }

    public String getAlertID() {
        return alertID;
    }

    public void setAlertID(String alertID) {
        this.alertID = alertID;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public AlertType getAlertType() {
        return type;
    }

    public void setAlertType(AlertType type) {
        this.type = type;
    }

    public AlertLevel getAlertLevel() {
        return level;
    }

    public void setAlertLevel(AlertLevel level) {
        this.level = level;
    }


    public LocalDateTime getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(LocalDateTime triggerTime) {
        this.triggerTime = triggerTime;
    }
}