package oop_in_java.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập a ");
        double number1= input.nextDouble();
        System.out.println("Nhập b ");
        double number2= input.nextDouble();
        System.out.println("Nhập c ");
        double number3= input.nextDouble();
        Quadratic quadratic = new Quadratic(number1,number2,number3);
        if (quadratic.getDiscriminant()>0) {
            System.out.println("nghiệm thú nhất là: "+quadratic.getRoot1()+"\n"+"nghiệm thứ 2 là: "+quadratic.getRoot2());
        } else if (quadratic.getDiscriminant()==0) {
            System.out.println("Phương trình có một nghiệm: "+quadratic.getRoot1());
        } else {
            System.out.println("The equation has no roots");

        }
    }
}
    class Quadratic{
    private double a;
    private double b;
    private double c;

    public Quadratic(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

}
    public double getDiscriminant() {
        return  Math.pow(b,2)-4*a*c;
    }
    public double getRoot1() {
        return ((-b+Math.sqrt(getDiscriminant()))/(2*a));
    }public double getRoot2() {
        return ((-b-Math.sqrt(getDiscriminant()))/(2*a));
    }
}
