package org.algorithms.graph.search.dfsbfs.bfs.make_4;
//숨바꼭질
//: 메모리 초과 발생 -> BFS는 너비우선이므로, 제일 먼저 이동한 위치는 이동횟수가 가장 최소 -> 방문여부만 체크
//따라서 dis[nX]=dis[X]+1;로 바꾸면 된다.
import org.io.FastReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BackJoon_1697 {
    static class State {
        int value;
        int cnt;

        State(int value, int cnt){
            this.value=value;
            this.cnt=cnt;
        }
    }
    static FastReader scan = new FastReader();
    static int answer=Integer.MAX_VALUE;
    static int N,M;
    static boolean [] visited;
    static int[] dis;

    static void input(){
        N= scan.nextInt();
        M=scan.nextInt();
        visited=new boolean[100001];
        dis=new int[100001];
        Arrays.fill(dis, Integer.MAX_VALUE);
    }
    static void pro(){
        bfs();
        System.out.println(dis[M]);
    }
    static void bfs(){
        Queue<State> Q = new LinkedList<>();
        Q.offer(new State(N,0));
        visited[N]=true;
        dis[N]=0;


        while(!Q.isEmpty()){
            State st= Q.poll();
            dis[st.value]=Math.min(st.cnt, dis[st.value]);

            if(st.value+1<=100000&&dis[st.value+1]>=st.cnt&&!visited[st.value+1]){
                visited[st.value+1]=true;
                Q.offer(new State(st.value+1, st.cnt+1));
            }

            if(st.value-1>=0&&dis[st.value-1]>=st.cnt&&!visited[st.value-1]){
                visited[st.value-1]=true;
                Q.offer(new State(st.value-1, st.cnt+1));
            }

            if(st.value*2<=100000&&dis[st.value*2]>=st.cnt&&!visited[st.value*2]) {
                visited[st.value*2]=true;
                Q.offer(new State(st.value*2, st.cnt+1));
            }

        }
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}
