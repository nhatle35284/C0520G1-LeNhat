package algorithm_sort.bai_tap;

import java.util.Scanner;

public class InsertionSortStep {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Input size array: ");
        int size=scanner.nextInt();
        int[] array=new int[size];
        for(int i=0;i<array.length;i++){
            System.out.print("Input  array element "+(i+1)+": ");
            array[i]=scanner.nextInt();
        }
    }
}
