package oop_in_java.bai_tap;

import java.time.LocalTime;
import java.util.Scanner;

//public class StopWatch {
//    public static void main(String[] args) {
//        Time time= new Time();
//        LocalTime timeStop;
//        System.out.println(time);
//        time.start();
//        int[] array= new int[1000];
//        for (int i=0;i<array.length;i++) {
//            array[i]= (int) (Math.random()*1000);
//        }
////        timeStop = time.stop();
////        System.out.println();
//    }
//}
//class Time {
//    private LocalTime startTime, endTime;
//    public LocalTime getStartTime() {
//        return startTime;
//    }
//    public LocalTime getEndTime() {
//        return endTime;
//    }
//    public void start() {
//        startTime = LocalTime.now();
//    }
//    public void stop() {
//        endTime = LocalTime.now();
//    }
//    public int getElapsedTime() {
//        int miliSecond = (((endTime.getHour() - startTime.getHour()) * 3600 +
//                (endTime.getMinute() - startTime.getMinute()) * 60 +
//                (endTime.getSecond() - startTime.getSecond())) * 1000);
//        return miliSecond;
//    }
//}



public class StopWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Time time = new Time();
        time.start();
        System.out.println(time.getStartTime());
        System.out.println();
        int[] array= new int[1000000];
        for (int i=0;i<1000000;i++){
            array[i] = (int) (Math.random()*1000000);
        }
        System.out.println("hello");
        int a=scanner.nextInt();
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[i]){
                    int temp = array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        System.out.println();
        time.stop();
        System.out.println(time.getEndTime());
        System.out.println();
        System.out.println("số thời gian sử dung thuật toán:--> "+ time.getElapsedTime()+"  miliSecond");
    }
}
class Time {
    private LocalTime startTime, endTime;
    public LocalTime getStartTime() {
        return startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void start() {
        startTime = LocalTime.now();
    }
    public void stop() {
        endTime = LocalTime.now();
    }
    public int getElapsedTime() {
        int miliSecond = (((endTime.getHour() - startTime.getHour()) * 3600 +
                (endTime.getMinute() - startTime.getMinute()) * 60 +
                (endTime.getSecond() - startTime.getSecond())) * 1000);
        return miliSecond;
    }
}
