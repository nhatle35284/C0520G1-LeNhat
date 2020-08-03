package case_study.furama_resort.models;

import case_study.furama_resort.commons.ReadWriteFile;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import static case_study.furama_resort.commons.ReadWriteFile.readerFile;
import static case_study.furama_resort.controllers.MainController.FILE_EMPLOYEE;
import static case_study.furama_resort.controllers.MainController.employeeMap;

public class CabinetFile {
    private static Stack<Employee> employeeStack = new Stack<>();

    static {
        readerFile(FILE_EMPLOYEE);
        for (Map.Entry<String, Employee> employeeEntry : employeeMap.entrySet()) {
            employeeStack.push(employeeEntry.getValue());
            System.out.println(employeeEntry.getKey() + ". " + employeeEntry.getValue().toString());
        }
    }
    private static Employee getFileEmployee(String id){
        Employee employee = null;
        while (!employeeStack.isEmpty()){
            employee=employeeStack.pop();
            if (employee.getId().equals(id)){
                return employee;
            }
        }
        return employee;
    }
    public static void findFileEmployee(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please input employee id want get file: ");
        String id=scanner.nextLine();
        Employee employee = getFileEmployee(id);
        if (employee != null){
            System.out.println("File employee: "+employee.toString());
        } else {
            System.out.println("File employee is not found");
        }
    }
}
