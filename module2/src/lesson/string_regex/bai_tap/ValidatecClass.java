package lesson.string_regex.bai_tap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatecClass {
    public static final String REGEX_NAME_CLASS="([CAP])\\d{4}([GHIKLM])";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name Class");
        String nameClass= scanner.nextLine();
        Pattern pattern=Pattern.compile(REGEX_NAME_CLASS);
        Matcher matcher=pattern.matcher(nameClass);
        if (matcher.matches()){
            System.out.println("Is Name Class");
        } else {
            System.out.println("Is Not Name Class");
        }
    }
}
