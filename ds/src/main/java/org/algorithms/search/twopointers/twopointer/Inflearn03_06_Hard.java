package org.algorithms.search.twopointers.twopointer;

import java.util.Scanner;

public class Inflearn03_06_Hard {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        Inflearn03_06_Hard main =new Inflearn03_06_Hard();
        System.out.println(main.solution(arr,m));
    }
    public int solution(int[] arr, int k){
        int lt=0;
        int cnt=0;
        int result=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) {
                cnt++;
            }
            while(cnt>k){
                if(arr[lt]==0) cnt--;
                lt++;
            }
            result=Math.max(result, i-lt+1);
        }

        return result;
    }
}