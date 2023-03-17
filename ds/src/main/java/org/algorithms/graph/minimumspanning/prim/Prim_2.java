package org.algorithms.graph.minimumspanning.prim;

import org.algorithms.graph.minimumspanning.SpanningTree;
import org.algorithms.graph.minimumspanning.SpanningTree.Edge;
import org.algorithms.graph.minimumspanning.kruskal.Kruskal_1;

import java.util.*;

public class Prim_2 {
    public static void main(String[] args) {
        //1. 간선과 노드을 담는 리스트 선언 및 초기화
        ArrayList<Edge> edges=new ArrayList<>();
        edges.add(new Edge(7, "A","B"));
        edges.add(new Edge(5, "A","D"));
//        edges.add(new Edge(7, "B","A"));
        edges.add(new Edge(8, "B","C"));
        edges.add(new Edge(9, "B","D"));
        edges.add(new Edge(7, "B","E"));
//        edges.add(new Edge(8, "C","B"));
        edges.add(new Edge(5, "C","E"));
//        edges.add(new Edge(5, "D","A"));
//        edges.add(new Edge(9, "D","B"));
        edges.add(new Edge(7, "D","E"));
        edges.add(new Edge(6, "D","F"));
//        edges.add(new Edge(7, "E","B"));
//        edges.add(new Edge(5, "E","C"));
//        edges.add(new Edge(7, "E","D"));
        edges.add(new Edge(8, "E","F"));
        edges.add(new Edge(9, "E","G"));
//        edges.add(new Edge(6, "F","D"));
//        edges.add(new Edge(8, "F","E"));
        edges.add(new Edge(11, "F","G"));
//        edges.add(new Edge(9, "G","E"));
//        edges.add(new Edge(11, "G","F"));

//        ArrayList<String> vertices=new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G"));
        System.out.println("edges = " + edges);
//        System.out.println("vertices = " + vertices);

        Prim_2 prim =new Prim_2();
        System.out.println("prim.primFunc(edges, vertices) = " + prim.primFunc(edges, "A"));
    }
    public ArrayList<Edge> primFunc(ArrayList<Edge> edges, String startNode){
        //1. 필요한 변수 선언
        ArrayList<Edge> currentEdgeList, candidateEdgeList;
        ArrayList<String> connectedNodes=new ArrayList<>();
        ArrayList<Edge> result = new ArrayList<>();
        //간선에 연결된 노드를 표현하기 위한 자료구조
        //: 노드를 키로 각 노드마다 연결된 간선들을 값으로 표현한다.
        HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<>();

        //2. 연결정보 초기화
        //(1) 각각의 노드 초기화
        //: Map에 키가 없으면 <키, 간선리스트> 추가
        for(Edge edge:edges){
            if(!adjacentEdges.containsKey(edge.getNodeV())) adjacentEdges.put(edge.getNodeV(),new ArrayList<>());
            if(!adjacentEdges.containsKey(edge.getNodeU())) adjacentEdges.put(edge.getNodeU(),new ArrayList<>());
        }
        //(2) 간선 리스트를 돌면서 맵에서 리스트를 얻고, 초기화한 노드들에 연결된 간선들을 현재 간선 리스트에 추가한다.
        for(Edge edge:edges){
            currentEdgeList=adjacentEdges.get(edge.getNodeV());
            currentEdgeList.add(new Edge(edge.getWeight(), edge.getNodeV(), edge.getNodeU()));

            currentEdgeList=adjacentEdges.get(edge.getNodeU());
            currentEdgeList.add(new Edge(edge.getWeight(), edge.getNodeU(), edge.getNodeV()));
        }

        PriorityQueue<Edge> priorityQueue = new PriorityQueue();
        for(Edge edge :adjacentEdges.getOrDefault(startNode, new ArrayList<>())){
            priorityQueue.add(edge);
        }

        //3. 초기값 설정
        //-시작점 연결된 리스트에 추가
        connectedNodes.add(startNode);

        //-간선 후보 리스트를 시작점을 키로 해시맵에서 없으면 만들어서 가져온다.
        candidateEdgeList=adjacentEdges.getOrDefault(startNode, new ArrayList<>());
        System.out.println("candidateEdgeList = " + candidateEdgeList);


        //-간선 후보 리스트를 돌면서 우선순위큐에 해당 간선들을 추가한다.
        for(Edge edge : candidateEdgeList){
            priorityQueue.offer(edge);
        }

        //5. 우선순위큐 반복
        while(!priorityQueue.isEmpty()) {
            //- 시작점과 연결된 최소 가중치 간선부터 꺼낸다.
            Edge poppedEdge =priorityQueue.poll();
            //A->D

            //연결할 노드가 연결된 노드 리스트에 없으면, 연결한 노드에 추가하고
            //-> 연결된 노드 리스트에 존재한다면, 연결할 경우 사이클이 생기므로 continue;
            if(!connectedNodes.contains(poppedEdge.getNodeU())) {
                connectedNodes.add(poppedEdge.getNodeU());
                //결과리스트에 해당 간선 정보를 추가한다.
                result.add(new Edge(poppedEdge.getWeight(), poppedEdge.getNodeV(), poppedEdge.getNodeU()));

                //해시맵에서 연결할 노드에 연결된 간선 리스트를 가져와서,
                // 해당 간선에 연결된 노드들을 인접한 노드이므로, 우선순위큐에 추가한다.
                ArrayList<Edge> adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.getNodeU(), new ArrayList<>());
                for (Edge edge : adjacentEdgeNodes) {
                    if (!connectedNodes.contains(edge.getNodeU())) priorityQueue.offer(edge);
                }
            }
        }
        return result;
    }

}
