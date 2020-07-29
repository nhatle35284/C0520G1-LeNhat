package lesson.geneue_stack_queue.thuc_hanh;

public class LinkedListQueueClient {
    public static void main(String[] args) {
        MyLinkedListQueue queue=new MyLinkedListQueue();
        queue.equeue(10);
        queue.equeue(20);
        queue.dequeue();
        queue.dequeue();
        queue.equeue(30);
        queue.equeue(40);
        queue.equeue(50);
        System.out.println("Dequeue item is "+queue.dequeue().key);
        System.out.println("Dequeue item is "+queue.dequeue().key);
        System.out.println("Dequeue item is "+queue.dequeue().key);
        System.out.println("Dequeue item is "+queue.dequeue().key);
        System.out.println("Dequeue item is "+queue.dequeue().key);
    }
}
