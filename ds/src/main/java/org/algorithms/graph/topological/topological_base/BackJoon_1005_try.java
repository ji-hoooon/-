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

//ACM Craft
public class BackJoon_1005_try {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] indeg, T_done, T;
    static ArrayList<Integer>[] adj;

    static void input() {
        // Testcase 가 존재하는 문제이므로 "배열 초기화"에 유의하자
        //정점 개수, 간선 개수
        N= scan.nextInt();
        M= scan.nextInt();

        //인접 리스트 - 정점 개수와 같다.
        adj=new ArrayList[N+1];
        //들어오는 차수
        indeg=new int[N+1];
        //건설 속도
        T=new int[N+1];

        //인접리스트, 건설 속도 배열 초기화
        for(int i=1;i<=N;i++){
            adj[i]=new ArrayList<>();
            T[i]= scan.nextInt();
        }
        for(int i=0;i<M;i++){
            int x= scan.nextInt();
            int y= scan.nextInt();
            adj[x].add(y);
            //들어오는 차수 계산
            indeg[y]++;
        }

    }

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        // 제일 앞에 "정렬될 수 있는" 정점 찾기
        //: 즉 차수가 0인 정점 - 바로 지을 수 있는 건물들
        for(int i=1;i<=N;i++){
            if(indeg[i]==0) queue.add(i);
            //바로 지을 수 있는 건물들은 본인의 건설 시간이 건물을 짓는 속도가 된다.
            T_done[i]=T[i];
        }

        // 위상 정렬 순서대로 T_done 계산을 함께 해주기
        //: x->y 간선을 지우면서, 건설 시간 갱신
        while(!queue.isEmpty()){
            int x=queue.poll();
            for(int y :adj[x]){
                indeg[y]--;
                if(indeg[y]==0) queue.offer(y);
                //T_done[x]는 이미 계산이 되어있으므로, T_done[x]을 이용해 갱신
                T_done[y]=Math.max(T_done[y],T_done[x]+T[y]);
            }
        }
        int W= scan.nextInt();
        System.out.println(T_done[W]);
    }

    public static void main(String[] args) {
        int Q = scan.nextInt();
        while (Q > 0) {
            Q--;
            input();
            pro();
        }
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