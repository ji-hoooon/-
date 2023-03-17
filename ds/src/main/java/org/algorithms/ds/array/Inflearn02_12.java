package org.algorithms.ds.array;

import java.util.Scanner;

public class Inflearn02_12 {
        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] arr = new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=in.nextInt();
                }
            }
            System.out.println(solution(arr, m,n));
        }
        public static int solution(int[][] arr, int m, int n){
            int answer=0;
            int[][]result = new int[arr[0].length][arr[0].length];
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    for(int k=0;k<m;k++){
                        result[arr[k][i]-1][arr[k][j]-1]+=1;
                    }
                }
            }

            for(int i=0;i<result.length;i++){
                for(int j=0;j<result.length;j++){
                    if(result[i][j]==m) answer++;
                }
            }
            return answer;
        }
    }