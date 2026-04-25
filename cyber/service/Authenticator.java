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
    }

    public boolean login(String username, String password) 
    {
        for (Analyst a : analysts) 
        {
            if (a.getUsername().toLowerCase().equals(username.toLowerCase()) && a.getPassword().equals(password))
            {
                currentUser = a;
                return true;
            }
        }
        return false;
    }

    public boolean logout()
    {
        if (currentUser != null) 
        {
            currentUser = null;
            return true;
        } 
        else 
        {
            System.out.println("No user is currently logged in.");
            return false;
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
 