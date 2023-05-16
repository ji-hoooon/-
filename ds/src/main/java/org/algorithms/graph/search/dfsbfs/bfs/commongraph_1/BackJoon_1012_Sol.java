package org.algorithms.graph.search.dfsbfs.bfs.commongraph_1;

import org.io.FastReader;
//유기농 배추
public class BackJoon_1012_Sol {
    static FastReader scan = new FastReader();
    static int T, N, M,K;
    static int[][] arr;
    static int[] answer;
    static boolean[][] visited;

    static int cnt;
    static int tmp=0;

    static int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    static void input(){
        T=scan.nextInt();
        answer=new int[T];
        for(;tmp<T;tmp++) {
            N= scan.nextInt();
            M= scan.nextInt();
            visited=new boolean[N][M];
            arr=new int[N][M];

            //배추 개수
            K= scan.nextInt();
            for (int j = 0; j < K; j++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                arr[x][y] = 1;
            }
            cnt=0;
            pro();
        }
        for(int x:answer) System.out.println(x);
    }
    static void pro(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==1&&!visited[i][j]) {
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        answer[tmp]=cnt;
    }
    static void dfs(int x, int y){
        if(visited[x][y]) return;
        visited[x][y]=true;

        for(int k=0;k<4;k++){
            int nx=x+dir[k][0];
            int ny=y+dir[k][1];
            if(nx<0||ny<0||nx>=N||ny>=M) continue;
            if(visited[nx][ny]) continue;
            if(arr[nx][ny]!=1) continue;
            dfs(nx,ny);
        }
    }
    public static void main(String[] args) {
        input();
//        pro();

    }

}
