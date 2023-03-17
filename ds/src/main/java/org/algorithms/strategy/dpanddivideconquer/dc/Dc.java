package org.algorithms.strategy.dpanddivideconquer.dc;

public class Dc {
    //알고리즘 풀이 전략 중 하나인 동적 계획법과 분할&정복의 공통점과 차이점
    //문제를 작은 단위로 분할해 푸는 것은 동일

    //분할과 정복 (Divide & Conquer) : 재귀함수 사용
    //하향식 접근법으로 상위의 해답을 구하기 위해, 아래로 내려가면서 분할하지 못할 때까지 내려가 최하위의 해답을 구해서 합치는 방식
    //문제를 나눌 수 없을 때까지 나누어서 각각을 풀면서 합치는 방식이기 때문에
    //부분 문제가 중복되지 않으므로, 메모이제이션을 사용해 저장하지  않아도 된다.
    //Ex) 병합 정렬, 퀵 정렬
    
    //피보나치 문제 - divide&conquer : 재귀함수 이용하면, 재사용하지 않기 때문에 낭비
    public int fibonacci(int data){
        if(data<=1){
            return data;
        }else return fibonacci(data-1)+ fibonacci(data-2);
    }
    public static void main(String[] args) {
        Dc dc = new Dc();
        System.out.println("dc.fibonacci(3) = " + dc.fibonacci(3));
    }
}
