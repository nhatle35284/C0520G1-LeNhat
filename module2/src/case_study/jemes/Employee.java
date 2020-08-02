package case_study.jemes;

import java.util.ArrayList;
import java.util.Collections;

class Employee implements Comparable<Employee> {
    int id;
    String name;
    int age;

    Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int compareTo(Employee employee) {
            return name.compareTo(employee.name);
    }
    public static void main(String args[]) {
        ArrayList<Employee> al = new ArrayList<Employee>();
        al.add(new Employee(101, "APeter", 23));
        al.add(new Employee(106, "Marry", 29));
        al.add(new Employee(105, "John", 21));

        //Sắp xếp list employee
        Collections.sort(al);
        for (Employee st : al) {
            System.out.println(st.id + " " + st.name + " " + st.age);
        }
    }
}
