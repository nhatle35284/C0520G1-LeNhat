package binary_file_serialization.bai_tap.copy_file_object;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManage {
    public static final String FILE_PATH = "C:\\123\\C0520G1-LeNhat\\module2\\src\\binary_file_serialization\\bai_tap\\copy_file_object\\student.txt";


    public static void writeFile() throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fos = new FileOutputStream("FILE_PATH");
            objectOutputStream = new ObjectOutputStream(fos);

            Student student1 = new Student("Toan", 25);
            Student student2 = new Student("Dat09", 29);
            Student student3 = new Student("Hai", 20);

            List<Student> studentList = new ArrayList<>();
            studentList.add(student1);
            studentList.add(student2);
            studentList.add(student3);

            objectOutputStream.writeObject(studentList);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            objectOutputStream.close();
        }
    }

    public static void readFile() {
        FileInputStream fis = null;
        ObjectInputStream objectInputStream = null;
        try {
            FileOutputStream newFile=new FileOutputStream("newFile.txt");
            ObjectOutputStream newOutput=new ObjectOutputStream(newFile);

            fis = new FileInputStream(FILE_PATH);
            objectInputStream = new ObjectInputStream(fis);
//            Student student = (Student) objectInputStream.readObject();

            List<Student> studentList = (List<Student>) objectInputStream.readObject();
            for (Student student : studentList) {
                System.out.println(student.getName() + " " + student.getAge() + " " + Student.sex);
                newOutput.writeObject(student);
            }
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//    public static void write2() throws IOException {
//        FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH);
//        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
//        byte[] input = new byte[]{'c', 'o', 'd', 'e', 'G', 'y', 'm'};
//        dataOutputStream.write(input, 0, 3);
//        dataOutputStream.close();
//    }

    public static void main(String[] args) throws IOException {
        writeFile();
        readFile();
    }
}

