package org.algorithms.graph.search.dfsbfs.dfs.arraygraph_1;

import java.util.*;

public class BackJoon_4963_solved_BFS {
    static int w,h,answer;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    static Queue<Integer> Q;
    static void pro(){
        Q=new LinkedList<>();
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(arr[i][j]==1&&!visited[i][j]){
                    Q.offer(i);
                    Q.offer(j);
                    visited[i][j]=true;
                    bfs();
                    answer++;
                }
            }
        }
    }
    static void input(){
        Scanner scan = new Scanner(System.in);
        while(true){
            w=scan.nextInt();
            h=scan.nextInt();
            arr=new int[h][w];
            visited=new boolean[h][w];
            answer=0;
            if(w==0 && h==0) break;
            else{
                for(int i=0;i<h;i++){
                    for(int j=0;j<w;j++){
                        arr[i][j]=scan.nextInt();
                    }
                }
            }
            pro();
            System.out.println(answer);
        }

    }
    static void bfs(){
        while(!Q.isEmpty()){
            int x=Q.poll();
            int y=Q.poll();
            for(int k=0;k<8;k++){
                int nx=x+dir[k][0];
                int ny=y+dir[k][1];
                if(nx<0||ny<0||nx>=h||ny>=w)continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny]!=1) continue;
                visited[nx][ny]=true;
                Q.offer(nx);
                Q.offer(ny);
            }
        }

    }
    public static void main(String[] args){
        input();
    }
}