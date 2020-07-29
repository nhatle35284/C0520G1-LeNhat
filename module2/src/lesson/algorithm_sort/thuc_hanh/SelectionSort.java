package lesson.algorithm_sort.thuc_hanh;

import java.util.Arrays;

public class SelectionSort {
    public static double[] selectionSort(double[] arr){
        for (int i=0;i<arr.length-1;i++){
            double min=arr[i];
            int index=i;
            for (int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                   min=arr[j];
                   index=j;
                }
            }
            if(index!=i){
                arr[index]=arr[i];
                arr[i]=min;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        double[] array={1,9,-3.5,6.5,7.4,9.1};
        System.out.println(Arrays.toString(selectionSort(array)));
    }
}
