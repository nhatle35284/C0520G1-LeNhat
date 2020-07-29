package lesson.inheritance.bai_tap.point_moveablepoint;

public class TestMoveablePoint {
    public static void main(String[] args) {
        MoveablePoint moveablePoint =new MoveablePoint(1,1,2,2);
        System.out.println(moveablePoint.toString());
        moveablePoint.move();
        System.out.println(moveablePoint.toString());
    }
}
