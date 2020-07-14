package geneue_stack_queue.bai_tap.palindrome_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input String Palindrome");
        String chain = scanner.nextLine().toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i =0;i<chain.length();i++) {
            queue.add(chain.charAt(i));
            stack.push(chain.charAt(i));
        }
        boolean checkPalindrome = false;
        while (!queue.isEmpty()&&!stack.isEmpty()) {
            if (queue.poll().equals(stack.pop())){
                checkPalindrome = true;
            } else {
                checkPalindrome = false;
            }
        }
        if (!checkPalindrome) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }
}
