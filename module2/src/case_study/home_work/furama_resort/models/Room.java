package case_study.home_work.furama_resort.models;

public class Room extends Services{
    private String serviceFreeIncluded;

    public Room() {
    }
    public Room(String serviceFreeIncluded) {
        this.serviceFreeIncluded = serviceFreeIncluded;
    }

    public Room(int id , String name, double userArena, double price, int maxPeople, int rentType, String serviceFreeIncluded) {
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
    public String showInform() {
        return "Phòng có kèm theo dịch vụ miễn phí kèm là: "+serviceFreeIncluded;
    }
}
