package org.algorithms.graph.minimumspanning.prim;

import org.algorithms.graph.minimumspanning.SpanningTree;
import org.algorithms.graph.minimumspanning.SpanningTree.Edge;
import org.algorithms.graph.minimumspanning.kruskal.Kruskal_1;

import java.util.*;

public class Prim_1 {
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

        ArrayList<String> vertices=new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G"));
        System.out.println("edges = " + edges);
        System.out.println("vertices = " + vertices);

        Prim_1 prim =new Prim_1();
        System.out.println("prim.primFunc(edges, vertices) = " + prim.primFunc(edges, vertices, "A"));
    }
    public ArrayList<Edge> primFunc(ArrayList<Edge> edges, ArrayList<String> vertices, String startNode){
        //변수 선언
        //: <노드, 해당 노드의 부모노드>의 해시맵 (해당 노드가 부모노드라면 자기자신을 가리키도록)
        //: <노드, 해당 노드의 높이>의 해시맵
//        HashMap<String, String> parent= new HashMap<>();

        //1. 필요한 변수 선언
        ArrayList<Edge> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;

        // 2. 사용할 변수 초기화
        HashMap<String, ArrayList<Edge>> edgeMap = new HashMap<>();
        ArrayList<String> connected = new ArrayList<>();
        ArrayList<Edge> result = new ArrayList<>();
        PriorityQueue<Edge> priorityQueue=new PriorityQueue<>();

        //3. 정렬과 초기화
        //-모든 간선을 담은 리스트 오름차순 정렬
        //-해시맵에 모든 정점 리스트 추가
        //-현재 간선리스트에 모든 간선 추가
        Collections.sort(edges);
        for (Edge edge : edges) {
            if (!edgeMap.containsKey(edge.getNodeV())) {
                edgeMap.put(edge.getNodeV(),new ArrayList<Edge>());
            }
            if (!edgeMap.containsKey(edge.getNodeU())) {
                edgeMap.put(edge.getNodeU(),new ArrayList<Edge>());
            }
        }
        for(Edge edge :edges){
            currentEdgeList=edgeMap.get(edge.getNodeV());
            currentEdgeList.add(new Edge(edge.getWeight(),edge.getNodeV(),edge.getNodeU()));

            currentEdgeList=edgeMap.get(edge.getNodeU());
            currentEdgeList.add(new Edge(edge.getWeight(),edge.getNodeU(),edge.getNodeV()));
        }

        //4. 초기값 설정
        //-시작점 연결된 리스트에 추가
        //-간선 후보 리스트를 시작점을 키로 해시맵에서 없으면 만들어서 가져온다.
        //-간선 후보 리스트를 돌면서 우선순위큐에 해당 간선들을 추가한다.
        connected.add(startNode);
        candidateEdgeList=edgeMap.getOrDefault(startNode, new ArrayList<>());
        for(Edge edge:candidateEdgeList){
            priorityQueue.add(edge);
        }

        //5. 우선순위큐 반복
        //- 시작점과 연결된 최소 가중치 간선부터 꺼낸다.
        //        while(priorityQueue.size()>0){
        while(!priorityQueue.isEmpty()){
            Edge poppedEdge=priorityQueue.poll();

            //연결할 노드가 연결된 노드 리스트에 없으면, 연결한 노드에 추가하고
            //결과리스트에 해당 간선 정보를 추가한다.
            if(!connected.contains(poppedEdge.getNodeU())){
                connected.add(poppedEdge.getNodeU());
                result.add(new Edge(poppedEdge.getWeight(), poppedEdge.getNodeV(), poppedEdge.getNodeU()));

                //인접한 노드 리스트에 연결할 노드가 없으면 추가하고,
                //인접한 노드 리스트를 돌면서 연결할 노드가 연결되어있지않은 간선들을 우선순위큐에 모두 추가
                adjacentEdgeNodes=edgeMap.getOrDefault(poppedEdge.getNodeU(), new ArrayList<>());
                for(Edge edge:adjacentEdgeNodes){
                    if(!connected.contains(edge.getNodeU())) priorityQueue.add(edge);
                }
            }
        }

        for(ArrayList<Edge> edge :edgeMap.values()){
            System.out.println("edge result = " + edge);
        }
        return result;
    }

}
