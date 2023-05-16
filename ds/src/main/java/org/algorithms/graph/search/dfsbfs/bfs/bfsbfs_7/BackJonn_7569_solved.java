package org.algorithms.graph.search.dfsbfs.bfs.bfsbfs_7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJonn_7569_solved {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, H;
    static int[][][] dist, a;
    static int[][] dir = {{1, 0, 0,}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    static Queue<Integer> q = new LinkedList<>();

    static void input() {
        M = scan.nextInt();
        N = scan.nextInt();
        H = scan.nextInt();
        dist = new int[H][N][M];
        a = new int[H][N][M];
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int x = scan.nextInt();
                    a[k][i][j] = x;
                    if (x == 1) {
                        q.offer(k);
                        q.offer(i);
                        q.offer(j);
                    }
                }
            }
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int z = q.poll();
            int x = q.poll();
            int y = q.poll();


            for (int k = 0; k < 6; k++) {
                int nz = z + dir[k][0];
                int nx = x + dir[k][1];
                int ny = y + dir[k][2];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue;
                if (a[nz][nx][ny] == -1) continue;
                if (a[nz][nx][ny] == 1) continue;
                a[nz][nx][ny] = 1;
                q.offer(nz);
                q.offer(nx);
                q.offer(ny);

                dist[nz][nx][ny] = dist[z][x][y] + 1;
            }
        }
    }

    static void pro() {
        bfs();
        int ans = 0;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (a[k][i][j] == -1) continue;
                    if (a[k][i][j] == 0) {
                        System.out.println("-1");
                        return;
                    }
                    ans = Math.max(ans, dist[k][i][j]);
                }
            }
        }
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