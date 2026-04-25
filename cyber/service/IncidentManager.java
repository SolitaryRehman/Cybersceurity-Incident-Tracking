package service;

import entities.Log;

import java.util.Vector;

import entities.incident.*;

public class IncidentManager
{
    private LogManager logManager;

    public Vector<Log> viewNetworkLogs()
    {
        Vector<Log> results = new Vector<Log>();

        for(Log l: logManager.getAllLogs())
        {
            if(l.getIncident() instanceof Network)
                results.add(l);
        }
        return results;
    }

    public Vector<Log> viewDDOSLogs()
    {
        Vector<Log> results = new Vector<Log>();

        for(Log l: logManager.getAllLogs())
        {
            if(l.getIncident() instanceof DDOS)
                results.add(l);
        }
        return results;
    }

    public Vector<Log> viewMalwareLogs()
    {
        Vector<Log> results = new Vector<Log>();

        for(Log l: logManager.getAllLogs())
        {
            if(l.getIncident() instanceof Malware)
                results.add(l);
        }
        return results;
    }

    public Vector<Log> viewPhishingLogs()
    {
        Vector<Log> results = new Vector<Log>();

        for(Log l: logManager.getAllLogs())
        {
            if(l.getIncident() instanceof Phishing)
                results.add(l);
        }
        return results;
    }

    public Vector<Log> viewRansomwareLogs()
    {
        Vector<Log> results = new Vector<Log>();

        for(Log l: logManager.getAllLogs())
        {
            if(l.getIncident() instanceof Ransomware)
                results.add(l);
        }
        return results;
    }

    public Vector<Log> viewSQLInjectionLogs()
    {
        Vector<Log> results = new Vector<Log>();

        for(Log l: logManager.getAllLogs())
        {
            if(l.getIncident() instanceof SQLInjection)
                results.add(l);
        }
        return results;
    }

    public Vector<Log> viewUnauthorizedAccessLogs()
    {
        Vector<Log> results = new Vector<Log>();

        for(Log l: logManager.getAllLogs())
        {
            if(l.getIncident() instanceof UnauthorizedAccess)
                results.add(l);
        }
        return results;
    }

}
