package lesson.binary_file_serialization.bai_tap.product_manage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManage {

    public static final String PRODUCT = "C:\\123\\C0520G1-LeNhat\\module2\\src\\lesson.binary_file_serialization\\bai_tap\\product_manage\\product.txt";
    static List<Product> products = new ArrayList<>();
    public static void readFile (String PRODUCT) {
        FileInputStream inputStream;
        ObjectInputStream objectInputStream;
        {
            try {
                inputStream = new FileInputStream(PRODUCT);
                objectInputStream = new ObjectInputStream(inputStream);
                List<Product> listProduct =(List<Product>) objectInputStream.readObject();
                for (Product list : listProduct) {
                    System.out.println(list.toString());
                }
                objectInputStream.close();
            } catch (FileNotFoundException e) {
                System.err.println("File not found");
            } catch (IOException e) {
                System.err.println("");
            } catch (ClassNotFoundException e) {
                System.err.println("Not Found Class");
            }
        }
    }
    public static void writeFile (String PRODUCT) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PRODUCT);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(products);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
//            Product product1 = new Product(1, "SamSung Galaxy note 10", "SamSung", 300);
//            Product product2 = new Product(2, "SamSung Galaxy note 9", "SamSung", 2700);
//            Product product3 = new Product(3, "SamSung Galaxy note 8", "SamSung", 250);
//            products.add(product1);
//            products.add(product2);
//            products.add(product3);
            int choose;
            System.out.println("1.Add Product");
            System.out.println("2.Display list product");
            System.out.println("3.Find product name");
            System.out.println("4.Exit");
            System.out.print("Enter the selection: ");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addProduct(scanner, products);
                    break;
                case 2:
                    displayProduct();
                    break;
                case 3:
                    if (products.size()==0){
                        System.err.println("No Product");
                    }else {
                    scanner.nextLine();
                    System.out.println("Input name product want find: ");
                    String nameFind=scanner.nextLine();
                    boolean check=true;
                    for (Product product : products) {
                        if (nameFind.equals(product.getName())) {
                            System.out.println(product);
                            check=true;
                            break;
                        } else {
                            check=false;
                        }
                    }
                    if(!check){
                        System.err.println("This product is unavailable");
                    }
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    throw new IllegalStateException("Unexpected value: " + choose);
            }
            writeFile(PRODUCT);
        }
    }

    private static void displayProduct() {
            readFile(PRODUCT);
    }

    public static void addProduct(Scanner scanner, List<Product> products) {
        scanner.nextLine();
        System.out.print("input id product: ");
        int newCode = Integer.parseInt(scanner.nextLine());
        System.out.print("Input name product: ");
        String newName = scanner.nextLine();
        System.out.print("input band product: ");
        String newBrand = scanner.nextLine();
        System.out.print("input price product: ");
        int newPrice = Integer.parseInt(scanner.nextLine());
        products.add(new Product(newCode, newName, newBrand, newPrice));
    }
}

