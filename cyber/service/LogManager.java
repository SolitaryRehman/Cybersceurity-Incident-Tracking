package service;

import entities.Log;
import entities.incident.Incident;

import java.util.Objects;
import java.util.Vector;

public class LogManager
{
    private Vector<Log> logs;

    public void logIncident(Log log)
    {
        logs.add(log);
    }

    public boolean updateLog(String logID, Log updatedLog)
    {
        boolean found = false;

        for(Log l: logs)
        {
            if(l.getLogID().equals(logID))
            {
                l = updatedLog;
                found = true;
            }
        }

        return found;
    }

    public boolean deleteLog(String logID)
    {
        boolean found = false;

        for(Log l: logs)
        {
            if(l.getLogID().equals(logID))
            {
                logs.remove(l);
                found = true;
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
                logs.remove(l);
                return l;
            }
        }

        return null;
    }
}

