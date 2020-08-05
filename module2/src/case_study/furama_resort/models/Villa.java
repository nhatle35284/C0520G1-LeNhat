package case_study.furama_resort.models;

public class Villa extends Services {
    private String roomStandard;
    private String description;
    private String areaPool;
    private String numberFloors;

    public Villa() {
    }

    public Villa(String roomStandard, String description, String areaPool, String numberFloors) {
        this.roomStandard = roomStandard;
        this.description = description;
        this.areaPool = areaPool;
        this.numberFloors = numberFloors;
    }

    public Villa(String id, String name, String userArea, String price, String maxPeople, String rentType, String roomStandard, String description, String areaPool, String numberFloors) {
        super(name, userArea, price, maxPeople, rentType, id);
        this.roomStandard = roomStandard;
        this.description = description;
        this.areaPool = areaPool;
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

    public String getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(String areaPool) {
        this.areaPool = areaPool;
    }

    public String getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(String numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString()+
                " roomStandard='" + roomStandard + '\'' +
                ", description='" + description + '\'' +
                ", arenaPool='" + areaPool + '\'' +
                ", numberFloors='" + numberFloors + '\'' +
                '}';
    }

    @Override
    public void showInform() {
        System.out.println(this.toString());
}}
