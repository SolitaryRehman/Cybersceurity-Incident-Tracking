package entities;

import entities.enums.AlertLevel;
import entities.enums.AlertType;
import java.time.LocalDateTime;

public class Alert
{
    private static int counter = 1;
    private String alertID;
    private Log log;
    private AlertLevel level;
    private AlertType type;
    private LocalDateTime triggerTime;

    public Alert(Log log, AlertType type, AlertLevel level)
    {
        this.log = log;
        this.alertID = ("A-" + String.format("%02d", counter++));
        this.type = type;
        this.level = level;
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