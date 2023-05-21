package org.test.test1.test1_4;
//애벌레의 최대 탈피 에너지
//: 축적된 탈피 에너지의 최댓값을 구해야한다.

import java.util.Scanner;

public class BackJoon_20167_solved {
    static int N, K, MAX;
    static int[] arr;
    static boolean[] visited;

    static void dfs(int x, int present, int total) {
        if (x == N) {
            MAX = Math.max(total, MAX);
            return;
        }

        if (present >= K) {
            total += present - K;
            dfs(x + 1, 0, total);
        } else {
            dfs(x + 1, present, total);
            dfs(x+1, present + arr[x], total);
        }
    }

    static void pro() {

        dfs(0, 0, 0);
        dfs(0, arr[0], 0);
//        }
        System.out.println(MAX);
    }

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();
        MAX = Integer.MIN_VALUE;
        arr = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
