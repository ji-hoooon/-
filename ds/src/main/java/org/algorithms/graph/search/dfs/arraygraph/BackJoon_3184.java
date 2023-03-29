package org.algorithms.graph.search.dfs.arraygraph;

import org.io.FastReader;
//양
public class BackJoon_3184 {
    static FastReader scan = new FastReader();
    static int N,M;
    static String[] arr;
    static int[] answer=new int[2];
    static boolean[][] visited;

    static int V,O,vcnt,ocnt;

    static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

    static void input() {
        N=scan.nextInt();
        M=scan.nextInt();
        visited=new boolean[N][M];
        arr=new String[N];
        for(int i=0;i<N;i++){
            arr[i]=scan.nextLine();
            for(int j=0;j<M;j++){
                if(arr[i].charAt(j)=='v') V++;
                if(arr[i].charAt(j)=='o') O++;
            }
        }
    }

    static void pro() {
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]&&(arr[i].charAt(j)=='v'||arr[i].charAt(j)=='o')){
                    ocnt=0;
                    vcnt=0;

//                    if(arr[i].charAt(j)=='v') vcnt=1;
//                    else if(arr[i].charAt(j)=='o') ocnt=1;

                    dfs(i,j);
                    if(vcnt<ocnt) V-=vcnt;
                    else O-=ocnt;
                }
            }
        }
        answer[0]=O;
        answer[1]=V;

        for(int X: answer)
            System.out.print(X+" ");
    }

    static void dfs(int x, int y) {
        if(arr[x].charAt(y)=='o')ocnt++;
        if(arr[x].charAt(y)=='v')vcnt++;
        visited[x][y]=true;

        for(int k=0;k<4;k++){
            int nx=x+dir[k][0];
            int ny=y+dir[k][1];

            if(visited[nx][ny])continue;
            if(nx<0||ny<0||nx>=N||ny>=M) continue;
            if(arr[nx].charAt(ny)=='#') continue;
            dfs(nx,ny);

//            if(arr[nx].charAt(ny)=='.') dfs(nx,ny);
//
//            else if(arr[nx].charAt(ny)=='o'){
//                ocnt++;
//                dfs(nx,ny);
//            }
//            else if(arr[nx].charAt(ny)=='v'){
//                vcnt++;
//                dfs(nx,ny);
//            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();

    }
}
