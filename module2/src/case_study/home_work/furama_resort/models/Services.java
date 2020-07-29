package case_study.home_work.furama_resort.models;

public abstract class Services {
    private String name;
    private double userArena;
    private double price;
    private int maxPeople;
    private int rentType;
    private int id;

    public Services() {
    }

    public Services(String name, double userArena, double price, int maxPeople, int rentType, int id) {
        this.name = name;
        this.userArena = userArena;
        this.price = price;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUserArena() {
        return userArena;
    }

    public void setUserArena(double userArena) {
        this.userArena = userArena;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getRentType() {
        return rentType;
    }

    public void setRentType(int rentType) {
        this.rentType = rentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public abstract String showInform();
}
