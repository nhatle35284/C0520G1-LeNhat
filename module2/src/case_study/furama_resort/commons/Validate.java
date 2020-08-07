package case_study.furama_resort.commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
//    public static final String SEVICE_ID_VILLA_REGEX = "^(SVVL-[\\d]{4})$";
//    public static final String SEVICE_ID_HOUSE_REGEX = "^(SVHO-[\\d]{4})$";
//    public static final String SEVICE_ID_ROOM_REGEX = "^(SVRO-[\\d]{4})$";
//    public static final String SEVICE_NAME_REGEX = "^([A-Z][a-z]*)$";
//    public static final String EXTRA_SERVICE_NAME_REGEX = "^(massage)|(karaoke)|(food)|(drink)|(car)$";

    private static Pattern pattern;
    private static Matcher matcher;
    public static boolean isValid(String str, String regex){
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        boolean check = matcher.matches();
        if (!check){
            System.out.println("Input is wrong !!!" + regex);
        }
        return check;
    }
//    public static boolean isMoreThan (double number, double numberToCompare) {
//        boolean check = number > numberToCompare;
//        if(!check){
//            System.out.println("This number is not more than " + numberToCompare);
//        }
//        return check;
//    }
//    public static boolean isLessThanAndMoreThan (double number, double smallerNumber, double biggerNumber) {
//        boolean check = number > smallerNumber && number < biggerNumber;
//        if(!check){
//            System.out.println("This number is wrong !!!");
//        }
//        return check;
//    }
}