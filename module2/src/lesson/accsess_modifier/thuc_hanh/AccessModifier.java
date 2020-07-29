package lesson.accsess_modifier.thuc_hanh;
/*pravite*/
//public class AccessModifier {
//    public static void main(String args[]){
//
//        A obj=new A();
//
//        System.out.println(obj.getData());//Compile Time Error
//
//        obj.msg();//Compile Time Error
//
//    }
//}
//class A{
//
//    private int data=40;
//
//    public int getData() {
//        return data;
//    }
//
//    public void setData(int data) {
//        this.data = data;
//    }
//
//    public void msg(){System.out.println("Hello java");}
//}
/*default*/
//save by A.java
//public class AccessModifier {
//package pack;
//
//class A{
//
//    void msg(){System.out.println("Hello");}
//
//}
////save by B.java
//
//package mypack;
//
//        import pack.*;
//
//class B{
//
//    public static void main(String args[]){
//
//        A obj = new A();//Compile Time Error
//
//        obj.msg();//Compile Time Error
//
//    }
//}
//}