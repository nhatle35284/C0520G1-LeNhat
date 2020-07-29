package lesson.abstrac_in_java.bai_tap.colorable;

public class TestColorableSquare {
    public static void main(String[] args) {
       Shape[] shapes=new Shape[3];
        shapes[0] = new Rectangle(3.0,2.0,"blue",true);
        shapes[1] = new Square(3.0,"blue");
        shapes[2] = new Circle(3.4,"blue");
        for (Shape a: shapes){
            System.out.println(a.toString());
        }for (Shape a: shapes){
            if(a instanceof Square) {
                Square find= (Square)a;
                System.out.println(a);
                find.HowToColor();
            }
        }
    }
}
