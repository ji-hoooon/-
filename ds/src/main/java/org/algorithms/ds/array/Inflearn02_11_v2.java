package org.algorithms.ds.array;

import java.util.Scanner;

public class Inflearn02_11_v2 {
        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            int n = in.nextInt();
            int[][] arr = new int[n+1][6];
            for(int i=1;i<=n;i++){
                for(int j=1;j<=5;j++){
                    arr[i][j]=in.nextInt();
                }
            }
            Inflearn02_11_v2 main = new Inflearn02_11_v2();
            System.out.println(main.solution(n, arr));
        }
        public int solution(int n, int[][] arr){
            int [][] result = new int[arr.length][arr.length];
            int [] resultArr = new int[arr.length];
            int answer=0;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=5;j++){
                    for(int k=1;k<=n;k++){
                        if(result[i][k]==0 && arr[i][j]==arr[k][j]){
                            result[i][k]=1;
                        }
                    }
                }
            }

            int max=Integer.MIN_VALUE;
            for(int i=1;i<arr.length; i++){
                int tmp=0;
                for(int j=1; j<arr.length; j++){
                    if(result[i][j]==1) tmp++;
                    if(tmp>max){
                        max=tmp;
                        answer=i;
                    }
                }
            }

            return answer;
    }
}
