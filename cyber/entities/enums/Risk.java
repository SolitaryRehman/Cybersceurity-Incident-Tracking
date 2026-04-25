package entities.enums;
public enum Risk
{
    NONE (1),
    LOW (2),
    MEDIUM (3),
    HIGH (4),
    CRITICAL(5);

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