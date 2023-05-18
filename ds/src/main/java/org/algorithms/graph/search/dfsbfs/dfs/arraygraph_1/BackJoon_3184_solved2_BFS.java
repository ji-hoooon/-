package org.algorithms.graph.search.dfsbfs.dfs.arraygraph_1;
import java.util.*;

public class BackJoon_3184_solved2_BFS {
    static int R, C;
    static String[] arr;
    static boolean[][] visited;
    static int[][]dir={{0,1},{1,0},{-1,0},{0,-1}};
    static int A,B;
    static Queue<Integer> Q =new LinkedList<>();

    static void bfs(int i, int j){
        int tmpA=0;
        int tmpB=0;
        if(arr[i].charAt(j)=='v') tmpA++;
        else if(arr[i].charAt(j)=='o') tmpB++;

        while(!Q.isEmpty()){
            int x=Q.poll();
            int y=Q.poll();
            for(int k=0;k<4;k++){
                int nx=x+dir[k][0];
                int ny=y+dir[k][1];
                if(arr[nx].charAt(ny)=='#') continue;
                if(nx<0||ny<0||nx>=R||ny>=C) continue;
                if(visited[nx][ny])continue;
                visited[nx][ny]=true;
                if(arr[nx].charAt(ny)=='v') tmpA++;
                else if(arr[nx].charAt(ny)=='o') tmpB++;
                Q.offer(nx);
                Q.offer(ny);
            }
        }
        if(tmpA<tmpB) A-=tmpA;
        else B-=tmpB;
    }
    static void pro(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i].charAt(j)=='v'){
                    A++;
                }
                if(arr[i].charAt(j)=='o'){
                    B++;
                }
            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i].charAt(j)=='o'||arr[i].charAt(j)=='v'&&!visited[i][j]){
                    visited[i][j]=true;
                    Q.offer(i);
                    Q.offer(j);
                    bfs(i,j);
                }
            }
        }
        System.out.print(B+" "+A);
    }
    static void input(){
        Scanner scan =new Scanner(System.in);
        R=scan.nextInt();
        C=scan.nextInt();
        arr=new String[R];
        visited=new boolean[R][C];
        for(int i=0;i<R;i++){
            arr[i]=scan.next();
        }
    }
    public static void main(String[] args){
        input();
        pro();
    }
}