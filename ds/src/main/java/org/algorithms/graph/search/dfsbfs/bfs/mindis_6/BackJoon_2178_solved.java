package org.algorithms.graph.search.dfsbfs.bfs.mindis_6;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BackJoon_2178_solved {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] a;
    static int[][] dist;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> group;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new String[N+1];
        visit = new boolean[N+1][M+1];
        dist = new int[N+1][M+1];

        for (int i = 1; i <= N; i++){
            Arrays.fill(dist[i],-1);
            a[i] = scan.nextLine();
        }

    }

    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    static void bfs(int x, int y) {
        Queue<int[]> Q = new LinkedList<>();
        // dist 배열 초기화
        /* TODO */
        dist[x][y]=1;
        visit[x][y]=true;
        Q.offer(new int[]{x,y});


        // (x, y)를 Q에 넣어주고, visit 표시와 dist 값 초기화
        /* TODO */
        while(!Q.isEmpty()){
            int[] tmp = Q.poll();
            if(tmp[0]==N && tmp[1]==M) return;

            for(int k=0;k<4;k++){
                int nx=tmp[0]+dir[k][0];
                int ny=tmp[1]+dir[k][1];
                if(nx<1||ny<1||nx>N||ny>M) continue;
                if(visit[nx][ny]) continue;
                if(a[nx].charAt(ny-1)=='0') continue;
                Q.offer(new int[]{nx,ny});
                visit[nx][ny]=true;

                dist[nx][ny]=dist[tmp[0]][tmp[1]]+1;
            }
        }

        // BFS 과정 시작
        /* TODO */
    }

    static void pro() {
        // 시작점이 (0, 0)인 탐색 시작
        /* TODO */
        bfs(1,1);


        // (N-1, M-1)까지 필요한 최소 이동 횟수 출력
        /* TODO */
        System.out.println(dist[N][M]);
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