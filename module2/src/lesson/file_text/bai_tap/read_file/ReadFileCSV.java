package lesson.file_text.bai_tap.read_file;

import java.io.*;

public class ReadFileCSV {

    public static void main(String[] args) {
        File file = new File("C:\\123\\C0520G1-LeNhat\\module2\\src\\lesson.file_text\\bai_tap\\file.csv");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = ",";
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }

        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace(); }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
