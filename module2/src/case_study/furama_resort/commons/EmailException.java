package case_study.furama_resort.commons;

public class EmailException extends Exception {
    public EmailException(String message){
        super(message);
    }
//    public static void emailCheck(boolean check) throws EmailException{
//        if (!check){
//            throw new EmailException("Enter wrong Email of Customer");
//        }
//    }
}
