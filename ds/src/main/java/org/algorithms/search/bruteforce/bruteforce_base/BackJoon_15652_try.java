package org.algorithms.search.bruteforce.bruteforce_base;

import org.algorithms.search.bruteforce.bruteforce_base.BackJoon_15651_Sol.FastReader;

//N과 M (4) - 중복 허용, 순서 없이 고른다.
//: 중복 조합
public class BackJoon_15652_try {
    static int N, M;
    static int[] selected;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb.toString());
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }

    static void pro() {
        rec_func(1);
    }

    //M개를 다 고르지 않은 경우에 k번째부터 M번째 원소를 조건에 맞게 고르는 재귀 함수
    static void rec_func(int k) {
        if (k == M + 1) {
            //M개를 다 고른 경우
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            //M개를 아직 못 고른 경우
            //: K번째 원소에 1번부터 M번까지 차례대로 가능


            //중복체크는 안 하지만, 순서는 체크한다.
            //: 시작 점은 selected 배열의 k-1번째보다 크거나 같으므로
            int start=selected[k-1];
            //시작점이 0이면 1부터 시작하도록 변경 (0번째는 존재하지 않으므로)
            if(start==0) start=1;

            //경우의 수마다 달리지는 부분
            //:순서를 확인해야하는 부분
            for (int cand = start; cand <= N; cand++) {

                selected[k] = cand;
                rec_func(k + 1);
                selected[k] = 0;
                //k번째 부터의 모든 탐색이 끝나면 k번째 값은 0으로 초기화
                //: 재귀호출 끝나고 다음 숫자로 사용되어야 하므로 0으로 초기화 필요
            }
        }
    }
}
