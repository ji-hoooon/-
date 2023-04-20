package org.algorithms.sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//수열 정
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {

        /**
         * @param idx A 배열의 idx 위치를 기억하는 변수
         * @param num A[idx]의 원래 값
         */
        public int num, idx;

        @Override
        public int compareTo(Elem o) {
            // TODO
            // 정렬 조건에 맞게 정렬하기
            // 1. num의 비내림차순 -이전 항목보다 같거나 작은순
            //: 같지않으면 오름차순
            if(this.num!=o.num){
                return this.num-o.num;
            }
            // 2. num이 같으면 idx 오름차순
            else return this.idx-o.idx;
        }
        public Elem(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    static int N;
    static int[] P;
    static Elem[] B;

    static void input() {
        N = scan.nextInt();
        B = new Elem[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            int num = scan.nextInt();
            B[i] = new Elem(num,i);
            // TODO: Elem 의 정의에 맞게 B[i] 에 값을 넣어주기
        }
    }

    static void pro() {
        // TODO: B 배열 정렬하기
        Arrays.sort(B);
//        for(Elem X :B){
//            System.out.println(X.num);
//        }
//        for(Elem X :B){
//            System.out.println(X.idx);
//        }
        // TODO: B 배열의 값을 이용해서 P 배열 채우기
        for(int i=0;i<N;i++){
            P[B[i].idx]=i;
        }

        // TODO: P 배열 출력하기
        for(int x: P){
            sb.append(x).append(" ");
        }
        sb.append('\n');
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
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