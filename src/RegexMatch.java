import java.io.IOException;
public class RegexMatch {
    public static boolean containsOnlyAlpha(String s) {
        // your code here
        if (s == null) {
            return false;
        }
        return s.matches("^[a-zA-Z]+$");
    }

    public static boolean startWithLetterAndEndWithNumber(String s) {
        // your code here
        if (s == null) {
            return false;
        }
        return s.matches("^[a-zA-Z].+[0-9]$");
    }

    public static boolean containsAtLeast3SuccessiveA(String s) {
        // your code here
        if (s == null) {
            return false;
        }
        return s.matches(".+A{3}.+");
    }

    public static void main(String[] args) throws IOException {
        System.out.println(RegexMatch.containsOnlyAlpha("azejkdfhjsdf"));
        System.out.println(RegexMatch.containsOnlyAlpha("azejkd fhjsdf"));
        System.out.println(RegexMatch.startWithLetterAndEndWithNumber("asjd jd34jds jkfd6f5"));
        System.out.println(RegexMatch.startWithLetterAndEndWithNumber("asjd jd34jds jkfd6."));
        System.out.println(RegexMatch.containsAtLeast3SuccessiveA("sdjkAAAAAsdjksj"));
        System.out.println(RegexMatch.containsAtLeast3SuccessiveA("sdjkAAsdaaasdjksj"));
    }
}