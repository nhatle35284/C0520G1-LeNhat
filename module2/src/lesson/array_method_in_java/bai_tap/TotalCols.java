package lesson.array_method_in_java.bai_tap;

import java.util.Scanner;

public class TotalCols {
    public static void main(String[] args) {
//        int[][] array2d = {
//                {1, 2, 3},
//                {3, 4, 6},
//                {5, 7, 8},
//        };
        Scanner scanner = new Scanner(System.in);
        System.out.println("input row");
        int row = scanner.nextInt();
        System.out.println("input cols");
        int cols= scanner.nextInt();
        int[][] array2d =new int[row][cols] ;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("array2d ["+i+"]"+"["+j+"] is : ");
                array2d[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Input cols total");
        int colstotal = scanner.nextInt();
        int total = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                total += array2d[i][colstotal - 1];
                break;
            }
        }
        System.out.println("total cols " + cols + " is : " + total);
    }
}
