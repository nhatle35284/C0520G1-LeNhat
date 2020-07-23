package binary_file_serialization.bai_tap.copy_file_object;

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void readFile(){
        try {
            FileInputStream read = new FileInputStream("C:\\123\\C0520G1-LeNhat\\module2\\haha.txt");
            DataInputStream inputStream=new DataInputStream(read);
            int readString;
            while ((readString=inputStream.read())!=-1){
                System.out.print(readString);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeFile(){
        try {
            Scanner scanner=new Scanner(System.in);
            System.out.println("enter file");
            File file= new File(scanner.nextLine());
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
//            dataOutputStream.writeInt(Integer.parseInt(chain));
            dataOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        readFile();
        writeFile();
}}
