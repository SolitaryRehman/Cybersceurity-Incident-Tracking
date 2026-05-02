package service;

import entities.Log;

import java.util.Vector;

import entities.incident.*;

public class IncidentManager
{
    // Provides access to all stored logs so they can be filtered by incident type.
    private LogManager logManager;

    public IncidentManager(LogManager logManager)
    {
        // Save the LogManager reference for later filtering operations.
        this.logManager = logManager;
    }

    public Vector<Log> viewLogsByType(Class<?> type)
    {
        // Stores logs whose incident matches the requested incident class.
        Vector<Log> results = new Vector<Log>();

        // Go through every log and check the actual incident type inside it.
        for(Log l: logManager.getAllLogs())
        {
            // isInstance allows this method to work with any incident subclass.
            if(type.isInstance(l.getIncident()))
                results.add(l);
        }

        // Return only logs that matched the requested incident type.
        return results;
    }

    public Vector<Log> viewNetworkLogs()
    {
        // Return only logs related to Network incidents.
        return viewLogsByType(Network.class);
    }

    public Vector<Log> viewDDOSLogs()
    {
        // Return only logs related to DDOS incidents.
        return viewLogsByType(DDOS.class);
    }

    public Vector<Log> viewMalwareLogs()
    {
        // Return only logs related to Malware incidents.
        return viewLogsByType(Malware.class);
    }

    public Vector<Log> viewPhishingLogs()
    {
        // Return only logs related to Phishing incidents.
        return viewLogsByType(Phishing.class);
    }

    public Vector<Log> viewRansomwareLogs()
    {
        // Return only logs related to Ransomware incidents.
        return viewLogsByType(Ransomware.class);
    }

    public Vector<Log> viewSQLInjectionLogs()
    {
        // Return only logs related to SQL Injection incidents.
        return viewLogsByType(SQLInjection.class);
    }

    public Vector<Log> viewUnauthorizedAccessLogs()
    {
        // Return only logs related to Unauthorized Access incidents.
        return viewLogsByType(UnauthorizedAccess.class);
    }
}
