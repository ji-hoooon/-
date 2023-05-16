package org.algorithms.graph.search.dfsbfs.dfs.commongraph_2;
import java.util.*;

import org.io.FastReader;
//바이러스
public class BackJoon_2606 {

    static FastReader scan = new FastReader();
    static int N,M;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static void input(){
        N= scan.nextInt();
        M= scan.nextInt();
        arr=new ArrayList[N+1];
        visited=new boolean[N+1];

        for(int i=1;i<=N;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            int x= scan.nextInt();
            int y= scan.nextInt();
            arr[x].add(y);
            arr[y].add(x);
        }
    }
    static void pro(){
        dfs(1);
        int cnt=0;
        for(int i=2;i<=N;i++){
            if(visited[i]) cnt++;
        }
        System.out.println(cnt);
//        boolean[] visit =Arrays.copyOf(visited, visited.length);
//        long count = Arrays.stream(visited)
//                .filter(Boolean::booleanValue)
//                .count();
    }
    static void dfs(int x) {
        visited[x] = true;
        for (int z : arr[x]) {
            if (!visited[z]) dfs(z);
        }
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}
