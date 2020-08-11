package product;

public class Validate {
    public static boolean isMoreThan (double number, double numberToCompare) {
        boolean check = number > numberToCompare;
        if(!check){
            System.out.println("This number is not more than " + numberToCompare);
        }
        return check;
    }
}
