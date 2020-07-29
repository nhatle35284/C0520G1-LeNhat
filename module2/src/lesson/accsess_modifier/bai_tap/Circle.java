package lesson.accsess_modifier.bai_tap;

import java.util.Scanner;

class TestCircle {
    private double radius = 1.0;
    private String color  = "Red";
    public void Circle() {}
    public void Circle(double radius) {
        this.radius=radius;
    }
    public static double getRadius(double radius){
        return radius;
    }
    public static double getArena(double radius){
        return (radius*radius*Math.PI);
    }
}
public class Circle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TestCircle circle = new TestCircle();
        circle.Circle(10);
        TestCircle.getRadius(10);
        System.out.println("Kết Quả là :"+TestCircle.getRadius(10));
    }
}
