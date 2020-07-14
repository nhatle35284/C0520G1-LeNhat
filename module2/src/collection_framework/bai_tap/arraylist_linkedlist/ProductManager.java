package collection_framework.bai_tap.arraylist_linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    public static void main(String[] args) {
        ArrayList<Product> arrayList = new ArrayList<>();
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
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addProduct(arrayList, scanner);
                    break;
                case 2:
                    System.out.println("Input id want edit");
                    int iputId = scanner.nextInt();
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (iputId == arrayList.get(i).getId()) {
                            System.out.println("Input id product");
                            int idNew = scanner.nextInt();
                            arrayList.get(i).setId(idNew);
                            System.out.println("Input name product");
                            String nameNew = scanner.nextLine();
                            arrayList.get(i).setName(nameNew);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Input id want delete");
                    int iputDelete = scanner.nextInt();
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (iputDelete == arrayList.get(i).getId()) {
                            arrayList.remove(arrayList.get(i));
                        }
                    }
                    break;
                case 4:
                    displayProduct(arrayList);
                    break;
                case 5:
                    String nameFind;
                    System.out.println("Input name want find");
                    scanner.nextLine();
                    nameFind = scanner.nextLine();
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (nameFind.equals(arrayList.get(i).getName())) {
                            System.out.println(arrayList.get(i).toString());;
                        }
                    }
                    break;
                case 6:
                    Collections.sort(arrayList,new SortProduct());
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

    private static void addProduct(ArrayList<Product> arrayList, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Input name product");
        String name = scanner.nextLine();
        System.out.println("Input id product");
        int id = scanner.nextInt();
        arrayList.add(new Product(name, id));
        displayProduct(arrayList);
    }

    private static void displayProduct(ArrayList<Product> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).toString());
        }
    }
}
