package org.algorithms.search.bruteforce.bruteforce_practice;

import org.io.FastReader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BackJoon_15663_solved {
    static int N, M;
    static int[] nums;
    static int[] selected;

    static int[] used;
    static Set<String> set =new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static void input(){
        FastReader scan = new FastReader();
        N= scan.nextInt();
        M= scan.nextInt();
        nums=new int[N+1];
        selected=new int[M+1];
        used=new int[N+1];

        for(int i=1;i<=N;i++){
            nums[i]=scan.nextInt();
        }
    }
    static void rec_func(int k){
        if(k==M+1){
            StringBuilder sb2 = new StringBuilder();
            for(int i=1;i<=M;i++){
                sb2.append(nums[selected[i]]).append(" ");
            }
            if(!set.contains(sb2.toString())){
                set.add(sb2.toString());
                sb.append(sb2);
                sb.append('\n');
            }
        }else{
            //경우의 수마다 달리지는 부분
            //:중복 체크해야하는 부분
            for (int cand = 1; cand <= N; cand++) {

                if (used[cand] == 1) continue;
                //k번째에 cand가 올 수 있다면
                //: 사용중이 아니면
                selected[k] = cand;
                used[cand]=1;
                rec_func(k + 1);
                selected[k] = 0;
                used[cand]=0;
                //k번째 부터의 모든 탐색이 끝나면 k번째 값은 0으로 초기화
                //: 재귀호출 끝나고 다음 숫자로 사용되어야 하므로 0으로 초기화 필요
            }
        }
    }

    public static void main(String[] args){
        input();
        Arrays.sort(nums);
        rec_func(1);
        System.out.println(sb);
    }
}
