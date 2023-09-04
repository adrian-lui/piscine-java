import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        // your code here
        if (dateTime == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'Le' d MMMM 'de l'" + "'"+"an' YYYY 'à' H'h'm'm et' s's'", Locale.FRENCH);
        return dateTime.format(formatter);
    }

    public static String formatSimple(LocalDate date) {
        // your code here
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yy", Locale.ITALIAN);
        return date.format(formatter);
    }

    public static String formatIso(LocalTime time) {
        // your code here
        if (time == null ) {
            return null;
        }
        return time.toString();
    }
    public static void main(String[] args) {
        System.out.println(FormatDate.formatToFullText(LocalDateTime.of(2021, 8, 22, 13, 25, 46)));
        System.out.println(FormatDate.formatSimple(LocalDate.of(2022, 2, 13)));
        System.out.println(FormatDate.formatIso(LocalTime.of(16, 18, 56, 8495847)));
    }
}