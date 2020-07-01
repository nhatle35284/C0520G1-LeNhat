package loop_in_java.bai_tap;

public class InCacHinh {
    public static void main(String[] args) {
        System.out.println("Hình Chữ Nhật");
        for (int i=0;i<3;i++) {
            System.out.println();
            for (int j=0;j<10;j++) {
                System.out.print("*");
            }
        }
        System.out.println(" ");
        System.out.println("tam giác cân");
        for(int i=1; i<=6; i++) {
            System.out.println(" ");
            for(int j=1; j<i; j++) {
                System.out.print(" *");
            }
        }
        System.out.println(" ");
        for(int i=5;i>=1;i--) {
            System.out.println();
            for(int j=1;j<=i;j++){
                System.out.print(" *");
            }
        }
        System.out.println(" ");
        for (int i=5;i>=1;i--) {
            System.out.println();
            for (int j=0;j<=i;j++){
                System.out.println();
                System.out.print(" *");
//                System.out.print(" ");
            }
        }
    }
}
