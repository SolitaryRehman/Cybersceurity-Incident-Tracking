package entities.enums;

public enum AlertLevel
{
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private final int code;

    AlertLevel(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return code;
    }
}

