package service;

import entities.Log;
import entities.enums.AlertLevel;
import entities.enums.AlertType;

import java.util.Vector;

public class LogManager
{
    // Stores all incident logs created during the current program session.
    private Vector<Log> logs;

    // Used to automatically create alerts when a log has enough severity/risk.
    private AlertManager alertManager;

    public LogManager(AlertManager alertManager)
    {
        // Initialize the log collection when the manager is created.
        this.logs = new Vector<Log>();
        this.alertManager = alertManager;
    }

    public void logIncident(Log log)
    {
        // Add the new incident log to the system.
        logs.add(log);

        // Automatically create an alert if the combined severity and risk score is high enough.
        if(log.getIncident().getSeverity().getScore() + log.getRisk().getScore() > 2)
        {
            // Convert the combined score into an alert level value.
            int alertScore = (log.getIncident().getSeverity().getScore() + log.getRisk().getScore() )/3;

            // Create an automatic alert linked to this log.
            alertManager.createAlert(log, AlertType.AUTOMATIC, AlertLevel.fromInt(alertScore));
        }
    }

    public boolean updateLog(String logID, Log updatedLog)
    {
        boolean found = false;

        // Search for the log with the matching ID and replace it with the updated log.
        for(int i = 0; i< logs.size(); i++)
        {
            if(logs.get(i).getLogID().equals(logID))
            {
                logs.set(i, updatedLog);
                found = true;
                return found;
            }
        }

        // Return false if no matching log was found.
        return found;
    }

    public boolean deleteLog(String logID)
    {
        boolean found = false;

        // Search for the log with the matching ID and remove it from the collection.
        for(int i = 0; i<logs.size(); i++)
        {
            if(logs.get(i).getLogID().equals(logID))
            {
                logs.remove(logs.get(i));
                found = true;
                return found;
            }
        }

        // Return false if no matching log was found.
        return found;
    }

    public Vector<Log> getAllLogs()
    {
        // Return all logs currently stored in the system.
        return logs;
    }

    public Log getLog(String logID)
    {
        // Find and return a single log by its unique log ID.
        for(Log l: logs)
        {
            if(l.getLogID().equals(logID))
            {
                return l;
            }
        }

        // Return null when the requested log does not exist.
        return null;
    }
}

