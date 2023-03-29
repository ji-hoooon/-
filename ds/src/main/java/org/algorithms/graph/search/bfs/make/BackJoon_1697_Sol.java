package org.algorithms.graph.search.bfs.make;
//숨바꼭질

import org.io.FastReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BackJoon_1697_Sol {

    static FastReader scan = new FastReader();
    static int N,M;
    static int[] dis;
    static boolean[] visited;

    static void input(){
        N= scan.nextInt();
        M=scan.nextInt();
        dis=new int[100001];
        visited=new boolean[100001];
        Arrays.fill(dis, Integer.MAX_VALUE);
    }
    static void pro(){
        bfs();
        System.out.println(dis[M]);
    }
    static void bfs(){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(N);
        visited[N]=true;
        dis[N]=0;


        while(!Q.isEmpty()){
            int X= Q.poll();
            int nX=X+1;
            if(nX>=0&&nX<=100000&&!visited[nX]) {
                visited[nX] = true;
                dis[nX]=dis[X]+1;
                Q.offer(nX);
            }
            nX=X-1;
            if(nX>=0 && nX<=100000&&!visited[nX]) {
                visited[nX] = true;
                dis[nX]=dis[X]+1;
                Q.offer(nX);
            }
            nX=X*2;
            if(nX>=0 && nX<=100000&&!visited[nX]){
                visited[nX]=true;
                dis[nX]=dis[X]+1;
                Q.offer(nX);
            }
        }
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}
