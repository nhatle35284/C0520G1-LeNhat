package case_study.furama_resort.commons;

public class GenderException extends Exception{
    public GenderException(String message){
        super(message);
    }
//    public static void genderCheck(boolean check) throws GenderException{
//        if (!check){
//            throw new GenderException("Enter wrong Email of Customer");
//        }
//    }
}
