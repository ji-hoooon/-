package org.algorithms.graph.search.bfs.mindis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b7562 {
        static FastReader scan = new FastReader();
        static StringBuilder sb = new StringBuilder();

        static int N, sx, sy, ex, ey;
        static int[][] dist;
        static int[][] dir = {{-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {1, 2}, {2, 1}};

        static void input() {
            N = scan.nextInt();
            sx = scan.nextInt();
            sy = scan.nextInt();
            ex = scan.nextInt();
            ey = scan.nextInt();
        }

        static int bfs() {
            // 초기화 해주기
            Queue<Integer> q = new LinkedList<>();
            dist = new int[N][N];
            boolean[][] visited = new boolean[N][N];

            q.offer(sx);
            q.offer(sy);
            visited[sx][sy]=true;

//        if(sx==ex&&sy==ey) return 0;

            // BFS 과정 시작
            while(q.isEmpty()){
                int x=q.poll();
                int y=q.poll();


                for(int i=0;i<8;i++){
                    int nx=x+dir[i][0];
                    int ny=y+dir[i][1];
                    if(nx<0 ||ny<0||nx>=N||ny>=N) continue;
                    if(visited[nx][ny]) continue;

                    visited[nx][ny]=true;
                    dist[nx][ny]=dist[x][y]+1;
                    q.offer(nx);
                    q.offer(ny);
                }
            }

            return dist[ex][ey];
        }

        static void pro() {
            System.out.println(bfs());
        }

        public static void main(String[] args) {
            int T = scan.nextInt();
            while (T-- > 0) {
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
