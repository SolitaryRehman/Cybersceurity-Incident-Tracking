import entities.enums.Severity;
import entities.incident.Incident;

import java.time.LocalDateTime;

public class UnauthorizedAccess extends Incident
{
    private String userID;
    private String accessPoint;
    private String terminalID;
    private LocalDateTime loginTime;

    public UnauthorizedAccess(Severity severity) {
        super(severity);
    }
}