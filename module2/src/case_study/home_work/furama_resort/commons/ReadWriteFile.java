package case_study.home_work.furama_resort.commons;

import java.io.*;

public class ReadWriteFile {
    public static String[] arrTemp;
    public static void readerFile(String filePath){
        File file = new File(filePath);
        try{
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedWriter=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedWriter.readLine())!=null){
                arrTemp=line.split(",");
            }
            bufferedWriter.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writerFile(String str,String filePath){
        File file=new File(filePath);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter=new FileWriter(file,true);
            BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);
            bufferedWriter.append(str);
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
