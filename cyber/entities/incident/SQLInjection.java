import incident.Incident;

public class SQLInjection extends Incident
{
    private String queryPayload;
    private String affectedDatabase;
    private String entryPointURL;
    private String databaseUser;
}