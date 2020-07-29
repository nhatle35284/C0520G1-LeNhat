package lesson.oop_in_java.thuc_hanh;

import java.util.Scanner;

public class Hinhchunhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the width:");
        double width = scanner.nextDouble();
        System.out.print("Enter the height:");
        double height = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Your Rectangle \n" + rectangle.display());
        System.out.println("Perimeter of the Rectangle: " + rectangle.getPerimeters());
        System.out.println("Area of the Rectangle: " + rectangle.getArena());
    }
}

class Rectangle {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArena() {return width * height;}

    public double getPerimeters() {
        return (width + height) / 2;
    }

    public String display() {
        return "Rectangle{" + " height = " + height + " width=" + width;
    }
}


