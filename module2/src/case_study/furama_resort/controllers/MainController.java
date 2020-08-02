package case_study.furama_resort.controllers;

import case_study.furama_resort.models.Customer;
import case_study.furama_resort.models.House;
import case_study.furama_resort.models.Room;
import case_study.furama_resort.models.Villa;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static case_study.furama_resort.commons.ReadWriteFile.*;

public class MainController {
    public static final String FILE_VILLA = "C:\\123\\C0520G1-LeNhat\\module2\\src\\case_study\\furama_resort\\data\\villa.csv";
    public static final String FILE_HOUSE = "C:\\123\\C0520G1-LeNhat\\module2\\src\\case_study\\furama_resort\\data\\house.csv";
    public static final String FILE_ROOM = "C:\\123\\C0520G1-LeNhat\\module2\\src\\case_study\\furama_resort\\data\\room.csv";
    public static final String FILE_CUSTOMER = "C:\\123\\C0520G1-LeNhat\\module2\\src\\case_study\\furama_resort\\data\\customer.csv";

    public static List<Villa> villaList = new ArrayList<>();
    public static List<House> houseList = new ArrayList<>();
    public static List<Room> roomList = new ArrayList<>();
    public static List<Customer> customerList = new ArrayList<>();

    static Matcher matcher;
    static Pattern pattern;
    //regex service
    public static final String REGEX_ID = "SV(VL|HO|RO)-\\d{4}";
    public static final String REGEX_NAME_SERVICE = "[A-Z][a-z]*";
    public static final String REGEX_ARENA = "[3-9]\\d(.{0,1})\\d{0,9}|\\d{3,9}(.{0,1})\\d{0,9}";
    public static final String REGEX_PRICE = "[1-9](.{0,1})\\d|[1-9]\\d(.{0,1})\\d{0,9}|[1-9]\\d{1,9}(.{0,1})\\d{0,9}";
    public static final String REGEX_MAX_PEOPLE = "[1-9]|[1]\\d|20";
    public static final String REGEX_SERVICE_INCLUDED = "(massage|karaoke|food|drink|car)";
    public static final String REGEX_NUMBER_FLOORS = "\\d|[1-9]\\d";
    public static final String REGEX_STANDARD = "SV(VIP|)";
    public static final String REGEX_BIRTHDAY = "(([0][1-9]|[1-2]\\d|[3][0-1])/(0[1-9]|1[0-2])/(19[2-9]\\d|(20[0-2]\\d)))";
    public static final String REGEX_NAME_CUSTOMER="[A-Z][a-z]* ([A-Z][a-z]* )*[A-Z][a-z]*";
    public static final String REGEX_EMAIL = "([a-zA-Z0-9_.\\-])+@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+";
    public static final String REGEX_GENDER = "(Male|Female|Unknow)";
    public static final String REGEX_ID_CUSTOMER = "\\d{9}";

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
                    addNewCustomer(scanner);
                    break;
                case 4:
                    showInformCustomer(scanner);
                    break;
                case 5:
                    addNewBooking(scanner);
                    break;
                case 6:
                    showInformationOfEmployee(scanner);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choose);
            }
        }
    }

    private static void showInformationOfEmployee(Scanner scanner) {

    }

    private static void addNewBooking(Scanner scanner) {
        int choose;
        System.out.println("1.\tBooking Villa\n" +
                "2.\tBooking House\n" +
                "3.\tBooking Room\n");
        choose=scanner.nextInt();
        switch (choose){
            case 1:
                bookingVilla();
            break;
            case 2:
                bookingHouse();
                break;
            case 3:
                bookingRoom();
                break;
            default:
        }
    }

    private static void bookingRoom() {
        readerFile(FILE_ROOM);
        for (Room room : roomList) {
            System.out.println(room.toString());
        }
    }

    private static void bookingHouse() {
        readerFile(FILE_HOUSE);
        for (House house: houseList) {
            System.out.println(house.toString());
        }
    }

    private static void bookingVilla() {
        readerFile(FILE_VILLA);
        for (Villa villa: villaList) {
            System.out.println(villa.toString());
        }

    }

    private static void showInformCustomer(Scanner scanner) {
        readerFile(FILE_CUSTOMER);
        Customer customer=null;
        for (int i=0;i<customerList.size();i++) {
            customer=customerList.get(i);
            System.out.println((i+1)+". ");
            customer.showInfor();
        }
    }

    private static void addNewCustomer(Scanner scanner) {
        scanner.nextLine();
        String name;
        do {
            System.out.println("Enter Name Customer: ");
            name = scanner.nextLine();
            pattern=Pattern.compile(REGEX_NAME_CUSTOMER);
            matcher=pattern.matcher(name);
        }while (!matcher.matches());

        String birthday;
        do {
            System.out.println("Enter Birthday of Customer: ");
            birthday = scanner.nextLine();
            pattern=Pattern.compile(REGEX_BIRTHDAY);
            matcher=pattern.matcher(birthday);
        }while (!matcher.matches());

        String gender;
        do {
            System.out.println("Enter Gender of Customer: ");
            gender = scanner.nextLine();
            pattern=Pattern.compile(REGEX_GENDER);
            matcher=pattern.matcher(gender);
        }while (!matcher.matches());

        String id;
        do {
            System.out.println("Enter ID of Customer: ");
            id = scanner.nextLine();
            pattern=Pattern.compile(REGEX_ID_CUSTOMER);
            matcher=pattern.matcher(id);
        }while (!matcher.matches());

        System.out.println("Enter Number Phone of Customer: ");
        String numberPhone=scanner.nextLine();

        String email;
        do {
            System.out.println("Enter Email of Customer: ");
            email = scanner.nextLine();
            pattern=Pattern.compile(REGEX_EMAIL);
            matcher=pattern.matcher(email);
        }while (!matcher.matches());

        System.out.println("Enter Type of Customer: ");
        String typeCustomer=scanner.nextLine();

        System.out.println("Enter Address of Customer: ");
        String address=scanner.nextLine();

        customerList.add(new Customer(name,birthday,id,gender,numberPhone,email,typeCustomer,address));
        Collections.sort(customerList);
        for (int i=customerList.size()-1;i<customerList.size();i++){
            writerFile(customerList.get(i).getName()+",",FILE_CUSTOMER);
            writerFile(customerList.get(i).getBirthday()+",",FILE_CUSTOMER);
            writerFile(customerList.get(i).getGender()+",",FILE_CUSTOMER);
            writerFile(customerList.get(i).getId()+",",FILE_CUSTOMER);
            writerFile(customerList.get(i).getNumberPhone()+",",FILE_CUSTOMER);
            writerFile(customerList.get(i).getEmail()+",",FILE_CUSTOMER);
            writerFile(customerList.get(i).getTypeCustomer()+",",FILE_CUSTOMER);
            writerFile(customerList.get(i).getAddress(),FILE_CUSTOMER);
            writerFile("\n",FILE_CUSTOMER);
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
        Set<String> listHouseSet= new TreeSet<>();
        for (House house: houseList){
            listHouseSet.add(house.getName());
        }

    }

    private static void showAllNameRoomNotDuplicate() {
        Set<String> listRoomSet= new TreeSet<>();
        for (Room room: roomList){
            listRoomSet.add(room.getName());
        }
    }

    private static void showAllNameVillaNotDuplicate() {
        Set<String> listVillaSet= new TreeSet<>();
        for (Villa villa: villaList){
            listVillaSet.add(villa.getName());
        }
    }

    private static void showAllRoom() {
        readerFile(FILE_ROOM);
        for (Room room: roomList) {
            room.showInform();
        }
    }

    private static void showAllHouse() {
        readerFile(FILE_HOUSE);
        for (House house: houseList) {
            house.showInform();
        }

    }

    private static void showAllVilla() {
        readerFile(FILE_VILLA);
        Villa villa=null;
        for (int i=0;i<villaList.size();i++) {
            villa = villaList.get(i);
            System.out.println((i+1)+". ");
            villa.showInform();
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
        String id;
        do {
            System.out.println("Enter ID: ");
            id= scanner.nextLine();
            pattern=Pattern.compile(REGEX_ID);
            matcher=pattern.matcher(id);
        }while (!matcher.matches());

        String name;
        do {
            System.out.println("Enter Name Room: ");
            name= scanner.nextLine();
            pattern=Pattern.compile(REGEX_NAME_SERVICE);
            matcher=pattern.matcher(name);
        }while (!matcher.matches());

        String userArena;
        do {
            System.out.println("Enter the area of use");
            userArena= scanner.nextLine();
            pattern=Pattern.compile(REGEX_ARENA);
            matcher=pattern.matcher(userArena);
        }while (!matcher.matches());

        System.out.println("Enter price: ");
        String price = scanner.nextLine();

        String maxPeople;
        do {
            System.out.println("Enter number People: ");
            maxPeople= scanner.nextLine();
            pattern=Pattern.compile(REGEX_MAX_PEOPLE);
            matcher=pattern.matcher(maxPeople);
        }while (!matcher.matches());

        System.out.println("Enter Type of rent(Hour/Day/month/year: ");
        String rentType = scanner.nextLine();
        System.out.println("Enter Free Service Included: ");
        String serviceFreeIncluded = scanner.nextLine();
        roomList.add(new Room(id,  name, userArena, price, maxPeople, rentType, serviceFreeIncluded));
        for (int i=roomList.size()-1;i<roomList.size();i++){
            writerFile(String.valueOf(roomList.get(i).getId())+",",FILE_ROOM);
            writerFile(roomList.get(i).getName()+",",FILE_ROOM);
            writerFile(String.valueOf(roomList.get(i).getUserArena())+",",FILE_ROOM);
            writerFile(String.valueOf(roomList.get(i).getPrice())+",",FILE_ROOM);
            writerFile(String.valueOf(roomList.get(i).getMaxPeople())+",",FILE_ROOM);
            writerFile(String.valueOf(roomList.get(i).getRentType())+",",FILE_ROOM);
            writerFile(roomList.get(i).getServiceFreeIncluded(),FILE_ROOM);
            writerFile("\n",FILE_ROOM);
        }
    }

    private static void addNewHouse(Scanner scanner) {
        scanner.nextLine();

        String id;
        Matcher matcher;
        Pattern pattern;
        do {
            System.out.println("Enter ID: ");
            id= scanner.nextLine();
            pattern=Pattern.compile(REGEX_ID);
            matcher=pattern.matcher(id);
        }while (!matcher.matches());

        String name;
        do {
            System.out.println("Enter Name House: ");
            name= scanner.nextLine();
            pattern=Pattern.compile(REGEX_NAME_SERVICE);
            matcher=pattern.matcher(name);
        }while (!matcher.matches());

        String userArena;
        do {
            System.out.println("Enter the area of use");
            userArena= scanner.nextLine();
            pattern=Pattern.compile(REGEX_ARENA);
            matcher=pattern.matcher(userArena);
        }while (!matcher.matches());

        System.out.println("Enter price: ");
        String price = scanner.nextLine();

        String maxPeople;
        do {
            System.out.println("Enter number People: ");
            maxPeople= scanner.nextLine();
            pattern=Pattern.compile(REGEX_ARENA);
            matcher=pattern.matcher(maxPeople);
        }while (!matcher.matches());

        System.out.println("Enter Type of rent(Hour/Day/month/year");
        String rentType = scanner.nextLine();
        System.out.println("Enter Standard Room: ");
        String roomStandard = scanner.nextLine();
        System.out.println("Enter Description Villa: ");
        String description = scanner.nextLine();

        String numberFloors;
        do {
            System.out.println("Enter Number Floors :");
            numberFloors= scanner.nextLine();
            pattern=Pattern.compile(REGEX_NUMBER_FLOORS);
            matcher=pattern.matcher(numberFloors);
        }while (!matcher.matches());

        houseList.add(new House(id,name,userArena,price,maxPeople,rentType,roomStandard,description,numberFloors));
        for (int i=houseList.size()-1;i<houseList.size();i++){
            writerFile(String.valueOf(houseList.get(i).getId())+",",FILE_HOUSE);
            writerFile(houseList.get(i).getName()+",",FILE_HOUSE);
            writerFile(String.valueOf(houseList.get(i).getUserArena())+",",FILE_HOUSE);
            writerFile(String.valueOf(houseList.get(i).getPrice())+",",FILE_HOUSE);
            writerFile(String.valueOf(houseList.get(i).getMaxPeople())+",",FILE_HOUSE);
            writerFile(String.valueOf(houseList.get(i).getRentType())+",",FILE_HOUSE);
            writerFile(houseList.get(i).getRoomStandard()+",",FILE_HOUSE);
            writerFile(houseList.get(i).getDescription()+",",FILE_HOUSE);
            writerFile(String.valueOf(houseList.get(i).getNumberFloors()),FILE_HOUSE);
            writerFile("\n",FILE_HOUSE);

        }
    }

    private static void addNewVilla(Scanner scanner) {
        //addNewVilla
        scanner.nextLine();
        String id;
        Matcher matcher;
        Pattern pattern;
        do {
            System.out.println("Enter ID: ");
            id= scanner.nextLine();
            pattern=Pattern.compile(REGEX_ID);
            matcher=pattern.matcher(id);
        }while (!matcher.matches());

        String name;
        do {
            System.out.println("Enter Name Villa: ");
            name= scanner.nextLine();
            pattern=Pattern.compile(REGEX_NAME_SERVICE);
            matcher=pattern.matcher(name);
        }while (!matcher.matches());

        String userArena;
        do {
            System.out.println("Enter the area of use");
            userArena= scanner.nextLine();
            pattern=Pattern.compile(REGEX_ARENA);
            matcher=pattern.matcher(userArena);
        }while (!matcher.matches());

        System.out.println("Enter price: ");
        String price = scanner.nextLine();

        String maxPeople;
        do {
            System.out.println("Enter number People: ");
            maxPeople= scanner.nextLine();
            pattern=Pattern.compile(REGEX_MAX_PEOPLE);
            matcher=pattern.matcher(maxPeople);
        }while (!matcher.matches());

        System.out.println("Enter Type of rent(Hour/Day/month/year");
        String rentType = scanner.nextLine();
        System.out.println("Enter Standard Room: ");
        String roomStandard = scanner.nextLine();
        System.out.println("Enter Description Villa: ");
        String description = scanner.nextLine();

        String arenaPool;
        do {
            System.out.println("Enter Arena Pool: ");
            arenaPool= scanner.nextLine();
            pattern=Pattern.compile(REGEX_ARENA);
            matcher=pattern.matcher(arenaPool);
        }while (!matcher.matches());


        String numberFloors;
        do {
            System.out.println("Enter Number Floors :");
            numberFloors= scanner.nextLine();
            pattern=Pattern.compile(REGEX_NUMBER_FLOORS);
            matcher=pattern.matcher(numberFloors);
        }while (!matcher.matches());

        villaList.add(new Villa(id,name,userArena,price,maxPeople,rentType,roomStandard,description,arenaPool,numberFloors));
        for (int i=villaList.size()-1;i<villaList.size();i++){
            writerFile(String.valueOf(villaList.get(i).getId())+",",FILE_VILLA);
            writerFile(villaList.get(i).getName()+",",FILE_VILLA);
            writerFile(String.valueOf(villaList.get(i).getUserArena())+",",FILE_VILLA);
            writerFile(String.valueOf(villaList.get(i).getPrice())+",",FILE_VILLA);
            writerFile(String.valueOf(villaList.get(i).getMaxPeople())+",",FILE_VILLA);
            writerFile(String.valueOf(villaList.get(i).getRentType())+",",FILE_VILLA);
            writerFile(villaList.get(i).getRoomStandard()+",",FILE_VILLA);
            writerFile(villaList.get(i).getDescription()+",",FILE_VILLA);
            writerFile(String.valueOf(villaList.get(i).getArenaPool())+",",FILE_VILLA);
            writerFile(String.valueOf(villaList.get(i).getNumberFloors()),FILE_VILLA);
            writerFile("\n",FILE_VILLA);

        }
    }
}
