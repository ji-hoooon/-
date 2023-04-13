package org.algorithms.graph.tree;

import org.io.FastReader;

import java.util.ArrayList;

//트리의 부모 찾기
public class BackJoon_11725_Sol {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static ArrayList<Integer>[] adj;
    static int[] parent;

    static void input() {
        n = scan.nextInt();

        adj=new ArrayList[n+1];
        parent=new int[n+1];

        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            int x=scan.nextInt();
            int y= scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    // dfs(x, par) := 정점 x 의 부모가 par 였고, x의 children들을 찾아주는 함수
    static void dfs(int x, int par) {
        for(int y : adj[x]){
            //(2) 부모일 때는 무시
            if(y==par) continue;
            //(3) 자식인 경우 -> 자식의 부모인 경우이다.
            parent[y]=x;
            //(4) 자식의 자식에 대해서 탐색 시작
            dfs(y,x);
        }
    }

    static void pro() {
        // 1 번 정점이 ROOT 이므로, 여기서 시작해서 Tree의 구조를 파악하자.
        //(1) 1번 정점의 부모는 존재하지 않으므로, -1
        //: visited 배열을 사용하지 않고, parent 정점 번호를 전달해서 부모를 제외할 수 있다.
        dfs(1,-1);

        //(5) 정답 출력하기 -> 루트가 1이므로 2부터 출력
        for(int i=2;i<=n;i++){
//            System.out.println(parent[i]);
            sb.append(parent[i]).append('\n');
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}