package service;

import entities.Analyst;
import java.util.Vector;

public class Authenticator
{
    // Stores all registered analysts for the current program session.
    private Vector<Analyst> analysts;

    // Keeps track of the analyst who is currently logged in.
    private Analyst currentUser;

    public Authenticator() 
    {
        // Initialize the analyst list and start with no logged-in user.
        this.analysts = new Vector<>();
        this.currentUser = null;
    }

    public void registerAnalyst(Analyst analyst) 
    {
        // Add a new analyst account to the system.
        analysts.add(analyst);
    }

    public boolean login(String username, String password) 
    {
        // Search through all registered analysts for matching login details.
        for (Analyst a : analysts) 
        {
            // Username comparison is case-insensitive, but password comparison is exact.
            if (a.getUsername().toLowerCase().equals(username.toLowerCase()) && a.getPassword().equals(password))
            {
                // Store the successfully logged-in analyst.
                currentUser = a;
                return true;
            }
        }

        // Return false if no analyst matched the provided username and password.
        return false;
    }

    public boolean logout()
    {
        // Only log out if a user is currently logged in.
        if (currentUser != null) 
        {
            currentUser = null;
            return true;
        } 
        else 
        {
            // Inform the user that logout cannot happen without an active session.
            System.out.println("No user is currently logged in.");
            return false;
        }
    }

    public Analyst getCurrentUser() 
    { 
        // Return the analyst who is currently logged in.
        return currentUser; 
    }

    public Vector<Analyst> getAnalysts() 
    { 
        // Return all registered analysts.
        return analysts; 
    }

    public boolean isLoggedIn() 
    {
        // A user is logged in if currentUser is not null.
        return currentUser != null;
    }
}
 