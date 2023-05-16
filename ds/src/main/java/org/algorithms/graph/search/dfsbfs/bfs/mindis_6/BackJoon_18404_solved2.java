package org.algorithms.graph.search.dfsbfs.bfs.mindis_6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//현명한 나이트
public class BackJoon_18404_solved2 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, sx, sy;
    static int[][] dist;
    static int[][] dir = {{-1,-2},{-2,-1},{-1,2},{-2,1},{1,-2},{2,-1},{1,2},{2,1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        sx = scan.nextInt();
        sy = scan.nextInt();
        dist = new int[N][N];
    }

    static void bfs() {
        // 초기화 해주기
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            Arrays.fill(dist[i],-1);
        }
        q.offer(sx);
        q.offer(sy);
        dist[sx][sy]=0;

        // BFS 과정 시작
        while(!q.isEmpty()){
            int x=q.poll();
            int y=q.poll();

            for(int k=0;k<8;k++){
                int nx=x+dir[k][0];
                int ny=y+dir[k][1];
                if(nx<0||ny<0||nx>=N||ny>=N)continue;
                if(dist[nx][ny]!=-1)continue;
                q.offer(nx);
                q.offer(ny);
                dist[nx][ny]=dist[x][y]+1;
            }
        }

    }

    static void pro() {
        bfs();
        while (M-- > 0) {
            int ex = scan.nextInt();
            int ey = scan.nextInt();
            System.out.print(dist[ex][ey]+ " ");
        }
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