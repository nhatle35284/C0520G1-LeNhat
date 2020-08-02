package case_study.furama_resort.models;

public class Villa extends Services {
    private String roomStandard;
    private String description;
    private String arenaPool;
    private String numberFloors;

    public Villa() {
    }

    public Villa(String roomStandard, String description, String arenaPool, String numberFloors) {
        this.roomStandard = roomStandard;
        this.description = description;
        this.arenaPool = arenaPool;
        this.numberFloors = numberFloors;
    }

    public Villa(String id,String name, String userArena, String price, String maxPeople, String rentType, String roomStandard, String description, String arenaPool, String numberFloors) {
        super(name, userArena, price, maxPeople, rentType, id);
        this.roomStandard = roomStandard;
        this.description = description;
        this.arenaPool = arenaPool;
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

    public String getArenaPool() {
        return arenaPool;
    }

    public void setArenaPool(String arenaPool) {
        this.arenaPool = arenaPool;
    }

    public String getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(String numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "roomStandard='" + roomStandard + '\'' +
                ", description='" + description + '\'' +
                ", arenaPool='" + arenaPool + '\'' +
                ", numberFloors='" + numberFloors + '\'' +
                '}'+ super.toString();
    }

    @Override
    public void showInform() {
        System.out.println(this.toString());
}}
