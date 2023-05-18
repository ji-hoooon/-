package org.algorithms.graph.search.dfsbfs.bfs.bfsbfs_7;
import java.util.*;

public class BackJoon_7569_solved_arr변경 {
    static int M,N,H,answer;
    static int[][][] arr;
    static boolean[][][] visited;
    static int[][] dir={{0,0,1},{0,0,-1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0}};

    static int[][][] dis;
    static void bfs(){
        Queue<int[]> Q=new LinkedList<>();
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(arr[i][j][k]==1) {
                        Q.offer(new int[]{i,j,k});
                        visited[i][j][k]=true;
                        dis[i][j][k]=0;
                    }
                }
            }
        }
        while(!Q.isEmpty()){
            int[] tmp = Q.poll();
            for(int k=0;k<6;k++){
                int nz=tmp[0]+dir[k][0];
                int nx=tmp[1]+dir[k][1];
                int ny=tmp[2]+dir[k][2];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue;
                if(visited[nz][nx][ny])continue;
                if(arr[nz][nx][ny]!=0)continue;
                visited[nz][nx][ny]=true;
                Q.offer(new int[]{nz,nx,ny});
                dis[nz][nx][ny]=dis[tmp[0]][tmp[1]][tmp[2]]+1;
            }
        }
    }
    static void pro(){
        bfs();
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(arr[i][j][k]==0&& !visited[i][j][k]){
                        System.out.println(-1);
                        return;
                    }
                    answer=Math.max(answer, dis[i][j][k]);
                }
            }
        }
        System.out.println(answer);
    }
    static void input(){
        Scanner scan = new Scanner(System.in);
        M=scan.nextInt();
        N=scan.nextInt();
        H=scan.nextInt();
        arr=new int[H][N][M];
        visited=new boolean[H][N][M];
        dis=new int[H][N][M];
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    arr[i][j][k]=scan.nextInt();
                }
            }
        }
    }
    public static void main(String[] args){
        input();
        pro();
    }

}