package case_study.james;

import java.io.*;

public class ReaderWriterFile {
    public static String[] arrTemp;

    public static String readFile(String filePath) {
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
                result = "Action: " + word + "\n" +
                        "\tPronunciation is: " + pronoun +"\n" +
                        "\tTranslate to Vietnamese is: " + translate +"\n" +
                        "\tType of word is: " + wordType +"\n" +
                        "\tWord Synonymous is: "+synonymous;
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
