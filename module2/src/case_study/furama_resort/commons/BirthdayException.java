package case_study.furama_resort.commons;

public class BirthdayException extends Exception {
    public BirthdayException(String message){
        super(message);
    }
//    public static void birthdayCheck(boolean check) throws BirthdayException{
//        if (!check){
//            throw new BirthdayException("Enter wrong Birth of Customer");
//        }
//    }
}
