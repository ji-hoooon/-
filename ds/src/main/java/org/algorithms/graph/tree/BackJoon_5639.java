package org.algorithms.graph.tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//이진 검색 트리 (BST)
public class BackJoon_5639 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer> a;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        a = new ArrayList<>();
        while ((input = br.readLine()) != null) {
            a.add(Integer.parseInt(input));
        }
    }

    // 현재 Subtree가 a[l...r] 일 때, 후위 순회를 하는 함수.
    static void traverse(int l, int r) {
        /* TODO */
    }

    static void pro() {
        traverse(0, a.size() - 1);
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
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
