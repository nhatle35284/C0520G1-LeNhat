package case_study.home_work.furama_resort.models;

public class House extends Services {
    private String roomStandard;
    private String description;
    private int numberFloors;

    public House() {
    }

    public House(String roomStandard, String description, int numberFloors) {
        this.roomStandard = roomStandard;
        this.description = description;
        this.numberFloors = numberFloors;
    }

    public House(int id,String name, double userArena, double price, int maxPeople, int rentType, String roomStandard, String description, int numberFloors) {
        super(name, userArena, price, maxPeople, rentType, id);
        this.roomStandard = roomStandard;
        this.description = description;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String showInform() {
        return "House{" +
                "roomStandard='" + roomStandard + '\'' +
                ", description='" + description + '\'' +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
