import entities.Alert;
import entities.Analyst;
import entities.Log;
import entities.enums.AlertLevel;
import entities.enums.AlertType;
import entities.enums.ResolutionStatus;
import entities.enums.Risk;
import entities.enums.Severity;
import entities.incident.DDOS;
import entities.incident.Malware;
import entities.incident.SQLInjection;
import service.AlertManager;
import service.IncidentManager;
import service.LogManager;
import service.LogViewer;

import java.util.Vector;

public class Main
{
    public static void main(String[] args)
    {
        AlertManager alertManager = new AlertManager();
        LogManager logManager = new LogManager(alertManager);
        LogViewer logViewer = new LogViewer(logManager);
        IncidentManager incidentManager = new IncidentManager(logManager);

        Analyst analyst1 = new Analyst("bilal", "<password>");
        Analyst analyst2 = new Analyst("sara", "<password>");

        Malware malware = new Malware(Severity.HIGH);
        SQLInjection sqlInjection = new SQLInjection(Severity.CRITICAL);
        DDOS ddos = new DDOS(Severity.MEDIUM);

        Log log1 = new Log(
            malware,
            analyst1,
            "Trojan malware detected from email attachment",
            "User downloaded suspicious file",
            Risk.HIGH,
            ResolutionStatus.LOGGED
        );

        Log log2 = new Log(
            sqlInjection,
            analyst2,
            "SQL injection attempt detected on login page",
            "Unsanitized input attempt",
            Risk.CRITICAL,
            ResolutionStatus.RESOLVING
        );

        Log log3 = new Log(
            ddos,
            analyst1,
            "Unusual traffic spike detected on HTTPS service",
            "Possible distributed denial of service attack",
            Risk.MEDIUM,
            ResolutionStatus.LOGGED
        );

        logManager.logIncident(log1);
        logManager.logIncident(log2);
        logManager.logIncident(log3);

        System.out.println("===== ALL LOGS =====");
        printLogs(logManager.getAllLogs());

        System.out.println("\n===== SEARCH: 'login' =====");
        printLogs(logViewer.searchLogs("login"));

        System.out.println("\n===== MALWARE LOGS =====");
        printLogs(incidentManager.viewMalwareLogs());

        System.out.println("\n===== SQL INJECTION LOGS =====");
        printLogs(incidentManager.viewSQLInjectionLogs());

        System.out.println("\n===== DDOS LOGS =====");
        printLogs(incidentManager.viewDDOSLogs());

        System.out.println("\n===== LOGS BY ANALYST: bilal =====");
        printLogs(logViewer.viewLogsByAnalyst("bilal"));

        System.out.println("\n===== LOGS BY RISK: HIGH =====");
        printLogs(logViewer.viewLogsByRisk(Risk.HIGH));

        System.out.println("\n===== SORTED BY RECENT FIRST =====");
        printLogs(logViewer.sortByRecentFirst());

        System.out.println("\n===== SORTED BY SEVERITY HIGHEST FIRST =====");
        printLogs(logViewer.sortBySeverityHighestFirst());

        Alert alert1 = alertManager.createAlert(log1, AlertType.AUTOMATIC, AlertLevel.HIGH);
        Alert alert2 = alertManager.createAlert(log2, AlertType.MANUAL, AlertLevel.HIGH);

        System.out.println("\n===== ALL ALERTS =====");
        printAlerts(alertManager.getAlerts());

        System.out.println("\n===== HIGH ALERTS =====");
        printAlerts(alertManager.getAlertsByLevel(AlertLevel.HIGH));

        Log updatedLog = new Log(
            ddos,
            analyst1,
            "Updated: DDoS traffic confirmed and escalated",
            "High traffic from multiple sources",
            Risk.HIGH,
            ResolutionStatus.RESOLVING
        );

        updatedLog.setLogID(log3.getLogID());

        boolean updated = logManager.updateLog(log3.getLogID(), updatedLog);

        System.out.println("\nUpdate " + log3.getLogID() + " successful? " + updated);

        System.out.println("\n===== ALL LOGS AFTER UPDATE =====");
        printLogs(logManager.getAllLogs());

        boolean deleted = logManager.deleteLog(log1.getLogID());

        System.out.println("\nDelete " + log1.getLogID() + " successful? " + deleted);

        System.out.println("\n===== ALL LOGS AFTER DELETE =====");
        printLogs(logManager.getAllLogs());
    }

    public static void printLogs(Vector<Log> logs)
    {
        if(logs.isEmpty())
        {
            System.out.println("No logs found.");
            return;
        }

        for(Log log : logs)
        {
            System.out.println(
                log.getLogID() +
                " | Incident ID: " + log.getIncident().getIncidentID() +
                " | Incident Type: " + log.getIncident().getClass().getSimpleName() +
                " | Severity: " + log.getIncident().getSeverity() +
                " | Risk: " + log.getRisk() +
                " | Status: " + log.getResolutionStatus() +
                " | Analyst: " + log.getLoggedBy().getUsername() +
                " | Description: " + log.getDescription()
            );
        }
    }

    public static void printAlerts(Vector<Alert> alerts)
    {
        if(alerts.isEmpty())
        {
            System.out.println("No alerts found.");
            return;
        }

        for(Alert alert : alerts)
        {
            System.out.println(
                alert.getAlertID() +
                " | Type: " + alert.getAlertType() +
                " | Level: " + alert.getAlertLevel() +
                " | Related Log: " + alert.getLog().getLogID() +
                " | Triggered: " + alert.getTriggerTime()
            );
        }
    }
}
