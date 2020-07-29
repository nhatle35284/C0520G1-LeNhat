package lesson.geneue_stack_queue.bai_tap.reverse_element;

import java.util.Stack;

public class ReverseElement {
    public static void main(String[] args) {
        Stack<String> mStack = new Stack<>();
        Stack<String> stack = new Stack<>();
        mStack.push("1");
        mStack.push("2");
        mStack.push("3");
        mStack.push("4");
        mStack.push("5");
        System.out.println(mStack);
        while (!mStack.isEmpty()){
           stack.push(mStack.peek());
            mStack.pop();
        }
        System.out.println(stack);
    }
}
