package entities;

public class Analyst
{
    // Used to generate unique analyst IDs.
    private static int counter = 1;

    // Unique identifier for the analyst, such as ANLYST-01.
    private String analystID;

    // Username used by the analyst to log in.
    private String username;

    // Password used by the analyst to log in.
    private String password;

    public Analyst(String username, String password)
    {
        // Generate a formatted analyst ID and then increase the counter.
        this.analystID = ("ANLYST-" + String.format("%02d", counter++));

        // Store the login credentials for this analyst.
        this.username = username;
        this.password = password;
    }

    public String getAnalystID()
    { 
        return analystID; 
    }

    public String getUsername() 
    { 
        return username; 
    }

    public String getPassword() 
    { 
        return password; 
    }

    public void setUsername(String username) 
    { 
        this.username = username; 
    }

    public void setPassword(String password) 
    { 
        this.password = password; 
    }

    @Override
    public String toString() 
    {
        // Return a readable summary of the analyst without displaying the password.
        return "Analyst ID: " + analystID + " | Username: " + username;
    }
} 
