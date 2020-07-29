package lesson.exception.bai_tap;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String message) {
        super(message);
    }

    public static void triangle(int a, int b, int c) throws IllegalTriangleException {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalTriangleException("side error");
        }
        if (a + b < c || b + c < a || a + c < b) {
            throw new IllegalTriangleException("total two sile error");
        } else {
            System.out.println("true");
        }
    }
}
