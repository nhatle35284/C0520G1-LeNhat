package file_text.bai_tap.read_file_test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class CSVReader {

    public static void main(String[] args) {

        String csvFile = "C:\\123\\C0520G1-LeNhat\\module2\\src\\file_text\\bai_tap\\read_file_test\\file.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}