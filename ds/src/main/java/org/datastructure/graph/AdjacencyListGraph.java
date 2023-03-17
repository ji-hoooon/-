package org.datastructure.graph;


import java.util.*;

public class AdjacencyListGraph implements IGraph{

    //멤버 변수 선언
    //중복되지 않는 정점 Set, 인접행렬, <정점, 차수> 저장하는 Map
    private Set<Integer> vertexes;
    private List<List<Node>> graph;
    private Map<Integer, Integer> indegrees;

    //인접 리스트 초기화하는 생성자 : 각 정점에 리스트 생성
    AdjacencyListGraph(int numOfVertex){
        this.vertexes=new HashSet<>();
        this.indegrees=new HashMap<>();
        this.graph=new ArrayList<>(numOfVertex);
        for(int i=0;i<numOfVertex;i++){
            this.graph.add(new ArrayList<>());
        }
    }

    @Override
    public String toString() {
        return "AdjacencyListGraph{" +
                "vertexes=" + vertexes +
                ", graph=" + Arrays.deepToString(graph.toArray()) +
                ", indegrees=" + indegrees +
                '}';
    }

    @Override
    public void add(int from, int to, int distance) {
        vertexes.add(from);
        vertexes.add(to);
        //차수 추가
        indegrees.put(to, indegrees.getOrDefault(to,0)+1);
        List<Node> list = this.graph.get(from);
        list.add(new Node(from, to, distance));
    }

    @Override
    public void add(int from, int to) {
        vertexes.add(from);
        vertexes.add(to);
        //차수 추가
        indegrees.put(to, indegrees.getOrDefault(to,0)+1);
        List<Node> list = this.graph.get(from);
        list.add(new Node(from, to,1));
    }

    @Override
    public int getDistance(int from, int to) {
        for(Node node :this.graph.get(from)){
            if(node.to.equals(to)){
                return node.weight;
            }
        }
        return -1;
        //return null; //가중치가 음수도 가능한 경우
    }

    @Override
    public Map<Integer, Integer> getIndegrees() {
        return this.indegrees;
    }

    @Override
    public Set<Integer> getVertexes() {
        return this.vertexes;
    }

    @Override
    public List<Integer> getNodes(int vertex) {
        List<Integer> list = new ArrayList<>();
        for(Node x: this.graph.get(vertex)){
            list.add(x.to);
        }
        return list;
    }

    private class Node{
        private Integer from;
        private Integer to;
        private int weight;
        Node(){};
        Node(Integer from, Integer to){
            this.from=from;
            this.to=to;
        }
        Node(Integer from, Integer to, int weight){
            this.from=from;
            this.to=to;
            this.weight=weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }
    public static void main(String[] args) {
        AdjacencyListGraph adjList=new AdjacencyListGraph(4);
        adjList.add(0, 1);
        adjList.add(0, 3);
        adjList.add(1, 0);
        adjList.add(1, 2);
        adjList.add(2, 1);
        adjList.add(2, 3);
        adjList.add(3, 0);
        adjList.add(3, 2);

        System.out.println("adjList.getDistance() = " + adjList.getDistance(0,1));
        System.out.println("adjList.getNodes() = " + adjList.getNodes(0));
        System.out.println("adjList.getIndegrees() = " + adjList.getIndegrees());

        System.out.println("adjList = " + adjList);
    }
}
