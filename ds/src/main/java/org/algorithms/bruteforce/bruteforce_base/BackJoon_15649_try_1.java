package org.algorithms.bruteforce.bruteforce_base;

import org.algorithms.bruteforce.bruteforce_base.BackJoon_15651_Sol.FastReader;

//N과 M (3) - 중복 허용, 순서 존재
//: 중복 순열
public class BackJoon_15649_try_1 {
    static int N, M;
    static int[] selected;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb.toString());
    }
    static void input(){
        FastReader scan = new FastReader();
        N=scan.nextInt();
        M=scan.nextInt();
        selected=new int[M+1];
    }
    static void pro(){
        rec_func(1);
    }

    //M개를 다 고르지 않은 경우에 k번째부터 M번째 원소를 조건에 맞게 고르는 재귀 함수
    static void rec_func(int k){
        if(k==M+1){
            //M개를 다 고른 경우
            for(int i=1;i<=M;i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{
            //M개를 아직 못 고른 경우
            //: K번째 원소에 1번부터 M번까지 차례대로 가능

            //경우의 수마다 달리지는 부분
            //:중복 체크해야하는 부분
            for(int cand=1;cand<=N;cand++){
                boolean isUsed=false;
                //: 기본적으로 사용한 적 없음으로 초기화
                for(int i=1;i<k;i++) {
                    if (cand == selected[i]) isUsed = true;
                    //올 수 없는 곳은 사용중으로 체크
                }
                    //k번째에 cand가 올 수 있다면
                    //: 사용중이 아니면
                    if (!isUsed) {
                        selected[k] = cand;
                        rec_func(k + 1);
                        selected[k] = 0;
                    }
                //k번째 부터의 모든 탐색이 끝나면 k번째 값은 0으로 초기화
            }
        }
    }
}
