package file_text.thuc_hanh;

import java.io.*;

public class WriteATextFile {
    public static void main(String[] args) {
        try {
            File file=new File("Hello.txt");
            FileReader fileReader= new FileReader(file);
            BufferedReader reader=new BufferedReader(fileReader);
            String line=null;
            while ((line=reader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//   static void main(String[] args) {
//        try {
//           FileWriter fileWriter=new FileWriter("Hello.txt");
//           fileWriter.write("Hello!");
//           fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
