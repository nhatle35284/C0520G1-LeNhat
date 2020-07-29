package lesson.abstrac_in_java.thuc_hanh.comparable_circle;

import lesson.inheritance.bai_tap.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
public ComparableCircle(){

    super(3.6);
}
public ComparableCircle(double radius){
    super(3.6);
}
public ComparableCircle(double radius,String color,boolean filled){
    super(3.6);
}

    @Override
    public int compareTo(ComparableCircle o) {
        if(getRadius()>o.getRadius()) return 1;
        else if (getRadius()<o.getRadius()) return -1;
        else return 1;
    }
}
