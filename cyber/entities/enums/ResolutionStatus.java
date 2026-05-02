package entities.enums;

public enum ResolutionStatus
{
    // Incident has been recorded but work has not fully started.
    LOGGED,

    // Incident is currently being investigated or fixed.
    RESOLVING,

    // Incident has been handled or closed.
    RESOLVED;
}