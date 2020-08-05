package case_study.james;

import java.util.Scanner;

public class Controller {
    static  Scanner scanner = new Scanner(System.in);
    public void displayMainMenu(){

        System.out.println("1.\tWords want word search\n" +
                "2.\tAdditional definition of a word\n" +
                "3.\tDelete item form\n" +
                "4.\tExport dictionary database\n"+
                "5.\tExit\n");
        System.out.println("Enter choose(1-5): ");
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

    private void lookWord() {
        System.out.println("Enter word want lookup: ");
        String word=scanner.nextLine();
    }
}
