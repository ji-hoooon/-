package org.algorithms.strategy.recursivecall;

import java.util.*;

public class recursive01 {
    //재귀 용법은 함수 안에서 동일한 함수를 호출하는 형태
    //재귀 호출은 스택의 전형적인 예로, 함수는 내부적으로 스택처럼 관리된다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        recursive01 recursive01 = new recursive01();
        System.out.println("recursive01.solution(x) = " + recursive01.solution(x));
        System.out.println("recursive01.ex1(x) = " + recursive01.ex1(x));
//        int[] array =  {1,2,3,4,5,6,7,8,9,10};
//        List<Integer> arr=Arrays.stream(array).boxed().collect(Collectors.toList());
        List<Integer> arr = new ArrayList<>();
        for(int i=1;i<=x;i++){
            arr.add(i);
        }

        System.out.println("recursive01.ex2(arr) = " + recursive01.ex2(arr));
        System.out.println("recursive01.ex3() = " + recursive01.ex3(x));;
    }
    /*
    *입력한 수의 팩토리얼 출력하는 메서드
     */

    public int solution(int x) {
//        //형태1 - 입력이 일정 값 초과면
//        if (x > 1) {
//            return x*Solution(x - 1);
//        }else
//            return 1;
        //형태2 - 입력이 일정 값보다 작으면
        if(x<2){
            return 1;
        }else return x*solution(x - 1);
    }

    /*
    *1부터 num까지 곱이 출력되도록하는 메서드
     */
    public int ex1(int x) {

        if(x<=1){
            return x;
        }else return x*ex1(x-1);
    }

    /*
    *숫자 리스트의 합을 리턴하는 재귀함수
     */
    public int ex2(List<Integer> dataList) {
        if(dataList.size()<=0){
            return 0;
        }
        return dataList.get(0)+ex2(new ArrayList<>(dataList.subList(1,dataList.size())));
    }

    /*
    * (정수 n을 만들 수 있는 경우의 수를 리턴하는 함수f(n)은 f(n-1)+f(n-2)+f(n-3)과 동일한 패턴 찾기)
    * 정수 4를 1,2,3의 조합으로 나타내는 방법은 총 7가지가 있다.
    * 정수 n이 입력으로 주어졌을 때 n을 1,2,3의 합으로 나타낼 수 있는 방법의 수를 구하시오
     */
    public int ex3(int n) {
        //4개로 구현하는 방법
        //각각 1,2,3일 때의 초기값 설정

        //1,2,3일 때 구하고, 나머지는 규칙을 찾아서 구한다.
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else if(n==3){
            return 4;
        }
        return ex3(n-1)+ex3(n-2)+ex3(n-3);
    }
}
