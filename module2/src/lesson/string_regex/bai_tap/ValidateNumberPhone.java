package lesson.string_regex.bai_tap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNumberPhone {
    public static final String REGEX_NUMBER_PHONE = "^[2-9]\\d(\\.?(\\d*))|([1-9][0-9]\\d+(\\.?(\\d*)))$";
//    public static final String REGEX_NUMBER_PHONE = "^([12]\\d{2,}(\\.|\\d{0,})*)|(([3-9][0-9])(\\.|\\d{0,})*)$";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number Phone: ");
        String numberPhone= scanner.nextLine();
        Pattern pattern=Pattern.compile(REGEX_NUMBER_PHONE);
        Matcher matcher=pattern.matcher(numberPhone);
        if (matcher.matches()){
            System.out.println("OK");
        } else {
            System.out.println("NOT OK");
        }
    }
}
