package service;

import entities.Log;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.Month;
import java.util.Vector;

public class ReportGenerator
{
    private LogManager logManager;
    private LogViewer logViewer;

    public ReportGenerator(LogManager logManager, LogViewer logViewer)
    {
        this.logManager = logManager;
        this.logViewer = logViewer;
    }

    // generates report for a specific month and saves it to a text file
    public void generateMonthlyReport(int month, int year)
    {
        String monthName = Month.of(month).name();
        String fileName = "Report_" + monthName + "_" + year + ".txt";

        Vector<Log> Logs = logManager.getLogs();

        try
        {
            FileWriter writer = new FileWriter(fileName);

            writer.write("_______________________________________\n");
            writer.write("        MONTHLY INCIDENT REPORT\n");
            writer.write("        " + monthName + " " + year + "\n");
            writer.write("_______________________________________\n");

            int count = 0;

            for (Log log : Logs)
            {
                // only write logs that match the given month and year
                if (log.getLogTime().getMonthValue() == month && log.getLogTime().getYear() == year)
                {
                    count++;
                    writer.write("Log ID        : " + log.getLogID() + "\n");
                    writer.write("Incident ID   : " + log.getIncident().getIncidentID() + "\n");
                    writer.write("Incident Type : " + log.getIncident().getType+ "\n");
                    writer.write("Severity      : " + log.getIncident().getSeverity() + "\n");
                    writer.write("Logged At     : " + log.getLogTime() + "\n");
                    writer.write("Logged By     : " + log.getLoggedBy().getUsername() + "\n");
                    writer.write("Description   : " + log.getDescription() + "\n");
                    writer.write("Cause         : " + log.getCause() + "\n");
                    writer.write("Risk          : " + log.getRisk() + "\n");
                    writer.write("Status        : " + log.getResolutionStatus() + "\n");
                    writer.write("----------------------------------------\n");
                }
            }

            writer.write("Total Incidents : " + count + "\n");
            writer.write("___________________________________\n");

            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Error saving report");
        }
    }

    // reads and prints the saved report for a specific month
    public void readMonthlyReport(int month, int year)
    {
        String monthName = Month.of(month).name();
        String fileName = "Report_" + monthName + "_" + year + ".txt";

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            // read and print each line until end of file
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }

            reader.close();
        }
        catch (IOException e)
        {
            // file not found means report hasnt been generated yet
            System.out.println("No report found for " + monthName + " " + year);
        }
    }
}
 