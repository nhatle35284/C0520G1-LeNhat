package lesson.geneue_stack_queue.bai_tap.demerging;

import java.util.*;

public class Demergings  {


    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student student = new Student("Nhat", "male", 20);
        Student student1 = new Student("Hai", "female", 21);
        Student student2 = new Student("Quang", "female", 19);
        list.add(student);
        list.add(student1);
        list.add(student2);
        Queue<Student> feMale = new LinkedList<>();
        Queue<Student> male = new LinkedList<>();
        Comparator comparator = new SortAge();
        Collections.sort(list,comparator);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Name is: "+list.get(i).getName()+" Age is: "+list.get(i).getAge()+" Gender is: "+list.get(i).getGender());
            if ("female".equals(list.get(i).getGender())) {
                feMale.add(list.get(i));
            } else if ("male".equals(list.get(i).getGender())) {
                male.add(list.get(i));
            }
         }  
        int count=0;
        while (!feMale.isEmpty()) {
            list.set(count,feMale.poll());
            count++;
        }

        while (!male.isEmpty()) {
            list.set(count,male.poll());
            count++;
        }
        System.out.println("-------------------------");
        for (int i=0 ;i<list.size();i++) {
            System.out.println("Name is: "+list.get(i).getName()+" Age is: "+list.get(i).getAge()+" Gender is: "+list.get(i).getGender());

        }
    }
}
