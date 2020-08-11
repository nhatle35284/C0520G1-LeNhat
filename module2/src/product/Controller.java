package product;

import javax.xml.datatype.DatatypeConstants;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    public static List<importProduct> importProductList = new LinkedList<>();
    public static List<exportProduct> exportProductsList = new LinkedList<>();
    public static List<Product> productsList = new LinkedList<>();
    public static String FILE_PRODUCT = "C:\\123\\C0520G1-LeNhat\\module2\\src\\product\\product.csv";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        while (true) {

            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM –");
            System.out.print("Chọn chức năng theo số (để tiếp tục):\n" +
                    "1. Thêm mới\n" +
                    "2. Xóa\n" +
                    "3. Xem danh sách các sản phẩm\n" +
                    "4. Tìm kiếm\n" +
                    "5. Thoát\n" +
                    "Chọn chức năng:\n");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    Feature.addNewProduct();
                    break;
                case 2:
                    Feature.deleteProduct();
                    break;
                case 3:
                    Feature.showInformationProduct();
                    break;
                case 4:
                    Feature.findProduct();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn đung chức năng");
            }
        }
    }

}
