package geneue_stack_queue.bai_tap.char_map;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CountChar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input String: ");
        String str= scanner.nextLine().toLowerCase();
        Character eachChar;
        int index=1;
        Map<Character, Integer> character = new TreeMap<>();
        for (int i=0;i<str.length();i++){
            eachChar = str.charAt(i);
            if(eachChar != ' ') {
                if(character.containsKey(eachChar)){
                    index=character.get(eachChar);
                    index++;
                } else {
                    index=1;
                }
                character.put(eachChar,index);
            }
        }
        Set<Character> freKey = character.keySet();
        for (Character key: freKey) {
            System.out.println("character: " +key+" key: "+character.get(key));
        }
    }
}
