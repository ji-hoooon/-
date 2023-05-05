package org.algorithms.strategy.dpanddivideconquer.dp.dp_practice_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1,2,3 더하기 6
public class BackJoon_15991_Base {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int Q, MOD = 1000000009;
    static int[] Dy;

    static void input() {
        Q = scan.nextInt();
    }

    static void preprocess() {
        // Dy[i] := i 를 1, 2, 3의 합으로 표현하는 방법
        /* TODO */
    }

    static void pro() {
        Dy = new int[100005];
        preprocess();
        while (Q-- > 0) {
            int x = scan.nextInt();

            int res = 0;
            /* TODO */

            sb.append(res).append('\n');
        }
        System.out.println(sb);
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
