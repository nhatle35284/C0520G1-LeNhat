package product;

import case_study.james.ReaderWriterFile;

import static product.Controller.*;

public class Feature {

    public static void findProduct() {
        scanner.nextLine();
        System.out.println("Nhập lựa chọn");
        System.out.println("1.Tìm Sản Phẩm Nhập khẩu\n"+
                "2. Tìm Sản phẩm xuất khẩ\n"+
                "3.Quay lại Menu\n"+
                "Chọn chức năng: ");
        int choose=scanner.nextInt();
        switch (choose){

        }
    }

    public static void showInformationProduct() {
        scanner.nextLine();
        System.out.println("Nhập lựa chọn");
        System.out.println("1.Hiển thị Sản Phẩm Nhập khẩu\n"+
                "2. Hiển Thị Sản phẩm xuất khẩu\n"+
                "3.Quay lại Menu\n"+
                "Chọn chức năng: ");
        int choose=scanner.nextInt();
        switch (choose){
            case 1:
                importProductList.clear();
                ReaderWriteFile.readerFile(FILE_PRODUCT);
                importProduct importProduct=null;
                for (int i = 0; i < importProductList.size(); i++) {
                    importProduct = importProductList.get(i);
                    System.out.print((i + 1) + ". ");
                    importProduct.showInformation();
                }
                break;
            case 2:
                exportProductsList.clear();
                ReaderWriteFile.readerFile(FILE_PRODUCT);
                exportProduct exportProduct=null;
                for (int i = 0; i < exportProductsList.size(); i++) {
                    exportProduct = exportProductsList.get(i);
                    System.out.print((i + 1) + ". ");
                    exportProduct.showInformation();
                }
                break;
            case 3:
                Controller.displayMainMenu();
                break;
            default:
                System.out.println("Chọn Sai");
        }
    }

    public static void deleteProduct() {
        scanner.nextLine();
        System.out.println("Nhập lựa chọn");
        System.out.println("1.Xóa Sản Phẩm Nhập khẩu\n"+
                "2. Xóa Sản phẩm xuất khẩ\n"+
                "3.Quay lại Menu\n"+
                "Chọn chức năng: ");
        int choose=scanner.nextInt();
        switch (choose){
            case 1:
                importProductList.clear();
                ReaderWriteFile.readerFile(FILE_PRODUCT);
                for(importProduct importProduct:importProductList){
                    importProduct.showInformation();
                }
                int indexImport=scanner.nextInt();
                for (int i=0;i<importProductList.size();i++){
                    if (indexImport-1==i){
                        importProductList.remove(i);
                    }
                }
                break;
            case 2:
                exportProductsList.clear();
                ReaderWriteFile.readerFile(FILE_PRODUCT);
                for(exportProduct exportProduct:exportProductsList){
                    exportProduct.showInformation();
                }
                int indexExport=scanner.nextInt();
                for (int i=0;i<importProductList.size();i++){
                    if (indexExport-1==i){
                        importProductList.remove(i);
                    }
                }
                break;
            case 3:
                Controller.displayMainMenu();
                break;
            default:
                System.out.println("Chọn Sai!!!");
        }
    }

    public static void addNewProduct() {
        scanner.nextLine();
        System.out.println("Nhập sản phẩm muốn thêm: ");
        System.out.println("1.Thêm Sản Phẩm Nhập khẩu\n"+
                "2. Thêm Sản phẩm xuất khẩu\n"+
                "3.Quay lại Menu\n"+
                "Chọn chức năng: ");
        int choose=scanner.nextInt();
        switch (choose){
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
    static int id=0;
    private static void addNewProductExport() {
        scanner.nextLine();
        System.out.println("Nhập Mã Sản Phẩm");
        String codeProduct=scanner.nextLine();
        System.out.println("Nhập Tên Sản Phẩm");
        String name=scanner.nextLine();
        System.out.println("Nhập Giá Sản Phẩm");
        double price=Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập Số lượng Sản Phẩm");
        int amount=Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Nhà Sản Xuất Sản Phẩm");
        String producer=scanner.nextLine();
        System.out.println("Nhập Giá Xuất Khẩu Sản Phẩm");
        double priceExport=Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập Quốc gia xuất khẩu Sản Phẩm");
        String exportNation=scanner.nextLine();
        exportProductsList.add(new exportProduct(++id,codeProduct,name,price,amount,producer,priceExport,exportNation));
        ReaderWriteFile.writerFile(exportProductsList.get(0).getId()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile(exportProductsList.get(0).getCodeProduct()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile(exportProductsList.get(0).getName()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile(exportProductsList.get(0).getPrice()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile(exportProductsList.get(0).getAmount()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile(exportProductsList.get(0).getProducer()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile(exportProductsList.get(0).getExportPrice()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile(exportProductsList.get(0).getExportNation()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile("1",FILE_PRODUCT);
        ReaderWriteFile.writerFile("\n",FILE_PRODUCT);
    }

    private static void addNewProductImport() {
        scanner.nextLine();
        System.out.println("Nhập Mã Sản Phẩm");
        String codeProduct=scanner.nextLine();
        System.out.println("Nhập Tên Sản Phẩm");
        String name=scanner.nextLine();
        System.out.println("Nhập Giá Sản Phẩm");
        double price=Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập Số lượng Sản Phẩm");
        int amount=Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Nhà Sản Xuất Sản Phẩm");
        String producer=scanner.nextLine();
        System.out.println("Nhập Giá Nhập Khẩu Sản Phẩm");
        double priceImport=Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập Tỉnh Nhập Khẩu Sản Phẩm");
        String importProvince=scanner.nextLine();
        System.out.println("Nhập Thuế Nhập Khẩu Sản Phẩm");
        double importTax=Double.parseDouble(scanner.nextLine());
        importProductList.add(new importProduct(++id,codeProduct,name,price,amount,producer,priceImport,importProvince,importTax));
        ReaderWriteFile.writerFile(importProductList.get(0).getId()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile(importProductList.get(0).getCodeProduct()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile(importProductList.get(0).getName()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile(importProductList.get(0).getPrice()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile(importProductList.get(0).getAmount()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile(importProductList.get(0).getProducer()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile(importProductList.get(0).getImportPrice()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile(importProductList.get(0).getImportProvince()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile(importProductList.get(0).getImportTax()+",",FILE_PRODUCT);
        ReaderWriteFile.writerFile("2",FILE_PRODUCT);
        ReaderWriteFile.writerFile("\n",FILE_PRODUCT);
    }
}
