package collection_framework.bai_tap.linkedkist_product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Product> linkedList = new LinkedList<>();
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
                    addProduct(linkedList, scanner);
                    break;
                case 2:
                    editProductById(linkedList, scanner);
                    break;
                case 3:
                    deleteProductById(linkedList, scanner);
                    break;
                case 4:
                    displayProduct(linkedList);
                    break;
                case 5:
                    findProductByName(linkedList, scanner);
                    break;
                case 6:
                    sortProduct(linkedList);
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

    private static void editProductById(LinkedList<Product> linkedList, Scanner scanner) {
        System.out.println("Input id want edit");
        int inputId = scanner.nextInt();
        for (int i = 0; i < linkedList.size(); i++) {
            if (inputId == linkedList.get(i).getId()) {
                System.out.println(linkedList.get(i));
                System.out.println("Input id product");
                int idNew = scanner.nextInt();
                linkedList.get(i).setId(idNew);
                scanner.nextLine();
                System.out.println("Input name product");
                String nameNew = scanner.nextLine();
                linkedList.get(i).setName(nameNew);
                System.out.println("Input price product");
                double priceNew = scanner.nextDouble();
                linkedList.get(i).setPrice(priceNew);
            }
        }
        displayProduct(linkedList);
    }

    private static void deleteProductById(LinkedList<Product> linkedList, Scanner scanner) {
        System.out.println("Input id want delete");
        int inputDelete = scanner.nextInt();
        for (int i = 0; i < linkedList.size(); i++) {
            if (inputDelete == linkedList.get(i).getId()) {
                linkedList.remove(linkedList.get(i));
            }
        }
        displayProduct(linkedList);
    }

    private static void findProductByName(LinkedList<Product> linkedList, Scanner scanner) {
        String nameFind;
        System.out.println("Input name want find");
        scanner.nextLine();
        nameFind = scanner.nextLine();
        for (int i = 0; i < linkedList.size(); i++) {
            if (nameFind.equals(linkedList.get(i).getName())) {
                System.out.println(linkedList.get(i).toString());
                ;
            }
        }
    }

    private static void sortProduct(LinkedList<Product> linkedList) {
        linkedList.sort(new SortProduct());
        System.out.println("After Product Sort");
        System.out.println(linkedList);
    }

    private static void addProduct(LinkedList<Product> linkedList, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Input name product");
        String name = scanner.nextLine();
        System.out.println("Input id product");
        int id = scanner.nextInt();
        System.out.println("Iput price Product");
        double price = scanner.nextDouble();
        linkedList.add(new Product(name, id, price));
        displayProduct(linkedList);
    }

    private static void displayProduct(LinkedList<Product> linkedList) {
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i).toString());
        }
    }
}
