package array_list_linked_list.bai_tap.linked_list;

public class MyLinkedListTest {
    public static void main(String[] args) {
        class Student {
            private int id;
            private String name;

            public Student() {
            }

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        Student student = new Student(1, "Nhat");
        Student student1 = new Student(1, "Hai");
        Student student2 = new Student(1, "Quang");
        Student student3 = new Student(1, "Hoang");
        Student student4 = new Student(1, "Chương");
        myLinkedList.addFirst(student);
        myLinkedList.addLast(student1);
        myLinkedList.addFirst(student2);
        myLinkedList.add(1,student3);
        System.out.println(myLinkedList.indexof(student4));
        myLinkedList.remove(2);
        for (int i=0;i<myLinkedList.size();i++){
            Student students = (Student) myLinkedList.get(i);
            System.out.println(students.getName());
        }
        System.out.println(myLinkedList.constrains(student2));
        MyLinkedList<Student> cloneLinkedList =myLinkedList.clone();
        for (int i=0;i<cloneLinkedList.size();i++){
            Student students = (Student) cloneLinkedList.get(i);
            System.out.println(students.getName());
        }
    }}
//        MyLinkedList linkedList= new MyLinkedList();
//        linkedList.add(0,"nha");
////        for (Object object : linkedList){
////        System.out.println();}
////        linkedList.addFirst(1);
////        linkedList.addLast(11);
//        for (int i=0;i<linkedList.getSize();i++){
//            System.out.println(linkedList.get(i));
//        }
//
////        System.out.println(linkedList.printList());
//    }