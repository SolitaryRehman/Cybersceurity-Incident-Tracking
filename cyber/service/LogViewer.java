package service;

import entities.enums.Risk;
import entities.Log;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.Vector;

public class LogViewer
{
    // Provides access to stored logs for searching, filtering, and sorting.
    private LogManager logManager;

    public LogViewer(LogManager logManager)
    {
        // Save the LogManager reference so this viewer can read all logs.
        this.logManager = logManager;
    }

    public Vector<Log> searchLogs(String query)
    {
        // Stores logs that match the search keyword.
        Vector<Log> results = new Vector<Log>();

        // Convert the query to lowercase to make searching case-insensitive.
        String lQuery = query.toLowerCase();

        // Search by log ID, description, or analyst username.
        for(Log l: logManager.getAllLogs())
        {
            if(l.getLogID().toLowerCase().contains(lQuery) ||
               l.getDescription().toLowerCase().contains(lQuery) ||
               l.getLoggedBy().getUsername().toLowerCase().contains(lQuery))
            {
                results.add(l);
            }
        }

        // Return all logs that matched the search query.
        return results;
    }

    public Vector<Log> viewLogsByDate(LocalDate date)
    {
        // Stores logs created on the requested date.
        Vector<Log> results = new Vector<Log>();

        // Compare each log's date part with the selected date.
        for(Log l: logManager.getAllLogs())
        {
            if(l.getLogTime().toLocalDate().equals(date))
                results.add(l);
        }

        return results;
    }

    public Vector<Log> viewLogsByMonth(YearMonth month)
    {
        // Stores logs created during the requested month and year.
        Vector<Log> results = new Vector<Log>();

        // Convert each log time to YearMonth and compare it with the selected month.
        for(Log l: logManager.getAllLogs())
        {
            if(YearMonth.from(l.getLogTime()).equals(month))
                results.add(l);
        }

        return results;
    }

    public Vector<Log> viewLogsByYear(Year year)
    {
        // Stores logs created during the requested year.
        Vector<Log> results = new Vector<Log>();

        // Compare each log's year with the selected year.
        for(Log l: logManager.getAllLogs())
        {
            if(Year.from(l.getLogTime()).equals(year))
                results.add(l);
        }

        return results;
    }


    public Vector<Log> viewLogsByAnalyst(String username)
    {
        // Stores logs created by the requested analyst.
        Vector<Log> results = new Vector<Log>();

        // Username comparison is case-insensitive.
        for(Log l: logManager.getAllLogs())
        {
            if(l.getLoggedBy().getUsername().toLowerCase().equals(username.toLowerCase()))
                results.add(l);
        }

        return results;
    }

    public Vector<Log> viewLogsByRisk(Risk risk)
    {
        // Stores logs with the selected risk level.
        Vector<Log> results = new Vector<Log>();

        // Compare each log's risk value with the requested risk.
        for(Log l: logManager.getAllLogs())
        {
            if(l.getRisk().equals(risk))
                results.add(l);
        }

        return results;
    }

    public Vector<Log> sortByRecentFirst()
    {
        // Create a copy so the original log order is not changed.
        Vector<Log> sortedLogs = new Vector<>(logManager.getAllLogs());

        // Sort logs from newest to oldest.
        sortedLogs.sort((log1, log2) -> log2.getLogTime().compareTo(log1.getLogTime()));

        return sortedLogs;
    }

    public Vector<Log> sortBySeverityHighestFirst()
    {
        // Create a copy so the original log order is not changed.
        Vector<Log> sortedLogs = new Vector<>(logManager.getAllLogs());

        // Sort logs by incident severity score from highest to lowest.
        sortedLogs.sort((log1, log2) ->
            Integer.compare(
                log2.getIncident().getSeverity().getScore(),
                log1.getIncident().getSeverity().getScore()
            )
        );

        return sortedLogs;
    }
}
