package org.algorithms.graph.search.dfsbfs.bfs.mindis_6;

import org.io.FastReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//미로탐색_N+1배열로
//: nextInt()가 아니라 nextLine()으로 받아야 한다.

public class BackJoon_2178 {
    static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    static int N,M;
    static String[] arr;
    static boolean[][] visited;
    static int[][] dis;
    static FastReader scan = new FastReader();

    static void bfs(int x, int y){
        Queue<Integer> Q = new LinkedList<>();
        dis[x][y] = 1;
        visited[x][y] = true;
        Q.offer(x);
        Q.offer(y);



        while(!Q.isEmpty()){
            x=Q.poll();
            y=Q.poll();
            if (x==N-1 && y==M-1) return;

            for(int k=0;k<4;k++){
                int nx=x+dir[k][0];
                int ny=y+dir[k][1];

                if(nx<0 || ny<0||nx>=N||ny>=M) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx].charAt(ny)=='0') continue;
                Q.offer(nx);
                Q.offer(ny);


                visited[nx][ny]=true;
                dis[nx][ny]=dis[x][y]+1;
            }
        }
    }

    static void pro(){
        bfs(0,0);
        System.out.println(dis[N-1][M-1]);
    }

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new String[N];
        visited = new boolean[N][M];
        dis = new int[N][M];



        for(int i = 0; i < N; i++){
            Arrays.fill(dis[i], -1);
            arr[i]=scan.nextLine();
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
