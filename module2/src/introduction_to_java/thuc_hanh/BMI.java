package introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight,height,bmi;
        System.out.print("Your weight (in kilogram) : ");
        weight = scanner.nextDouble();
        System.out.print("Your height (in meters) : ");
        height = scanner.nextDouble();
        bmi = weight/Math.pow(height,2);
        System.out.println("BMI is :"+bmi);
            if (bmi<18) {
                System.out.println("BMI is : "+bmi+" UnderWeight");
            } else if (bmi<25) {
                System.out.println("BMI is : "+bmi+" Normal");
            } else if (bmi<30) {
                System.out.println("BMI is : "+bmi+" OverWeight");
            }
            else {
                System.out.println("BMI is :"+bmi+" Obese");
            }
    }
}
