package entities;

public class Analyst
{
    private static int counter = 1;
    private String analystID;
    private String username;
    private String password;

    public Analyst(String username, String password)
    {
        this.analystID = ("ANLYST-" + String.format("%02d", counter++));
        this.username = username;
        this.password = password;
    }
<<<<<<< HEAD
    public String getAnalystID() 
    { 
        return analystID; 
    }
    public String getUsername() 
    { return username; 
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
        return "Analyst ID: " + analystID + " | Username: " + username;
    }
} 
=======

    public String getAnalystID() {
        return analystID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
>>>>>>> 1334e5f678d73cfa7ae2c9f995ed348577f6f23b
