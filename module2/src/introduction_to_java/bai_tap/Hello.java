package introduction_to_java.bai_tap;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter Name :");
        String name = scanner.nextLine();
        System.out.println("Hello "+name);
    }
}
