import entities.enums.Severity;
import entities.incident.Incident;

public class SQLInjection extends Incident
{
    private String queryPayload;
    private String affectedDatabase;
    private String entryPointURL;
    private String databaseUser;

    public SQLInjection(Severity severity) 
    {
        super(severity);
    }

    public String getQueryPayload() 
    {
        return queryPayload;
    }

    public void setQueryPayload(String queryPayload) 
    {
        this.queryPayload = queryPayload;
    }

    public String getAffectedDatabase() 
    {
        return affectedDatabase;
    }

    public void setAffectedDatabase(String affectedDatabase) 
    {
        this.affectedDatabase = affectedDatabase;
    }

    public String getEntryPointURL() 
    {
        return entryPointURL;
    }

    public void setEntryPointURL(String entryPointURL) 
    {
        this.entryPointURL = entryPointURL;
    }

    public String getDatabaseUser() 
    {
        return databaseUser;
    }

    public void setDatabaseUser(String databaseUser) 
    {
        this.databaseUser = databaseUser;
    }
}