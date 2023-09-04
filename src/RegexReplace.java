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
        String username = list.get(0).replaceAll("(\\.|-|_)", "_");
        String hidden = "";
        if (username.contains("_")) {
            hidden += username.substring(0, username.indexOf("_")-1);
            hidden += "*".repeat(username.length() - username.indexOf("_") + 1);
        } else if (username.length() > 3) {
            hidden += username.substring(0, username.length()-3);
            hidden += "*".repeat(3);
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
    public static void main(String[] args) throws IOException {
        System.out.println(RegexReplace.removeUnits("32cm et 50€"));
        System.out.println(RegexReplace.removeUnits("32 cm et 50 €"));
        System.out.println(RegexReplace.removeUnits("32cms et 50€!"));

        System.out.println(RegexReplace.obfuscateEmail("john.doe@example.com"));
        System.out.println(RegexReplace.obfuscateEmail("jann@example.co.org"));
        System.out.println(RegexReplace.obfuscateEmail("jackob@example.fr"));
    }
}