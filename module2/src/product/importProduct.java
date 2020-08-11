package product;

public class importProduct extends Product {
    private double importPrice;
    private String importProvince;
    private double importTax;


    public importProduct(int id, String codeProduct, String name, double price, int amount, String producer, double importPrice, String importProvince, double importTax) {
        super(id, codeProduct, name, price, amount, producer);
        this.importPrice = importPrice;
        this.importProvince = importProvince;
        this.importTax = importTax;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public String getImportProvince() {
        return importProvince;
    }

    public void setImportProvince(String importProvince) {
        this.importProvince = importProvince;
    }

    public double getImportTax() {
        return importTax;
    }

    public void setImportTax(double importTax) {
        this.importTax = importTax;
    }

    @Override
    public String toString() {
        return super.toString()+"importProduct{" +
                "importPrice=" + importPrice +
                ", importProvince='" + importProvince + '\'' +
                ", importTax=" + importTax +
                '}';
    }

    @Override
    public void showInformation() {
        System.out.println(toString());
    }
}
