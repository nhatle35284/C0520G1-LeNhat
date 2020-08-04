package case_study.furama_resort.models;

public class Room extends Services{
    private ExtraService extraService;
    public Room(String id,String name, String userArena, String price, String maxPeople, String rentType,  ExtraService extraService) {
        super(name, userArena, price, maxPeople, rentType, id);
        this.extraService = extraService;
    }

    public Room(String id, String name, String userArena, String price, String maxPeople, String rentType, String freeService) {
    }


    public String getExtraService() {
        return extraService.getExtraServiceName();
    }

    public void setExtraService(ExtraService extraService) {
        this.extraService = extraService;
    }

    @Override
    public String toString() {
        return "Room{" +super.toString()+
                "extraService=" + extraService +
                '}';
    }

    @Override
    public void showInform() {
        System.out.println(this.toString());
    }
}
