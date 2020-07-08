package abstrac_in_java.bai_tap.colorable;

public class TestColorableSquare {
    public static void main(String[] args) {
        Square square=new Square();
        System.out.println(square.toString());
        square.HowToColor("red");
        System.out.println(square.toString());
    }
}
