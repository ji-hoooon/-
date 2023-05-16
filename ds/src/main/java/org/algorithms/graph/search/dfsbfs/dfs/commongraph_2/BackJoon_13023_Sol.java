package org.algorithms.graph.search.dfsbfs.dfs.commongraph_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BackJoon_13023_Sol {
    //N명의 친구 -> 한명의 친구로부터 모든 친구와 연결되었는지 여부

    //N개의 뎁스 유무를 담는 변수
    static boolean found=false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int N= Integer.valueOf(s.split(" ")[0]);    //사람의 수
        int M= Integer.valueOf(s.split(" ")[1]);    //관계의 수

        //인접 리스트 방식을 사용해 그래프 구현
        List<List<Integer>> graph = new ArrayList<>();
        //리스트 초기화
        for(int i=0;i<N;i++){
            graph.add(i, new ArrayList<>());
        }
        //리스트에 노드 삽입
        for(int i=0;i<M;i++){
            s=in.nextLine();

            //양방향 관계인 친구관계를 표현하기 위해
            //String to Int = " "기준 분리 후 -> valueOf로 변환
            int a = Integer.valueOf(s.split(" ")[0]);
            int b = Integer.valueOf(s.split(" ")[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //방문 여부 배열
        boolean[] visited = new boolean[N];

        //어느 친구(정점)부터 시작하냐에 따라 달라질 수 있으므로
        //: DFS를 이용해 반복문으로 돈다
        for(int i=0;i<N; i++){
            //자기자신을 포함시켜야하므로
            dfs(graph, visited, i ,1);

            if (found) {
                System.out.println("1");
                return;
            }
        }
        System.out.println("0");
    }
    static void dfs(List<List<Integer>> graph, boolean[] visited, int v, int depth){
        //종료 조건 먼저
        if(depth==5){
            found =true;
            return;
        }

        //해당 vertex와 연결된 노드를 방문할 것이므로,해당 노드를 제외할 수 있도록 방문했다고 체크
        visited[v]=true;
        //해당 노드와 연결된 노드를 방문
        for(int vertex : graph.get(v)){
            //방문하지 않은 노드에만 방문하도록
            if(!visited[vertex]){
                dfs(graph, visited, vertex, depth+1);
            }
        }
        //해당 vertex와 연결된 노드를 방문을 다 했으므로, 다른 노드에서 해당 노드를 다시 방문할 수 있도록 방문했다는 걸 체크해제
        visited[v]=false;
        //: 탐색의 순서가 달라지더라도 방문했던 노드를 다시 방문하지 못하면 원하는 뎁스를 가진 경로를 찾을 수 없다.
    }
}
