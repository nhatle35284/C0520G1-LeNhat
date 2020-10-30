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
//    @Pattern(regexp = "(SP-\\d{4})",message = "Please enter the correct format (SP-XXXX)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String productName;

    //    @NotNull(message = "nhaplai")
    private double price;
    private boolean status;
    @ManyToOne()
    @JoinColumn(name = "id")
    private Category category;

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
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
