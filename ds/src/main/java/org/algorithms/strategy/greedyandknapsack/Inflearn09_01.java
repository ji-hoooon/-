package org.algorithms.strategy.greedyandknapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//1. 씨름 선수
//        설명
//
//        현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.
//
//        현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
//
//        현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
//
//        “A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가
//
//        존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
//
//        N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.

public class Inflearn09_01 {
    static class Person{
        public int h, w;
        Person(int h, int w){
            this.h=h;
            this.w=w;
        }
    }     
    public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            ArrayList<Person> list = new ArrayList<>();
            Inflearn09_01 main = new Inflearn09_01();
            int n = in.nextInt();
            Person[] arr = new Person[n];
            for(int i=0;i<n;i++){
                int h=in.nextInt();
                int w=in.nextInt();
                list.add(new Person(h, w));
                arr[i]=new Person(h, w);
            }
            System.out.println(main.solution(list));
            System.out.println(main.solution2(arr));
    }
        public int solution(ArrayList<Person> list){
            int answer=0;
            e: for(Person p : list){
                for(Person s : list){
                    if(p.h<s.h && p.w<s.w){
                        continue e;
                    }
                }
                answer++;
            }

            return answer;
        }

        
        public int solution2(Person[] arr){
            int answer=0;
            Arrays.sort(arr);
            for(int i=0;i<arr.length;i++){
                int cnt=0;
                for(int j=0;j<arr.length;j++){

                    if(i==j) continue;
                    if(arr[i].h<arr[j].h&&arr[i].w<arr[j].w) {
                        break;
                    }
                    cnt++;
                }
                if(cnt==arr.length-1) answer++;
            }

            return answer;
        }
    }

