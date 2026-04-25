package service;

import entities.enums.Risk;
import entities.Log;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.Vector;

public class LogViewer
{
    private LogManager logManager;

    public LogViewer(LogManager logManager)
    {
        this.logManager = logManager;
    }
    public Vector<Log> searchLogs(String query)
    {
        Vector<Log> results = new Vector<Log>();
        String lQuery = query.toLowerCase();

        for(Log l: logManager.getAllLogs())
        {
            if(l.getLogID().toLowerCase().contains(lQuery) ||
               l.getDescription().toLowerCase().contains(lQuery) ||
               l.getLoggedBy().getUsername().toLowerCase().contains(lQuery))
            {
                results.add(l);
            }
        }
        return results;
    }

    public Vector<Log> viewLogsByDate(LocalDate date)
    {
        Vector<Log> results = new Vector<Log>();

        for(Log l: logManager.getAllLogs())
        {
            if(l.getLogTime().toLocalDate().equals(date))
                results.add(l);
        }
        return results;
    }

    public Vector<Log> viewLogsByMonth(YearMonth month)
    {
        Vector<Log> results = new Vector<Log>();

        for(Log l: logManager.getAllLogs())
        {
            if(YearMonth.from(l.getLogTime()).equals(month))
                results.add(l);
        }
        return results;
    }

    public Vector<Log> viewLogsByYear(Year year)
    {
        Vector<Log> results = new Vector<Log>();

        for(Log l: logManager.getAllLogs())
        {
            if(Year.from(l.getLogTime()).equals(year))
                results.add(l);
        }
        return results;
    }


    public Vector<Log> viewLogsByAnalyst(String username)
    {
        Vector<Log> results = new Vector<Log>();

        for(Log l: logManager.getAllLogs())
        {
            if(l.getLoggedBy().getUsername().toLowerCase().equals(username.toLowerCase()))
                results.add(l);
        }
        return results;
    }

    public Vector<Log> viewLogsByRisk(Risk risk)
    {
        Vector<Log> results = new Vector<Log>();

        for(Log l: logManager.getAllLogs())
        {
            if(l.getRisk().equals(risk))
                results.add(l);
        }
        return results;
    }
    
    public Vector<Log> sortByRecentFirst()
    {
        Vector<Log> sortedLogs = new Vector<>(logManager.getAllLogs());

        sortedLogs.sort((log1, log2) -> log2.getLogTime().compareTo(log1.getLogTime()));

        return sortedLogs;
    }

    public Vector<Log> sortBySeverityHighestFirst()
    {
        Vector<Log> sortedLogs = new Vector<>(logManager.getAllLogs());

        sortedLogs.sort((log1, log2) ->
            Integer.compare(
                log2.getIncident().getSeverity().getScore(),
                log1.getIncident().getSeverity().getScore()
            )
        );

        return sortedLogs;
    }
}
