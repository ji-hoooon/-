package org.algorithms.graph.search.bfs.mindis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_2664_sovled {
        static FastReader scan = new FastReader();
        static StringBuilder sb = new StringBuilder();

        static int N, st, ed, M;
        static ArrayList<Integer>[] adj;
        static int[] dist;
        static boolean[] visited;

        static void input() {
            N = scan.nextInt();
            st = scan.nextInt();
            ed = scan.nextInt();
            M = scan.nextInt();
            adj = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++)
                adj[i] = new ArrayList<>();
            for (int i = 1; i <= M; i++) {
                int x = scan.nextInt(), y = scan.nextInt();
                adj[x].add(y);
                adj[y].add(x);
            }
        }

//사람들은 1, 2, 3, …, n (1 ≤ n ≤ 100)의 연속된 번호로 각각 표시된다. 입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고,
//둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다.
//셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다.
//넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다
//이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.
//각 사람의 부모는 최대 한 명만 주어진다.

        // start 에서 시작해서 갈 수 있는 정점들을 모두 탐색하기
        static void bfs(int start) {
            Queue<Integer> q = new LinkedList<>();
            dist[start]=0;
            dist[ed]=-1;
            q.offer(start);
            visited[start]=true;

            while(!q.isEmpty()){
                int x=q.poll();

                for(int y:adj[x]){
                    if(visited[y]) continue;
                    q.offer(y);
                    dist[y]=dist[x]+1;
                    visited[y]=true;
                }
            }
        }

        static void pro() {
            dist = new int[N + 1];
            visited=new boolean[N+1];
            bfs(st);
            System.out.println(dist[ed]);
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

