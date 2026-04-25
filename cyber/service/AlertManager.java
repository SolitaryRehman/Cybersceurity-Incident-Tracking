package service;

import entities.Alert;
import entities.Log;
import entities.enums.AlertLevel;
import entities.enums.AlertType;
import java.util.Vector;

public class AlertManager
{
    private Vector<Alert> alerts;

    public AlertManager()
    {
        this.alerts = new Vector<>();
    }

    public Vector<Alert> getAlerts()
    {
        return alerts;
    }

    public void setAlerts(Vector<Alert> alerts)
    {
        this.alerts = alerts;
    }

    public Alert createAlert(Log log, AlertType type, AlertLevel level)
    {
        Alert alert = new Alert(log, type, level);
        alerts.add(alert);
        switch(level)
        {
            case LOW:
                // Only for the technical/junior guys
                System.out.println("[IT NOTIFICATION]: Routine event logged. Assigned to Junior Analyst.");
                break;

            case MEDIUM:
                System.out.println("[MANAGEMENT ALERT]: Potential security threat. Managerial oversight required.");
                break;

            case HIGH:
                System.out.println("[EMERGENCY BROADCAST]: Critical security breach! Executives and All Staff notified.");
                break;

        }
        return alert;
    }

    public Vector<Alert> getAlertsByLevel(AlertLevel level)
    {
        Vector<Alert> filtered = new Vector<>();
        for (Alert alert : alerts)
        {
            if (alert.getAlertLevel() == level)
            {
                filtered.add(alert);
            }
        }
        return filtered;
    }
}