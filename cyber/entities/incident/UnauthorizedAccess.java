package entities.incident;

import entities.enums.Severity;
import entities.incident.Incident;

import java.time.LocalDateTime;

public class UnauthorizedAccess extends Incident
{
    private String userID;
    private String accessPoint;
    private String terminalID;
    private LocalDateTime loginTime;

    public UnauthorizedAccess(Severity severity) 
    {
        super(severity);
    }

    public String getUserID() 
    {
        return userID;
    }

    public void setUserID(String userID) 
    {
        this.userID = userID;
    }

    public String getAccessPoint() 
    {
        return accessPoint;
    }

    public void setAccessPoint(String accessPoint) 
    {
        this.accessPoint = accessPoint;
    }

    public String getTerminalID() 
    {
        return terminalID;
    }

    public void setTerminalID(String terminalID) 
    {
        this.terminalID = terminalID;
    }

    public LocalDateTime getLoginTime() 
    {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) 
    {
        this.loginTime = loginTime;
    }
}