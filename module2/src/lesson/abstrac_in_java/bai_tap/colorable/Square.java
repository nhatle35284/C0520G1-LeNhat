package lesson.abstrac_in_java.bai_tap.colorable;

public class Square extends Shape implements Colorable {
    double edge=1.0;
    String color="blue";

    public Square() {
    }

    public Square(double edge) {
        this.edge = edge;
    }

    public Square(double edge, String color) {
        this.edge = edge;
        this.color = color;
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Edge is: " + getEdge() + "\n" +
                "Color is: " + getColor() + "\n";
    }

    @Override
    public void HowToColor() {
        System.out.println("Color all four sides");;
    }
}
