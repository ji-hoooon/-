package org.algorithms.graph.search.dfsbfs.bfs.mindis_6;
import java.util.*;
//촌수 계산
public class BackJoon_2644_solved2 {
    static int N,M;
    static int A,B;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] dis;
    static int answer;
    static void bfs(int A, int B){
        Queue<Integer> Q= new LinkedList<>();
        Q.offer(A);
        visited[A]=true;
        dis[A]=0;

        while(!Q.isEmpty()){
            int x=Q.poll();
            if(x==B) return;
            for(int y:adj[x]){
                if(visited[y])continue;
                visited[y]=true;
                dis[y]=dis[x]+1;
                Q.offer(y);
            }
        }

    }
    static void pro(){
        bfs(A,B);
        System.out.println(dis[B]);
    }
    static void input(){
        Scanner scan = new Scanner(System.in);
        N=scan.nextInt();
        A=scan.nextInt();
        B=scan.nextInt();
        M=scan.nextInt();
        dis=new int[N+1];
        Arrays.fill(dis,-1);
        visited=new boolean[N+1];
        adj=new ArrayList[N+1];
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
