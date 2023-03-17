package org.algorithms.graph.minimumspanning.kruskal;

import org.algorithms.graph.minimumspanning.SpanningTree.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Kruskal_1 {
    //크루스칼 알고리즘을 이용한 최소신장트리(MST) 구하기
    //1-1. 크루스칼 알고리즘
    // - 탐욕 알고리즘과 Union-Find 알고리즘을 이용해 간선을 오름차순으로 정렬해 최소 가중치부터 연결하면서 구현

    //1-2. 구현하기 위해 사용하는 알고리즘의 특징
    //(1) 탐욕 알고리즘 : 현재 시점에서 최소 비용을 선택해서, 최적의 결과를 찾도록 하는 알고리즘
    //(2) Union-Find 알고리즘 : 트리 구조를 활용해 Disjoint Set을 표현하는 알고리즘으로,
    //노드들 중에 연결된 노드를 찾거나, 노드들을 서로 연결할 때 사용한다.

    //(2)-1. Disjoint Set : 서로소 집합 자료구조로, 중복되지 않는 부분 집합들로 나눠진 원소들을 저장하는 자료구조

    //(2)-2. Union-Find 알고리즘 구현 : 간선으로 연결된 두 노드의 루트 노드가 서로 다르도록 합친다.
    //(1) n개의 원소가 개별 집합이 되도록 만든다. - 초기화
    //(2) 두 개별 집합인 두 트리를 하나의 트리로 만들기 위해 하나의 집합으로 합친다. - Union
    //(3) 존재 하는 여러 노드 중 두 개의 노드를 선택,
    // 선택한 두 노드가 하나의 그래프에 속하는지 각 그룹의 최상단 원소인 루트 노드로 확인한다. - Find

    //(2)-3. 높이가 늘어나지 않도록 관리해, 효율적으로 루트 노드를 계산 하기 위한 기법
    //(1) union-by-rank 기법 : rank는 0부터 시작
    // 각 트리의 높이를 기억해 서로 다른 두 트리를 union할 때 높이가 낮은 트리를 높이가 높은 트리에 붙인다.
    //-> 높이가 큰 트리의 루트 노드가 합친 집합의 루트노드가 되도록 한다.
    //만약, 서로의 높이가 같다면 하나의 트리의 높이를 늘려서 다른 트리를 해당 트리의 루트 노드에 붙인다.

    //(2) path compression 기법  : Find 실행시에 동작
    //Find를 실행한 노드에서 거쳐간 노드를 루트노드의 자식으로 직접 연결하는 기법으로,
    //-> Find를 실행한 노드 이후의 노드들은 루트 노드를 한번에 알 수 있게 된다.


    //1-3. 크루스칼 알고리즘 구현 순서
    //(1) 모든 정점을 연결된 간선을 제거한 상태로 만든다.
    //(2) 모든 간선을 비용 기준으로 정렬해 최소 비용 간선부터 양 끝의 두 정점을 비교한다.
    //(3) 비교해 최소 비용의 간선을 선택할 때, 두 정점사이에 사이클이 존재하지 않도록 연결한다.
    //-> 따라서, 사이클이 생기지 않도록 구현하기 위해 두 정점의 Union-Find 알고리즘을 이용해 최상위 정점을 확인해 서로 다를 때만 연결한다.
    //(4) 모든 정점을 사이클 없이 연결한 경우 최소신장트리 완성
    HashMap<String, String> parent =new HashMap<>();
    HashMap<String, Integer> rank=new HashMap<>();


    public static void main(String[] args) {
        //1. 간선과 노드을 담는 리스트 선언 및 초기화
        ArrayList<Edge> edges=new ArrayList<>();
        edges.add(new Edge(7, "A","B"));
        edges.add(new Edge(5, "A","D"));
        edges.add(new Edge(7, "B","A"));
        edges.add(new Edge(8, "B","C"));
        edges.add(new Edge(9, "B","D"));
        edges.add(new Edge(7, "B","E"));
        edges.add(new Edge(8, "C","B"));
        edges.add(new Edge(5, "C","E"));
        edges.add(new Edge(5, "D","A"));
        edges.add(new Edge(9, "D","B"));
        edges.add(new Edge(7, "D","E"));
        edges.add(new Edge(6, "D","F"));
        edges.add(new Edge(7, "E","B"));
        edges.add(new Edge(5, "E","C"));
        edges.add(new Edge(7, "E","D"));
        edges.add(new Edge(8, "E","F"));
        edges.add(new Edge(9, "E","G"));
        edges.add(new Edge(6, "F","D"));
        edges.add(new Edge(8, "F","E"));
        edges.add(new Edge(11, "F","G"));
        edges.add(new Edge(9, "G","E"));
        edges.add(new Edge(11, "G","F"));

        ArrayList<String> vertices=new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G"));
        System.out.println("edges = " + edges);
        System.out.println("vertices = " + vertices);

        Kruskal_1 kruskal =new Kruskal_1();
        System.out.println("kruskal.kruskalFunc(edges, vertices) = " + kruskal.kruskalFunc(edges, vertices));
    }
    public ArrayList<Edge> kruskalFunc(ArrayList<Edge> edges, ArrayList<String> vertices){
        //변수 선언
        //: <노드, 해당 노드의 부모노드>의 해시맵 (해당 노드가 부모노드라면 자기자신을 가리키도록)
        //: <노드, 해당 노드의 높이>의 해시맵
//        HashMap<String, String> parent= new HashMap<>();
//        HashMap<String, Integer> rank = new HashMap<>();
        ArrayList<Edge> result = new ArrayList<>();


        //(1) 반복문을 이용해 인자로 모든 노드를 전달해 초기화 메서드 호출
        for(String node : vertices){
            makeSet(node);
        }
        //(2) 간선리스트를 가중치를 기준으로 오름차순 정렬
        Collections.sort(edges);

        //(3) 가장 가중치가 작은 간선부터 뽑아서 사이클이 생기지 않으면 간선 연결한다.
        //-> 서로의 부모노드가 같은지 확인해 사이클이 존재여부 판단
        for(Edge node : edges){
            if(find(node.getNodeV())!=find(node.getNodeU())){
                union(node.getNodeV(), node.getNodeU());
                result.add(node);
            }
        }
        return result;
    }
    //2. Union-Find 알고리즘의 메서드 작성
    //: union-by-rank, path compression 기법을 이용해 효율적인 메서드 작성
    //(1) 초기화
    public void makeSet(String node){
        //(1)-(1). 노드 하나만 있기 때문에 해당 노드가 루트노드
        parent.put(node,node);
        //(1)-(2). 노드 하나만 있기 때문에 높이도 0;
        rank.put(node, 0);
    }

    //(2) Union
    //: 사이클이 존재하지 않을 때만 호출한다고 가정하고, union-by-rank기법을 이용해 간선을 잇는 메서드
    public void union(String nodeV, String nodeU){
        String root1 = find(nodeV);
        String root2 = find(nodeU);


        //union-by-rank 기법
        //(1) 높이가 다를 경우
        //: 높이가 작은 쪽의 트리의 부모노드를 높이가 높은 쪽의 루트 노드의 자식 노드로 붙인다.
        //(2) 높이가 같은 경우
        //: 한 트리의 높이를 한 칸 높여서, 높이가 작은 쪽의 트리의 부모노드를 높이가 높은 쪽의 루트 노드의 자식 노드로 붙인다.

        //구현
        //(1) 루트노드의 높이를 비교한다.
        if(rank.get(root1)>rank.get(root2)){
            //높이가 큰 쪽에 작은 노드의 루트노드를 붙인다.
            parent.put(root2, root1);
        }
        //(2) 높이가 서로 같거나 루트1의 높이가 낮을 때
        else {
            //(3) 루트2보다 루트1의 높이가 낮을 때
            parent.put(root1, root2);
            //(4) 만약에 높이가 같을 경우
            if(rank.get(root1)==rank.get(root2)){
                //(5) 루트2의 부모를 루트1의 자식노드로 붙였기 때문에
                //-> 루트1의 높이를 +1한다.
                rank.put(root2, rank.get(root2)+1);
            }
        }

    }

    //(3) Find
    //: 해당 노드의 루트 노드를 반환하는 메서드로, path compression을 이용해 루트노드에 모든 자손 노드들을 자식 노드로 연결한다.
    public String find(String node){
        //(3)-(1). 현재 노드가 루트 노드가 아니면, 부모노드가 루트노드인지 재귀적으로 확인

        if(parent.get(node)!=node){
            //-> path compression 기법을 이용해 직접 확인
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }
}
