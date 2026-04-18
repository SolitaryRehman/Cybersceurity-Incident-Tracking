package entities.enums;
public enum Risk
{
    LOW (1),
    MEDIUM (2),
    HIGH (3),
    CRITICAL(4);

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