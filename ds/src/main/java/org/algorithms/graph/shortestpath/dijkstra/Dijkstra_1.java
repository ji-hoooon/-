package org.algorithms.graph.shortestpath.dijkstra;

import org.algorithms.graph.shortestpath.WeightedGraph;
import org.algorithms.graph.shortestpath.WeightedGraph.Edge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra_1 {
    //다익스트라 알고리즘
    //: 방향이 있는 가중치 그래프에서 시작정점이 주어졌을 경우에 모든 정점까지의 최단 경로의 길이 구하기
    // 시작정점이 주어지지 않았을 경우, 일반적으로 진입차수가 0인 정점부터 시작
    //(1) 시작 정점과 다른 모든 정점까지의 거리를 무한대로 둔 배열 작성
    //(2) 시작 정점과 연결된 정점들까지의 거리와 비교해 업데이트 -> 더 적은 비용으로 변경
    //(3) 시작 정점과 연결된 정점중 가장 가중치가 작은 노드부터 폴하는 최소힙 하면서 반복

    public HashMap<String,Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> map, String startEdge){

        //1. 초기화 과정
        //(1) 최소힙 선언
        //(2) 정점까지의 거리를 저장하기 위한 해시맵 선언 후, <정점, 무한대>로 초기화
        //(3) 시작정점에서 시작정점으로 가는 사이클이 존재하지 않으므로 0으로 변경
        //(4) 시작정점에서 갈 수 있는 모든 정점을 최소힙에 넣는다.

        PriorityQueue<Edge> pq =new PriorityQueue<>();
        HashMap<String, Integer> distances = new HashMap<>();
        for(String node : map.keySet()) distances.put(node, Integer.MAX_VALUE);
        distances.put(startEdge,0);
        pq.addAll(map.get(startEdge));

        //2. 무한 반복 과정
        //(1) 시작 정점에서부터 가장 적은 비용이 드는 정점부터 폴
        //(2) 시작 정점부터 해당 정점까지의 거리가 해당 정점의 거리보다 짧으면 컨티뉴 -> 순수한 거리가 더 길면 확인할 필요가 없으므로
        //(3) 그렇지 않으면, 해당 정점까지의 거리를 담는 맵에 넣고, 그래프에서 해당 정점에서 연결된 정점을 순차 탐색
        //(4) 순차탐색하면서, 해당 정점까지 가는 이전 비용보다 시작 정점에서 이전 정점을 거쳐 해당 정점까지의 거리가 더 짧으면 업데이트
        while(!pq.isEmpty()){
            Edge node = pq.poll();
            //C,D,B
            System.out.println("node = " +node.getName() +" "+node.getValue());
            if(distances.get(node.getName())<node.getValue()) continue;
            distances.put(node.getName(), node.getValue());

            for (Edge n : map.get(node.getName())) {
                System.out.println("n = " + n.getName() + " " + n.getValue());
                distances.put(n.getName(), Math.min(distances.get(node.getName()) + n.getValue(), distances.get(n.getName())));
            }
        }
        return distances;
    }
    public static void main(String[] args) {
        WeightedGraph graph=new WeightedGraph();
        Dijkstra_1 dijkstra = new Dijkstra_1();
        System.out.println("dijkstra.DijkstraFunc(graph.graph, \"A\") = " + dijkstra.dijkstraFunc(graph.graph, "A"));
    }
}
