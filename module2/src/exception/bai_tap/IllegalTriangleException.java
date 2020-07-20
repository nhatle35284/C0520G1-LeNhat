package exception.bai_tap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String message){
        super(message);
    }
    public static void Triangle(int a,int b,int c) throws IllegalTriangleException {
        if (a<0||b<0||c<0) {
            throw new IllegalTriangleException("side error");
        } if(a+b<c||b+c<a||a+c<b) {
            throw new IllegalTriangleException("total two sile error");
        } else {
            System.out.println("true");
        }
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        try{
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            int c=scanner.nextInt();
            Triangle(a,b,c);
        } catch (InputMismatchException e) {
            System.out.println("lỗi định dang");
        } catch (IllegalTriangleException e){
            System.out.println(e.getMessage());
        }
    }
}
