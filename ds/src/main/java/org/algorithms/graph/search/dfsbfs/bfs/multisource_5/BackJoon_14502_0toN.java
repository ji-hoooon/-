package org.algorithms.graph.search.dfsbfs.bfs.multisource_5;

import org.io.FastReader;

import java.util.LinkedList;
import java.util.Queue;

//연구소
//: 멀티소스 BFS (시작점이 여러개인 BFS)
public class BackJoon_14502_0toN {
    static FastReader scan = new FastReader();
    static int N,M,B;
    static int[][] arr;
    static int[][] blank;
    static int answer;
    static boolean[][] visited;
    static int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    static void input(){
        N=scan.nextInt();
        M=scan.nextInt();
        arr=new int[N][M];
        blank=new int[N*M][2];
        visited=new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j]=scan.nextInt();
            }
        }
    }
    static void dfs(int idx, int selected_cnt){
        //전달받은 idx번째 빈칸에 벽을 세울지 결정하기 위해 완전 탐색
        //DFS 돌기 전, 종료 조건 확인 -> 3개를 모두 골랐으면 해당 벽이 존재하는 경우에 안전영역의 개수 구하기 (BFS)
        if(selected_cnt==3) {
            bfs();
            return;
        }
        //더 이상 세울 벽이 없을 때 : idx가 1개부터 시작하므로
        if(idx>B) return;

        //벽을 세우기 :
        // B번째 벽의 위치= blank[B][0], blank[B][1]이므로 idx를 증가시키면서 벽을 세운다.
        arr[blank[idx][0]][blank[idx][1]]=1;
        dfs(idx+1,selected_cnt+1);
        //벽을 치우기: selected_cnt는 증가시키지 않고 다음 벽을 세우기 위해 호출
        arr[blank[idx][0]][blank[idx][1]]=0;
        dfs(idx+1, selected_cnt);

    }
    static void bfs(){
        //바이러스 노출된 지역을 확인한다.
        //-> 큐에 바이러스를 모두 넣고,
        Queue<Integer> Q = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visited[i][j]=false;
                if(arr[i][j]==2){
                    Q.offer(i);
                    Q.offer(j);
                    visited[i][j]=true;
                }
            }
        }
        while(!Q.isEmpty()){
            int x=Q.poll();
            int y=Q.poll();

            for(int k=0;k<4;k++){
                int nX=x+dir[k][0];
                int nY=y+dir[k][1];
//                if(nX<0 || nX>=N || nY<0 || nY>=M) continue;
//                if(visited[nX][nY])continue;
//                if(arr[nX][nY]!=0) continue;
//                visited[nX][nY]=true;
//                Q.offer(nX);
//                Q.offer(nY);
                if(nX>=0&&nX<N&&nY>=0&&nY<M){
                    if(!visited[nX][nY] && arr[nX][nY]==0){
                        visited[nX][nY]=true;
                        Q.offer(nX);
                        Q.offer(nY);
                    }
                }
            }
        }
        int cnt=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==0&&!visited[i][j]) cnt++;
            }
        }
        answer=Math.max(cnt,answer);
    }
    static void pro(){
        //벽을 놓을 수 있는 모든 위치를 찾기
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==0) {
                    B++;
                    //벽을 세울 수 있는 위치를 기억하기
                    //: B번째 벽의 위치는 blank[B][0], blank[B][1]
                    blank[B][0]=i;
                    blank[B][1]=j;
                }

            }
        }

        dfs(1,0);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
