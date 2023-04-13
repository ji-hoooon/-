package org.algorithms.graph.tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//트리
public class BackJoon_1068_Sol {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, root, erased;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    static void input() {
        n = scan.nextInt();
        //간선의 정보가 아니므로 인접 리스트가 아닌, 정점의 자식들을 가지고 있다.
        child=new ArrayList[n];

        //x를 루트로하는 서브트리의 단말노드의 개수를 담는 배열
        leaf=new int[n];
        for(int i=0;i<n;i++) child[i]=new ArrayList<>();
        for(int i=0;i<n;i++){
            int par= scan.nextInt();

            //1. 루트인 경우에는 제외
            if(par==-1) {
                root=i;
                continue;
            }
            //2. 루트가 아닌 경우에는, 부모에 i를 자식으로 추가
            child[par].add(i);
        }
        //마지막의 입력값으로 지워지는 정점 번호
        erased=scan.nextInt();
    }

    // dfs(x, par) := 정점 x 의 부모가 par 였고, Subtree(x) 의 leaf 개수를 세주는 함수
    static void dfs(int x, int par) {
        //(1) x가 단말 노드일때 (x의 자식노드가 없을 때)
        if(child[x].isEmpty()){
            leaf[x]=1;
        }
        //(2) x가 단말 노드가 아닐 때 (재귀함수로 단말노드가 없을 때는 노드까지 나누어 해결)
        for(int y:child[x]){
            //(3) 부모일 때는 제외해야한다.
            if(y==par) continue;

            //(4) 자식에 대해서 DFS 호출
            dfs(y,x);

            //(5) dfs로 탐색한 자식(자식의 단말노드 개수)을 부모(부모의 단말노드 개수)에 추가
            leaf[x]+=leaf[y];
        }
    }

    static void pro() {
        //3. erased와 그의 부모 사이의 연결을 끊어주기
        //: 자식들이 erased인 경우를 찾아서 erased의 부모와의 간선을 끊기
        for(int i=0;i<n;i++){
//            for(int children :child[i]){
//                if(children==erased) child[i].remove(new Integer(children));
//            }

            //돌지않고, contains함수로 찾아서 지우기
            if(child[i].contains(erased)) {
//                child[i].remove(new Integer(erased));
                child[i].remove(child[i].indexOf(erased));
            }
        }

            //4. erased 가 root 인 예외 처리하기
            //만약 루트가 erased인 경우엔 예외처리 필수
            //: 즉 루트가 사라지지 않은 경우에만 dfs 호출
            if(root!=erased){
                dfs(root, -1);

            }
            // 정답 출력하기
            //dfs가 마치면, 단말노드의 개수를 담은 leaf 배열에서 루트노드의 단말 노드 개수 출력
            System.out.println(leaf[root]);

    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}