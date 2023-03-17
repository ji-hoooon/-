package org.datastructure.hashtable;

import java.util.HashMap;
import java.util.Scanner;

public class Inflearn04_01 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        Inflearn04_01 main = new Inflearn04_01();
        System.out.println(main.solution(n,str));
    }
    public char solution(int n, String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
        }
        int max=0;
        char answer=' ';
        for(char x:map.keySet()){
            if(max<map.get(x)) {
                max=map.get(x);
                answer=x;
            }
        }
        return answer;
    }
}