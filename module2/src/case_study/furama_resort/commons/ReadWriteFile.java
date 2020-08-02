package case_study.furama_resort.commons;

import case_study.furama_resort.controllers.MainController;
import case_study.furama_resort.models.Customer;
import case_study.furama_resort.models.House;
import case_study.furama_resort.models.Room;
import case_study.furama_resort.models.Villa;

import java.io.*;

public class ReadWriteFile {
    public static String[] arrayTemp;
    public static void readerFile(String filePath) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ( (line = bufferedReader.readLine()) != null ) {
                arrayTemp = line.split(",");
                if (filePath.equals(MainController.FILE_VILLA)) {
                    String id = ReadWriteFile.arrayTemp[0];
                    String name = (ReadWriteFile.arrayTemp[1]);
                    String userArena = ReadWriteFile.arrayTemp[2];
                    String price = ReadWriteFile.arrayTemp[3];
                    String maxPeople = ReadWriteFile.arrayTemp[4];
                    String rentType = ReadWriteFile.arrayTemp[5];
                    String roomStandard = ReadWriteFile.arrayTemp[6];
                    String description = ReadWriteFile.arrayTemp[7];
                    String arenaPool = ReadWriteFile.arrayTemp[8];
                    String numberFloors = ReadWriteFile.arrayTemp[9];
                    MainController.villaList.add(new Villa(id, name, userArena, price, maxPeople, rentType, roomStandard, description, arenaPool, numberFloors));
                }else if (filePath.equals(MainController.FILE_HOUSE)) {
                    String id = ReadWriteFile.arrayTemp[0];
                    String name = (ReadWriteFile.arrayTemp[1]);
                    String userArena = ReadWriteFile.arrayTemp[2];
                    String price = ReadWriteFile.arrayTemp[3];
                    String maxPeople = ReadWriteFile.arrayTemp[4];
                    String rentType = ReadWriteFile.arrayTemp[5];
                    String roomStandard = ReadWriteFile.arrayTemp[6];
                    String description = ReadWriteFile.arrayTemp[7];
                    String numberFloors = ReadWriteFile.arrayTemp[8];
                    MainController.houseList.add(new House(id, name, userArena, price, maxPeople, rentType, roomStandard, description, numberFloors));
                }else if(filePath.equals(MainController.FILE_ROOM)){
                    String id = ReadWriteFile.arrayTemp[0];
                    String name = (ReadWriteFile.arrayTemp[1]);
                    String userArena = ReadWriteFile.arrayTemp[2];
                    String  price = ReadWriteFile.arrayTemp[3];
                    String maxPeople = ReadWriteFile.arrayTemp[4];
                    String rentType = ReadWriteFile.arrayTemp[5];
                    String freeService=ReadWriteFile.arrayTemp[6];
                    MainController.roomList.add(new Room(id, name, userArena, price, maxPeople, rentType, freeService));
                } else if(filePath.equals(MainController.FILE_CUSTOMER)){
                    String name = ReadWriteFile.arrayTemp[0];
                    String birthday = ReadWriteFile.arrayTemp[1];
                    String id = ReadWriteFile.arrayTemp[2];
                    String gender = ReadWriteFile.arrayTemp[3];
                    String numberPhone = ReadWriteFile.arrayTemp[4];
                    String email = ReadWriteFile.arrayTemp[5];
                    String typeCustomer = ReadWriteFile.arrayTemp[6];
                    String address = ReadWriteFile.arrayTemp[7];
                    MainController.customerList.add(new Customer(name,birthday,id,gender,numberPhone,email,typeCustomer,address));
                }
            }
            bufferedReader.close();
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
