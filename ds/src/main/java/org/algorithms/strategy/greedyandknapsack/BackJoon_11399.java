package org.algorithms.strategy.greedyandknapsack;

import java.util.Arrays;
import java.util.Scanner;

public class BackJoon_11399 {
        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int n=in.nextInt();
            int[] arr= new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            System.out.println(solution(arr, n));
        }
        static int solution(int[] arr, int n){
            Arrays.sort(arr);
            int tmp=arr[0];
            int sum=tmp;
            for(int i=1;i<n;i++){
                tmp+=arr[i];
                sum+=tmp;
            }
            return sum;
        }
    }