package inheritance.bai_tap;

import inheritance.thuc_hanh.shape.Shape;

public class Triangle extends Shape {
    double side1=1.0;
    double side2=1.0;
    double side3=1.0;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle() {
    }
    public double getPerimeter(){
        return side1+side2+side3;
    }
    public double getArena(){
        double p=getPerimeter()/2;
        return side1*((Math.sqrt(p*(p-side1)*(p-side2)*(p-side3)))/side1);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }

    public static void main(String[] args) {
        Triangle triangle=new Triangle(4,3,5);
        System.out.println(triangle.toString());
        System.out.println(triangle.getArena());
    }
}
