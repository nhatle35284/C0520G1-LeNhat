package bai_thi.commons;


import bai_thi.models.Directory;

import java.util.Scanner;

import static bai_thi.controllers.MainController.*;

public class Feature {
    static Scanner scanner = new Scanner(System.in);

    public static void showNumberPhone() {
        for (Directory directory : directoryList) {
            System.out.println(directory.toString());
        }
    }

    public static void addNewNumberPhone() {
        String numberPhone;
        do {
            System.out.println("Nhập số điện thoại: ");
            numberPhone = scanner.nextLine();
        } while (!Validate.isValid(numberPhone, REGEX_NUMBER_PHONE));

        System.out.println("Nhập nhóm số điện thoại: ");
        String groupNumberPhone = scanner.nextLine();
        System.out.println("Nhập Tên số điện thoại: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giới tính số điện thoại: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập dịa chỉ số điện thoại: ");
        String address = scanner.nextLine();
        System.out.println("Nhập ngày sinh số điện thoại: ");
        String birthday = scanner.nextLine();
        String email;
        do {
            System.out.println("Nhập email số điện thoại: ");
            email = scanner.nextLine();
        } while (!Validate.isValid(email, REGEX_EMAIL));

        directoryList.add(new Directory(numberPhone, groupNumberPhone, name, gender, address, birthday, email));
        System.out.println("Thêm Thành Công!!!");
    }

    public static void updateNumberPhone() {
        String numberUpdate;
        do {
            System.out.println("Nhập Số điện thoại cần sửa: ");
            numberUpdate = scanner.nextLine();
        } while (!Validate.isValid(numberUpdate, REGEX_NUMBER_PHONE));

        for (int i = 0; i < directoryList.size(); i++) {
            if (numberUpdate.equals(directoryList.get(i).getNumberPhone())) {
                String numberPhoneNew;
                do {
                    System.out.println("Nhập số điện thoại thay thế: ");
                    numberPhoneNew = scanner.nextLine();
                } while (!Validate.isValid(numberPhoneNew, REGEX_NUMBER_PHONE));
                directoryList.get(i).setNumberPhone(numberPhoneNew);
                System.out.println("Nhập Nhóm số điện thoại thay thế: ");
                String groupNumberPhoneNew = scanner.nextLine();
                directoryList.get(i).setGroupNumberPhone(groupNumberPhoneNew);
                System.out.println("Nhập tên số điện thoại thay thế: ");
                String namePhoneNew = scanner.nextLine();
                directoryList.get(i).setName(namePhoneNew);
                System.out.println("Nhập giới tính số điện thoại thay thế: ");
                String genderNumberPhoneNew = scanner.nextLine();
                directoryList.get(i).setGender(genderNumberPhoneNew);
                System.out.println("Nhập địa chỉ số điện thoại thay thế: ");
                String addressNumberPhoneNew = scanner.nextLine();
                directoryList.get(i).setAddress(addressNumberPhoneNew);
                System.out.println("Nhập ngày sinh số điện thoại thay thế: ");
                String birthdayNumberPhoneNew = scanner.nextLine();
                directoryList.get(i).setBirthday(birthdayNumberPhoneNew);
                String EmailNumberPhoneNew;
                do {
                    System.out.println("Nhập email của số điện thoại thay thế: ");
                    EmailNumberPhoneNew = scanner.nextLine();
                } while (!Validate.isValid(EmailNumberPhoneNew, REGEX_EMAIL));
                directoryList.get(i).setEmail(EmailNumberPhoneNew);
            }}
    }

    public static void deleteNumberPhone() {
        System.out.println("Nhập Số điện thoại cần xóa: ");
        String numberDelete = scanner.nextLine();
        for (int i = 0; i < directoryList.size(); i++) {
            if (numberDelete.equals(directoryList.get(i).getNumberPhone())) {
                System.out.println("Nhập Y để đồng ý xóa : ");
                String choose = scanner.nextLine();
                if (choose.equals("y")) {
                    directoryList.remove(directoryList.get(i));
                }
            }
        }

    }

    public static void searchNumberPhone() {
        System.out.print("1.Tìm theo số điện thoại\n"+
                "2.Tìm theo tên\n");
        int choose=scanner.nextInt();
        switch (choose){
            case 1:
                scanner.nextLine();
                System.out.println("Nhập Số điện thoại cần tìm: ");
                String numberSearch = scanner.nextLine();
                Directory directory = null;
                for (int i = 0; i < directoryList.size(); i++) {
                    if (numberSearch.equals(directoryList.get(i).getNumberPhone())) {
                        directory = directoryList.get(i);
                        System.out.println(directory.toString());
                    }
                }
                break;
            case 2:
                scanner.nextLine();
                System.out.println("Nhập Tên Số điện thoại cần tìm: ");
                String nameNumberPhone = scanner.nextLine();
                Directory directoryName = null;
                for (int i = 0; i < directoryList.size(); i++) {
                    if (nameNumberPhone.equals(directoryList.get(i).getName())) {
                        directoryName = directoryList.get(i);
                        System.out.println(directoryName.toString());
                    }
                }
        }

    }

    public static void readNumberPhoneFile() {
        directoryList.clear();
        ReaderWriterFile.readerFile(FILE_DIRECTORY);
        Directory directory = null;
        for (Directory directory1 : directoryList) {
            directory = directory1;
            System.out.println(directory.toString());
        }
    }

    public static void writeNumberPhoneFile() {
        for (int i = 0; i < directoryList.size(); i++) {
            ReaderWriterFile.writerFile(directoryList.get(i).getNumberPhone() + ",", FILE_DIRECTORY);
            ReaderWriterFile.writerFile(directoryList.get(i).getGroupNumberPhone() + ",", FILE_DIRECTORY);
            ReaderWriterFile.writerFile(directoryList.get(i).getName() + ",", FILE_DIRECTORY);
            ReaderWriterFile.writerFile(directoryList.get(i).getGender() + ",", FILE_DIRECTORY);
            ReaderWriterFile.writerFile(directoryList.get(i).getAddress() + ",", FILE_DIRECTORY);
            ReaderWriterFile.writerFile(directoryList.get(i).getBirthday() + ",", FILE_DIRECTORY);
            ReaderWriterFile.writerFile(directoryList.get(i).getEmail(), FILE_DIRECTORY);
            ReaderWriterFile.writerFile("\n", FILE_DIRECTORY);
        }
        System.out.println("Done");
    }

}
