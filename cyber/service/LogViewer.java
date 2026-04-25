package service;

import entities.enums.Risk;
import entities.Log;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.util.Vector;

public class LogViewer
{
    private LogManager logManager;

    public Vector<Log> searchLogs(String query)
    {
        Vector<Log> results = new Vector<Log>();

        for(Log l: logManager.getAllLogs())
        {
            if(l.getLogID().toLowerCase().contains(query.toLowerCase()))
                results.add(l);

            if(l.getDescription().toLowerCase().contains(query.toLowerCase()))
                results.add(l);

            if(l.getLoggedBy().getUsername().toLowerCase().contains(query.toLowerCase()))
                results.add(l);
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

    public Vector<Log> viewLogsByMonth(Year year)
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
            if(l.getLoggedBy().getUsername().equals(username))
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



}
