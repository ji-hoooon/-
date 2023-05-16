package org.algorithms.graph.search.dfsbfs.dfs.arraygraph_1;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//단지 번호 붙이기
public class BackJoon_2667_solved {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, group_cnt;
    static String[] a;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> group;

    static void input() {
        N = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++)
            a[i] = scan.nextLine();
        visit = new boolean[N][N];
    }

    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            group_cnt++;

            // 인접한 집으로 새로운 방문하기
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dir[k][0];
                int ny = cur[1] + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (a[nx].charAt(ny) == '0') continue;  // 갈 수 있는 칸인지 확인해야 한다.
                if (visit[nx][ny]) continue;
                q.add(new int[]{nx, ny});
                visit[nx][ny] = true;
            }
        }
    }
    static void dfs(int x, int y) {
        group_cnt++;
        // 단지에 속한 집의 개수 증가, visit 체크 하기
//        if(visit[x][y]) return;
        visit[x][y]=true;

        // 인접한 집으로 새로운 방문하기
        for(int k=0;k<4;k++){
            int nx=x+dir[k][0];
            int ny=y+dir[k][1];
            if(nx<0||ny<0||nx>=N||ny>=N) continue;
            if (a[nx].charAt(ny) == '0') continue;  // 갈 수 있는 칸인지 확인해야 한다.
            if(visit[nx][ny]) continue;
            dfs(nx,ny);
        }
    }

    static void pro() {
        group = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && a[i].charAt(j) == '1') {
                    // 갈 수 있는 칸인데, 이미 방문처리 된, 즉 새롭게 만난 단지인 경우!
                    group_cnt = 0;
                    bfs(i, j);
                    group.add(group_cnt);
                }
            }
        }

        // 찾은 단지의 정보를 출력하기
        Collections.sort(group);
        sb.append(group.size()+"\n");
        for(int x:group){
            sb.append(x+"\n");
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
