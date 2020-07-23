package collection_framework.bai_tap.arraylist_product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    public static void main(String[] args) {
        List<Product> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choose;

            System.out.println("1.Add Product");
            System.out.println("2.Edit information id product");
            System.out.println("3.Delete information id product");
            System.out.println("4.Display list product");
            System.out.println("5.Find product name");
            System.out.println("6.SortProduct product ascending/decrease");
            System.out.println("7.Exit");
            System.out.print("Enter the selection: ");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addProduct(arrayList, scanner);
                    break;
                case 2:
                    editProductById(arrayList, scanner);
                    break;
                case 3:
                    deleteProductById(arrayList, scanner);
                    break;
                case 4:
                    displayProduct(arrayList);
                    break;
                case 5:
                    findProductByName(arrayList, scanner);
                    break;
                case 6:
                    sortProduct(arrayList);
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

    private static void editProductById(List<Product> arrayList, Scanner scanner) {
        System.out.println("Input id want edit");
        int inputId = scanner.nextInt();
        for (int i = 0; i < arrayList.size(); i++) {
            if (inputId == arrayList.get(i).getId()) {
                System.out.println("Input id product");
                int idNew = scanner.nextInt();
                arrayList.get(i).setId(idNew);
                scanner.nextLine();
                System.out.println("Input name product");
                String nameNew = scanner.nextLine();
                arrayList.get(i).setName(nameNew);
                System.out.println("Input name product");
                double priceNew = scanner.nextDouble();
                arrayList.get(i).setPrice(priceNew);
            }
        }
        displayProduct(arrayList);
    }

    private static void deleteProductById(List<Product> arrayList, Scanner scanner) {
        System.out.println("Input id want delete");
        int iputDelete = scanner.nextInt();
        for (int i = 0; i < arrayList.size(); i++) {
            if (iputDelete == arrayList.get(i).getId()) {
                arrayList.remove(arrayList.get(i));
            }
        }
        displayProduct(arrayList);
    }

    private static void findProductByName(List<Product> arrayList, Scanner scanner) {
        String nameFind;
        System.out.println("Input name want find");
        scanner.nextLine();
        nameFind = scanner.nextLine();
        for (int i = 0; i < arrayList.size(); i++) {
            if (nameFind.equals(arrayList.get(i).getName())) {
                System.out.println(arrayList.get(i).toString());
                ;
            }
        }
    }

    private static void sortProduct(List<Product> arrayList) {
        arrayList.sort(new SortProduct());
        System.out.println("After Product Sort");
        System.out.println(arrayList);
    }

    private static void addProduct(List<Product> arrayList, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Input name product");
        String name = scanner.nextLine();
        System.out.println("Input id product");
        int id = scanner.nextInt();
        System.out.println("Input price Product");
        double price = scanner.nextDouble();
        arrayList.add(new Product(name, id, price));
        displayProduct(arrayList);
    }

    private static void displayProduct(List<Product> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).toString());
        }
    }
}
