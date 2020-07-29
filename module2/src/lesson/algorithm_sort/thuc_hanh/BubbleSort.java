package lesson.algorithm_sort.thuc_hanh;

import java.util.Arrays;

public class BubbleSort {
    public static int[] bubbleSort(int[] arr){
        boolean check=true;
        for (int i=1;1<arr.length&&check;i++){
            check=false;
            for (int j=1;j<arr.length-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    check=true;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr ={1,4,3,5,2,8,7,9,6};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

}
