package case_study.list_employee;

import java.util.Scanner;

public class Controller {
    static Scanner scanner=new Scanner(System.in);
    public static void displayMainMenu(){
        System.out.println("1.\tAdd new Employee\n"+
                "2.\tDelete Employee+\n"+
                "3.\tFind Employee\n"+
                "4.\tShow Information Employee\n"+
                "5.\tExit\n");
        int choose=scanner.nextInt();
        switch (choose){
            case 1:
                Service.addNewEmployee();
                break;
            case 2:
                Service.deleteEmployee();
                break;
            case 3:
                Service.findEmployee();
                break;
            case 4:
                Service.showInformationEmployee();
                break;
            case 5:
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
