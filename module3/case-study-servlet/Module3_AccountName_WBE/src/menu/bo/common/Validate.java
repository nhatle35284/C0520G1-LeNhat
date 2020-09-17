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
    public static final String DOUBLE_20 = "^[2-9]\\d(\\.?(\\d*))|([1-9][0-9]\\d+(\\.?(\\d*)))$";
    public static final String ID_REGEX = "^(\\d{3}-\\d{2}-\\d{2})|([A-Z]{3}-[A-Z]{2}-[A-Z]{2})$";


        public static final String REGEX_DATE = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean isValid(String str, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        boolean check = matcher.matches();
        return check;
    }

    public static String changeFormatDateSQL(String date) {
        String[] array = date.split("/");
        return array[2] +"-"+ array[1] +"-"+ array[0];
    }
    public static String changeFormatDateDisplay(String date) {
        String[] array = date.split("-");
        return array[2] +"/"+ array[1] +"/"+ array[0];
    }
}
