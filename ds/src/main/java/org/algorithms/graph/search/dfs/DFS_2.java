package org.algorithms.graph.search.dfs;

import org.algorithms.graph.search.Graph;

import java.util.*;

public class DFS_2 {
    //Stack을 이용한 그래프 깊이우선탐색 DFS 구현
    //: DFS의 경우 Stack, 재귀함수로 구현이 가능하다.

    public ArrayList<String> dfsFunc(HashMap<String, ArrayList<String>>graph, String startNode){
        //(1) 방문할 스택과 방문한 큐 생성
        //(2) 시작노드를 방문할 노드에 추가
        //(3) while을 이용해 방문할 노드 스택이 비어있지 않으면 무한 반복
        //(4) 방문할 스택에서 노드를 꺼내 방문한 노드 큐 없으면 추가 후, 인접한 노드를 방문할 노드 스택에 추가

        ArrayList<String> visited= new ArrayList<>();
        ArrayList<String> needVisit= new ArrayList<>();

        needVisit.add(startNode);
        int cnt=0;
        while(!needVisit.isEmpty()){
            cnt++;
            String node=needVisit.remove(needVisit.size()-1);

            if(!visited.contains(node)){
                visited.add(node);
                //우측 서브트리부터
//                needVisit.addAll(graph.graph.get(str));
                //좌측 서브트리부터
                Collections.sort(graph.get(node), Collections.reverseOrder());
                needVisit.addAll(graph.get(node));
            }
        }
        System.out.println("CNT: "+cnt);
        return visited;
    }

    public static void main(String[] args) {
        DFS_2 dfs = new DFS_2();
        Graph graph = new Graph();
        System.out.println(dfs.dfsFunc(graph.graph, "A"));
    }
}