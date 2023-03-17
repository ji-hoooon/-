package org.algorithms.strategy.greedyandknapsack;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    //부분 배낭 알고리즘
    //:무게 제한이 k인 배낭에 최대 가치를 가지는 물건을 넣는 문제
    //각 물건은 무게 w와 가치 v로 표현한다.
    //물건을 쪼개서 일부분을 배낭에 넣을 수도 있다.
    //: 무게 대비 가치가 높은 물건을 넣는다. ->  가치/무게의 비율이 높은 물건순
    //현재 시점에 가장 가치가 높은 물건 선택
    public void fknapsack(Integer[][] objectList, double capacity){
        double totalValue = 0.0;
        double fraction = 0.0;

        //가치/무게 순으로 정렬하기 위해 재정의
//        Arrays.sort(objectList, new Comparator<Integer[]>() {
//            @Override
//            public int compare(Integer[] o1, Integer[] o2) {
//                return o2[1]/o2[0]-o1[1]/o1[0];
//            }
//        });
        Arrays.sort(objectList, (o1,o2) -> o2[1]/o2[0]-o1[1]/o1[0]);

        for(Integer[] arr:objectList){
            if(capacity-(double) arr[0]>0){
                capacity-=(double) arr[0];
                totalValue+=(double) arr[1];
                System.out.println("무게: "+arr[0]+" , 가치: "+ arr[1]);
            }else{
               fraction=capacity/(double) arr[0];
               totalValue+=(double) arr[1]*fraction;
                System.out.println("무게: "+arr[0]+" , 가치: "+arr[1]+" ,  비율: "+fraction);
                //나머지 비율까지 모두 채웠으므로 중단
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치: "+totalValue);

    }

    public static void main(String[] args) {
        FractionalKnapsack fractionalKnapsack=new FractionalKnapsack();
        Integer[][] objectList = {{10,10}, {15,12},{20,10},{25,8},{30,5}};
        fractionalKnapsack.fknapsack(objectList,30.0);

    }
}
