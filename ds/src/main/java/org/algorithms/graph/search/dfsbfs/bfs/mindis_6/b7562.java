package org.algorithms.graph.search.dfsbfs.bfs.mindis_6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b7562 {
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
        dist = new int[M][N][H];
        a = new int[M][N][H];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < H; k++) {
                        Arrays.fill(dist[i][j], -1);
                    int x = scan.nextInt();
                    a[i][j][k] = x;
                    if (x == 1) {
                        dist[i][j][k] = 0;
                        q.offer(i);
                        q.offer(j);
                        q.offer(k);
                    }
                }
            }
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            int z = q.poll();

            for (int k = 0; k < 6; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                int nz = z + dir[k][2];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H) continue;
                if (a[nx][ny][nz] == -1) continue;
                if (dist[nx][ny][nz] != -1) continue;
                //if(a[nx][ny][nz]==1) continue;
                //a[nx][ny][nz]=1;
                q.offer(nx);
                q.offer(ny);
                q.offer(nz);
                dist[nx][ny][nz] = dist[x][y][z] + 1;
            }
        }
    }

    static void pro() {
        bfs();
        int ans = 0;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (a[i][j][k] == -1) continue;
                    if (dist[i][j][k] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    //if(ans<dist[i][j][k]) ans=dist[i][j][k];
                    ans = Math.max(ans, dist[i][j][k]);
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