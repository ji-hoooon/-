package org.algorithms.graph.search.dfsbfs.bfs.bfsbfs_7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon_3055_solved2 {
    static int R, C;
    static int[] S, D;
    static String[] A;
    static boolean[][] visited;
    static boolean[][] Wvisited;
    static int[][] dis;
    static int[][] Wdis;
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    static void bfs(int i, int j) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(i);
        Q.offer(j);

        visited[i][j] = true;
        dis[i][j] = 0;

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            if (x == D[0] && y == D[1]) return;
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (visited[nx][ny]) continue;
                if (A[nx].charAt(ny) == '*' || A[nx].charAt(ny)=='X') continue;
                if (Wdis[nx][ny]<=dis[x][y]+1) continue;

                visited[nx][ny] = true;
                dis[nx][ny] = dis[x][y] + 1;
                Q.offer(nx);
                Q.offer(ny);
            }
        }
    }

    static void pro() {
        Queue<Integer> water = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i].charAt(j) == 'D') {
                    D[0] = i;
                    D[1] = j;
                }
                if (A[i].charAt(j) == 'S') {
                    S[0] = i;
                    S[1] = j;
                }
                if (A[i].charAt(j) == '*') {
                    water.offer(i);
                    water.offer(j);
                    Wvisited[i][j] = true;
                    Wdis[i][j] = 0;
                }
            }
        }
        while (!water.isEmpty()) {
            int x = water.poll();
            int y = water.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (Wvisited[nx][ny]) continue;
                if (A[nx].charAt(ny)!='.') continue;
                Wvisited[nx][ny]=true;
                Wdis[nx][ny] = Wdis[x][y] + 1;
                water.offer(nx);
                water.offer(ny);
            }
        }

        bfs(S[0], S[1]);
//        if (dis[D[0]][D[1]] == Integer.MAX_VALUE)
        if (!visited[D[0]][D[1]])
            System.out.println("KAKTUS");
        else
            System.out.println(dis[D[0]][D[1]]);
    }

    static void input() {
        Scanner scan = new Scanner(System.in);
        R = scan.nextInt();
        C = scan.nextInt();
        D = new int[2];
        S = new int[2];
        A=new String[R];
        visited = new boolean[R][C];
        Wvisited = new boolean[R][C];
        dis = new int[R][C];
        Wdis = new int[R][C];
        for (int i = 0; i < R; i++) {
            A[i] = scan.next();
        }
        for (int i = 0; i < R; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            Arrays.fill(Wdis[i], Integer.MAX_VALUE);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}