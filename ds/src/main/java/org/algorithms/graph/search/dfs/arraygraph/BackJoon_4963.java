package org.algorithms.graph.search.dfs.arraygraph;

import java.util.*;
import java.io.*;
import org.io.FastReader;

public class BackJoon_4963 {
    static FastReader scan = new FastReader();
    static int w,h,answer;
    static int[][] arr;
    static boolean[][] visited;

    static int[][] dir={{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};

    static void input(){
        while(true) {
            h = scan.nextInt();
            w = scan.nextInt();
            if(w==0&&h==0) break;
            visited=new boolean[w][h];
            arr = new int[w][h];
            for(int i=0;i<w;i++){
                for(int j=0;j<h;j++){
                    arr[i][j]=scan.nextInt();
                }
            }
            answer=0;
            pro();
        }
    }
    static void pro(){
        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                if(arr[i][j]==1&&!visited[i][j]){
                    answer++;
                    dfs(i,j);
                }
            }
        }

        System.out.println(answer);
    }
    static void dfs(int x, int y){
        for(int k=0;k<8;k++){
            int nx=x+dir[k][0];
            int ny=y+dir[k][1];
            if(nx<0||ny<0||nx>=w||ny>=h)continue;
            if(visited[nx][ny])continue;
            if(arr[nx][ny]!=1)continue;

            visited[nx][ny]=true;
            dfs(nx,ny);
        }
    }

    public static void main(String[] args) {
        input();

    }
}
