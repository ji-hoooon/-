package org.algorithms.strategy.dpanddivideconquer.dp;

public class Dp {
    //알고리즘 풀이 전략 중 하나인 동적 계획법과 분할&정복의 공통점과 차이점
    //동적 계획법 (Dynamic Programming) : 메모이제이션 기법 사용
    //상향식 접근법으로 가장 최하위 문제 해결 후 해결한 해답을 재사용해 상위 문제를 해결해 나가는 기법
    //: 입력 크기가 작은 중복되는 부분 문제를 해결하고 메모이제이션 기법을 사용함으로써, 이전에 계산한 값을 다시 계산하지 않도록 저장한다.
    // 저장한 값을 재사용해서 실행 속도를 빠르게 하는 기술
    //Ex) 피보나치 수열


    //피보나치 문제 - strategy
    public int fibonacci(int data, int[] arr){
        //1~data까지
        //배열로 intStream만들기
//        IntStream stream = Arrays.stream(arr);
        for(int i=1;i<=data;i++){
            if(i==1||i==2) arr[i]=1;
            else arr[i]=arr[i-2]+arr[i-1];
        }
        return arr[data];
    }
    public static void main(String[] args) {
        Dp dp = new Dp();
        int n=9;
        int[] arr = new int[n+1];
        System.out.println("dc.fibonacci("+n+") = " + dp.fibonacci(n, arr));
    }
}
