import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegexReplace {
    public static String removeUnits(String s) {
        // your code here
        if (s == null) {
            return null;
        }
        return s.replaceAll("(?<=\\d)cm(?!\\S)", "").replaceAll("(?<=\\d)€(?!\\S)", "");
    }

    public static String obfuscateEmail(String s) {
        // your code here
        if (s == null) {
            return null;
        }
        List<String> list = new ArrayList<>(Arrays.stream(s.split("@")).toList());
        String username = list.get(0);
        String hidden = "";
        if (username.contains("_") || username.contains(".") || username.contains("-")) {
            if (username.contains("_")) {
                hidden += username.substring(0, username.indexOf("_")+1);
            }
            if (username.contains("-")) {
                hidden += username.substring(0, username.indexOf("-")+1);
            }
            if (username.contains(".")) {
                hidden += username.substring(0, username.indexOf(".")+1);
            }
            hidden += "*".repeat(username.length() - hidden.length());
        } else if (username.length() > 3) {
            if (username.length() == 4) {
                hidden += username.substring(0, username.length()-1);
                hidden += "*";
            } else {

            hidden += username.substring(0, username.length()-3);
            hidden += "*".repeat(3);
            }

        }
        list.set(0, hidden);

        List<String> domains = new ArrayList<>(Arrays.asList(list.get(1).split("\\.")));
        if (domains.size() == 3) {
            domains.set(0, "*".repeat(domains.get(0).length()));
            domains.set(2, "*".repeat(domains.get(2).length()));
        } else if (domains.size() == 2) {
            domains.set(0, "*".repeat(domains.get(0).length()));
            if (!domains.get(1).matches("^(com|org|net)$")) {
                domains.set(1, "*".repeat(domains.get(1).length()));
            }
        }
        list.set(1, domains.stream().collect(Collectors.joining(".")));
        return list.stream().collect(Collectors.joining("@"));
    }
}
