package product;

import case_study.furama_resort.commons.ReadWriteFile;

import java.io.*;
import java.util.List;

public class ReaderWriteFile {
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
                if ("1".equals(arrayTemp[8])) {
                    int id = Integer.parseInt(ReadWriteFile.arrayTemp[0]);
                    String codeProduct = ReadWriteFile.arrayTemp[1];
                    String name = ReadWriteFile.arrayTemp[2];
                    double price = Double.parseDouble(ReadWriteFile.arrayTemp[3]);
                    int amount = Integer.parseInt(ReadWriteFile.arrayTemp[4]);
                    String producer = ReadWriteFile.arrayTemp[5];
                    double priceExport = Double.parseDouble(ReadWriteFile.arrayTemp[6]);
                    String exportNation = ReadWriteFile.arrayTemp[7];
                    Controller.exportProductsList.add(new exportProduct(id,codeProduct,name,price,amount,producer,priceExport,exportNation));
                } else {
                    int id = Integer.parseInt(ReadWriteFile.arrayTemp[0]);
                    String codeProduct = ReadWriteFile.arrayTemp[1];
                    String name = ReadWriteFile.arrayTemp[2];
                    double price = Double.parseDouble(ReadWriteFile.arrayTemp[3]);
                    int amount = Integer.parseInt(ReadWriteFile.arrayTemp[4]);
                    String producer = ReadWriteFile.arrayTemp[5];
                    double priceImport = Double.parseDouble(ReadWriteFile.arrayTemp[6]);
                    String importProvince = ReadWriteFile.arrayTemp[7];
                    double importTax = Double.parseDouble(ReadWriteFile.arrayTemp[8]);
                    Controller.importProductList.add(new importProduct(id,codeProduct,name,price,amount,producer,priceImport,importProvince,importTax));
                }
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
