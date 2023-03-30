package org.algorithms.graph.search.bfs.make;

import org.io.FastReader;

import java.io.*;
import java.util.*;

//케빈 베이컨의 6단계 법칙
//: 케빈 베이컨 수가 가장 적은 사람 중 번호가 가장 작은 사람 출력
public class BackJoon_1389_Base {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    static void input() {
        N= scan.nextInt();
        adj=new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            adj[i]=new ArrayList<>();
        }
        M= scan.nextInt();
        for(int i=0;i<M;i++){
            int x= scan.nextInt();
            int y= scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    // start 라는 정점의 케빈 베이컨의 수를 계산해주는 함수
    static int bfs(int start) {
        Queue<Integer> Q = new LinkedList<>();

    }

    static void pro() {
        int minV = bfs(1), minIdx = 1;
        // 최소의 케빈 베이컨의 수를 갖는 사람 찾기
        /* TODO */
        System.out.println(minIdx);
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
