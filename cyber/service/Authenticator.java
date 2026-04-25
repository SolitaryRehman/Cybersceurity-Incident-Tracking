package service;

import entities.Analyst;
import java.util.Vector;

public class Authenticator
{
    private Vector<Analyst> analysts;
    private Analyst currentUser;
    public Authenticator() 
    {
        this.analysts = new Vector<>();
        this.currentUser = null;
    }

    public void registerAnalyst(Analyst analyst) 
    {
        analysts.add(analyst);
        System.out.println("Analyst registered: " + analyst.getUsername());
    }

    public boolean login(String username, String password) 
    {
        for (Analyst a : analysts) 
        {
            if (a.getUsername().equals(username) && a.getPassword().equals(password)) 
            {
                currentUser = a;
                System.out.println("Login successful! Welcome, " + username);
                return true;
            }
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    public void logout() 
    {
        if (currentUser != null) 
        {
            System.out.println("Logged out: " + currentUser.getUsername());
            currentUser = null;
        } 
        else 
        {
            System.out.println("No user is currently logged in.");
        }
    }

    public Analyst getCurrentUser() 
    { 
        return currentUser; 
    }
    public Vector<Analyst> getAnalysts() 
    { 
        return analysts; 
    }

    public boolean isLoggedIn() 
    {
        return currentUser != null;
    }
}
 