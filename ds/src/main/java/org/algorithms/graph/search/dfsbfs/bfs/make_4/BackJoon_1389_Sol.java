package org.algorithms.graph.search.dfsbfs.bfs.make_4;

import java.io.*;
import java.util.*;

//케빈 베이컨의 6단계 법칙
//: 케빈 베이컨 수가 가장 적은 사람 중 번호가 가장 작은 사람 출력
public class BackJoon_1389_Sol {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    static void input() {
        N= scan.nextInt();
        adj=new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            adj[i]=new ArrayList<>();
        }
        dist=new int[N+1];

        M= scan.nextInt();

        for(int i=0;i<M;i++){
            int x= scan.nextInt();
            int y= scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    // start 라는 정점의 케빈 베이컨의 수를 계산해주는 함수
    static int bfs(int start) {
        int ret=0;
        Queue<Integer> Q = new LinkedList<>();
        //dist배열 -1로 초기화
        Arrays.fill(dist,-1);

        //방문가능한 점 초기화
        Q.offer(start);
        dist[start]=0;  //1->1 가능 같은 점은 0으로 설정

        while(!Q.isEmpty()){
            int x=Q.poll();
            ret+=dist[x];   //0 + 0

            for(int y:adj[x]){
                //1번과 친구관계 추가

                //이미 갈 수 있으면 제외하기 위해서
                if(dist[y]!=-1) continue;
                //갈 수 있으면 일단 추가
                Q.offer(y);
                //이미 갈 수 있는 점으로 부터 1단계 추가
                dist[y]=dist[x]+1;
            }
        }
        return ret;
    }

    static void pro() {
        //케빈 베이컨 수, 최소 베이컨 수를 가지는 번호 초깃값 설정
        int minV = bfs(1), minIdx = 1;

        // 최소의 케빈 베이컨의 수를 갖는 사람 찾기
        //:1번의 케빈 베이컨 수는 minV이므로 2번부터 반복문
        for(int i=2;i<=N;i++){
            int v=bfs(i);
            if(minV>v){
                //더 작은 케빈 베이컨 수가 존재하면
                minV=v;
                minIdx=i;
            }
        }
        System.out.println(minIdx);
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
