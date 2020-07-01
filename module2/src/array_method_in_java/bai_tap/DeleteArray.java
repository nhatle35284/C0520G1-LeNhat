package array_method_in_java.bai_tap;

import java.util.Scanner;

public class DeleteArray {
    public static void main(String[] args) {
        int []array = {10,4,6,7,8,6,0,0,0,0};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Number want delete");
        int input = scanner.nextInt();
        int index=0;
        for (int i=0;i<array.length;i++) {
            if (array[i]==input) {
                index=i;
                System.out.println("Input Number is :"+array[i]+" index is: "+(i+1));
            }
        }for (int j=index;j<array.length-1;j++) {
            array[j]=array[j+1];
        }
        for (int k : array ) {
            System.out.print(k+" ");
        }
    }
}
