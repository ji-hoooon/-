package org.algorithms.search.bruteforce.bruteforce_advanced;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//연산자 끼워넣기
//: k-1까지 계산한 결과를 가지고 있는 재귀함수
public class BackJoon_14888_try2 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        order = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
        for (int i = 1; i <= 4; i++) operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int N, max, min;
    static int[] nums, operators, order;

    // 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
    static int calculator(int operand1, int operator, int operand2) {
        int value=operand1;
            //value, order[i], num[i+1]
            if(operator==1) // +
                value+=operand2;
            if(operator==2) // -
                value-=operand2;
            if(operator==3) // *
                value*=operand2;
            if(operator==4) // /
                value/=operand2;
        return value;
    }


    // order[1...N-1] 에 연산자들이 순서대로 저장될 것이다.
    static void rec_func(int k, int value) {
        if (k == N) {
            // 완성된 식에 맞게 계산을 해서 정답에 갱신하는 메서드 호출
            max=Math.max(max, value);
            min=Math.min(min, value);
        } else {
            // k 번째 연산자는 무엇을 선택할 것인가?
            for(int cand=1; cand<=4;cand++){
                if(operators[cand]>=1){
                    operators[cand]--;
                    order[k]=cand;  //연산자 번호 저장
                    //: 연산자를 순서대로 저장한 배열에 연산자에 해당하는 번호를 순서대로 저장

                    //4가지 연산자들 중에 뭘 쓸건지 선택하고 연산자를 계산한 후에 재귀호출
                    //: 인자에 따라 새로운 값을 만들어야 한다. (value를 그대로 쓰면 영향을 주기 떄문에 안 된다.)
//                    int new_value=calculator(value, cand, nums[k+1]);
//                    rec_func(k+1, new_value);
                    rec_func(k+1, calculator(value, cand, nums[k+1]));

                    operators[cand]++;
                    order[k]=0;
                    //: k번째 초기화
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}