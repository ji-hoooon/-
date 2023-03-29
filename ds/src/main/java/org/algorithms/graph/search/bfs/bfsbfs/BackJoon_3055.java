package org.algorithms.graph.search.bfs.bfsbfs;

import org.io.FastReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BackJoon_3055 {
    static FastReader scan = new FastReader();
    static int N,M;
    static String[] arr;
    static int[][] dis;
    static int[][] wdis;
    static int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    static int sX,sY,dX,dY;

    static boolean[][] visited;
    static boolean[][] wvisited;
    static int answer=-1;

    static Queue<Integer> water = new LinkedList<>();
    static void input(){
        N=scan.nextInt();
        M=scan.nextInt();
        arr=new String[N];
        dis=new int[N][M];
        wdis=new int[N][M];
        visited=new boolean[N][M];
        wvisited=new boolean[N][M];

        for(int i=0;i<N;i++){
            arr[i]=scan.nextLine();
            Arrays.fill(dis[i], -1);
            Arrays.fill(wdis[i], Integer.MAX_VALUE);

            for(int j=0;j<M;j++){
                if(arr[i].charAt(j)=='S'){
                    sX=i;
                    sY=j;
                }
                if(arr[i].charAt(j)=='D'){
                    dX=i;
                    dY=j;
                }
                if(arr[i].charAt(j)=='*'){
                    water.offer(i);
                    water.offer(j);
                    wdis[i][j]=0;
                }
            }
        }
    }
    static void pro(){
        bfs(sX,sY);
        if(dis[dX][dY]==-1) System.out.println("KAKTUS");
        else System.out.println(dis[dX][dY]);
    }
    static void bfs(int sX,int sY){
        while(!water.isEmpty()){
            int wX=water.poll();
            int wY=water.poll();
            wvisited[wX][wY]=true;

            for (int k = 0; k < 4; k++) {
                int nX = wX + dir[k][0];
                int nY = wY + dir[k][1];

                if(nX<0||nY<0||nX>=N||nY>=M) continue;
                if(wvisited[nX][nY]) continue;
                if(arr[nX].charAt(nY)!='.') continue;
                wvisited[nX][nY]=true;
                wdis[nX][nY]=wdis[wX][wY]+1;
                water.offer(nX);
                water.offer(nY);
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(sX);
        Q.offer(sY);
        dis[sX][sY]=0;
        visited[sX][sY]=true;
        if(sX==dX && sY==dY) return;

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            if(x==dX && y==dY) return;

            for (int k = 0; k < 4; k++) {
                int nX = x + dir[k][0];
                int nY = y + dir[k][1];

                if(nX<0||nY<0||nX>=N||nY>=M) continue;
                if(visited[nX][nY]) continue;
                if(arr[nX].charAt(nY)!='.'&&arr[nX].charAt(nY)!='D') continue;
                if(dis[x][y]+1>=wdis[nX][nY]) continue;

                visited[nX][nY]=true;
                dis[nX][nY]=dis[x][y]+1;
                Q.offer(nX);
                Q.offer(nY);
            }
        }
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}
