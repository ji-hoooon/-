package org.algorithms.strategy.dpanddivideconquer.dp.dp_base_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1,2,3 구하기
public class BackJoon_9095_try {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] Dy;

    static void preprocess() {
        Dy = new int[15];
        // 초기값 구하기
        Dy[1]=1;
        Dy[2]=2;
        Dy[3]=4;

        // 점화식을 토대로 Dy 배열 채우기
        for(int i=4;i<15;i++){
            Dy[i]=Dy[i-1]+Dy[i-2]+Dy[i-3];
        }
    }

    static void pro() {
        int T = scan.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            int N = scan.nextInt();
            sb.append(Dy[N]).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        preprocess();
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
