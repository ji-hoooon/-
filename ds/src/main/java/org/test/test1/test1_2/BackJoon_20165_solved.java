package org.test.test1.test1_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Dir{
    int x;
    int y;

    int z;
    int[] dir;
    Dir(int x, int y, int z,char c){
        this.x=x;
        this.y=y;
        this.z=z;
        if(c=='E'){
            dir=new int[]{0,1};
        }else if(c=='W'){
            dir=new int[]{0,-1};

        }else if(c=='S'){
            dir=new int[]{-1,0};

        }else if(c=='N'){
            dir = new int[]{-1,0};
        }
    }
}
public class BackJoon_20165_solved {
    static StringBuilder sb=new StringBuilder();
    static int N,M,R,answer=0;
    static boolean[][] visited;
    static int[][] arr;
    static char[][] result;
    static void bfs(int x, int y, int z,char d){
        if(result[x][y]=='F'||visited[x][y]) return;

        Queue<Dir> Q = new LinkedList<>();
        Q.offer(new Dir(x,y,z,d));

        visited[x][y]=true;
        result[x][y] = 'F';

        while(!Q.isEmpty()){
            Dir tmp =Q.poll();
            //tmp의 z길이여야한다.!!!!
            for(int k=1;k<arr[tmp.x][tmp.y];k++) {
                int nx = tmp.x + tmp.dir[0]*k;
                int ny = tmp.y + tmp.dir[1]*k;
                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                result[nx][ny] = 'F';
                answer++;
                Q.offer(new Dir(nx, ny, arr[nx][ny], d));
            }
        }

    }
    static void input(){
        Scanner scan= new Scanner(System.in);
        N=scan.nextInt();
        M=scan.nextInt();
        R= scan.nextInt();
        result=new char[N+1][M+1];
        arr=new int[N+1][M+1];
        visited=new boolean[N+1][M+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                arr[i][j]= scan.nextInt();
            }
        }
        for(int i=1;i<=N;i++){
            Arrays.fill(result[i], 'S');
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<2;j++){
                if(j==0) {
                    int x = scan.nextInt();
                    int y = scan.nextInt();
                    char d = scan.next().charAt(0);
                    answer++;
                    bfs(x,y,arr[x][y],d);
                }else{
                    int x = scan.nextInt();
                    int y = scan.nextInt();
                    if(result[x][y]=='F'){
                        result[x][y]='S';
                        visited[x][y]=false;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static void pro(){

        sb.append(answer);
        sb.append('\n');
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                sb.append(result[i][j]+" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
