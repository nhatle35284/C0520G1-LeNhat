package lesson.binary_file_serialization.thuc_hanh;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestDataInputStream {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("C:\\123\\C0520G1-LeNhat\\module2\\haha.txt");
            DataInputStream din=new DataInputStream(fin);
            while (true){
                System.out.println(din.readInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
