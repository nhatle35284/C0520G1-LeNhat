package oop_in_java.bai_tap;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

}
    public double getDiscriminant() {
        return  Math.pow(b,2)-4*a*c;
    }
}
