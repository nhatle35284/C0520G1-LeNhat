package lesson.exception.bai_tap;

import java.util.InputMismatchException;
import java.util.Scanner;

import static lesson.exception.bai_tap.IllegalTriangleException.triangle;

public class IllegalTriangleExceptionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("input a: ");
            int a = scanner.nextInt();
            System.out.println("input b: ");
            int b = scanner.nextInt();
            System.out.println("input c: ");
            int c = scanner.nextInt();
            triangle(a, b, c);
        } catch (InputMismatchException e) {
            System.out.println("lỗi định dang");
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
