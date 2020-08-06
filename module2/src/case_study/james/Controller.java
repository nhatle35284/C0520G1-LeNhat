package case_study.james;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        displayMainMenu();
    }
    static  Scanner scanner = new Scanner(System.in);
    public static void displayMainMenu(){

        System.out.print("1.\tWords want word search\n" +
                "2.\tAdditional definition of a word\n" +
                "3.\tDelete item form\n" +
                "4.\tExport dictionary database\n"+
                "5.\tExit\n");
        System.out.print("Enter choose Action(1-5): ");
        int choose=scanner.nextInt();
        switch (choose){
            case 1:
                lookWord();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                System.exit(0);
                break;
        }
    }

    private static void lookWord() {
        scanner.nextLine();
        System.out.print("Enter word want lookup: ");
        String word=scanner.nextLine();
        System.out.println(word);
    }
}
