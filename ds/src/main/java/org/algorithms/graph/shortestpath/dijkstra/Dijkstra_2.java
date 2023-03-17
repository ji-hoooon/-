package org.algorithms.graph.shortestpath.dijkstra;

import org.algorithms.graph.shortestpath.WeightedGraph;
import org.algorithms.graph.shortestpath.WeightedGraph.Edge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra_2 {
    //다익스트라 알고리즘
    //: 방향이 있는 가중치 그래프에서 시작정점이 주어졌을 경우에 모든 정점까지의 최단 경로의 길이 구하기
    // 시작정점이 주어지지 않았을 경우, 일반적으로 진입차수가 0인 정점부터 시작
    //(1) 시작 정점과 다른 모든 정점까지의 거리를 무한대로 둔 배열 작성
    //(2) 시작 정점과 연결된 정점들까지의 거리와 비교해 업데이트 -> 더 적은 비용으로 변경
    //(3) 시작 정점과 연결된 정점중 가장 가중치가 작은 노드부터 폴하는 최소힙 하면서 반복
    public HashMap<String,Integer> dijkstraFunc(HashMap<String, ArrayList<WeightedGraph.Edge>> map, String startEdge){

        Edge edgeNode, adjacentNode;
        ArrayList<Edge> nodeList;
        int currentDistance, weight, distance;
        String currentNode, adjacent;

        HashMap<String, Integer> distances = new HashMap<>();
        for(String node : map.keySet()) distances.put(node, Integer.MAX_VALUE);
        distances.put(startEdge,0);
        PriorityQueue<Edge> pq =new PriorityQueue<>();
        pq.offer(new Edge(startEdge,distances.get(startEdge)));

        //2. 무한 반복 과정
        //(1) 시작 정점에서부터 가장 적은 비용이 드는 정점부터 폴
        //(2) 시작 정점부터 해당 정점까지의 거리가 해당 정점의 거리보다 짧으면 컨티뉴 -> 순수한 거리가 더 길면 확인할 필요가 없으므로
        //(3) 그렇지 않으면, 해당 정점까지의 거리를 담는 맵에 넣고, 그래프에서 해당 정점에서 연결된 정점을 순차 탐색
        //(4) 순차탐색하면서, 해당 정점까지 가는 이전 비용보다 시작 정점에서 이전 정점을 거쳐 해당 정점까지의 거리가 더 짧으면 업데이트

        while (pq.size()>0){
            edgeNode=pq.poll();
            currentDistance=edgeNode.getValue();
            currentNode=edgeNode.getName();

            if(distances.get(currentNode)<currentDistance) continue;

            nodeList=map.get(currentNode);
            for(int index=0; index<nodeList.size();index++){
                adjacentNode=nodeList.get(index);
                adjacent=adjacentNode.getName();
                weight=adjacentNode.getValue();
                distance=currentDistance+weight;

                if(distance<distances.get(adjacent)){
                    distances.put(adjacent, distance);
                    pq.offer(new Edge(adjacent,distance));
                }
            }
        }

        return distances;
    }
    public static void main(String[] args) {
        WeightedGraph graph=new WeightedGraph();
        Dijkstra_2 dijkstra = new Dijkstra_2();
        System.out.println("dijkstra.DijkstraFunc(graph.graph, \"A\") = " + dijkstra.dijkstraFunc(graph.graph, "A"));
    }
}
