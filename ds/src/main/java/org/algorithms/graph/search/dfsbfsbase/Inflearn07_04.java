package org.algorithms.graph.search.dfsbfsbase;
//피보나치 수열
//(1) 배열
//(2) 재귀함수
//: 배열과 for문으로 짜는게 더 성능이 좋다. 재귀함수는 스택프레임을 이용해서 메모리 낭비
//(3) 메모이제이션

import java.util.Scanner;

public class Inflearn07_04 {
    //DFS(n) : 피보나치 수열의 n번째 항
    //-> for문을 돌면, 호출했던 DFS(n)을 다시 호출하는 문제

    //메모이제이션을 이용해, 호출한적 있으면 배열에서 가져온다.
    static int[] fibo;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        fibo = new int[n+1];
        solution(n);
        //n은 항의 번호
        for(int i=1;i<=n;i++){
            System.out.print(fibo[i]+" ");
        }
    }
    public static int solution(int n){
        if(fibo[n]>0) return fibo[n];
        if(n==1){
            return fibo[n]=1;
        }else if(n==2){
            return fibo[n]=1;
        }else{
            return fibo[n]=solution(n-2)+solution(n-1);
        }
    }
}