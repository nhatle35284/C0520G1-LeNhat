package product;

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
                if (arrayTemp.length==8) {
                    int id = Integer.parseInt(ReaderWriteFile.arrayTemp[0]);
                    String codeProduct = ReaderWriteFile.arrayTemp[1];
                    String name = ReaderWriteFile.arrayTemp[2];
                    double price = Double.parseDouble(ReaderWriteFile.arrayTemp[3]);
                    int amount = Integer.parseInt(ReaderWriteFile.arrayTemp[4]);
                    String producer = ReaderWriteFile.arrayTemp[5];
                    double priceExport = Double.parseDouble(ReaderWriteFile.arrayTemp[6]);
                    String exportNation = ReaderWriteFile.arrayTemp[7];
                    Controller.exportProductsList.add(new exportProduct(id,codeProduct,name,price,amount,producer,priceExport,exportNation));
                } else {
                    int id = Integer.parseInt(ReaderWriteFile.arrayTemp[0]);
                    String codeProduct = ReaderWriteFile.arrayTemp[1];
                    String name = ReaderWriteFile.arrayTemp[2];
                    double price = Double.parseDouble(ReaderWriteFile.arrayTemp[3]);
                    int amount = Integer.parseInt(ReaderWriteFile.arrayTemp[4]);
                    String producer = ReaderWriteFile.arrayTemp[5];
                    double priceImport = Double.parseDouble(ReaderWriteFile.arrayTemp[6]);
                    String importProvince = ReaderWriteFile.arrayTemp[7];
                    double importTax = Double.parseDouble(ReaderWriteFile.arrayTemp[8]);
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
    public static void save(String str, String filePath) {
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedReader = new BufferedWriter(fileWriter);
            bufferedReader.write(str);
            bufferedReader.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
