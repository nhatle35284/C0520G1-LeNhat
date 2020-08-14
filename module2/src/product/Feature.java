package product;

import case_study.james.ReaderWriterFile;

import static product.Controller.*;

public class Feature {

    public static void findProduct() {
        scanner.nextLine();
        System.out.println("Nhập lựa chọn");

        System.out.println("1.Tìm Sản Phẩm Theo tên\n" +
                "2. Tìm Sản phẩm theo mã\n" +
                "3.Quay lại Menu\n" +
                "Chọn chức năng: ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                scanner.nextLine();
                System.out.println("Nhập tên muốn tìm: ");
                String key=scanner.nextLine();
                importProductList.clear();
                exportProductsList.clear();
                ReaderWriteFile.readerFile(FILE_PRODUCT);
                for (int i = 0; i < importProductList.size(); i++) {
                    if (key.equals(importProductList.get(i).getName())) {
                        importProductList.get(i).showInformation();
                        break;
                    }
                }
                for (int i = 0; i < exportProductsList.size(); i++) {
                    if (key.equals(exportProductsList.get(i).getName())) {
                        exportProductsList.get(i).showInformation();
                        break;
                    }
                }
                break;
            case 2:
                scanner.nextLine();
                System.out.println("Nhập mã muốn tìm: ");
                String code=scanner.nextLine();
                importProductList.clear();
                exportProductsList.clear();
                ReaderWriteFile.readerFile(FILE_PRODUCT);
                for (int i = 0; i < importProductList.size(); i++) {
                    if (code.equals(importProductList.get(i).getCodeProduct())) {
                        importProductList.get(i).showInformation();
                        break;
                    }
                }
                for (int i = 0; i < exportProductsList.size(); i++) {
                    if (code.equals(exportProductsList.get(i).getCodeProduct())) {
                        exportProductsList.get(i).showInformation();
                        break;
                    }
                }
                break;
            default:
        }
    }

    public static void showInformationProduct() {
        scanner.nextLine();
        importProductList.clear();
        ReaderWriteFile.readerFile(FILE_PRODUCT);
        for (importProduct importProduct1: importProductList) {
            importProduct1.showInformation();
        }
        exportProductsList.clear();
        ReaderWriteFile.readerFile(FILE_PRODUCT);
        for (exportProduct exportProduct1: exportProductsList) {
            exportProduct1.showInformation();
        }
    }

    public static void deleteProduct() {
        scanner.nextLine();

        System.out.println("Nhập mã sản phẩm muốn xóa");
        String indexImport = scanner.nextLine();
        importProductList.clear();
        exportProductsList.clear();
        ReaderWriteFile.readerFile(FILE_PRODUCT);
        for (int i = 0; i < importProductList.size(); i++) {
            if (indexImport.equals(importProductList.get(i).getCodeProduct())) {
                importProductList.remove(importProductList.get(i));
                break;
            }
        }
        for (int i = 0; i < exportProductsList.size(); i++) {
            if (indexImport.equals(exportProductsList.get(i).getCodeProduct())) {
                exportProductsList.remove(exportProductsList.get(i));
                break;
            }
        }
        ReaderWriteFile.save("", FILE_PRODUCT);
        for (int i = 0; i < importProductList.size(); i++) {
            ReaderWriteFile.writerFile(importProductList.get(i).getId() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile(importProductList.get(i).getCodeProduct() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile(importProductList.get(i).getName() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile(importProductList.get(i).getPrice() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile(importProductList.get(i).getAmount() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile(importProductList.get(i).getProducer() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile(importProductList.get(i).getImportPrice() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile(importProductList.get(i).getImportProvince() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile(importProductList.get(i).getImportTax() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile("2", FILE_PRODUCT);
            ReaderWriteFile.writerFile("\n", FILE_PRODUCT);
        }
        importProductList.clear();
        for (int i = 0; i < exportProductsList.size(); i++) {
            ReaderWriteFile.writerFile(exportProductsList.get(i).getId() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile(exportProductsList.get(i).getCodeProduct() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile(exportProductsList.get(i).getName() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile(exportProductsList.get(i).getPrice() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile(exportProductsList.get(i).getAmount() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile(exportProductsList.get(i).getProducer() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile(exportProductsList.get(i).getExportPrice() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile(exportProductsList.get(i).getExportNation() + ",", FILE_PRODUCT);
            ReaderWriteFile.writerFile("1", FILE_PRODUCT);
            ReaderWriteFile.writerFile("\n", FILE_PRODUCT);
        }
        exportProductsList.clear();
    }

    public static void addNewProduct() {
        scanner.nextLine();
        System.out.println("Nhập sản phẩm muốn thêm: ");
        System.out.println("1.Thêm Sản Phẩm Nhập khẩu\n" +
                "2. Thêm Sản phẩm xuất khẩu\n" +
                "3.Quay lại Menu\n" +
                "Chọn chức năng: ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                addNewProductImport();
                break;
            case 2:
                addNewProductExport();
                break;
            case 3:
                Controller.displayMainMenu();
                break;
            default:
                System.out.println("Vui Lòng chọn lại,chức năng có trong menu");
        }
    }

    static int id = 0;

    private static void addNewProductExport() {
        scanner.nextLine();
        System.out.println("Nhập Mã Sản Phẩm");
        String codeProduct = scanner.nextLine();
        System.out.println("Nhập Tên Sản Phẩm");
        String name = scanner.nextLine();
        System.out.println("Nhập Giá Sản Phẩm");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập Số lượng Sản Phẩm");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Nhà Sản Xuất Sản Phẩm");
        String producer = scanner.nextLine();
        System.out.println("Nhập Giá Xuất Khẩu Sản Phẩm");
        double priceExport = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập Quốc gia xuất khẩu Sản Phẩm");
        String exportNation = scanner.nextLine();
        exportProductsList.add(new exportProduct(++id, codeProduct, name, price, amount, producer, priceExport, exportNation));
        ReaderWriteFile.writerFile(exportProductsList.get(0).getId() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile(exportProductsList.get(0).getCodeProduct() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile(exportProductsList.get(0).getName() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile(exportProductsList.get(0).getPrice() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile(exportProductsList.get(0).getAmount() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile(exportProductsList.get(0).getProducer() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile(exportProductsList.get(0).getExportPrice() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile(exportProductsList.get(0).getExportNation() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile("1", FILE_PRODUCT);
        ReaderWriteFile.writerFile("\n", FILE_PRODUCT);
        exportProductsList.clear();
    }

    private static void addNewProductImport() {
        scanner.nextLine();
        System.out.println("Nhập Mã Sản Phẩm");
        String codeProduct = scanner.nextLine();
        System.out.println("Nhập Tên Sản Phẩm");
        String name = scanner.nextLine();
        double price;
        do {
            System.out.println("Nhập Giá Sản Phẩm");
            price = Double.parseDouble(scanner.nextLine());
        } while (Validate.isMoreThan(price,0));

        System.out.println("Nhập Số lượng Sản Phẩm");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Nhà Sản Xuất Sản Phẩm");
        String producer = scanner.nextLine();
        System.out.println("Nhập Giá Nhập Khẩu Sản Phẩm");
        double priceImport = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập Tỉnh Nhập Khẩu Sản Phẩm");
        String importProvince = scanner.nextLine();
        System.out.println("Nhập Thuế Nhập Khẩu Sản Phẩm");
        double importTax = Double.parseDouble(scanner.nextLine());
        importProductList.add(new importProduct(++id, codeProduct, name, price, amount, producer, priceImport, importProvince, importTax));
        ReaderWriteFile.writerFile(importProductList.get(0).getId() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile(importProductList.get(0).getCodeProduct() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile(importProductList.get(0).getName() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile(importProductList.get(0).getPrice() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile(importProductList.get(0).getAmount() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile(importProductList.get(0).getProducer() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile(importProductList.get(0).getImportPrice() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile(importProductList.get(0).getImportProvince() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile(importProductList.get(0).getImportTax() + ",", FILE_PRODUCT);
        ReaderWriteFile.writerFile("2", FILE_PRODUCT);
        ReaderWriteFile.writerFile("\n", FILE_PRODUCT);
        importProductList.clear();
    }
}
