package case_study.furama_resort.commons;

public class NameException extends Exception {
    public NameException(String message){
        super(message);
    }
//    public static void nameCheck(boolean check) throws NameException{
//        if (!check){
//            throw new NameException("Enter wrong Name of Customer");
//        }
//    }
}
