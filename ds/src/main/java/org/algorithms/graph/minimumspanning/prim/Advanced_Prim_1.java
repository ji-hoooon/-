package org.algorithms.graph.minimumspanning.prim;

import org.algorithms.graph.minimumspanning.SpanningTree;

import java.util.*;

public class Advanced_Prim_1 {
    //개선된 프림 알고리즘
    //: 기존의 프림 알고리즘의 경우 간선을 중심으로 우선순위 큐를 적용
    //: 개선된 프림 알고리즘의 경우 노드를 중심으로 우선순위 큐를 적용 (다익스트라 알고리즘과 유사)

    //-> 정점끼리의 거리를 최대 거리로 초기화하고, (자기 자신의 키값은 0으로) 키값을 우선순위큐에 삽입
    // 현재 정점과 인접한 정점들의 연결된 가중치의 합과 현재 배열의 가중치의 합과 비교해 작은 값으로 설정 후 우선순위큐에 삽입
    //=> 우선순위 큐에는 노드의 개수만큼 노드를 키로, 해당 노드에 접근하는 가중치의 합을 값으로하는 요소들을 담게 된다.

    //노드 이름과 가중치만 갖는 간선 클래스
    public static class Edge implements Comparable<Edge> {
        private String node;
        private int weight;

        public Edge(){}

        public Edge(String node, int weight){
            this.node=node;
            this.weight=weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "node='" + node + '\'' +
                    ", weight=" + weight +
                    '}';
        }


        //가중치 기준 오름차순 정렬
        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }

    }

    //노드 이름과 가중치만 갖는 간선에 어떤 노드와 연결되었는지 경로를 명시하는 클래스
    public static class Path{
        private int weight;
        private String node1;
        private String node2;

        public Path(int weight, String nodeV, String nodeU) {
            this.weight = weight;
            this.node1 = nodeV;
            this.node2 = nodeU;
        }

        public int getWeight() {
            return weight;
        }

        public String getNodeV() {
            return node1;
        }

        public String getNodeU() {
            return node2;
        }

        @Override
        public String toString() {
            return "Path{" +
                    "weight=" + weight +
                    ", node1='" + node1 + '\'' +
                    ", node2='" + node2 + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        //사용할 변수 설정
        //<노드, 노드에 해당하는 graph>를 담는 자료구조
        HashMap<String, HashMap<String,Integer>> mygraph=new HashMap<>();

        HashMap<String, Integer> edges=new HashMap<>();
        edges.put("B",7);
        edges.put("C",5);
        edges.put("D",7);
        edges.put("F",8);
        edges.put("G",9);
        mygraph.put("E",edges);

        edges=new HashMap<>();
        edges.put("D",6);
        edges.put("E",8);
        edges.put("G",11);
        mygraph.put("F",edges);

        edges=new HashMap<>();
        edges.put("E",9);
        edges.put("F",11);
        mygraph.put("G",edges);

        Advanced_Prim_1 advanced_prim_1 = new Advanced_Prim_1();
        String startNode = "A";
        advanced_prim_1.advanced_prim(mygraph, startNode);

    }
    public ArrayList<Path> advanced_prim(HashMap<String, HashMap<String, Integer>> mygraph, String startNode){
        //1. 필요한 ds 선언
        ArrayList<Path> result = new ArrayList<>();
        PriorityQueue<Edge> mst = new PriorityQueue<>();
        //(1) Path가 아닌 특정 간선을 기준으로 하는 우선순위큐이기 때문에, 해당 간선을 직접 명시해야 함
        //(2) 키에 해당하는 객체를 맵으로 구성해두고, 해당 맵을 이용해서 객체를 찾는다.
        //: 우선순위 큐에 들어있는 간선들의 가중치 조회, 특정 간선 삭제를 위해 간선을 맵으로 관리를 위한 자료구조
        HashMap<String, Edge> keysObject = new HashMap<>();
        Edge edgeObject;
        HashMap<String, String> mstPath = new HashMap<>();
        

        //2. 초기화 작업
        //(1) 그래프에서 노드 기준으로 순회하면서, 거리 배열을 최대 거리로 초기화
        //: 우선순위큐에서 최소거리를 가지는 노드의 값을 갱신한다. -> 갱신할 때 우선순위큐가 유지 되기 어려움
        //따라서 우선순위큐의 remove 메서드를 이용해 삭제 후, 다시 삽입하는 방식으로 우선순위큐의 특성을 유지하도록 한다.

        for(String key : mygraph.keySet()){
            //(1) 키에 해당하는 간선 객체 생성해
            //시작 노드면 0, 그 외의 노드면 최대 거리로 초기화
            //(2) 노드간의 연결 관계를 저장
            //시작 노드면 자기 자신을 가리키도록, 시작 노드가 아니면 null로
            if(key.equals(startNode)){
                edgeObject = new Edge(key,0);

                mstPath.put(key, key);
            }
            else{
                edgeObject = new Edge(key,Integer.MAX_VALUE);
                mstPath.put(key, null);
            }
            //해당 간선객체를 우선순위큐에 삽입
            mst.offer(edgeObject);
            //정점을 키로 간선 객체 값으로 가지는 맵에 삽입 (나중에 우선순위큐에 들어있는 간선 정보를 최소 거리로 갱신하기 위해)
            keysObject.put(key, edgeObject);
        }




        return  result;
    }


}
