package org.algorithms.graph.topological.topological_base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//줄 세우기
public class BackJoon_2252_try {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] indeg;
    static ArrayList<Integer>[] adj;

    static void input() {
        // Adjacent List 생성 및 indegree 계산하기
        //1. 변수 입력
        N= scan.nextInt();
        M= scan.nextInt();
        //2. 자료구조 초기화
        adj=new ArrayList[N+1];
        indeg=new int[N+1];

        //3. 자료구조에 값 추가
        for(int i=1;i<=N;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            int x= scan.nextInt();
            int y= scan.nextInt();
            //4. x->y로 가는 간선 추가
            adj[x].add(y);
            //5. y로 들어오는 간선 개수 (차수) 추가
            indeg[y]++;
        }

    }

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        // 제일 앞에 "정렬될 수 있는" 정점 찾기
        for(int i=1;i<=N;i++){
            if(indeg[i]==0){
                queue.offer(i);
            }
        }

        // 정렬될 수 있는 정점이 있다면?
        // 1. 정렬 결과에 추가하기
        // 2. 정점과 연결된 간선 제거하기
        // 3. 새롭게 "정렬 될 수 있는" 정점을 큐에 추가
        while(!queue.isEmpty()){
            int x=queue.poll();
            sb.append(x).append(" ");
            for(int y : adj[x]){
                indeg[y]--;
                if(indeg[y]==0) queue.offer(y);
            }
        }
        System.out.println(sb);
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