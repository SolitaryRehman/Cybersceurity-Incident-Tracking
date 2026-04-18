package entities.enums;

public enum Severity
{
    LOW (1),
    MEDIUM (2),
    HIGH (3),
    CRITICAL(4);

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