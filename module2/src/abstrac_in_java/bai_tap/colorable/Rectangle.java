package abstrac_in_java.bai_tap.colorable;

public class Rectangle extends Shape implements Colorable {
    @Override
    public void HowToColor() {
        System.out.println("Color all four sides");
    }

    double width = 1.0;
    double length = 1.0;
    public Rectangle() {
    }
    public Rectangle(double width, double length,String color,boolean filled) {
        super(color,filled);
        this.width = width;
        this.length = length;

    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getArea() {
        return width * this.length;
    }
    public double getPerimeter() {
        return 2 * (width + this.length);
    }
    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getLength()
                + ", subclass of shape  "
                + super.toString()
                + ", Area=" +
                + getArea();
    }
}
