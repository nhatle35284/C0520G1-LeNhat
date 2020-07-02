package array_method_in_java.bai_tap;

import java.util.Scanner;

public class TotalArraySquare {
    public static void main(String[] args) {
//        int[][] array2D={
//                {1,2,3},
//                {6,5,4},
//                {9,7,8},
//        };
        Scanner scanner = new Scanner(System.in);
        System.out.println("input row");
        int row = scanner.nextInt();
        System.out.println("input cols");
        int cols= scanner.nextInt();
        int[][] array2D =new int[row][cols] ;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("array2d ["+i+"]"+"["+j+"] is : ");
                array2D[i][j] = scanner.nextInt();
            }
        }
        int total=0;
        for (int i=0;i<array2D.length;i++) {
            total += array2D[i][i];
        }
        System.out.println("total diagonal square maxtric is: "+total);
    }
}
