package org.algorithms.search.twopointers.twopointer_inflearn;

import java.util.Scanner;

public class Inflearn03_04 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[]arr =new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        Inflearn03_04 main = new Inflearn03_04();
        System.out.println(main.solution(arr, m));
    }
    public int solution(int[] arr, int m){
        //m보다 작으면 더하고, 같으면 추가하고, 크면 맨앞 뺀다.
        int p=0;
        int result=0;
        int answer=0;
        for(int i=0;i<arr.length;i++){
            result+=arr[i];
            if(result==m) answer++;
            while(result>m){
                result-=arr[p++];
                if(result==m) answer++;
            }
        }
        return answer;
    }
}