package lesson.loop_in_java.thuc_hanh;

import java.util.Scanner;

public class UocChungLonNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1, number2,number3;
        System.out.println("Enter number1: ");
        number1 = scanner.nextInt();
        System.out.println("Enter number2: ");
        number2 = scanner.nextInt();
        number1 = Math.abs(number1);
        number2 = Math.abs(number2);
        if (number1 == 0 && number2 == 0) {
            System.out.println("No greatest common factor");
        }
        while (number1 != number2) {
            if (number1 > number2) {
                number3 = number1-number2;
            } else {
                number3 = number2-number1;
            }
            System.out.println("Greatest common factor: " + number3 );
            break;
        }

    }
}
