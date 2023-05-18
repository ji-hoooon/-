package org.algorithms.graph.search.dfsbfs.dfs.commongraph_2;
import java.util.*;

public class BackJoon_2606_solved2 {
    static int N,M,V;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int answer;
    static void input(){
        Scanner scan = new Scanner(System.in);
        N=scan.nextInt();
        M=scan.nextInt();
        V=1;
        adj=new ArrayList[N+1];
        visited=new boolean[N+1];
        for(int i=1;i<=N;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            int x=scan.nextInt();
            int y=scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }
    static void pro(){
        visited[V]=true;
        dfs(V);
        System.out.println(answer);
    }
    static void dfs(int V){
        for(int y : adj[V]){
            if(visited[y]) continue;
            visited[y]=true;
            answer++;
            dfs(y);
        }
    }
    public static void main(String[] args){
        input();
        pro();

    }
}
