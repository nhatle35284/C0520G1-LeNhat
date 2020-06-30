package introduction_to_java.bai_tap;

import java.util.Scanner;

public class Rate {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int rate = 23000,usd,total;
        System.out.println("Nhập Số USD muốn đổi sang Vnđ ?");
        usd = scanner.nextInt();
        total = usd*rate;
        System.out.println("Số tiền USD sang Vnđ là : "+total+" Vnđ");
    }
}
