package org.algorithms.graph.search.bfs.mindis;

import org.io.FastReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//미로탐색_N+1배열로
//: nextInt()가 아니라 nextLine()으로 받아야 한다.

public class BackJoon_2178_Nplus1 {
    static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    static int N,M;
    static String[] arr;
    static boolean[][] visited;
    static int[][] dis;
    static FastReader scan = new FastReader();

    static void bfs(int x, int y){
        Queue<int[]> Q = new LinkedList<>();
        dis[x][y] = 1;
        visited[x][y] = true;
        Q.offer(new int[]{x,y});


        while(!Q.isEmpty()){
            int[] tmp=Q.poll();
            if(tmp[0]==N&&tmp[1]==M) return;

            for(int k=0;k<4;k++){
                int nx=tmp[0]+dir[k][0];
                int ny=tmp[1]+dir[k][1];

                if(nx<1 || ny<1||nx>N||ny>M) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx].charAt(ny-1)=='0') continue;
                Q.offer(new int[]{nx,ny});

                visited[nx][ny]=true;
                dis[nx][ny]=dis[tmp[0]][tmp[1]]+1;
            }
        }
    }

    static void pro(){
        bfs(1,1);
        System.out.println(dis[N][M]);
    }

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new String[N+1];
        visited = new boolean[N+1][M+1];
        dis = new int[N+1][M+1];



        for(int i = 1; i <= N; i++){
            Arrays.fill(dis[i], -1);
            arr[i]=scan.nextLine();
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
