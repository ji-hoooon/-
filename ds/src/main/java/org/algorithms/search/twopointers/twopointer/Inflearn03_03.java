package org.algorithms.search.twopointers.twopointer;

import java.util.Scanner;

public class Inflearn03_03 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr =new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        Inflearn03_03 main = new Inflearn03_03();
        System.out.println(main.solution(arr, m));
    }
    public int solution(int[]arr, int m){
        int answer=0;
        for(int i=0;i<m;i++){
            answer+=arr[i];
        }

        int result=answer;
        for(int i=m;i<arr.length;i++){
            result-=arr[i-m];
            result+=arr[i];
            answer=Math.max(result, answer);
        }
        return answer;
    }
}