package org.algorithms.bruteforce.bruteforce_advanced;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//부분수열의 합
public class BackJoon_1182_try {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
    }
    static int N, S, ans;
    static int[] nums;
    // k번째 원소를 포함시킬 지 정하는 함수
    // value:= k-1 번째 원소까지 골라진 원소들의 합
    static void rec_func(int k, int value) {
        if (k == N + 1) {  // 부분 수열을 하나 완성 시킨 상태
            // value 가 S 랑 같은 지 확인하기
            // TODO
            if(value==S) ans++;
        } else {
            // k 번째 원소를 포함시킬 지 결정하고 재귀호출해주기
            // 포함 시키는 경우와 포함시키지 않는 경우
            rec_func(k+1, value+nums[k]);
            rec_func(k+1, value);
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1, 0);
        // ans 가 정말 "진 부분집합"만 다루는 지 확인하기
        //: 하나도 안고를 경우는 S가 0일 때만 존재 -> 공집합 제거
        if(S==0) ans--;
        System.out.println(ans);
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