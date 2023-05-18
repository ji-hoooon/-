package org.algorithms.graph.search.dfsbfs.bfs.commongraph_1;
import java.util.*;
//루트가 1인 트리에서 모든 노드의 부모 찾기
//: 말단 노드는 자식이 없는 노드 -> 1부터 시작하면, 인접리스트에 방문한적 없는 노드가 있으면 해당 노드가 부모 노드!
public class BackJoon_11725_solved {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] answer;
    static void pro(){
        dfs(1, 0);
        for(int i=2;i<=N;i++){
            sb.append(answer[i]+"\n");
        }
        System.out.println(sb);
    }
    //1: 6, 4
    //2: 4
    //3: 5, 6
    //4: 2, 7
    //5: 3
    //6: 1, 3
    //7: 4
    static void input(){
        Scanner scan=new Scanner(System.in);
        N=scan.nextInt();
        adj=new ArrayList[N+1];
        answer=new int[N+1];
        visited=new boolean[N+1];
        for(int i=1;i<=N;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=1;i<N;i++){
            int x=scan.nextInt();
            int y=scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

//        def dfs(node, parent, graph, visited):
//    visited[node] = True  # 현재 노드를 방문한 것으로 표시
//   parent[node] = parent  # 현재 노드의 부모 노드 저장

    //    for adjacent_node in graph[node]:  # 현재 노드와 연결된 인접 노드들에 대해
//       if not visited[adjacent_node]:  # 아직 방문하지 않은 노드라면
//            dfs(adjacent_node, node, graph, visited)  # DFS 수행
    static void dfs(int V, int parent){
        visited[V]=true;
        answer[V]=parent;
        for(int y : adj[V]){
            if(!visited[y]) dfs(y, V);
        }
    }
    public static void main(String[] args){
        input();
        pro();
    }
}