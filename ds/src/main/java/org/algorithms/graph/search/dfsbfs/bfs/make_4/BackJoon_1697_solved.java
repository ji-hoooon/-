package org.algorithms.graph.search.dfsbfs.bfs.make_4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon_1697_solved {
    static int N, K;
    static boolean[] visited;

    //dis 배열 필요 -> 항상 최소 이동으로 갈 수 있도록 해야하므로
    static int[] dis;


    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(N);
        visited[N] = true;
        dis[N] = 0;
        while (!Q.isEmpty()) {
            int X = Q.poll();
            if (X == K) return;

            int nX = X + 1;
            if (nX >= 0 && nX > 100000 || !visited[nX]) {
                visited[nX] = true;
                dis[nX] = dis[X] + 1;
                Q.offer(nX);
            }

            nX = X - 1;
            if (nX >= 0 && nX > 100000 || !visited[nX]) {
                visited[nX] = true;
                dis[nX] = dis[X] + 1;
                Q.offer(nX);
            }

            nX = X * 2;
            if (nX >= 0 && nX > 100000 || !visited[nX]) {
                visited[nX] = true;
                dis[nX] = dis[X] + 1;
                Q.offer(nX);
            }
        }
    }

    static void pro() {
        bfs();
        System.out.println(dis[K]);
    }

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();
        dis = new int[100001];
        visited = new boolean[100001];
        Arrays.fill(dis, Integer.MAX_VALUE);

    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
