package org.algorithms.search.twopointers.twopointer_inflearn;

import java.util.Scanner;

public class Inflearn03_05 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        Inflearn03_05 main = new Inflearn03_05();
        System.out.println(main.solution(n));
    }
    public int solution(int n){
        int result=0;
        int answer=0;
        int p1=1;
        for(int i=1;i<=n/2+1;i++){
            result+=i;
            if(result==n) answer++;

            while(result>n){
                result-=p1++;
                if(result==n) answer++;
            }
        }
        return answer;
    }
}