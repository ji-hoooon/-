package org.algorithms.graph.search.bfs.make;

import org.io.FastReader;

import java.util.*;
//결혼식

public class BackJoon_5567_Sol {

    static FastReader scan = new FastReader();
    static int N,M,answer;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    static void input(){
        N= scan.nextInt();
        M= scan.nextInt();
        adj=new ArrayList[N+1];
        dist=new int[N+1];
        for(int i=1;i<=N;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            int x= scan.nextInt();
            int y= scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }
    static void pro(){
        bfs(1);
        System.out.println(answer);
    }

    static void bfs(int start){
        Queue<Integer> Q = new LinkedList<>();
        for(int x : adj[start]){
            Q.offer(x);
        }

    }
    public static void main(String[] args) {
        input();
        pro();

    }
}
