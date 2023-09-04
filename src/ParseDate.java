import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.time.format.DateTimeFormatter;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        // your code here
        if (stringDate == null) {
            return null;
        }
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        // your code here
        if (stringDate == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM y", Locale.FRENCH);
        return LocalDate.parse(stringDate, formatter);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        // your code here
        if (stringDate == null) {
            return null;
        }
        String[] str = stringDate.split(" ");
        boolean am = true;
        List<Integer> result = new ArrayList<>();
        for (String x : str) {
            if (x.contains("soir")) {
                am = false;
            }
           if (isNumeric(x)) {
               result.add(Integer.parseInt(x));
           }
        }
        return LocalTime.of(am? result.get(0) : result.get(0) + 12, result.get(1), result.get(2));
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}