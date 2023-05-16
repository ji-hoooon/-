package org.algorithms.graph.search.dfsbfs.bfs.multisource_5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon_14502_N번풀만한문제 {
    static int N, M, B, answer;
    static int[][] arr;
    static int[][] blank;
    static boolean[][] visited;
    static int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        blank=new int[N*M][2];
        arr=new int[N][M];
        visited=new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
    }

    static void pro() {
        //벽을 세울 수 있는 개수 세고, 배열에 벽의 위치 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }
        dfs(1, 0);
        System.out.println(answer);
    }

    //벽 세우기
    static void dfs(int idx, int selected_cnt) {
        //종료조건 설정
        if (selected_cnt == 3) {
            //3개가 되면 바이러스 개수를 세고 종료
            bfs();
            return;
        }
        //idx가 벽의 개수보다 많아지면 종료
        if (idx > B) return;

        //벽을 세운다.
        //:벽을 세우고, 바이러스 개수 세기
        arr[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx + 1, selected_cnt + 1);
        //: 세운 벽을 치우고, 바이러스 개수 세기
        arr[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, selected_cnt);
    }

    //바이러스 개수 세기
    static void bfs() {
        Queue<int[]> Q = new LinkedList<>();

        //바이러스의 개수를 세려면 visited 배열을 초기화해야한다 -> 이미 센적이 있기 때문에
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //visited 배열 초기화하는 과정
                visited[i][j]=false;
                if (arr[i][j] == 2) {
                    int[] tmp = new int[]{i, j};
                    Q.offer(tmp);
                    visited[i][j]=true;
                }
            }
        }
        while (!Q.isEmpty()) {
            int[] newtmp = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = newtmp[0] + dir[k][0];
                int ny = newtmp[1] + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
//                if (arr[nx][ny] != 0) continue;
//                visited[nx][ny] = true;
//                Q.offer(new int[]{nx, ny});
                if(arr[nx][ny]==0){
                    visited[nx][ny]=true;
                    Q.offer((new int[]{nx,ny}));
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && arr[i][j] == 0) cnt++;
            }
        }
        answer = Math.max(cnt, answer);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}