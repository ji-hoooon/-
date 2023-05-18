package org.algorithms.graph.search.dfsbfs.bfs.mindis_6;

import java.util.*;
public class BackJoon_7562_solved2 {
    static int T;
    static int N;
    static int[] start;
    static int[] end;
    static boolean[][] visited;
    static int[][] dis;
    static int[][] dir={{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{2,-1},{-2,-1},{-2,1},};
    static Scanner scan =new Scanner(System.in);
    static void bfs(int[] start, int[] end){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(start[0]);
        Q.offer(start[1]);
        dis[start[0]][start[1]]=0;
        visited[start[0]][start[1]]=true;

        while(!Q.isEmpty()){
            int x=Q.poll();
            int y=Q.poll();
            if(x==end[0]&&y==end[1]) return;
            for(int k=0;k<8;k++){
                int nx=x+dir[k][0];
                int ny=y+dir[k][1];
                if(nx<0||ny<0||nx>=N||ny>=N) continue;
                if(visited[nx][ny])continue;
                visited[nx][ny]=true;
                dis[nx][ny]=dis[x][y]+1;
                //dis[nx][ny]=Mathmin(dis[x][y]+1, dis[nx][ny]);
                Q.offer(nx);
                Q.offer(ny);
            }
        }

    }
    static void pro(){
        bfs(start, end);
        System.out.println(dis[end[0]][end[1]]);
    }
    static void input(){
        N=scan.nextInt();
        visited= new boolean[N][N];
        start=new int[2];
        end= new int[2];
        dis=new int[N][N];
        //for(int i=0;i<N;i++){
        //    Arrays.fill(visited[i], Integer.MAX_VALUE);
        //}
        int x=scan.nextInt();
        int y=scan.nextInt();
        start[0]=x;
        start[1]=y;
        x=scan.nextInt();
        y=scan.nextInt();
        end[0]=x;
        end[1]=y;
    }
    public static void main(String[] args){
        T=scan.nextInt();
        while(T-->0){
            input();
            pro();
        }
    }
}