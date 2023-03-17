package org.datastructure.hashtable;

import java.util.HashMap;
import java.util.Scanner;

public class Inflearn04_02 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();
        Inflearn04_02 main =new Inflearn04_02();
        System.out.println(main.solution(str1, str2));
    }
    public String solution(String str1, String str2){
        String answer="NO";
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char x: str1.toCharArray()){
            map1.put(x, map1.getOrDefault(x, 0)+1);
        }
        for(char x: str2.toCharArray()){
            map2.put(x, map2.getOrDefault(x, 0)+1);
        }
        if(map1.equals(map2)) answer="YES";

        return answer;
    }
}