package lesson.geneue_stack_queue.bai_tap.reverse_element;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> numbers = new LinkedList<>();
        numbers.add(1);
        numbers.offer(2);
        numbers.offer(3);
        System.out.println("Queue: " + numbers);
    }



}
