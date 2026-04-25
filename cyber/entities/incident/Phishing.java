package entities.incident;

import entities.enums.Severity;
import entities.incident.Incident;
import java.util.function.IntConsumer;

public class Phishing extends Incident
{
    private String senderEmail;
    private String phishingURL;
    private String emailSubject;
    private int recipientCount;

    public Phishing(Severity severity) 
    {
        super(severity);
    }

    public String getSenderEmail() 
    {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) 
    {
        this.senderEmail = senderEmail;
    }

    public String getPhishingURL() 
    {
        return phishingURL;
    }

    public void setPhishingURL(String phishingURL) 
    {
        this.phishingURL = phishingURL;
    }

    public String getEmailSubject() 
    {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) 
    {
        this.emailSubject = emailSubject;
    }

    public int getRecipientCount()
    {
        return recipientCount;
    }

    public void setRecipientCount(int recipientCount)
    {
        this.recipientCount = recipientCount;
    }
}