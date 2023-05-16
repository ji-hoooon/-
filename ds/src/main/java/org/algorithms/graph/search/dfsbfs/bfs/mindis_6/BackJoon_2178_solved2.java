package org.algorithms.graph.search.dfsbfs.bfs.mindis_6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon_2178_solved2 {
    static int N, M, answer;
    static String[] str;
    static int[] start, end;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static int[][] dis;

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        start = new int[]{1, 1};
        end = new int[]{N, M};
        str = new String[N + 1];
        answer = Integer.MAX_VALUE;
        visited = new boolean[N + 1][M + 1];
        dis = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dis[i], -1);
        }
        for (int i = 1; i <= N; i++) {
            str[i] = scan.next();
        }
    }

    static void pro() {
        bfs(start);
        System.out.println(dis[end[0]][end[1]]);
    }

    static void bfs(int[] start) {
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(start);
        dis[start[0]][start[1]]=1;
        visited[start[0]][start[1]] = true;

        while (!Q.isEmpty()) {
            int[] tmp = Q.poll();
            if (tmp[0] == end[0] && tmp[1] == end[1]) return;

            for (int k = 0; k < 4; k++) {
                int nx = tmp[0] + dir[k][0];
                int ny = tmp[1] + dir[k][1];
                if (nx <= 0 || ny <= 0 || nx > N || ny > M) continue;
                if (visited[nx][ny]) continue;
                //String 비교시 반드시 '0'으로
                if (str[nx].charAt(ny - 1)=='0') continue;

                visited[nx][ny] = true;
                dis[nx][ny] = dis[tmp[0]][tmp[1]]+1;
                Q.offer(new int[]{nx, ny});
            }
        }

    }

    public static void main(String[] args) {
        input();
        pro();
    }
}