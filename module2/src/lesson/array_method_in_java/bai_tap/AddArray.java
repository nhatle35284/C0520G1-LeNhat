package lesson.array_method_in_java.bai_tap;

import java.util.Scanner;

public class AddArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Input Number");
        int input = scanner.nextInt();
        System.out.println("Input local index add?");
        int input_add= scanner.nextInt();
        int[] array = {10,4,6,7,8,0,0,0,0,0};
        if (input_add <=1 || input_add >= array.length-1) {
            System.out.println("Không chèn được");
        }
        else {
            for (int j=array.length-1;j>input_add;j--) {
                array[j]=array[j-1];
            }
            array[input_add]=input;
        }
        for (int i=0;i<array.length;i++) {
            System.out.print(array[i]+" ");
        }
    }
}
