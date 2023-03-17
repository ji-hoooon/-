package org.algorithms.strategy.greedyandknapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Inflearn09_02 {
//    2. 회의실 배정
//
//    설명
//
//    한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
//
//    각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
//
//            단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
//
//            입력
//
//    첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정보가 주어지는데
//
//    이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 회의시간은 0시부터 시작한다.
//
//    회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.
//
//    출력
//
//    첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
    static class Work implements Comparable<Work> {
        public int start, end;

        Work(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Work o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        Room[] arr = new Room[n];
        ArrayList<Work> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int s=in.nextInt();
            int e=in.nextInt();
            list.add(new Work(s, e));
            arr[i]=new Room(s, e);
        }
        System.out.println(solution(list));
    }

    static int solution(ArrayList<Work> list) {
        int answer = 0;
        Collections.sort(list);

        int tmp = 0;
        for (Work w : list) {
            //System.out.println(w.start+" "+w.end);
            if (tmp <= w.start) {
                answer++;
                tmp = w.end;
            }
        }

        return answer;
    }

    static class Room {
        public int s;
        public int e;

        Room(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int solution2(Room[] arr) {
            int answer = 0;
            Arrays.sort(arr, (o1, o2) -> (o1.e == o2.e ? o1.s - o2.s : o1.e - o2.e));

            int tmp = 0;
            for (Room r : arr) {
                if (tmp <= r.s) {
                    answer++;
                    tmp = r.e;
                }
            }

            return answer;
        }
    }
}

