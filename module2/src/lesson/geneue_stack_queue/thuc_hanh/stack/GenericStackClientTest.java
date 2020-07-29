package lesson.geneue_stack_queue.thuc_hanh.stack;

class GenericStackClient {
    private static void stackOfStrings() {
        MyGenerListStack<String> stack = new MyGenerListStack<>();
        stack.push("Five");
        stack.push("Four");
        stack.push("Three");
        stack.push("Two");
        stack.push("One");
        System.out.println("1.1 Size of stack after push operations: "+stack.size());
        System.out.println("1.2 Pop element from stack " );
        while (!stack.isEmpty()) {
            System.out.println(""+stack.pop());
        }
        System.out.println("1.3. Size of stack after pop operations : "+stack.size());
    }

    private static void stackOfIntegers() {
        MyGenerListStack<Integer> stack = new MyGenerListStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("1.1 Size of stack after push operations: "+stack.size());
        System.out.println("1.2 Pop element from stack " );
        while (!stack.isEmpty()) {
            System.out.println(""+stack.pop());
        }
        System.out.println("1.3. Size of stack after pop operations : "+stack.size());
    }
    public static void main(String[] args) {
        System.out.println("1. Stack of integers");
        stackOfIntegers();
        System.out.println("2. Stack of Strings");
        stackOfStrings();
    }
}
