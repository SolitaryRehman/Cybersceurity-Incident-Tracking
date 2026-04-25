package service;

import entities.Log;
import java.util.Vector;

public class LogManager
{
    private Vector<Log> logs;

    public LogManager()
    {
        this.logs = new Vector<Log>();
    }

    public void logIncident(Log log)
    {
        logs.add(log);
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

