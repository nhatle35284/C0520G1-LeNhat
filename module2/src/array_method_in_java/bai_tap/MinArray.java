package array_method_in_java.bai_tap;

import java.util.Scanner;

public class MinArray {
    public static void main(String[] args) {
        int size;
        int[] arr;
        Scanner scanner= new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);
        arr =new int[size];
        int i = 0;
        while (i < arr.length) {
            System.out.print("Enter element" + (i + 1) + " : ");
            arr[i] = scanner.nextInt();
            i++;
        }
        int index = minValue(arr);
        System.out.println("The smallest in the array is "+arr[index]);
    }
    public static int minValue(int[] array) {
        int min = array[0];
        int index = 0;
        for (int i=0;i<array.length;i++) {
            if (array[i]<min) {
                min = array[i];
                index=i;
            }
        }
        return index;
    }

}
