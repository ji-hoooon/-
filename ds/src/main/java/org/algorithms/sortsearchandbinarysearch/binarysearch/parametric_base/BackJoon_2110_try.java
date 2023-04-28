package org.algorithms.sortsearchandbinarysearch.binarysearch.parametric_base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//공유기 설치
//C개의 공유기를 설치했을 때, 최대 인접거리는 얼마인가?
//해당 거리만큼의 거리를 둘 때, 공유기 C개를 설치할 수 있는가? (YES/NO)

public class BackJoon_2110_try {
    static BackJoon_2110_Base.FastReader scan = new BackJoon_2110_Base.FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, C;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        C = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static boolean determination(int D) {
        // D 만큼의 거리 차이를 둔다면 C 개 만큼의 공유기를 설치할 수 있는가?

        // 제일 왼쪽 집부터 가능한 많이 설치해보자!
        // D 만큼의 거리를 두면서 최대로 설치한 개수와 C 를 비교하자.
        int cnt = 1, last = A[1];
        return cnt >= C;
    }

    static void pro() {
        // determination을 빠르게 하기 위해서 정렬해주자.

        int L = 1, R = 1000000000, ans = 0;
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
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