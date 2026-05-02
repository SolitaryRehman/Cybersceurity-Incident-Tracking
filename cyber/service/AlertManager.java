package service;

import entities.Alert;
import entities.Log;
import entities.enums.AlertLevel;
import entities.enums.AlertType;
import java.util.Vector;

public class AlertManager
{
    // Stores all alerts created during the current program session.
    private Vector<Alert> alerts;

    public AlertManager()
    {
        // Initialize the alert list when the manager is created.
        this.alerts = new Vector<>();
    }

    public Vector<Alert> getAlerts()
    {
        // Return all alerts stored in the system.
        return alerts;
    }

    public void setAlerts(Vector<Alert> alerts)
    {
        // Replace the current alert list with a new one.
        this.alerts = alerts;
    }

    public Alert createAlert(Log log, AlertType type, AlertLevel level)
    {
        // Create a new alert connected to the provided incident log.
        Alert alert = new Alert(log, type, level);

        // Store the newly created alert in the alert list.
        alerts.add(alert);

        // Print a different notification message depending on the alert level.
        switch(level)
        {
            case LOW:
                // Low-level alerts are routine and usually handled by technical staff.
                System.out.println("[IT NOTIFICATION]: Routine event logged. Assigned to Junior Analyst.");
                break;

            case MEDIUM:
                // Medium alerts may require management awareness or follow-up.
                System.out.println("[MANAGEMENT ALERT]: Potential security threat. Managerial oversight required.");
                break;

            case HIGH:
                // High alerts represent urgent security incidents that need immediate attention.
                System.out.println("[EMERGENCY BROADCAST]: Critical security breach! Executives and All Staff notified.");
                break;

        }

        // Return the created alert so the caller can display or use its details.
        return alert;
    }

    public Vector<Alert> getAlertsByLevel(AlertLevel level)
    {
        // Stores only alerts that match the requested level.
        Vector<Alert> filtered = new Vector<>();

        // Check every alert and keep only those with the selected alert level.
        for (Alert alert : alerts)
        {
            if (alert.getAlertLevel() == level)
            {
                filtered.add(alert);
            }
        }

        // Return the filtered alert list.
        return filtered;
    }
}