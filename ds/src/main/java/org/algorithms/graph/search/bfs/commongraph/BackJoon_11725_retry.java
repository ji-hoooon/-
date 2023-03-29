package org.algorithms.graph.search.bfs.commongraph;
import java.util.*;

import org.io.FastReader;


public class BackJoon_11725_retry {

    static FastReader scan = new FastReader();
    static int N;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static void input(){
        N= scan.nextInt();
        arr=new ArrayList[N+1];
        visited=new boolean[N+1];
        for(int i=1;i<=N;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=1;i<=N;i++){
            int parent = scan.nextInt();
            int child = scan.nextInt();
            arr[parent].add(child);
        }
    }
    static void pro(){
        dfs(1);
    }
    static void dfs(int root){


    }
    static void bfs(){

    }
    public static void main(String[] args) {
        input();
        pro();

    }
}
