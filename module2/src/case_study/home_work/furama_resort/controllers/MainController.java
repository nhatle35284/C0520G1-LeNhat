package case_study.home_work.furama_resort.controllers;

import case_study.home_work.furama_resort.commons.ReadWriteFile;
import case_study.home_work.furama_resort.models.House;
import case_study.home_work.furama_resort.models.Room;
import case_study.home_work.furama_resort.models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static final String FILE_VILLA = "C:\\123\\C0520G1-LeNhat\\module2\\src\\case_study\\home_work\\furama_resort\\data\\villa.csv";
    public static final String FILE_HOUSE = "C:\\123\\C0520G1-LeNhat\\module2\\src\\case_study\\home_work\\furama_resort\\data\\room.csv";
    public static final String FILE_ROOM = "C:\\123\\C0520G1-LeNhat\\module2\\src\\case_study\\home_work\\furama_resort\\data\\house.csv";
    public static List<Villa> villaList = new ArrayList<>();
    public static List<House> houseList = new ArrayList<>();
    public static List<Room> roomList = new ArrayList<>();
    public static void main(String[] args) {
        displayMainMenu();
    }
    public static void displayMainMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int choose;
            System.out.println("1.Add New Services");
            System.out.println("2.Show Services");
            System.out.println("3.Add new Customer");
            System.out.println("4.Show Information of Customer");
            System.out.println("5.Add New Booking");
            System.out.println("6.Show Information of Employee");
            System.out.println("7.Exit");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addNewService(scanner);
                    break;
                case 2:
                    showService(scanner);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choose);
            }
        }
    }

    private static void showService(Scanner scanner) {
        int choose;
        System.out.println("1.\tShow all Villa\n" +
                "2.\tShow all House\n" +
                "3.\tShow all Room\n" +
                "4.\tShow All Name Villa Not Duplicate\n" +
                "5.\tShow All Name House Not Duplicate\n" +
                "6.\tShow All Name Name Not Duplicate\n" +
                "7.\tBack to menu\n" +
                "8.\tExit\n");
        choose=scanner.nextInt();
        switch (choose){
            case 1:
                showAllVilla();
                break;
            case 2:
                showAllHouse();
                break;
            case 3:
                showAllRoom();
                break;
            case 4:
                showAllNameVillaNotDuplicate();
                break;
            case 5:
                showAllNameHouseNotDuplicate();
                break;
            case 6:
                showAllNameRoomNotDuplicate();
                break;
            case 7:
                displayMainMenu();
                break;
            case 8:
                System.exit(0);
                break;
        }
    }


    private static void showAllNameHouseNotDuplicate() {

    }

    private static void showAllNameRoomNotDuplicate() {

    }

    private static void showAllNameVillaNotDuplicate() {

    }

    private static void showAllRoom() {
        ReadWriteFile.readerFile(FILE_ROOM);
        for (Room room: roomList) {
            System.out.println(room.showInform());
        }
    }

    private static void showAllHouse() {
        ReadWriteFile.readerFile(FILE_HOUSE);
        for (House house: houseList) {
            System.out.println(house.showInform());
        }

    }

    private static void showAllVilla() {
        ReadWriteFile.readerFile(FILE_VILLA);
        for (Villa villa: villaList) {
            System.out.println(villa.showInform());
        }
    }

    private static void addNewService(Scanner scanner) {
        int choose;
        System.out.print("1.\tAdd New Villa\n" +
                "2.\tAdd New House\n" +
                "3.\tAdd New Room\n" +
                "4.\tBack to menu\n" +
                "5.\tExit\n");
        choose = scanner.nextInt();
        switch (choose) {
            case 1:
                addNewVilla(scanner);
                break;
            case 2:
                addNewHouse(scanner);
                break;
            case 3:
                addNewRoom(scanner);
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
    }

    private static void addNewRoom(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Name Villa: ");
        String name = scanner.nextLine();
        System.out.println("Enter the area of use");
        double userArena = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter number People: ");
        int maxPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Type of rent(Hour/Day/month/year: ");
        int rentType = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Free Service Included: ");
        String serviceFreeIncluded = scanner.nextLine();
        roomList.add(new Room(id,  name, userArena, price, maxPeople, rentType, serviceFreeIncluded));
        for (int i=0;i<roomList.size();i++){
            ReadWriteFile.writerFile(String.valueOf(roomList.get(i).getId())+",",FILE_ROOM);
            ReadWriteFile.writerFile(roomList.get(i).getName()+",",FILE_ROOM);
            ReadWriteFile.writerFile(String.valueOf(roomList.get(i).getUserArena())+",",FILE_ROOM);
            ReadWriteFile.writerFile(String.valueOf(roomList.get(i).getPrice())+",",FILE_ROOM);
            ReadWriteFile.writerFile(String.valueOf(roomList.get(i).getMaxPeople())+",",FILE_ROOM);
            ReadWriteFile.writerFile(String.valueOf(roomList.get(i).getRentType())+",",FILE_ROOM);
            ReadWriteFile.writerFile(roomList.get(i).getServiceFreeIncluded(),FILE_ROOM);
            ReadWriteFile.writerFile("\n",FILE_ROOM);
        }
    }

    private static void addNewHouse(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Name Villa: ");
        String name = scanner.nextLine();
        System.out.println("Enter the area of use");
        double userArena = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter number People: ");
        int maxPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Type of rent(Hour/Day/month/year");
        int rentType = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Standard Room: ");
        String roomStandard = scanner.nextLine();
        System.out.println("Enter Description Villa: ");
        String description = scanner.nextLine();
        System.out.println("Enter Number Floors :");
        int numberFloors = Integer.parseInt(scanner.nextLine());
        houseList.add(new House(id,name,userArena,price,maxPeople,rentType,roomStandard,description,numberFloors));
        for (int i=0;i<houseList.size();i++){
            ReadWriteFile.writerFile(String.valueOf(houseList.get(i).getId())+",",FILE_HOUSE);
            ReadWriteFile.writerFile(houseList.get(i).getName()+",",FILE_HOUSE);
            ReadWriteFile.writerFile(String.valueOf(houseList.get(i).getUserArena())+",",FILE_HOUSE);
            ReadWriteFile.writerFile(String.valueOf(houseList.get(i).getPrice())+",",FILE_HOUSE);
            ReadWriteFile.writerFile(String.valueOf(houseList.get(i).getMaxPeople())+",",FILE_HOUSE);
            ReadWriteFile.writerFile(String.valueOf(houseList.get(i).getRentType())+",",FILE_HOUSE);
            ReadWriteFile.writerFile(houseList.get(i).getRoomStandard()+",",FILE_HOUSE);
            ReadWriteFile.writerFile(houseList.get(i).getDescription()+",",FILE_HOUSE);
            ReadWriteFile.writerFile(String.valueOf(houseList.get(i).getNumberFloors()),FILE_HOUSE);
            ReadWriteFile.writerFile("\n",FILE_HOUSE);

        }
    }

    private static void addNewVilla(Scanner scanner) {
        //addNewVilla
        scanner.nextLine();
        System.out.println("Enter Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Name Villa: ");
        String name = scanner.nextLine();
        System.out.println("Enter the area of use");
        double userArena = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter number People: ");
        int maxPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Type of rent(Hour/Day/month/year");
        int rentType = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Standard Room: ");
        String roomStandard = scanner.nextLine();
        System.out.println("Enter Description Villa: ");
        String description = scanner.nextLine();
        System.out.println("Enter Arena Pool: ");
        double arenaPool= Double.parseDouble(scanner.nextLine());
        System.out.println("Enter Number Floors :");
        int numberFloors = Integer.parseInt(scanner.nextLine());
        villaList.add(new Villa(id,name,userArena,price,maxPeople,rentType,roomStandard,description,arenaPool,numberFloors));
        for (int i=0;i<villaList.size();i++){
            ReadWriteFile.writerFile(String.valueOf(villaList.get(i).getId())+",",FILE_VILLA);
            ReadWriteFile.writerFile(villaList.get(i).getName()+",",FILE_VILLA);
            ReadWriteFile.writerFile(String.valueOf(villaList.get(i).getUserArena())+",",FILE_VILLA);
            ReadWriteFile.writerFile(String.valueOf(villaList.get(i).getPrice())+",",FILE_VILLA);
            ReadWriteFile.writerFile(String.valueOf(villaList.get(i).getMaxPeople())+",",FILE_VILLA);
            ReadWriteFile.writerFile(String.valueOf(villaList.get(i).getRentType())+",",FILE_VILLA);
            ReadWriteFile.writerFile(villaList.get(i).getRoomStandard()+",",FILE_VILLA);
            ReadWriteFile.writerFile(villaList.get(i).getDescription()+",",FILE_VILLA);
            ReadWriteFile.writerFile(String.valueOf(villaList.get(i).getArenaPool())+",",FILE_VILLA);
            ReadWriteFile.writerFile(String.valueOf(villaList.get(i).getNumberFloors()),FILE_VILLA);
            ReadWriteFile.writerFile("\n",FILE_VILLA);

        }
    }
}
