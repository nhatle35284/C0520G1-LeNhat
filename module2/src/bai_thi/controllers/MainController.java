package bai_thi.controllers;

import bai_thi.commons.Feature;
import bai_thi.models.Directory;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);
    public static final String REGEX_NUMBER_PHONE= "0[1-9]\\d{8}";
    public static final String REGEX_EMAIL= "([a-zA-Z0-9_.\\-])+@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+";
    public static List<Directory> directoryList = new LinkedList<>();
    public static String FILE_DIRECTORY="C:\\123\\C0520G1-LeNhat\\module2\\src\\bai_thi\\data\\contacts.csv";
    public static void main(String[] args) {
        displayMainMenu();
    }
    public static void displayMainMenu() {
        while (true) {
            System.out.println("---Chương Trình Quản Lý Danh Bạ---");
            System.out.print("Chọn chức năng theo số (để tiếp tục):\n" +
                    "1. Xem danh sách\n" +
                    "2. Thêm mới\n" +
                    "3. Cập Nhật\n" +
                    "4. Xóa\n" +
                    "5. Tìm Kiếm\n" +
                    "6. Đọc từ file\n" +
                    "7. Ghi vào file\n" +
                    "8. Thoát\n" +
                    "Chọn chức năng:\n");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    Feature.showNumberPhone();
                    break;
                case 2:
                    Feature.addNewNumberPhone();
                    break;
                case 3:
                    Feature.updateNumberPhone();
                    break;
                case 4:
                    Feature.deleteNumberPhone();
                    break;
                case 5:
                    Feature.searchNumberPhone();
                    break;
                case 6:
                    Feature.readNumberPhoneFile();
                    break;
                case 7:
                    Feature.writeNumberPhoneFile();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn đúng chức năng có trong menu");
            }
        }
    }
}
