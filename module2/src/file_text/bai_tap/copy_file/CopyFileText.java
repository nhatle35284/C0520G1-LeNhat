package file_text.bai_tap.copy_file;

import java.io.*;


public class CopyFileText {
    public static void main(String[] args) {
        File hasName = new File("C:\\123\\C0520G1-LeNhat\\module2\\src\\file_text\\bai_tap\\copy_file\\name.txt");
        File NoName = new File("C:\\123\\C0520G1-LeNhat\\module2\\src\\file_text\\bai_tap\\copy_file\\noName.txt");

            try {
                FileReader fileReader = new FileReader(hasName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                FileWriter fileWriter = new FileWriter(NoName);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                    bufferedWriter.write(line);
                    bufferedWriter.write("\n");
                }
                bufferedWriter.close();
                bufferedReader.close();
                fileWriter.close();
                fileReader.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("file not exist");
            }
            catch (IOException e) {
                e.printStackTrace();
            }

    }
}
