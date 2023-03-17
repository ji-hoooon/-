package org.algorithms.graph.search.bfs;

import org.algorithms.graph.search.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_1 {
    //Queue를 이용한 그래프 너비우선탐색 BFS 구현
    //Queue : visited, needVisit

    public static void main(String[] args) {
        //(1) 방문한 노드 큐, 방문할 노드 큐 생성
        //(2) 시작노드를 방문할 노드에 추가
        //(3) while을 이용해 방문할 노드 큐가 비어있지 않으면 무한 반복
        //(4) 방문할 노드큐에서 노드를 꺼내 방문한 노드 큐 없으면 추가 후, 인접한 노드를 방문할 노드 큐에 추가

        Queue<String> visited= new LinkedList<>();
        Queue<String> needVisit= new LinkedList<>();
        Graph graph = new Graph();
        needVisit.offer("A");
        int cnt=0;
        while(!needVisit.isEmpty()){
            cnt++;
            String str=needVisit.poll();

            if(!visited.contains(str)){
                visited.offer(str);
                needVisit.addAll(graph.graph.get(str));
            }
        }
        System.out.println("CNT: "+cnt);
        for(String s : visited){
            System.out.print(s+" ");
        }

    }


}
