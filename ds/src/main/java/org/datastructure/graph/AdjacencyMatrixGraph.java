package org.datastructure.graph;

import java.util.*;

public class AdjacencyMatrixGraph implements IGraph{
    //인접행렬을 이용한 그래프 구현 : 인접행렬의 크기(n^2)만큼 메모리 낭비

    //멤버 변수 선언
    //중복되지 않는 정점 Set, 인접행렬, <정점, 차수> 저장하는 Map
    private Set<Integer> vertexes;
    private Integer[][] matrix;

    private Map<Integer, Integer> indegrees;

    //전달받은 정점 개수를 이용해 행렬 초기화를 수행하는 생성자
    AdjacencyMatrixGraph(int numOfVertex){
        this.vertexes=new HashSet<>();
        this.indegrees=new HashMap<>();
        this.matrix=new Integer[numOfVertex][];
        for(int i=0;i<numOfVertex;i++){
            this.matrix[i]=new Integer[numOfVertex];
        }
    }

    //출력을 위한 toString() 오버라이딩


    @Override
    public String toString() {
        return "AdjacencyMatrixGraph{" +
                "vertexes=" + vertexes +
                ", matrix=" + Arrays.deepToString(matrix) +
                ", indegrees=" + indegrees +
                '}';
    }

    @Override
    //유방향 가중치 그래프
    public void add(int from, int to, int distance) {
        vertexes.add(from);
        vertexes.add(to);
        //차수에 추가하기 위해 이전의 차수 구하기
//        int count= indegrees.getOrDefault(to,0);
//        indegrees.put(to, count+1);
        indegrees.put(to, indegrees.getOrDefault(to,0)+1);
        matrix[from][to]=distance;
        //matrix[to][from]=distance; //무방향 그래프일 경우 추가
    }

    @Override
    //유방향 그래프
    public void add(int from, int to) {
        vertexes.add(from);
        vertexes.add(to);
        //차수에 추가하기 위해 이전의 차수 구하기
//        int count= indegrees.getOrDefault(to, 0);
//        indegrees.put(to, count+1);
        indegrees.put(to, indegrees.getOrDefault(to,0)+1);
        matrix[from][to]=1;
        //matrix[to][from]=1; //무방향 그래프일 경우 추가
    }

    @Override
    public int getDistance(int from, int to) {
        return this.matrix[from][to];
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
        for(int i=0;i<matrix[vertex].length; i++){
            if(matrix[vertex][i]!=null)
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        AdjacencyMatrixGraph adjMatrix=new AdjacencyMatrixGraph(4);
        adjMatrix.add(0, 1);
        adjMatrix.add(0, 3);
        adjMatrix.add(1, 0);
        adjMatrix.add(1, 2);
        adjMatrix.add(2, 1);
        adjMatrix.add(2, 3);
        adjMatrix.add(3, 0);
        adjMatrix.add(3, 2);

        System.out.println("adjMatrix.getDistance() = " + adjMatrix.getDistance(0,1));
        System.out.println("adjMatrix.getNodes() = " + adjMatrix.getNodes(0));
        System.out.println("adjMatrix.getIndegrees() = " + adjMatrix.getIndegrees());

        System.out.println("adjMatrix = " + adjMatrix);
    }
}
