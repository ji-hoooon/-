package org.algorithms.strategy.greedyandknapsack;

import java.util.Scanner;
import java.util.*;

class Income{
    int money;
    int day;
    Income(int money, int day){
        this.money=money;
        this.day=day;
    }

    @Override
    public String toString() {
        return "Income{" +
                "money=" + money +
                ", day=" + day +
                '}';
    }
}

public class Inflearn09_04_Hard {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Income> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new Income(in.nextInt(), in.nextInt()));
        }
        Inflearn09_04_Hard main = new Inflearn09_04_Hard();
        System.out.println(main.solution(arr));
    }
    public int solution(ArrayList<Income> arr){
        int answer=0;
        Collections.sort(arr, (o1,o2) -> o1.day-o2.day);
        int max=arr.get(arr.size()-1).day;
        for(Income i : arr){
//            System.out.println("i.money+\" \"+i.day = " + i.money + " " + i.day);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i=arr.size()-1;
        for(;max>=1;max--){

            //112233
            //3 -> 0,1,2,3,
            while(i!=0){
                if(arr.get(i).day<max) break;
                else {
                    pq.offer(arr.get(i).money);
                }
                i--;
            }

            if(!pq.isEmpty()) {
                int money = pq.poll();
//                System.out.println("max=, money = " +max+ " "+money);

                answer+=money;
            }
        }
        return answer;
    }
}