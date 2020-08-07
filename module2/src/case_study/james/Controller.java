package case_study.james;

import case_study.furama_resort.models.Villa;

import java.util.*;

public class Controller {
    public static final String FILE_DICTIONARY = "C:\\123\\C0520G1-LeNhat\\module2\\src\\case_study\\james\\dictionary.csv";
    public static final String FILE_DICTIONARY_EXPORT = "C:\\123\\C0520G1-LeNhat\\module2\\src\\case_study\\james\\dictionary.csv";
    public static Map<String, Word> wordMap = new HashMap<>();
    public static List<Word> wordList=new LinkedList<>();
    public static final String str = null;

    public static void main(String[] args) {
        displayMainMenu();
    }

    static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {

        System.out.print("1.\tWords want word search\n" +
                "2.\tAdditional definition of a word\n" +
                "3.\tDelete item form\n" +
                "4.\tExport dictionary database\n" +
                "5.\tExit\n");
        System.out.print("Enter choose Action(1-5): ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                Service.lookWord();
                break;
            case 2:
                Service.addDefinitionWord();
                break;
            case 3:
                Service.deleteItemFrom();
                break;
            case 4:
                Service.exportDatabase();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("enter choose (1-5)");
        }
    }
}
