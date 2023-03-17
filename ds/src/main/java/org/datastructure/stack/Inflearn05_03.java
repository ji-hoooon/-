package org.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class Inflearn05_03 {
        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            int n = in.nextInt();
            int[][] arr = new int[n+1][n+1];
            for(int i=1; i<n+1;i++){
                for(int j=1; j<n+1;j++){
                    arr[i][j]=in.nextInt();
                }
            }

            Inflearn05_03 main = new Inflearn05_03();
            int m=in.nextInt();
            int[] result = new int[m];
            for(int i=0;i<m;i++){
                result[i]=in.nextInt();
            }
            System.out.println(main.solution(arr, n, result));
        }

        public int solution(int[][] arr, int n,int[] result){
            int answer=0;
            Stack<Integer> stack = new Stack<>();
            for(int x:result){
                int num=0;
                for(int j=0; j<=n;j++){
                    if(arr[j][x] != 0){
                        num=arr[j][x];
                        arr[j][x]=0;
                        break;
                    }
                }
                if(!stack.isEmpty() && stack.peek()==num){
                    stack.pop();
                    answer+=2;
                }else if(num!=0){
                    stack.push(num);
                }
            }
            return answer;
        }
    }