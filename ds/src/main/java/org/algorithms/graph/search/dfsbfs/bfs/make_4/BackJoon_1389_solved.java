package org.algorithms.graph.search.dfsbfs.bfs.make_4;

import java.util.*;
//케빈 베이컨 6단계 법칙
public class BackJoon_1389_solved {
    static int N,M,result,ans;
    static boolean[] visited;
    static int[]dis;
    static ArrayList<Integer>[] adj;

    static int[] answer;
    static void bfs(int x){
        Queue<Integer> Q =new LinkedList<>();
        Q.offer(x);
        visited[x]=true;
        dis[x]=0;
        while(!Q.isEmpty()){
            x=Q.poll();
            for(int y:adj[x]){
                if(visited[y]) continue;
                visited[y]=true;
                dis[y]=Math.min(dis[y], dis[x]+1);
                Q.offer(y);
            }
        }
    }
    static void input(){
        Scanner scan = new Scanner(System.in);
        N=scan.nextInt();
        M=scan.nextInt();
        adj=new ArrayList[N+1];
        answer=new int[N+1];
        result=Integer.MAX_VALUE;

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
        for(int i=1;i<=N;i++){
            dis=new int[N+1];
            Arrays.fill(dis,Integer.MAX_VALUE);
            visited=new boolean[N+1];

            bfs(i);
            for(int j=1;j<=N;j++){
                answer[i]+=dis[j];
            }
            if(answer[i]<result) {
                result=answer[i];
                ans=i;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args){
        input();
        pro();
    }
}