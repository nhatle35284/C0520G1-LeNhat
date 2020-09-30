package nhat.coder.userform.model;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Size(min=  5,max = 45)
    private String firstName;
//    @Size(min=  5,max = 45)
    private String lastName;
//    @Pattern(regexp = "(09|01[2689])+([0-9]{8})",message = "sai rooiii?")
    private String numberPhone;
//    @Range(min = 18,max = 100 ,message = "Nhập lại")
    private int age;
    @Pattern(regexp = "[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}",message = "sai rooiii?")
    private String email;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.firstName.length() < 5 || user.firstName.length() > 45) {
            errors.rejectValue("firstName", "firstNameErr");
        }
        if (user.lastName.length() < 5 || user.lastName.length() > 45) {
            errors.rejectValue("lastName", "lastNameErr");
        }
        if (user.age<18){
            errors.rejectValue("age","ageErr");
        }if (user.numberPhone.length()>11||user.numberPhone.length()<10){
            errors.rejectValue("numberPhone","numberPhone.length");
        }
    }
}
