package org.algorithms.graph.tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//트리
public class BackJoon_4803 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, m, vertex_cnt, edge_cnt;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static void input() {
        /* TODO */
    }

    static void dfs(int x) {
        /* TODO */
    }

    static void pro(int tt) {
        /* TODO */
    }

    public static void main(String[] args) {
        for (int tt = 1; ; tt++) {
            input();
            if (n == 0 && m == 0) break;
            pro(tt);
        }
        System.out.print(sb);
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