import incident.Incident;

public class UnauthorizedAccess extends Incident
{
    private String userID;
    private String accessPoint;
    private String terminalID;
    private LocalDateTime loginTime;

}