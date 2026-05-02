package entities.enums;
public enum Risk
{
    // No meaningful risk identified.
    NONE (1),

    // Low risk with limited possible impact.
    LOW (2),

    // Medium risk that should be monitored.
    MEDIUM (3),

    // High risk that needs quick attention.
    HIGH (4),

    // Critical risk that needs immediate action.
    CRITICAL(5);

    // Numeric score used for alert calculations.
    private final int score;

    Risk(int score)
    {
        this.score = score;
    }

    public int getScore()
    {
        return score;
    }
}