package algorithm_search.bai_tap.binary_search_recursive;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={2,4,6,8,9,11,12};
        Scanner scanner =new Scanner(System.in);
        System.out.println("Input key search: ");
        int key=scanner.nextInt();
        System.out.println(search(arr,key,0,arr.length));
    }
    public static int search(int[] arr, int key, int low, int high) {
        if (high>=1) {
            int mid=(low+high-1)/2;
            if (arr[mid]==key){
                return mid;
            }
            if (arr[mid]>key){
                return search(arr,key,low,high-1);
            }if (arr[mid]<key){
                return search(arr,key,low-1,high);
            }
        }
        return -1;
    }
}
