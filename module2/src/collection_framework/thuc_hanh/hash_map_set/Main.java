package collection_framework.thuc_hanh.hash_map_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Nam",20, "HN");
        Student student2 = new Student("Hung",21, "HN");
        Student student3 = new Student("qanknk",19, "HN");
        // write your code here
        Map<Student,Integer> studentMap = new HashMap<>();
        studentMap.put(student1,1);
        studentMap.put(student2,2);
        studentMap.put(student3,3);

        for(Map.Entry<Student,Integer> student : studentMap.entrySet()){
            System.out.println(student.toString());
        }
        System.out.println("...........Set");
        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student1);

        for(Student student : students){
            System.out.println(student.toString());
        }
    }
}