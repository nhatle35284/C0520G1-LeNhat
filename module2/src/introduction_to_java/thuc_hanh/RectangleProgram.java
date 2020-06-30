package introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class RectangleProgram {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Width: ");
        width = scanner.nextFloat();
        System.out.println("Enter Height: ");
        height = scanner.nextFloat();
        float arena = width*height;
        System.out.println("Arena: "+arena);
    }
}
