package org.algorithms.strategy.dpanddivideconquer.dp.dp_practice_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//피보나치 함수
public class BackJoon_1003_Base {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int Q;
    static long[][] Dy;

    static void input() {
        Q = scan.nextInt();
    }

    // Dy[][] 를 미리 계산해 놓기
    static void preprocess() {
        // Dy[i][k] := fibonacci(i) 를 호출했을 때, k 가 출력되는 횟수
        /* TODO */
    }

    static void pro() {
        Dy = new long[40 + 1][2];
        preprocess();

        /* TODO */
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
