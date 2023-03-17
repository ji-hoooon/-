package org.datastructure.hashtable;

import java.util.HashMap;
import java.util.Scanner;

public class Inflearn04_04 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str = in.next();
        String s=in.next();
        Inflearn04_04 main = new Inflearn04_04();
        System.out.println(main.solution(str,s));
    }
    public int solution(String str, String s){
        int answer=0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(char c:s.toCharArray()){
            map1.put(c, map1.getOrDefault(c,0)+1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        char[] arr = str.toCharArray();
        for(int i=0;i<s.length();i++){
            map2.put(arr[i], map2.getOrDefault(arr[i],0)+1);
        }
        if(map1.equals(map2)) answer++;

        int p=0;
        for(int i=s.length(); i<str.length();i++){
            map2.put(arr[p], map2.get(arr[p])-1);
            if(map2.get(arr[p])==0)map2.remove(arr[p]);
            p++;
            map2.put(arr[i], map2.getOrDefault(arr[i],0)+1);
            if(map1.equals(map2)) answer++;
        }
        return answer;
    }
}