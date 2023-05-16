package org.algorithms.graph.search.dfsbfs.dfs.arraygraph_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon_2667_solved3_BFSDFS {
    static int N, group_cnt;
    static String S;
    static boolean[][] visited;
    static String[] list;
    static ArrayList<Integer> answer;
    static StringBuilder sb = new StringBuilder();
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        visited = new boolean[N + 1][N + 1];
        list = new String[N+1];
        answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            S = scan.next();
            list[i]= S;
        }
    }

    static void bfs(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(x);
        Q.offer(y);
        visited[x][y] = true;

        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            group_cnt++;
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if (visited[nx][ny]) continue;
                if (list[nx].charAt(ny-1) == '0') continue;

                visited[nx][ny] = true;
                Q.offer(nx);
                Q.offer(ny);
            }
        }
    }

    static void dfs(int x, int y) {
        group_cnt++;
        // 단지에 속한 집의 개수 증가, visit 체크 하기
//        if(visit[x][y]) return;
        visited[x][y] = true;

        // 인접한 집으로 새로운 방문하기
        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
            if (list[nx].charAt(ny - 1) == '0') continue;  // 갈 수 있는 칸인지 확인해야 한다.
            if (visited[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (visited[i][j]) continue;
                if (list[i].charAt(j - 1) == '1') {
                    group_cnt = 0;
                    bfs(i, j);
                    answer.add(group_cnt);
                }
            }
        }

        sb.append(answer.size() + "\n");
        Collections.sort(answer);
        for (int y : answer) {
            sb.append(y + "\n");
        }
        System.out.println(sb);
    }
}