package org.algorithms.graph.search.dfsbfs.bfs;

import java.util.*;
import java.io.*;
//연구소
public class Main{
    static int N, M, B, answer;
    static int[][] blank;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    static void input(){
        Scanner scan =new Scanner(System.in);
        N=scan.nextInt();
        M=scan.nextInt();
        arr=new int[N+1][M+1];
        blank=new int[N*M][2];
        visited=new boolean[N+1][M+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                arr[i][j]=scan.nextInt();
            }
        }
    }
    public static void main(String[] args){
        input();
        pro();
    }
    static void pro(){
        //벽의 개수
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(arr[i][j]==0) {
                    B++;
                    blank[B][0]=i;
                    blank[B][1]=j;
                }
            }
        }
        dfs(1, 0);
        System.out.println(answer);
    }

    //바이러스 개수 세기
    static void bfs(){
        //바이러스 노출된 지역을 확인한다.
        //-> 큐에 바이러스를 모두 넣고,
        Queue<Integer> Q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                visited[i][j]=false;
                if(arr[i][j]==2){
                    Q.offer(i);
                    Q.offer(j);
                    visited[i][j]=true;
                }
            }
        }
        while(!Q.isEmpty()){
            int x=Q.poll();
            int y=Q.poll();

            for(int k=0;k<4;k++){
                int nX=x+dir[k][0];
                int nY=y+dir[k][1];
                if(nX<0 || nX>N || nY<0 || nY>M) continue;
                if(visited[nX][nY])continue;
                if(arr[nX][nY]!=0) continue;
                visited[nX][nY]=true;
                Q.offer(nX);
                Q.offer(nY);

            }
        }
        int cnt=0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(arr[i][j]==0&&!visited[i][j]) cnt++;
            }
        }
        answer=Math.max(cnt,answer);
    }
    //벽을 세우기
    static void dfs(int idx, int selected_cnt){
        //벽을 세울 수 있는 곳 찾기
        if(selected_cnt==3){
            bfs();
            return;
        }
        //더 이상 세울 벽이 없을 때 : idx가 1개부터 시작하므로
        if(idx>B) return;

        arr[blank[idx][0]][blank[idx][1]]=1;
        dfs(idx+1, selected_cnt+1);

        arr[blank[idx][0]][blank[idx][1]]=0;
        dfs(idx+1, selected_cnt);
    }
}