package lesson.array_method_in_java.bai_tap;

import java.util.Scanner;

public class CountCharacter {
    public static void main(String[] args) {
        String chain = "nha la noi de ve" ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the character you want to find the frequency :");
        char character = 'a';
        int count=0;
        for (int i=0;i<chain.length();i++) {
            if (character == chain.charAt(i)) {
               count++;
            }
        }
        System.out.println(""+character+" is: "+count);
    }
}
