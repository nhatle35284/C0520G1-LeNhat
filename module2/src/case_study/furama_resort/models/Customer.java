package case_study.furama_resort.models;

public class Customer implements Comparable<Customer> {
    private String name;
    private String birthday;
    private String gender;
    private String id;
    private String numberPhone;
    private String email;
    private String typeCustomer;
    private String address;
    private Services userService;

    public Services getUserService() {
        return userService;
    }

    public void setUserService(Services userService) {
        this.userService = userService;
    }


    public Customer() {
    }

    public Customer(String name, String birthday, String gender, String id, String numberPhone, String email, String typeCustomer, String address) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.id = id;
        this.numberPhone = numberPhone;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", id='" + id + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", email='" + email + '\'' +
                ", typeCustomer='" + typeCustomer + '\'' +
                ", address='" + address + '\'' +
                ", userService=" + userService +
                '}';
    }

    public void showInfor(){
        System.out.println("Customer{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", id='" + id + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", email='" + email + '\'' +
                ", typeCustomer='" + typeCustomer + '\'' +
                ", address='" + address + '\'' +
                '}');
    }
    @Override
    public int compareTo(Customer o) {
        return name.compareTo(o.name);
    }
}
