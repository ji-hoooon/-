package org.algorithms.graph.search.dfsbfs.dfs.commongraph_2;

import java.util.*;
//가중치 없는 방향 그래프의 경로 찾기

public class BackJoon_11403_solved2 {
    static ArrayList<Integer>[] list;
    static int[][] adj;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static boolean[] visited;

    static void dfs(int V){
        for(int y:list[V]){
            if(visited[y]) continue;
            visited[y]=true;
            dfs(y);
        }
    }
    static void pro() {
        for(int i=0;i<N;i++){
            visited=new boolean[N];
            dfs(i);
            for(int j=0;j<N;j++){
                if(visited[j]) {
                    adj[i][j]=1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(adj[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        list=new ArrayList[N+1];
        adj = new int[N][N];
        for(int i=0;i<N;i++){
            list[i]=new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(scan.nextInt()==1) {
                    list[i].add(j);
                }
            }
        }
    }


    public static void main(String[] args) {
        input();
        pro();
    }
}
