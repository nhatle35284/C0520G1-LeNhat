package product;

public abstract class Product {
    static int id;
    private String codeProduct;
    private String name;
    private double price;
    private int amount;
    private String producer;

    public Product(int id, String codeProduct, String name, double price, int amount, String producer) {
        this.codeProduct = codeProduct;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", codeProduct='" + codeProduct + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", producer='" + producer + '\'' +
                '}';
    }

    public abstract void showInformation();
}
