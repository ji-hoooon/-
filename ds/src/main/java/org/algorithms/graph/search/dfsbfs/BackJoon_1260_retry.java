package org.algorithms.graph.search.dfsbfs;

import java.util.*;
//DFS와 BFS
public class BackJoon_1260_retry {
    static ArrayList<Integer> answer= new ArrayList<>();
    static boolean[] visited;
    static ArrayList<Integer> needVisit=new ArrayList<>();


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int V = in.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        visited = new boolean[N+1];

        for(int i=0;i<=N;i++){
            graph.add(i, new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(graph, V);
        for(int x: answer) System.out.print(x+" ");
        System.out.println();
        visited = new boolean[N+1];
        for(int x: bfs(graph, V)) System.out.print(x+" ");
    }
    static void dfs(List<List<Integer>> graph, int V){
        answer.add(V);
        visited[V] = true;
        Collections.sort(graph.get(V));

        for (int x : graph.get(V)) {
            if (!visited[x]) {
                dfs(graph, x);
            }
        }
    }
    static ArrayList<Integer> bfs(List<List<Integer>> graph, int V){
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        visited[V]=true;
        while(!q.isEmpty()){
            int v=q.poll();
            list.add(v);
            Collections.sort(graph.get(v));

            for(int x : graph.get(v)){
                if(!visited[x]){
                    visited[x]=true;
                    q.offer(x);
                }
            }
        }
        return list;
    }
}