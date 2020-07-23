package binary_file_serialization.bai_tap.copy_file_object;

import java.io.*;
import java.util.Scanner;

public class CopyFile2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("input file want to copy");
        File file = new File(scanner.nextLine());
        try {
            FileInputStream inputStream = new FileInputStream("C:\\\\123\\\\C0520G1-LeNhat\\\\module2\\\\haha.txt");
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] buffer=new byte[1024];
            int reader;
            while ((reader=inputStream.read(buffer))!=-1){
                outputStream.write(reader);
            }
            System.out.println("copy success");
            outputStream.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
