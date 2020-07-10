package array_list_linked_list.bai_tap;

public class MyListTest {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.add(0,"Student1");
        System.out.println(list);
        list.add(1,"Student2");
        list.add(2,"Student3");
        list.add(3,"Student4");
        list.add(4,"Student5");
        System.out.println(list);
        list.remove(2);
        list.get(3);
//        list.clone();
    }
}
