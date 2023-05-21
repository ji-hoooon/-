package org.test.test1.test1_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BackJoon_20165_Sol {
    static StringBuilder sb = new StringBuilder();
    static int N, M, R, answer = 0;
    static int[][] arr;
    static int[][] backup;
    static void bfs(int x, int y,char dir) {
        //이미 쓰러진 도미노면 무시해야한다.
        if(arr[x][y]==0) return;

        //도미노가 쓰러질 방향을 체크한다.
        int dx=0, dy=0;
        if(dir=='E') dy=1;
        else if(dir=='W') dy=-1;
        else if(dir=='S') dx=1;
        else if(dir=='N') dx=-1;


        //cnt는 연쇄적으로 넘어질 도미노의 개수
        int cnt=arr[x][y];
        while(x>=1&&x<=N&&y>=1&&y<=M&&cnt>=1){
            if(arr[x][y]!=0) answer++;

            //: 다음에 넘어진 도미노의 높이에 따라 달라진다.
            //cnt가 가능한 경우의 수 : Math.max(cnt-1, h-1)
            cnt=Math.max(cnt-1, arr[x][y]-1);

            //도미노 쓰러뜨리고, 다음 도미노로 이동
            arr[x][y]=0;
            x+=dx;
            y+=dy;
        }
    }

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        R = scan.nextInt();
        arr = new int[N + 1][M + 1];
        backup = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = scan.nextInt();
                backup[i][j]=arr[i][j];
            }
        }

        for (int i = 1; i <= R; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            char d = scan.next().charAt(0);
            bfs(x, y, d);

            x = scan.nextInt();
            y = scan.nextInt();
            arr[x][y] = backup[x][y];
        }
    }


    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {

        sb.append(answer);
        sb.append('\n');
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(arr[i][j]==0) sb.append("F" + " ");
                else sb.append("S"+" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
