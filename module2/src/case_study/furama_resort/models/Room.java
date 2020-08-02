package case_study.furama_resort.models;

public class Room extends Services{
    private String serviceFreeIncluded;

    public Room() {
    }
    public Room(String serviceFreeIncluded) {
        this.serviceFreeIncluded = serviceFreeIncluded;
    }

    public Room(String id , String name, String userArena, String price, String maxPeople, String rentType, String serviceFreeIncluded) {
        super(name, userArena, price, maxPeople, rentType, id);
        this.serviceFreeIncluded = serviceFreeIncluded;
    }

    public String getServiceFreeIncluded() {
        return serviceFreeIncluded;
    }

    public void setServiceFreeIncluded(String serviceFreeIncluded) {
        this.serviceFreeIncluded = serviceFreeIncluded;
    }

    @Override
    public String toString() {
        return "Room{" +
                "serviceFreeIncluded='" + serviceFreeIncluded + '\'' +
                '}'+ super.toString();
    }

    @Override
    public void showInform() {
        System.out.println(this.toString());
    }
}
