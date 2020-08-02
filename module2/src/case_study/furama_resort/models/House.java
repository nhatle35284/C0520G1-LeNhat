package case_study.furama_resort.models;

public class House extends Services {
    private String roomStandard;
    private String description;
    private String numberFloors;

    public House() {
    }

    public House(String roomStandard, String description, String numberFloors) {
        this.roomStandard = roomStandard;
        this.description = description;
        this.numberFloors = numberFloors;
    }

    public House(String id,String name, String userArena, String price, String maxPeople, String rentType, String roomStandard, String description, String numberFloors) {
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

    public String getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(String numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "roomStandard='" + roomStandard + '\'' +
                ", description='" + description + '\'' +
                ", numberFloors='" + numberFloors + '\'' +
                '}'+ super.toString();
    }

    @Override
    public void showInform() {
        System.out.println(this.toString());
    }
}
