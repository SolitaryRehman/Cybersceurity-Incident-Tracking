import entities.enums.Severity;
import entities.incident.Incident;

public class Phishing extends Incident
{
    private String senderEmail;
    private String phishingURL;
    private String emailSubject;
    private String receipientCount;

    public Phishing(Severity severity) {
        super(severity);
    }
}