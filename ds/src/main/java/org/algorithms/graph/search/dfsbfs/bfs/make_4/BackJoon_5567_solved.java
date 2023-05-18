package org.algorithms.graph.search.dfsbfs.bfs.make_4;
import java.util.*;

//결혼식
public class BackJoon_5567_solved {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] dis;
    static void bfs(int V){
        Queue<Integer>Q =new LinkedList<>();
        Q.offer(V);
        visited[V]=true;
        dis[V]=0;
        while(!Q.isEmpty()){
            int x= Q.poll();
            for(int y : adj[x]){
                if(dis[x]>1) continue;
                if(visited[y])continue;
                visited[y]=true;
                dis[y]=dis[x]+1;
                Q.offer(y);
            }
        }
    }
    static void pro(){
        bfs(1);
        int answer=0;
        for(int i=2;i<=N;i++){
            if (visited[i]==true) answer++;
        }
        System.out.println(answer);
    }
    static void input(){
        Scanner scan =new Scanner(System.in);
        N=scan.nextInt();
        M=scan.nextInt();
        adj=new ArrayList[N+1];
        dis=new int[N+1];
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
    public static void main(String[] args){
        input();
        pro();
    }
}