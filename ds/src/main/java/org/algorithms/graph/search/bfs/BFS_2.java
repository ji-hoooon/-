package org.algorithms.graph.search.bfs;

import org.algorithms.graph.search.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_2 {
    //Queue를 이용한 그래프 너비우선탐색 BFS 구현2
    //Queue : visited, needVisit
    //: 큐를 구현하기위해 리스트를 사용
    public ArrayList<String> bfsFunc(HashMap<String, ArrayList<String>>graph, String startNode){
        //(1) 방문한 노드 큐, 방문할 노드 큐 생성
        //(2) 시작노드를 방문할 노드에 추가
        //(3) while을 이용해 방문할 노드 큐가 비어있지 않으면 무한 반복
        //(4) 방문할 노드큐에서 노드를 꺼내 방문한 노드 큐 없으면 추가 후, 인접한 노드를 방문할 노드 큐에 추가

        ArrayList<String> visited= new ArrayList<>();
        ArrayList<String> needVisit= new ArrayList<>();

        needVisit.add(startNode);
        int cnt=0;
        while(!needVisit.isEmpty()){
            cnt++;
            String node=needVisit.remove(0);

            if(!visited.contains(node)){
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        System.out.println("CNT: "+cnt);
        return visited;
    }

    public static void main(String[] args) {
        BFS_2 bfs = new BFS_2();
        Graph graph = new Graph();
        System.out.println(bfs.bfsFunc(graph.graph, "A"));
    }
}