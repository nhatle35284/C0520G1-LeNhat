package lesson.geneue_stack_queue.bai_tap.check_sym;

import java.util.Scanner;
import java.util.Stack;

public class Symbol {
    public static void main(String[] args) {
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Math : ");
        String operaMath = scanner.nextLine();
        boolean check=true;
        for (int i = 0; i < operaMath.length(); i++) {
            if (operaMath.charAt(i) == '(') {
                leftStack.push(operaMath.charAt(i));
            }
            if (operaMath.charAt(i) == ')') {
                if ( leftStack.size()<=rightStack.size()) {
                    check=false;
                    break;
                } else {
                    rightStack.push(operaMath.charAt(i));
                }
            }
        }
        if(leftStack.size()!=rightStack.size()) {
            check=false;
        }
        if (check==false) {
            System.out.println("false");
        } else {
            System.out.println("ok");
        }
    }
}

