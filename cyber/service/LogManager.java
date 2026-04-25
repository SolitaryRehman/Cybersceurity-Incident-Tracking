package service;

import entities.Log;
import entities.enums.AlertLevel;
import entities.enums.AlertType;

import java.util.Vector;

public class LogManager
{
    private Vector<Log> logs;
    private AlertManager alertManager;

    public LogManager(AlertManager alertManager)
    {
        this.logs = new Vector<Log>();
        this.alertManager = alertManager;
    }

    public void logIncident(Log log)
    {
        logs.add(log);

        if(log.getIncident().getSeverity().getScore() + log.getRisk().getScore() > 2)
        {
            int alertScore = (log.getIncident().getSeverity().getScore() + log.getRisk().getScore() )/3;
            alertManager.createAlert(log, AlertType.AUTOMATIC, AlertLevel.fromInt(alertScore));
        }
    }

    public boolean updateLog(String logID, Log updatedLog)
    {
        boolean found = false;

        for(int i = 0; i< logs.size(); i++)
        {
            if(logs.get(i).getLogID().equals(logID))
            {
                logs.set(i, updatedLog);
                found = true;
                return found;
            }
        }

        return found;
    }

    public boolean deleteLog(String logID)
    {
        boolean found = false;

        for(int i = 0; i<logs.size(); i++)
        {
            if(logs.get(i).getLogID().equals(logID))
            {
                logs.remove(logs.get(i));
                found = true;
                return found;
            }
        }
        return found;
    }

    public Vector<Log> getAllLogs()
    {
        return logs;
    }

    public Log getLog(String logID)
    {
        for(Log l: logs)
        {
            if(l.getLogID().equals(logID))
            {
                return l;
            }
        }

        return null;
    }
}

