package product;

public class exportProduct extends Product {
    private double exportPrice;
    private String exportNation;

    public exportProduct(int id, String codeProduct, String name, double price, int amount, String producer, double exportPrice, String exportNation) {
        super(id, codeProduct, name, price, amount, producer);
        this.exportPrice = exportPrice;
        this.exportNation = exportNation;
    }


    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getExportNation() {
        return exportNation;
    }

    public void setExportNation(String exportNation) {
        this.exportNation = exportNation;
    }

    @Override
    public String toString() {
        return super.toString()+"exportProduct{" +
                "exportPrice=" + exportPrice +
                ", exportNation='" + exportNation + '\'' +
                '}';
    }

    @Override
    public void showInformation() {
        System.out.println(toString());
    }
}
