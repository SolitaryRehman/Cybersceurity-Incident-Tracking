package entities.enums;

public enum AlertLevel
{
    // Low-priority alert for routine or minor incidents.
    LOW(1),

    // Medium-priority alert for incidents that may need attention.
    MEDIUM(2),

    // High-priority alert for serious or urgent incidents.
    HIGH(3);

    // Numeric code used to convert user/system scores into alert levels.
    private final int code;

    AlertLevel(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return code;
    }

    public static AlertLevel fromInt(int value) {
        // Search for an alert level with the matching numeric code.
        for (AlertLevel s : AlertLevel.values()) {
            if (s.code == value) {
                return s;
            }
        }

        // Throw an error if the value does not match any alert level.
        throw new IllegalArgumentException("Invalid Alert Level");
    }
}

