package org.algorithms.strategy.greedyandknapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinExchange {
    //탐욕 알고리즘(그리디) - 근사치 추정
    //: 최적의 해에 가까운 값을 구하기 위해 사용되며,
    //여러 경우의 수 중 하나를 선택하는 경우, 매순간 최적이라고 생각되는 (현재 시점의 최고의 선택)으로 진행해 최종 결과 반환
    //한계 : 여러 조합의 경우의 수가 존재한다면, 최적이 아닌 경우의 수도 존재

    //동전 교환
    public void coinFunc(Integer price, List<Integer> coinList){
        Integer totalCoinCount=0;
        Integer coinNum=0;

        List<Integer> details =new ArrayList<>();

        for(int i : coinList){
            coinNum=price/i;
            totalCoinCount+=coinNum;
            price-=coinNum*i;
            details.add(coinNum);
            System.out.println(i+"원: "+coinNum+"개");
        }
        System.out.println("총 동전 개수 : "+totalCoinCount);

    }

    public static void main(String[] args) {
        CoinExchange gObject = new CoinExchange();
        List<Integer> coinList = new ArrayList<Integer>(Arrays.asList(500, 100, 50, 1));
        gObject.coinFunc(4720, coinList);
    }
}
