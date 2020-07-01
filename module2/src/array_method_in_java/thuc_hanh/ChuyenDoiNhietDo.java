package array_method_in_java.thuc_hanh;

import java.util.Scanner;

public class ChuyenDoiNhietDo {
    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }

    public static double fahrenheitToCelius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit + 32);
        return celsius;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double fahrenheit;
        double celsius;
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Fahrenheit To Celsius");
            System.out.println("2. Celsius To Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Fahrenheit: ");
                    fahrenheit=input.nextDouble();
                    System.out.println("Fahrenheit To Celsius : "+fahrenheitToCelius(fahrenheit));
                    break;
                case 2:
                    System.out.println("Enter Celsius: ");
                    celsius=input.nextDouble();
                    System.out.println("Fahrenheit To Celsius : "+celsiusToFahrenheit(celsius));
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice !=0);
    }
}
