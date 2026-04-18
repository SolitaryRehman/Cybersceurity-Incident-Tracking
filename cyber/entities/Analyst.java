package entities;

public class Analyst
{
    private static int counter = 1;
    private String analystID;
    private String username;
    private String password;

    public Analyst()
    {
        this.analystID = ("ANLYST-" + String.format("%02d", counter++));
    }
}