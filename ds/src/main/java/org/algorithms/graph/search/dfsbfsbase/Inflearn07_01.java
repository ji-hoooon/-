package org.algorithms.graph.search.dfsbfsbase;

import java.util.Scanner;
//재귀 함수

//스택을 사용하는 재귀함수
//: 자기 자신을 호출하는 특징을 가진다.
//-> 재귀 함수는 반드시 종료 조건과, 감소조건/증가조건이 존재해야한다.
public class Inflearn07_01 {
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
//            System.out.print(n+" ");
            //3->2->1 호출 = 호출 순서 대로 출력
            //: 다음 함수 호출하기 전에 출력
            solution(n-1);
            System.out.print(n+" ");
            //1->2->3 호출 = 함수 종료 순서대로 출력
            //: 모든 스택 호출 끝나고 마지막으로 호출한 함수 부터 출력
        }
    }
}
