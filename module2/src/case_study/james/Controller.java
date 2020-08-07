package case_study.james;

import case_study.furama_resort.models.Villa;

import java.util.*;

public class Controller {
    public static final String FILE_DICTIONARY = "C:\\123\\C0520G1-LeNhat\\module2\\src\\case_study\\james\\dictionary.csv";
    public static Map<String, Word> wordMap = new HashMap<>();
    public static List<Word> wordList=new LinkedList<>();

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
                lookWord();
                break;
            case 2:
                addDefinitionWord();
                break;
            case 3:
                deleteItemFrom();
                break;
            case 4:
                break;
            case 5:
                System.exit(0);
                break;
            default:
        }
    }

    private static void deleteItemFrom() {
        ReaderWriterFile.readFile(FILE_DICTIONARY);
        Word word = null;
        for (int i = 0; i < wordList.size(); i++) {
            word = wordList.get(i);
            System.out.print((i + 1) + ". ");
            System.out.println(word.toString());
        }
        System.out.println("Enter index want delete");
        int choose=scanner.nextInt();
        wordList.remove(choose-1);
        ReaderWriterFile.writeFileNew("",FILE_DICTIONARY);
        for (int i=0;i<wordList.size();i++){
            ReaderWriterFile.writeFile(wordList.get(i).getKeyWord() + ",", FILE_DICTIONARY);
            ReaderWriterFile.writeFile(wordList.get(i).getPronoun() + ",", FILE_DICTIONARY);
            ReaderWriterFile.writeFile(wordList.get(i).getTranslate() + ",", FILE_DICTIONARY);
            ReaderWriterFile.writeFile(wordList.get(i).getWordType() + ",", FILE_DICTIONARY);
            ReaderWriterFile.writeFile(wordList.get(i).getSynonymous(), FILE_DICTIONARY);
            ReaderWriterFile.writeFile("\n", FILE_DICTIONARY);
        }
    }


    private static void addDefinitionWord() {
        scanner.nextLine();
        System.out.println("Enter key word want add: ");
        String word = scanner.nextLine();
        System.out.println("Enter the pronunciation of the keyword: ");
        String pronoun = scanner.nextLine();
        System.out.println("Enter the meaning of the keyword: ");
        String translate = scanner.nextLine();
        System.out.println("Enter the type of the keyword: ");
        String typeWord = scanner.nextLine();
        System.out.println("Enter synonyms for keywords: ");
        String synonyms = scanner.nextLine();
        wordList.add(new Word(word, pronoun, translate, typeWord, synonyms));
            ReaderWriterFile.writeFile(wordList.get(0).getKeyWord() + ",", FILE_DICTIONARY);
            ReaderWriterFile.writeFile(wordList.get(0).getPronoun() + ",", FILE_DICTIONARY);
            ReaderWriterFile.writeFile(wordList.get(0).getTranslate() + ",", FILE_DICTIONARY);
            ReaderWriterFile.writeFile(wordList.get(0).getWordType() + ",", FILE_DICTIONARY);
            ReaderWriterFile.writeFile(wordList.get(0).getSynonymous(), FILE_DICTIONARY);
            ReaderWriterFile.writeFile("\n", FILE_DICTIONARY);
            wordList.clear();
    }
        private static void lookWord() {
            ReaderWriterFile.readFile(FILE_DICTIONARY);
            scanner.nextLine();
            System.out.print("Enter word want lookup: ");
            String word = scanner.nextLine();
            for (Map.Entry<String, Word> wordEntry : wordMap.entrySet()) {
                if (word.equals(wordEntry.getKey())) {
                    System.out.println(wordEntry.getKey() + " " + wordEntry.getValue());
                } else {
                    addDefinitionWord();
                }
            }
            System.out.println(word);
        }

}
