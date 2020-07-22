package binary_file_serialization.thuc_hanh;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class TestDataOutStream {
    public static void main(String[] args) {
        int a[]={2,3,5,7,11};
        System.out.println(a);
//        try {
//            FileOutputStream fout=new FileOutputStream(args[0]);
//            DataOutputStream dout=new DataOutputStream(fout);
//            for (int i=0;i<a.length;i++){
//                dout.writeInt(a[i]);
//            }
//            dout.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
   }
}
