package org.algorithms.graph.search.dfs.arraygraph;
import java.util.*;
import java.io.*;
import org.io.FastReader;

public class BackJoon_11724 {

    static FastReader scan = new FastReader();
    static int N,M,answer;
    //배열리스트 배열
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static void input(){
        N= scan.nextInt();
        M= scan.nextInt();
        list= new ArrayList[N+1];
        visited=new boolean[N+1];
        for(int i=1;i<=N;i++){
            list[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            int x= scan.nextInt();
            int y= scan.nextInt();
            list[x].add(y);
            list[y].add(x);
        }

    }
    static void pro(){
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                answer++;
                dfs(i);
            }
        }
        System.out.println(answer);
    }
    static void dfs(int i){
        if(visited[i]) return;
        visited[i]=true;

        for(int x:list[i]){
            if(!visited[x]) dfs(x);
        }
    }

    public static void main(String[] args) {
        input();
        pro();

    }
}
