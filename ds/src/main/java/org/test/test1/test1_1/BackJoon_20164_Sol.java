package org.test.test1.test1_1;

import java.util.Scanner;

public class BackJoon_20164_Sol {
    static int N, MIN, MAX;
    static int get_odd_cnt(int x){
        int res=0;
        while(x>0){
            int digit=x%10;
            if(digit%2==1)res++;
            x/=10;
        }
        return res;
    }
    static void dfs(int x, int total_odd_cnt){
        //1. 만약 한 자리 수면 더 이상 작업 반복 못하므로, 정답 갱신하고, 종료
        if(x<10){
            MIN=Math.min(total_odd_cnt, MIN);
            MAX=Math.max(total_odd_cnt, MIN);
            return;
        }
        //2. 만약 두 자리 수면, 2개로 나눠서 재귀 호출
        if(x<100){
            int next_x=(x/10)+(x%10);
            dfs(next_x, total_odd_cnt+get_odd_cnt(next_x));
            return;
        }

        //3. 만약 세 자리 수면, 가능한 3가지 자르는 방법 진행
        String str = Integer.toString(x);
        int len=str.length();
        for(int i=0;i<=len-3;i++){
            for(int j=i+1; j<=len-2;j++){
                String x1= str.substring(0,i+1);
                String x2= str.substring(i+1,j+1);
                String x3= str.substring(j+1,len);

                int next_x=Integer.parseInt(x1)+Integer.parseInt(x2)+Integer.parseInt(x3);
                dfs(next_x, total_odd_cnt+get_odd_cnt(next_x));
            }
        }
    }
    static void input(){
        Scanner scan =new Scanner(System.in);
        N=scan.nextInt();
        MIN=Integer.MAX_VALUE;
        MAX=Integer.MIN_VALUE;
    }
    static void pro(){
        dfs(N,get_odd_cnt(N));
        System.out.println(MIN+" "+MAX);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
