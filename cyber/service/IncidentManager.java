package service;

import entities.Log;

import java.util.Vector;

import entities.incident.*;

public class IncidentManager
{
    private LogManager logManager;

    public IncidentManager(LogManager logManager)
    {
        this.logManager = logManager;
    }

    public Vector<Log> viewLogsByType(Class<?> type)
    {
        Vector<Log> results = new Vector<Log>();

        for(Log l: logManager.getAllLogs())
        {
            if(type.isInstance(l.getIncident()))
                results.add(l);
        }
        return results;
    }

    public Vector<Log> viewNetworkLogs()
    {
        return viewLogsByType(Network.class);
    }

    public Vector<Log> viewDDOSLogs()
    {
        return viewLogsByType(DDOS.class);
    }

    public Vector<Log> viewMalwareLogs()
    {
        return viewLogsByType(Malware.class);
    }

    public Vector<Log> viewPhishingLogs()
    {
        return viewLogsByType(Phishing.class);
    }

    public Vector<Log> viewRansomwareLogs()
    {
        return viewLogsByType(Ransomware.class);
    }

    public Vector<Log> viewSQLInjectionLogs()
    {
        return viewLogsByType(SQLInjection.class);
    }

    public Vector<Log> viewUnauthorizedAccessLogs()
    {
        return viewLogsByType(UnauthorizedAccess.class);
    }
}
