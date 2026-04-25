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
            case LOW: System.out.println("Sending alert to high-level executives!");
            case MEDIUM: System.out.println("Sending alert to managerial employees!");
            case HIGH: System.out.println("Sending alert to ALL employees!");
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