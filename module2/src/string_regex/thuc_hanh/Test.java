package string_regex.thuc_hanh;

public class Test {
    public static void main(String[] args) {
        String s1="Welcome to Java";
        String s2="Program in fun to Java m";
        String s3="Welcome to Java";
        System.out.println(s1.startsWith("el"));

        String x = "user@fpt.edu.vn";
        String y = "\\w+@\\w+(\\.\\w+){1,2}";
        if(x.matches(y)){
            System.out.print("A");
        }
        else{
            System.out.print("B");
        }
    }


}
