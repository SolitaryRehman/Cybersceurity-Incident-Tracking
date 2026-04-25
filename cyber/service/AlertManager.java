package service;

import entities.Alert;
import entities.Log;
import entities.enums.AlertType;

import java.time.LocalDateTime;
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

    public Alert createAlert(Log log, AlertType type)
    {
        Alert alert = new Alert(log, type, LocalDateTime.now());
        alerts.add(alert);
        return alert;
    }

    public Vector<Alert> getAlertsByLevel(AlertType type)
    {
        Vector<Alert> filtered = new Vector<>();
        for (Alert alert : alerts)
        {
            if (alert.getType() == type)
            {
                filtered.add(alert);
            }
        }
        return filtered;
    }
}