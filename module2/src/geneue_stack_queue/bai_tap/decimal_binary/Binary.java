package geneue_stack_queue.bai_tap.decimal_binary;

import java.util.Scanner;
import java.util.Stack;

public class Binary {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Input number decimal: ");
        int number= scanner.nextInt();
        System.out.println("The decimal to binary is: ");
        Dec2Bin(number);
//        int count;
//        while (number >=1) {
//            count = number%2;
//            number/=2;
//            System.out.println(count);
//        }
    }

    private static void Dec2Bin(int number) {
        Stack<Integer> stack = new Stack<>();
        int count;
        stack.push(1);
        stack.push(1);
        stack.push(1);
        while (number >=1) {
           count = number%2;
           stack.push(count);
           System.out.print(stack.peek());
           number/=2;
        }
    }
}
