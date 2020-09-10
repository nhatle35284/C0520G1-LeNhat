package menu.bo.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static final String REGEX_ID_CUSTOMER = "(KH_\\d{4})";
    public static final String REGEX_ID_SERVICE = "(DV_\\d{4})";
    public static final String REGEX_NUMBER_PHONE = "^((090|091|8490|8491)\\d{7})$";
    public static final String REGEX_ID = "^(\\d{9}|\\d{12})$";
    public static final String REGEX_EMAIL = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
    //   public static final String REGEX_DATE = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
    public static final String INTEGER = "^[1-9]|([1-9]\\d+)$";
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean isValid(String str, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        boolean check = matcher.matches();
        return check;
    }
}
