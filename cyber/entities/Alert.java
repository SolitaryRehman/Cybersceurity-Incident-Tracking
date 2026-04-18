package entities;

import entities.enums.AlertType;
import java.time.LocalDateTime;

public class Alert
{
    private static int counter = 1;
    private String alertID;
    private Log log;
    private AlertType type;
    private LocalDateTime triggerTime;

    public Alert(Log log, AlertType type, LocalDateTime triggerTime)
    {
        this.alertID = ("A-" + String.format("%02d", counter++));
        this.type = type;
        this.triggerTime = triggerTime;
    }
}