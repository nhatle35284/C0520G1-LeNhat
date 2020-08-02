package lesson.string_regex.bai_tap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatecClass {
//    public static final String REGEX_NAME_CLASS="([CAP])\\d{4}([GHIKLM])";
    public static final String REGEX_NAME_CLASS = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameClass;
        Matcher matcher;
        Pattern pattern;
        do {
            System.out.println("Enter Name Class");
            nameClass= scanner.nextLine();
            pattern=Pattern.compile(REGEX_NAME_CLASS);
            matcher=pattern.matcher(nameClass);
        }while (!matcher.matches());
//        if (matcher.matches()){
//            System.out.println("Is Name Class");
//        } else {
//            System.out.println("Is Not Name Class");
//        }
//        let nhapThangNam;
//        let ngayTrongThang=[31,28,31,30,31,30,31,31,30,31,30,31];
//        do {
//            nhapThangNam = prompt("Nhập Ngày MM/yyyy");
//            let patNgay=/^((0[1-9]|1[0-2])\/(19\d{2}|(20[0-2]\d)))$/;
//            check=patNgay.test(nhapThangNam);
//        }while (!check);
    }
}
