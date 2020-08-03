package lesson.string_regex.bai_tap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNumberPhone {
    public static final String REGEX_NUMBER_PHONE= "84-0[1-9]\\d{8}";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number Phone: ");
        String numberPhone= scanner.nextLine();
        Pattern pattern=Pattern.compile(REGEX_NUMBER_PHONE);
        Matcher matcher=pattern.matcher(numberPhone);
        if (matcher.matches()){
            System.out.println("Is Number Phone");
        } else {
            System.out.println("Is Not Number Phone");
        }
    }
}