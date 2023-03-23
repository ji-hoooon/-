package org.algorithms.graph.search.dfsbfsbase;

import java.util.Scanner;
//재귀함수를 이용한 이진수 출력

public class Inflearn07_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        solution(n);
    }
    public static void solution(int n){
        if(n==0){
            return;
        }
        else{
            solution(n/2);
            System.out.print(n%2);
            //재귀 함수 종료 순서대로 나머지 출력
        }
    }
}
