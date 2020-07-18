package algorithm_sort.bai_tap;

import java.util.Arrays;

public class InsertionSort {
    public static int[] insertionSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            int element=arr[i];
            int k=i-1;
            for (;k>=0&&arr[k]>element;k--){
                arr[k+1]=arr[k];
            }
            arr[k+1]=element;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] array={1,9,5,8,7,3,4,2};
        System.out.println(Arrays.toString(insertionSort(array)));
    }
}
