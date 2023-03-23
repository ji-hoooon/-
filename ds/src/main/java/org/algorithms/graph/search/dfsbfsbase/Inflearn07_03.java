package org.algorithms.graph.search.dfsbfsbase;

import java.util.Scanner;
//팩토리얼

public class Inflearn07_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        solution(n, 1);
    }
    public static void solution(int n,int m){
        if(n==1){
            System.out.println(m);
        }else{
            m*=n;
            solution(n-1, m);
        }
    }
}
