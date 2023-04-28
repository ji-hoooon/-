package org.algorithms.search.binarysearch.binary_others;

import java.util.Arrays;
import java.util.Scanner;

public class BackJoon_2512 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int m= in.nextInt();

        BackJoon_2512 main= new BackJoon_2512();
        System.out.println(main.solution(arr, n, m));
    }
    public int solution(int[]arr, int n, int m){
        int answer=0;
        Arrays.sort(arr);
        int lt=0;
        int rt=arr[arr.length-1];
        while(lt<=rt){
            int limit=(lt+rt)/2;
            int tmp=0;
            for(int i=0;i<n;i++){
                if(arr[i]>limit){
                    tmp+=limit;
                }else{
                    tmp+=arr[i];
                }
                if(tmp>m) break;
            }
            if(tmp<=m) {
                answer=limit;
                lt=limit+1;
            }
            else{
                rt=limit-1;
            }
        }
        return answer;
    }
}