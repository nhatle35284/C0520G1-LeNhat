package lesson.accsess_modifier.bai_tap;

import java.util.Scanner;

public class StudentCodeGymClass {
    static StudentCodeGym[] studentCodeGyms = new StudentCodeGym[100];
    static int count = 0;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        Lựa chọn
        while (true) {
            System.out.println("1.Đăng ký học viên mới: ");
            System.out.println("2.Học viên đã tốt nghiệp: ");
            System.out.println("3.Hiển thị danh sách sinh viên hiện tại: ");
            int chosse = scanner.nextInt();
            switch (chosse) {
                case 1:
//       Thêm sinh viên
                    for (int i = count; i < studentCodeGyms.length; i++) {
                        System.out.print("nhập id sinh viên cần thêm:");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("nhập tên sinh viên cần thêm:");
                        String name1 = scanner.nextLine();
                        System.out.print("nhập ngày sinh sinh viên cần thêm:");
                        String dateOfBirthday = scanner.nextLine();
                        StudentCodeGym studentCodeGym = new StudentCodeGym(id, name1, dateOfBirthday);
                        register(studentCodeGym);
                        studentCodeGyms[i].setId(id);
                        studentCodeGyms[i].setName(name1);
                        studentCodeGyms[i].setDateOfBirth(dateOfBirthday);
                        break;
                    }
                    break;
                case 2:
                    graduate();
                    System.out.println("xóa thành công");
                    break;
                case 3:
                    listDisplay();
                    break;
                default:
                    System.out.println("lựa chọn không hợp lệ: ");
            }
        }
    }
    //             THÊM
    static public void register(StudentCodeGym studentCodeGym) {
        for (int i = 0; i < studentCodeGyms.length; i++) {
            studentCodeGyms[count] = studentCodeGym;
            count++;
            break;
        }
    }
    //            XÓA
    public static void graduate() {
        System.out.println("nhập ID học viên đã tốt nghiệp:");
        int id = scanner.nextInt();
        int index = 0;
        for (int i = 0; i < studentCodeGyms.length; i++) {
            if (id == studentCodeGyms[i].getId()) {
                index = i;
                count--;
                break;
            }
        }
        for (int i = index; i < studentCodeGyms.length - 1; i++) {
            studentCodeGyms[i] = studentCodeGyms[i + 1];
        }
    }
    //               HIỂN THỊ
    public static void listDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("danh sách học viên hiện tại: ");
        System.out.println(" số học viên hiện tại là  " + count + " bạn");
        String temp = "";
        for (int i = 1; i < count; i++) {
            temp += "Tên: " + studentCodeGyms[i].getName() + "\n";
        }
        System.out.println(temp);
        int choice = scanner.nextInt();
        System.out.println("id: " + studentCodeGyms[choice].getId());
        System.out.println("tên: " + studentCodeGyms[choice].getName());
        System.out.println("ngày sinh: " + studentCodeGyms[choice].getDateOfBirth());
    }
}
class StudentCodeGym {
    public int id;
    public String name;
    public String dateOfBirth;
    public StudentCodeGym(int id, String name, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
    public int getId() {
        return id;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
