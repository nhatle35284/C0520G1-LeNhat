package lesson.algorithm_sort.bai_tap;

import java.util.Arrays;

public class InsertionSort {
    public static int[] insertionSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            int element=arr[i];
            int temp=-1;
            for (int k=i-1;k>=0&&arr[k]>element;k--){
                arr[k+1]=arr[k];
                temp=k;
            }
            if (temp!=-1){
            arr[temp]=element;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] array={1,9,5,8,7,3,4,2};
        System.out.println(Arrays.toString(insertionSort(array)));
    }
}
