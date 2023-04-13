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
public class BackJoon_4803_Sol {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, m, vertex_cnt, edge_cnt;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        adj = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        // 인접 리스트 구성하기
        for (int i = 1; i <= m; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void dfs(int x) {
        //정점 개수 추가
        vertex_cnt++;
        //간선 개수는 해당 자식의 간선만큼 추가
        edge_cnt += adj[x].size();

        visit[x] = true;
        for (int y : adj[x]) {
            if (visit[y]) continue;
            dfs(y);
        }
    }

    static void pro(int tt) {
        //트리의 개수
        int ans = 0;

        //모든 정점에 대해서 방문
        for (int i = 1; i <= n; i++) {

            //방문 한 정점은 통과하고, 해당 정점에서 연결된 총 정점의 개수와, 총 간선의 개수를 구한다.
            if (visit[i]) continue;
            vertex_cnt = 0;
            edge_cnt = 0;
            dfs(i);
            if (edge_cnt == (vertex_cnt - 1) * 2) ans++;
        }

        // 정답 출력하기
        sb.append("Case ").append(tt).append(": ");
        if (ans == 0) {
            sb.append("No trees.\n");
        } else if (ans == 1) {
            sb.append("There is one tree.\n");
        } else {
            sb.append("A forest of ").append(ans).append(" trees.\n");
        }
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