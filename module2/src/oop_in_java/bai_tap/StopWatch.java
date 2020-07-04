package oop_in_java.bai_tap;

import java.time.LocalTime;

class Time {
    private LocalTime startTime,endTime;
    public void startTime() {
//        return startTime;
    }
    public LocalTime start() {
        LocalTime now = LocalTime.now();
    }
    public LocalTime stop() {
        LocalTime now = LocalTime.now();
    }
    public void getElapsedTime() {

    }

}
public class StopWatch {
    public static void main(String[] args) {
        Time time= new Time();
        System.out.println(time);
        int[] array= new int[1000];
        array = Math.random()*1000;
    }
}
