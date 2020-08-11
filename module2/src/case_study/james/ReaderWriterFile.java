package case_study.james;

import java.io.*;
import java.util.List;

public class ReaderWriterFile {
    public static String[] arrTemp;

    public static List<String> readFile(String filePath) {
        String result = null;
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arrTemp = line.split(",");
                String word = ReaderWriterFile.arrTemp[0];
                String pronoun = ReaderWriterFile.arrTemp[1];
                String translate = ReaderWriterFile.arrTemp[2];
                String wordType = ReaderWriterFile.arrTemp[3];
                String synonymous = ReaderWriterFile.arrTemp[4];
                Controller.wordMap.put(word, new Word(word, pronoun, translate, wordType, synonymous));
                Controller.wordList.add(new Word(word, pronoun, translate, wordType, synonymous));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeFile(String str, String filePath) {
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedReader = new BufferedWriter(fileWriter);
            bufferedReader.write(str);
            bufferedReader.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeFileNew(String str, String filePath) {
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedReader = new BufferedWriter(fileWriter);
            bufferedReader.write(str);
            bufferedReader.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
