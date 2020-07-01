package array_method_in_java.bai_tap;

import java.lang.reflect.Array;

public class AddUpArray {
    public static void main(String[] args) {
        int[] array1= new int[10];
        int[] array2= new int[5];
        int[] array3= new int[15];
        for (int i=0;i<array1.length;i++) {
            array1[i]=i;
        }
//        for (int i=0;i<array2.length;i++) {
//            array1[i]=i;
//        }
        for (int i=0;i<array1.length;i++) {
            array3[i]=array1[i];
        }
        for (int i=0;i<array2.length;i++) {
            array3[array1.length+i]=i;
        }
        for (int i=0;i<array3.length;i++){
            System.out.print(array3[i]+ " ");
        }
    }
}
