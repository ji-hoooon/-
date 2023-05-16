package org.algorithms.graph.search.dfsbfs.dfs.arraygraph_1;

import java.util.*;

public class BackJoon_11724_solved {
    static int N,M,answer;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static void pro(){
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }
    static void dfs(int x){
        for(int y:adj[x]){
            if(visited[y])continue;
            visited[y]=true;
            dfs(y);
        }
    }
    static void input(){
        Scanner scan =new Scanner(System.in);
        N=scan.nextInt();
        M=scan.nextInt();
        adj=new ArrayList[N+1];
        visited=new boolean[N+1];
        for(int i=1;i<=N;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=1;i<=M;i++){
            int x=scan.nextInt();
            int y=scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }
    public static void main(String[] args){
        input();
        pro();
    }
}