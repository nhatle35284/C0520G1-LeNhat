package array_list_linked_list.bai_tap.linked_list;


public class MyLinkedList<E> {
    private Node head;
    private int numNodes;
    private Node next;
    private Object data;
    public MyLinkedList(Object data){
        head = new Node(data);
    }
    public MyLinkedList(){}
    private  class Node{
        private Node next;
        private Object data;

        private Node(Object data) {
            this.data = data;
        }
        public Object getData(){
            return this.data;
        }
    }
    public void add(int index, Object data) {

        Node temp = head;
        Node holder;

        for(int i=1; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }
    public void addLast(Object data) {
        Node temp=head;
       while (temp.next!=null) {
           temp=temp.next;
       }
       temp.next= new Node(data);
       numNodes++;
    }
    public Object get(int index){
        Node temp=head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public int getSize(){
        return numNodes;
    }
    public int size(){
        return numNodes;
    }
    public E remove(int index) {
        if(index<0 || index>numNodes){
            throw new IllegalArgumentException("Error index "+index);
        }
        Node temp = head;
        Object data;
        if(index==0){
            data =temp.data;
            head=head.next;
        }else {
            for (int i= 0;i<index-1&&temp.next!=null;i++){
                temp=temp.next;
            }
            data=temp.next.data;
            temp.next=temp.next.next;
            numNodes--;
        }
        return (E)data;
    }
    public boolean remove(E e) {
        if(head.data.equals(e)){
            remove(0);
            return true;
        }else {
            Node temp=head;
            while (temp.next!=null){
                if(temp.next.data.equals(e)){
                    temp.next=temp.next.next;
                    numNodes--;
                    return  true;
                }
                temp=temp.next;
            }
        }
        return false;
    }
    public MyLinkedList<E> clone(){
        if(numNodes==0){
                throw new NullPointerException("Linked is Null");
        }
        MyLinkedList<E> returnLinkedList=new MyLinkedList<>();
        Node temp=head;
        returnLinkedList.addFirst((E) temp.data);
        temp=temp.next;
        while (temp!=null){
            returnLinkedList.addLast((E) temp.data);
            temp=temp.next;
        }
        return returnLinkedList;
    }
    public boolean constrains(E e){
        Node temp=head;
        while (temp.next!=null){
            if(temp.data.equals(e)){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public int indexof(E e){
        Node temp=head;
        for(int i=0;i<numNodes;i++){
            if(temp.getData().equals(e)){
                return i;
            }
            temp=temp.next;
        }
        return -1;
    }
}
