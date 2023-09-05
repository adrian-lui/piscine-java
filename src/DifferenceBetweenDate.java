import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;

public class DifferenceBetweenDate {

    public static Duration durationBetweenTime(LocalTime localTime1, LocalTime localTime2) {
        // your code here
        if (localTime1 == null || localTime2 == null) {
            return null;
        }
        if (Duration.between(localTime1, localTime2).isNegative()) {
            return Duration.between(localTime2, localTime1);
        } else {
            return Duration.between(localTime1, localTime2);
        }
    }

    public static Period periodBetweenDate(LocalDate date1, LocalDate date2) {
        // your code here
        if (date1 == null || date2 == null) {
            return null;
        }
        if (Period.between(date1, date2).isNegative()) {
            return Period.between(date2, date1);
        } else {
            return Period.between(date1, date2);
        }
    }

    public static Long numberOfHoursBetweenDateTime(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        // your code here
        if (dateTime1 == null || dateTime2 == null) {
            return null;
        }
        Duration dur;
        if (Duration.between(dateTime1, dateTime2).isNegative()) {
            dur = Duration.between(dateTime2, dateTime1);
        } else {
            dur = Duration.between(dateTime1, dateTime2);
        }
        return dur.getSeconds() / 60 / 60;
    }
}
