package lesson.file_text.bai_tap.copy_file;

import java.io.*;

public class CopyFileTest2 {
    static String alo="";
    public static void readFile() {
        File file = new File("C:\\123\\C0520G1-LeNhat\\module2\\src\\lesson.file_text\\bai_tap\\copy_file\\name.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                alo+=line;
                alo+="\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeFile() {
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Input file ");
//        File file= new File(scanner.nextLine());
        File file = new File("C:\\123\\C0520G1-LeNhat\\module2\\src\\lesson.file_text\\bai_tap\\copy_file\\noName.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(alo);
            bufferedWriter.close();
            fileWriter.close();
        }  catch (FileNotFoundException e) {
            System.out.println("file not exist");
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        readFile();
        writeFile();
    }
}
