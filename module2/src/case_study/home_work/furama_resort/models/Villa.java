package case_study.home_work.furama_resort.models;

public class Villa extends Services {
    private String roomStandard;
    private String description;
    private double arenaPool;
    private int numberFloors;

    public Villa() {
    }

    public Villa(String roomStandard, String description, double arenaPool, int numberFloors) {
        this.roomStandard = roomStandard;
        this.description = description;
        this.arenaPool = arenaPool;
        this.numberFloors = numberFloors;
    }

    public Villa(int id,String name, double userArena, double price, int maxPeople, int rentType, String roomStandard, String description, double arenaPool, int numberFloors) {
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

    public double getArenaPool() {
        return arenaPool;
    }

    public void setArenaPool(double arenaPool) {
        this.arenaPool = arenaPool;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String showInform() {
        return "Villa{" +
                "roomStandard='" + roomStandard + '\'' +
                ", description='" + description + '\'' +
                ", arenaPool=" + arenaPool +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
