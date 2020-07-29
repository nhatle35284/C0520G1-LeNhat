package lesson.abstrac_in_java.bai_tap.colorable;

public class Circle extends Shape {
    double radius = 1.0;
    String color = "red";
    public Circle() {
    }
    public Circle(double radius){
    this.radius=radius;
    }
    public Circle(double radius,String color) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return radius * radius * Math.PI;
    }
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }
    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", subclass of shape "
                + super.toString()
                + ", Area=" +
                + getArea();

}

}
