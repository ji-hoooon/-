package org.algorithms.graph.search.dfsbfsbase;

import java.util.Scanner;
//팩토리얼
//: 함수 호출 순서대로 가다가, 종료 조건 발동시, 복귀주소로 return
public class Inflearn07_03_Sol {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(solution(n));
    }
    public static int solution(int n){
        if(n==1){
            return 1;
        }else{
            return n*solution(n-1);
        }
    }
}
