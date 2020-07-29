package lesson.loop_in_java.bai_tap;

//import java.util.Scanner;

public class SoNguyenTo100 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int numbers;
        int count = 0;
        int N = 2;
//        System.out.println("Nhap vao so luong so nguyen to can hien thi");
//        numbers = scanner.nextInt();
        while (count < 100){
            boolean check = true;
            for (int i = 2; i < N; i++){
                if (N % i == 0){
                    check = false;
                    break;
                }
            }
            if (check){
                System.out.println(N+" là Số nguyên tố");
                count++;
            }
            N++;
        }
    }
}
