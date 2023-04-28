package org.algorithms.search.sortsearch.sort_inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inflearn06_06_retry {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[]arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        Inflearn06_06_retry main = new Inflearn06_06_retry();
        for(int x:main.solution(n, arr)){
            System.out.print(x+" ");
        }
    }
    public List<Integer> solution(int n, int[]arr){
        List<Integer> list= new ArrayList<>();
        //철수
        int[] newarr= Arrays.copyOf(arr,arr.length);
        Arrays.sort(newarr);
        int tmp=0;
        for(int i=1;i<=n;i++){
            if(arr[i-1] != newarr[i-1]) list.add(i);
            if(list.size()==2) return list;
        }
        return list;
    }
}