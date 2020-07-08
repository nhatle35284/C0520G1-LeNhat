package inheritance.bai_tap;

import java.util.Scanner;

public class Circle {
    public double radius;
    public String color;
    public Circle(double radius,String color) {
        this.radius=radius;
        this.color=color;
    }

    public Circle(double v, String indigo, boolean b) {
    }

    public Circle(double v) {

    }

    public Circle() {

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius,String color) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArena() {
        return Math.PI*Math.pow(radius,2);
    }

    @Override
    public String toString() {
        return "The radius of the circle is: "+getRadius()+"\n" +
                "circle color is: "+getColor()+"\n"+
                "Arena is: "+getArena();
    }
}
class Cylinder extends Circle{
    public double height;
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Cylinder(double radius,double height,String color) {
        super(radius,color);
        this.height=height;
    }
    public double getArenaCylinder() {
        return super.getArena()*height;
    }

    @Override
    public String toString() {
        return "The radius of the circle is: "+radius+"\n" +
                "circle color is: "+color+"\n"+
                "height is: " +height+"\n"+
                "ArenaCylinder: "+getArenaCylinder();
    }
}
//class TestCircle{
//    public static void main(String[] args) {
//        Circle circle = new Circle(10,"red");
//        System.out.println(circle.toString());
//    }
//}
class TestCylinder{
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter color: ");
        String color=scanner.nextLine();
        System.out.println("Enter Radius :");
        double radius=scanner.nextDouble();
        System.out.println("Enter Height :");
        double height=scanner.nextDouble();
        Cylinder cylinder = new Cylinder(radius,height,color) ;
        System.out.println(cylinder.toString());
    }
}
