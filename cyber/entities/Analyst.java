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