package nhat.coder.baithi.model;

import nhat.coder.baithi.day.ValidateBirthday18;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Product {
    @Id
    @Pattern(regexp = "(SP-\\d{4})",message = "Please enter the correct format (SP-XXXX)")
    private String productId;
    private String productName;

//    @NotNull(message = "nhaplai")
    @Min(value = 1,message = "Giá đó có đéo")
    private double price;
    private int quantity;
    @ValidateBirthday18()
    private String color;
    private String description;
    private boolean status;
    @ManyToOne()
    @JoinColumn(name = "id")
    private Category category;

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
