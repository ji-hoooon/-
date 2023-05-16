package org.algorithms.graph.search.dfsbfs.bfs.commongraph_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//유기농 배추
public class BackJoon_1012_solved {
    static int T,N,M,K,answer;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Integer> Q;
    static Scanner scan=new Scanner(System.in);
    static int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    public static void main(String[] args){
        T=scan.nextInt();
        pro();
    }
    static void input(){
        M=scan.nextInt();
        N=scan.nextInt();
        K=scan.nextInt();

        arr=new int[N][M];
        visited=new boolean[N][M];
        for(int i=0;i<K;i++){

            int y=scan.nextInt();
            int x=scan.nextInt();
            arr[x][y]=1;
        }
    }
    static void pro(){
        Q = new LinkedList<>();
        for(int i=0;i<T;i++) {
            input();
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(arr[j][k]==1&&!visited[j][k]){
                        Q.offer(j);
                        Q.offer(k);
                        visited[j][k]=true;
                        bfs();
                        answer++;
                    }
                }
            }
            System.out.println(answer);
            answer=0;
        }
    }
    static void bfs(){
        while(!Q.isEmpty()){
            int x=Q.poll();
            int y=Q.poll();

            for(int k=0;k<4;k++){
                int nx=x+dir[k][0];
                int ny=y+dir[k][1];
                if(nx<0||ny<0||nx>=N||ny>=M) continue;
                if(visited[nx][ny])continue;
                if(arr[nx][ny]!=1)continue;

                visited[nx][ny]=true;
                Q.offer(nx);
                Q.offer(ny);
            }
        }
    }
}