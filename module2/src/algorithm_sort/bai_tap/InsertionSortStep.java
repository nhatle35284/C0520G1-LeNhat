package algorithm_sort.bai_tap;

import java.util.Arrays;
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
        System.out.println("Array after sort: ");
        System.out.println(Arrays.toString(insertionSort(array)));
    }
    public static int[] insertionSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            System.out.println("element assign arr["+i+"] is "+arr[i]);
            int element=arr[i];
            int k=i-1;
            for (;k>=0&&arr[k]>element;k--){
                System.out.println("arr "+k+1+" assign arr["+k+"] is : "+arr[k]);
                arr[k+1]=arr[k];
            }
            System.out.println("arr["+k+1+"] is: "+element);
            arr[k+1]=element;
            System.out.println();
        }
        return arr;
    }
}
