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
    // Provides access to logs that will be written into reports.
    private LogManager logManager;

    public ReportGenerator(LogManager logManager)
    {
        // Save the LogManager reference so reports can use all stored logs.
        this.logManager = logManager;
    }

    // Generates a report for a specific month and saves it to a text file.
    public void generateMonthlyReport(int month, int year)
    {
        // Validate month number before trying to create a Month object.
        if(month < 1 || month > 12)
        {
            System.out.println("Invalid month. Please enter a value from 1 to 12.");
            return;
        }

        // Convert the month number into a readable month name.
        String monthName = Month.of(month).name();

        // Create the report file name using the selected month and year.
        String fileName = "Report_" + monthName + "_" + year + ".txt";

        // Get all logs from the system.
        Vector<Log> Logs = logManager.getAllLogs();

        try
        {
            // Open the report file for writing.
            FileWriter writer = new FileWriter(fileName);

            // Write the report header.
            writer.write("_______________________________________\n");
            writer.write("        MONTHLY INCIDENT REPORT\n");
            writer.write("        " + monthName + " " + year + "\n");
            writer.write("_______________________________________\n");

            // Counts how many logs are included in the report.
            int count = 0;

            for (Log log : Logs)
            {
                // Only write logs that match the given month and year.
                if (log.getLogTime().getMonthValue() == month && log.getLogTime().getYear() == year)
                {
                    count++;

                    // Write the main details of each matching incident log.
                    writer.write("Log ID        : " + log.getLogID() + "\n");
                    writer.write("Incident ID   : " + log.getIncident().getIncidentID() + "\n");
                    writer.write("Incident Type : " + log.getIncident().getClass().getSimpleName()+ "\n");
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

            // Write the final summary section.
            writer.write("Total Incidents : " + count + "\n");
            writer.write("___________________________________\n");

            // Close the file after writing is complete.
            writer.close();
        }
        catch (IOException e)
        {
            // Display a simple error message if the report could not be saved.
            System.out.println("Error saving report");
        }
    }

    // Reads and prints the saved report for a specific month.
    public void readMonthlyReport(int month, int year)
    {
        // Validate month number before trying to read a report.
        if(month < 1 || month > 12)
        {
            System.out.println("Invalid month. Please enter a value from 1 to 12.");
            return;
        }

        // Build the same file name used when the report was generated.
        String monthName = Month.of(month).name();
        String fileName = "Report_" + monthName + "_" + year + ".txt";

        try
        {
            // Open the report file for reading.
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            // Read and print each line until the end of the file.
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }

            // Close the reader after the file has been fully read.
            reader.close();
        }
        catch (IOException e)
        {
            // File not found usually means the report has not been generated yet.
            System.out.println("No report found for " + monthName + " " + year);
        }
    }
}
 