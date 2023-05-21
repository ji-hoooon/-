package org.algorithms.search.bruteforce.bruteforce_base;

import java.util.*;

public class BackJoon_15651_solved2 {
    //중복이 허용되는 N개중 M개를 고르는 수열
//    | 중복 조합 | N개 중 중복을 허용하여 M개를 선택하는 경우의 수 | (N+M-1)C(M) |
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    static void pro() {
        rec_func(1);
        System.out.println(sb);
    }

    static void rec_func(int k) {
        //M개를 골랐다.
        if (k == M + 1) {
            //출력을 위해 sb에 추가한다.
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i] + " ");
            }
            //다음 줄
            sb.append('\n');
            return;
        }
        //M개를 아직 못골랐다.
        //:M개를 고를때까지 재귀함수 호출하고, 다음을 위해 초기화해야한다.
        for (int i = 1; i <= N; i++) {
            selected[k] = i;
            rec_func(k + 1);
            selected[k] = 0;
        }
    }

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
