package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static final String MA_REGEX = "^(\\d{3}|-\\d{2}-\\d{2})|([A-Z]{3}-[A-Z]{2}-[A-Z]{2})$";
    public static final String DIEN_TICH = "^[2-9]\\d(\\.?(\\d*))|([1-9][0-9]\\d+(\\.?(\\d*)))$";

    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean isValid(String str, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        boolean check = matcher.matches();
        return check;
    }
}
