package bai_thi.commons;

import bai_thi.controllers.MainController;
import bai_thi.models.Directory;
import product.ReaderWriteFile;


import java.io.*;
import java.util.List;

public class ReaderWriterFile {
    public static String[] arrayTemp;

    public static List<String> readerFile(String filePath) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arrayTemp = line.split(",");
                String numberPhone = ReaderWriterFile.arrayTemp[0];
                String groupNumberPhone = ReaderWriterFile.arrayTemp[1];
                String name = ReaderWriterFile.arrayTemp[2];
                String gender = ReaderWriterFile.arrayTemp[3];
                String address = ReaderWriterFile.arrayTemp[4];
                String birthday = ReaderWriterFile.arrayTemp[5];
                String email = ReaderWriterFile.arrayTemp[6];
                MainController.directoryList.add(new Directory(numberPhone, groupNumberPhone, name, gender, address, birthday, email));

            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writerFile(String str, String filePath) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
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
