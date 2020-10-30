package nhat.coder.bai_thi_2.model;

//import nhat.coder.bai_thi_2.day.ValidateBirthday18;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Product {
    @Id
//    @Pattern(regexp = "(SP-\\d{4})",message = "Please enter the correct format (SP-XXXX)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    @Size(min = 5,max = 50,message = "5 to 50 key")
    private String productName;


    //    @NotNull(message = "nhaplai")
//    @Min(value = 1,message = "")
    @Pattern(regexp = "^[1-9]\\d{5}(\\.?(\\d*))|([1-9]{5}\\d+(\\.?(\\d*)))$",message = "price >100.000 VND")
//    @Min(value = 100000,message = "price >100.000 VND")
    private String price;
    private String status;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
