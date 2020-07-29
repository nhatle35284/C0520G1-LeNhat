package lesson.binary_file_serialization.thuc_hanh;

import java.io.*;
import java.util.Scanner;

class TestDataOutStream {
    public static void main(String[] args) {
        int a[]={2,3,5,7,11};
        Scanner scanner=new Scanner(System.in);
        System.out.println("Input name file");
        File file= new File(scanner.nextLine());
        try {
            FileOutputStream fout=new FileOutputStream(file);
            DataOutputStream dout=new DataOutputStream(fout);
            for (int i=0;i<a.length;i++){
                dout.writeInt(a[i]);
            }
            dout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
   }
}
