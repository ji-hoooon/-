package org.algorithms.graph.search.dfsbfs.dfs;

import org.algorithms.graph.search.Graph;

import java.util.*;

public class DFS_1 {
    //Stack을 이용한 그래프 깊이우선탐색 DFS 구현
    //: DFS의 경우 Stack, 재귀함수로 구현이 가능하다.

    public static void main(String[] args) {
        //(1) 방문할 스택과 방문한 큐 생성
        //(2) 시작노드를 방문할 노드에 추가
        //(3) while을 이용해 방문할 노드 스택이 비어있지 않으면 무한 반복
        //(4) 방문할 스택에서 노드를 꺼내 방문한 노드 큐 없으면 추가 후, 인접한 노드를 방문할 노드 스택에 추가

        Queue<String> visited = new LinkedList<>();
        Stack<String> needVisit = new Stack<>();
        Graph graph = new Graph();

        int cnt=0;
        needVisit.push("A");
        while (!needVisit.isEmpty()){
            cnt++;
            String str=needVisit.pop();

            if(!visited.contains(str)){
                visited.offer(str);
                //우측 서브트리부터
//                needVisit.addAll(graph.graph.get(str));
                //좌측 서브트리부터
                Collections.sort(graph.graph.get(str), Collections.reverseOrder());
                needVisit.addAll(graph.graph.get(str));
            }
        }

        System.out.println("cnt = " + cnt);
        for(String s : visited){
            System.out.print(s+" ");
        }
    }
}
