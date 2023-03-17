package org.datastructure.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Inflearn04_03 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int [] arr =new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        Inflearn04_03 main = new Inflearn04_03();
        for(int x: main.solution(arr, m)){
            System.out.print(x+" ");
        }
    }
    public ArrayList<Integer> solution(int[] arr, int m){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<m;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        answer.add(map.size());
        int p=0;
        for(int i=m;i<arr.length;i++){
            map.put(arr[p], map.get(arr[p])-1);
            if(map.get(arr[p])==0) map.remove(arr[p]);
            p++;

            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            answer.add(map.size());
        }
        return answer;
    }
}