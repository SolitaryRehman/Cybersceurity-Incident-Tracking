package entities.enums;

public enum Severity
{
    // Minor severity with limited impact.
    LOW (1),

    // Moderate severity that should be reviewed.
    MEDIUM (2),

    // Serious severity that needs prompt attention.
    HIGH (3),

    // Most severe level, requiring immediate action.
    CRITICAL(4);

    // Numeric score used when calculating alert priority.
    private final int score;

    Severity(int score)
    {
        this.score = score;
    }

    public int getScore()
    {
        return score;
    }

}