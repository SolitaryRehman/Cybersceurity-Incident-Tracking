import entities.Alert;
import entities.Analyst;
import entities.Log;
import entities.enums.AlertLevel;
import entities.enums.AlertType;
import entities.enums.ResolutionStatus;
import entities.enums.Risk;
import entities.enums.Severity;
import entities.incident.DDOS;
import entities.incident.Incident;
import entities.incident.Malware;
import entities.incident.Network;
import entities.incident.Phishing;
import entities.incident.Ransomware;
import entities.incident.SQLInjection;
import entities.incident.UnauthorizedAccess;
import java.util.Scanner;
import java.util.Vector;
import service.AlertManager;
import service.Authenticator;
import service.IncidentManager;
import service.LogManager;
import service.LogViewer;
import service.ReportGenerator;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        AlertManager alertManager = new AlertManager();
        LogManager logManager = new LogManager(alertManager);
        LogViewer logViewer = new LogViewer(logManager);
        IncidentManager incidentManager = new IncidentManager(logManager);
        ReportGenerator reportGenerator = new ReportGenerator(logManager);
        Authenticator authenticator = new Authenticator();

        boolean running = true;

        while (running)
        {
            System.out.println("\n====================================");
            System.out.println("   CYBERSECURITY INCIDENT TRACKER");
            System.out.println("====================================");

            if (!authenticator.isLoggedIn())
            {
                System.out.println("1. Register Analyst");
                System.out.println("2. Login");
                System.out.println("0. Exit\n");
                System.out.print("Choose option: ");

                switch (readInt())
                {
                    case 1: registerAnalyst(authenticator); break;
                    case 2: login(authenticator);           break;
                    case 0:
                        running = false;
                        System.out.println("Exiting system...");
                        break;
                    default: System.out.println("Invalid option.");
                }
            }
            else
            {
                System.out.println("Logged in as: " + authenticator.getCurrentUser().getUsername());
                System.out.println("------------------------------------");
                System.out.println("1. Logout");
                System.out.println("2. Add Incident Log");
                System.out.println("3. Manage Logs");
                System.out.println("4. Manage Alerts");
                System.out.println("5. Manage Reports");
                System.out.println("0. Exit\n");
                System.out.print("Choose option: ");

                switch (readInt())
                {
                    case 1:
                        if (authenticator.logout())
                            System.out.println("Logged out successfully.");
                        break;

                    case 2:
                        addIncidentLog(logManager, authenticator.getCurrentUser());
                        break;

                    case 3:
                        manageLogsMenu(logManager, logViewer, incidentManager, authenticator);
                        break;

                    case 4:
                        manageAlertsMenu(alertManager, logManager);
                        break;

                    case 5:
                        manageReportsMenu(reportGenerator);
                        break;

                    case 0:
                        running = false;
                        System.out.println("Exiting system...");
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            }
        }

        scanner.close();
    }

    // ─────────────────────────────────────────────
    //  SUB-MENUS
    // ─────────────────────────────────────────────

    private static void manageLogsMenu(LogManager logManager, LogViewer logViewer,
                                        IncidentManager incidentManager, Authenticator authenticator)
    {
        boolean back = false;

        while (!back)
        {
            System.out.println("\n--------- MANAGE LOGS ---------");
            System.out.println("1. View All Logs");
            System.out.println("2. Search Logs");
            System.out.println("3. Filter Logs");
            System.out.println("4. Sort Logs");
            System.out.println("5. Update Log");
            System.out.println("6. Delete Log");
            System.out.println("0. Back\n");
            System.out.print("Choose option: ");

            switch (readInt())
            {
                case 1:
                    printLogs(logManager.getAllLogs());
                    break;

                case 2:
                    System.out.print("Enter search keyword: ");
                    String query = scanner.nextLine();
                    printLogs(logViewer.searchLogs(query));
                    break;

                case 3:
                    filterLogsMenu(logViewer, incidentManager);
                    break;

                case 4:
                    sortLogsMenu(logViewer);
                    break;

                case 5:
                    updateLog(logManager, authenticator.getCurrentUser());
                    break;

                case 6:
                    deleteLog(logManager);
                    break;

                case 0:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void filterLogsMenu(LogViewer logViewer, IncidentManager incidentManager)
    {
        System.out.println("\n--------- FILTER LOGS ---------");
        System.out.println("1. By Incident Type");
        System.out.println("2. By Analyst");
        System.out.println("3. By Risk");
        System.out.println("0. Back\n");
        System.out.print("Choose option: ");

        switch (readInt())
        {
            case 1:
                filterByIncidentType(incidentManager);
                break;

            case 2:
                System.out.print("Enter analyst username: ");
                String username = scanner.nextLine();
                printLogs(logViewer.viewLogsByAnalyst(username));
                break;

            case 3:
                printLogs(logViewer.viewLogsByRisk(chooseRisk()));
                break;

            case 0:
                break;

            default:
                System.out.println("Invalid option.");
        }
    }

    private static void sortLogsMenu(LogViewer logViewer)
    {
        System.out.println("\n--------- SORT LOGS ---------");
        System.out.println("1. Recent First");
        System.out.println("2. Severity Highest First");
        System.out.println("0. Back\n");
        System.out.print("Choose option: ");

        switch (readInt())
        {
            case 1:
                printLogs(logViewer.sortByRecentFirst());
                break;

            case 2:
                printLogs(logViewer.sortBySeverityHighestFirst());
                break;

            case 0:
                break;

            default:
                System.out.println("Invalid option.");
        }
    }

    private static void manageAlertsMenu(AlertManager alertManager, LogManager logManager)
    {
        boolean back = false;

        while (!back)
        {
            System.out.println("\n--------- MANAGE ALERTS ---------");
            System.out.println("1. View All Alerts");
            System.out.println("2. View Alerts By Level");
            System.out.println("3. Create Manual Alert");
            System.out.println("0. Back\n");
            System.out.print("Choose option: ");

            switch (readInt())
            {
                case 1:
                    printAlerts(alertManager.getAlerts());
                    break;

                case 2:
                    printAlerts(alertManager.getAlertsByLevel(chooseAlertLevel()));
                    break;

                case 3:
                    createManualAlert(logManager, alertManager);
                    break;

                case 0:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void manageReportsMenu(ReportGenerator reportGenerator)
    {
        boolean back = false;

        while (!back)
        {
            System.out.println("\n--------- MANAGE REPORTS ---------");
            System.out.println("1. Generate Monthly Report");
            System.out.println("2. Read Monthly Report");
            System.out.println("0. Back\n");
            System.out.print("Choose option: ");

            switch (readInt())
            {
                case 1:
                    generateReport(reportGenerator);
                    break;

                case 2:
                    readReport(reportGenerator);
                    break;

                case 0:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }


    private static void registerAnalyst(Authenticator authenticator)
    {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        authenticator.registerAnalyst(new Analyst(username, password));
        System.out.println("\nANALYST REGISTERED SUCCESSFULLY.");
    }

    private static void login(Authenticator authenticator)
    {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authenticator.login(username, password))
            System.out.println("\nLOGIN SUCCESSFUL.");
        else
            System.out.println("\nINVALID USERNAME OR PASSWORD.");
    }


    private static void addIncidentLog(LogManager logManager, Analyst currentUser)
    {
        Incident incident = createIncidentFromMenu();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter cause: ");
        String cause = scanner.nextLine();

        Risk risk = chooseRisk();
        ResolutionStatus status = chooseResolutionStatus();

        Log log = new Log(incident, currentUser, description, cause, risk, status);
        logManager.logIncident(log);

        System.out.println("Log added successfully.");
        System.out.println("Generated Log ID: " + log.getLogID());
    }

    private static void updateLog(LogManager logManager, Analyst currentUser)
    {
        System.out.print("Enter Log ID to update: ");
        String logID = scanner.nextLine();

        Log oldLog = logManager.getLog(logID);
        if (oldLog == null)
        {
            System.out.println("Log not found.");
            return;
        }

        System.out.print("Enter new description: ");
        String description = scanner.nextLine();
        System.out.print("Enter new cause: ");
        String cause = scanner.nextLine();

        Risk risk = chooseRisk();
        ResolutionStatus status = chooseResolutionStatus();

        Log updatedLog = new Log(oldLog.getIncident(), currentUser, description, cause, risk, status);
        updatedLog.setLogID(oldLog.getLogID());

        if (logManager.updateLog(logID, updatedLog))
            System.out.println("Log updated successfully.");
        else
            System.out.println("Log update failed.");
    }

    private static void deleteLog(LogManager logManager)
    {
        System.out.print("Enter Log ID to delete: ");
        String logID = scanner.nextLine();

        if (logManager.deleteLog(logID))
            System.out.println("Log deleted successfully.");
        else
            System.out.println("Log not found.");
    }


    private static Incident createIncidentFromMenu()
    {
        System.out.println("\nChoose Incident Type:");
        System.out.println("1. Malware");
        System.out.println("2. SQL Injection");
        System.out.println("3. DDOS");
        System.out.println("4. Network");
        System.out.println("5. Phishing");
        System.out.println("6. Ransomware");
        System.out.println("7. Unauthorized Access");
        System.out.print("\nChoose option: ");

        int type = readInt();
        Severity severity = chooseSeverity();

        switch (type)
        {
            case 1: return new Malware(severity);
            case 2: return new SQLInjection(severity);
            case 3: return new DDOS(severity);
            case 4: return new Network(severity);
            case 5: return new Phishing(severity);
            case 6: return new Ransomware(severity);
            case 7: return new UnauthorizedAccess(severity);
            default:
                System.out.println("Invalid type. Defaulting to Network.");
                return new Network(severity);
        }
    }

    private static void filterByIncidentType(IncidentManager incidentManager)
    {
        System.out.println("\nFilter By Incident Type:");
        System.out.println("1. Malware");
        System.out.println("2. SQL Injection");
        System.out.println("3. DDOS");
        System.out.println("4. Network");
        System.out.println("5. Phishing");
        System.out.println("6. Ransomware");
        System.out.println("7. Unauthorized Access");
        System.out.print("\nChoose option: ");

        switch (readInt())
        {
            case 1: printLogs(incidentManager.viewMalwareLogs());           break;
            case 2: printLogs(incidentManager.viewSQLInjectionLogs());      break;
            case 3: printLogs(incidentManager.viewDDOSLogs());              break;
            case 4: printLogs(incidentManager.viewNetworkLogs());           break;
            case 5: printLogs(incidentManager.viewPhishingLogs());          break;
            case 6: printLogs(incidentManager.viewRansomwareLogs());        break;
            case 7: printLogs(incidentManager.viewUnauthorizedAccessLogs()); break;
            default: System.out.println("Invalid incident type.");
        }
    }


    private static void createManualAlert(LogManager logManager, AlertManager alertManager)
    {
        System.out.print("Enter Log ID for alert: ");
        String logID = scanner.nextLine();

        Log log = logManager.getLog(logID);
        if (log == null)
        {
            System.out.println("Log not found.");
            return;
        }

        Alert alert = alertManager.createAlert(log, AlertType.MANUAL, chooseAlertLevel());
        System.out.println("Manual alert created successfully.");
        System.out.println("Alert ID: " + alert.getAlertID());
    }


    private static void generateReport(ReportGenerator reportGenerator)
    {
        System.out.print("Enter month number: ");
        int month = readInt();
        System.out.print("Enter year: ");
        int year = readInt();

        reportGenerator.generateMonthlyReport(month, year);
        System.out.println("Report generation process completed.");
    }

    private static void readReport(ReportGenerator reportGenerator)
    {
        System.out.print("Enter month number: ");
        int month = readInt();
        System.out.print("Enter year: ");
        int year = readInt();

        reportGenerator.readMonthlyReport(month, year);
    }



    private static Severity chooseSeverity()
    {
        System.out.println("\nChoose Severity:  1.LOW  2.MEDIUM  3.HIGH  4.CRITICAL");
        System.out.print("Choose option: ");

        switch (readInt())
        {
            case 1: return Severity.LOW;
            case 2: return Severity.MEDIUM;
            case 3: return Severity.HIGH;
            case 4: return Severity.CRITICAL;
            default:
                System.out.println("Invalid severity. Defaulting to LOW.");
                return Severity.LOW;
        }
    }

    private static Risk chooseRisk()
    {
        System.out.println("\nChoose Risk:  1.NONE  2.LOW  3.MEDIUM  4.HIGH  5.CRITICAL");
        System.out.print("Choose option: ");

        switch (readInt())
        {
            case 1: return Risk.NONE;
            case 2: return Risk.LOW;
            case 3: return Risk.MEDIUM;
            case 4: return Risk.HIGH;
            case 5: return Risk.CRITICAL;
            default:
                System.out.println("Invalid risk. Defaulting to NONE.");
                return Risk.NONE;
        }
    }

    private static ResolutionStatus chooseResolutionStatus()
    {
        System.out.println("\nChoose Status:  1.LOGGED  2.RESOLVING  3.RESOLVED");
        System.out.print("Choose option: ");

        switch (readInt())
        {
            case 1: return ResolutionStatus.LOGGED;
            case 2: return ResolutionStatus.RESOLVING;
            case 3: return ResolutionStatus.RESOLVED;
            default:
                System.out.println("Invalid status. Defaulting to LOGGED.");
                return ResolutionStatus.LOGGED;
        }
    }

    private static AlertLevel chooseAlertLevel()
    {
        System.out.println("\nChoose Alert Level:  1.LOW  2.MEDIUM  3.HIGH");
        System.out.print("Choose option: ");

        switch (readInt())
        {
            case 1: return AlertLevel.LOW;
            case 2: return AlertLevel.MEDIUM;
            case 3: return AlertLevel.HIGH;
            default:
                System.out.println("Invalid level. Defaulting to LOW.");
                return AlertLevel.LOW;
        }
    }


    public static void printLogs(Vector<Log> logs)
    {
        if (logs.isEmpty())
        {
            System.out.println("No logs found.");
            return;
        }

        for (Log log : logs)
        {
            System.out.println(
                log.getLogID() +
                " | Incident ID: "   + log.getIncident().getIncidentID() +
                " | Type: "          + log.getIncident().getClass().getSimpleName() +
                " | Severity: "      + log.getIncident().getSeverity() +
                " | Risk: "          + log.getRisk() +
                " | Status: "        + log.getResolutionStatus() +
                " | Analyst: "       + log.getLoggedBy().getUsername() +
                " | Description: "   + log.getDescription()
            );
        }
    }

    public static void printAlerts(Vector<Alert> alerts)
    {
        if (alerts.isEmpty())
        {
            System.out.println("No alerts found.");
            return;
        }

        for (Alert alert : alerts)
        {
            System.out.println(
                alert.getAlertID() +
                " | Type: "         + alert.getAlertType() +
                " | Level: "        + alert.getAlertLevel() +
                " | Related Log: "  + alert.getLog().getLogID() +
                " | Triggered: "    + alert.getTriggerTime()
            );
        }
    }


    private static int readInt()
    {
        while (!scanner.hasNextInt())
        {
            System.out.print("Invalid input. Enter a number: ");
            scanner.nextLine();
        }

        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}