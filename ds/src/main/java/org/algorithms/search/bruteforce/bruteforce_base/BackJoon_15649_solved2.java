package org.algorithms.search.bruteforce.bruteforce_base;
import java.util.*;
//조합
//: 중복없이 M개를 선택해야한다. -> 조합 -> visited배열 필요
public class BackJoon_15649_solved2 {
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] selected;
    static boolean[] visited;
    static void rec_func(int k, int v){
        if(k==M+1){
            for(int i=1;i<=M;i++){
                sb.append(selected[i]+" ");
            }
            sb.append('\n');
            return;
        }
        for(int i=1;i<=N;i++){
            //방문체크, 수열 체크
            if(visited[i])continue;
            visited[i]=true;
            selected[k]=i;
            rec_func(k+1,v+1);
            //v=1부터 시작하는 k=M개를 모두 골랐으므로, i번째 방문배열과 k번째 숫자 배열 초기화
            visited[i]=false;
            selected[k]=0;
        }

    }
    static void pro(){
        //1개고르는 것부터 시작하는데 숫자 1부터 시작
        rec_func(1, 1);
        System.out.println(sb);
    }
    static void input(){
        Scanner scan =new Scanner(System.in);
        N=scan.nextInt();
        M=scan.nextInt();
        selected=new int[M+1];
        visited=new boolean[N+1];
    }
    public static void main(String[] args){
        input();
        pro();
    }
}