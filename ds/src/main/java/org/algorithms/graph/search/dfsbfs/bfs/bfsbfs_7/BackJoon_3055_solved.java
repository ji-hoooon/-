package org.algorithms.graph.search.dfsbfs.bfs.bfsbfs_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//탈출
public class BackJoon_3055_solved {
    static FastReader scan = new FastReader();
    static int N, M;
    static String[] arr;
    static int[][] dis;
    static int[][] wdis;
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static int sX, sY, dX, dY;

    static boolean[][] visited;
    static boolean[][] wvisited;
    static int answer = -1;

    static Queue<Integer> water = new LinkedList<>();

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new String[N];
        dis = new int[N][M];
        wdis = new int[N][M];
        visited = new boolean[N][M];
        wvisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextLine();
            Arrays.fill(dis[i], -1);
            Arrays.fill(wdis[i], Integer.MAX_VALUE);

            for (int j = 0; j < M; j++) {
                if (arr[i].charAt(j) == 'S') {
                    sX = i;
                    sY = j;
                }
                if (arr[i].charAt(j) == 'D') {
                    dX = i;
                    dY = j;
                }
                if (arr[i].charAt(j) == '*') {
                    water.offer(i);
                    water.offer(j);
                    wdis[i][j] = 0;
                }
            }
        }
    }

    static void pro() {
        bfs(sX, sY);
        if (dis[dX][dY] == -1) System.out.println("KAKTUS");
        else System.out.println(dis[dX][dY]);
    }

    static void bfs(int sX, int sY) {
        while (!water.isEmpty()) {
            int wX = water.poll();
            int wY = water.poll();
            wvisited[wX][wY] = true;

            for (int k = 0; k < 4; k++) {
                int nX = wX + dir[k][0];
                int nY = wY + dir[k][1];

                if (nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
                if (wvisited[nX][nY]) continue;
                if (arr[nX].charAt(nY) != '.') continue;
                wvisited[nX][nY] = true;
                wdis[nX][nY] = wdis[wX][wY] + 1;
                water.offer(nX);
                water.offer(nY);
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(sX);
        Q.offer(sY);
        dis[sX][sY] = 0;
        visited[sX][sY] = true;
        if (sX == dX && sY == dY) return;

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            if (x == dX && y == dY) return;

            for (int k = 0; k < 4; k++) {
                int nX = x + dir[k][0];
                int nY = y + dir[k][1];

                if (nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
                if (visited[nX][nY]) continue;
                if (arr[nX].charAt(nY) != '.' && arr[nX].charAt(nY) != 'D') continue;
                if (dis[x][y] + 1 >= wdis[nX][nY]) continue;

                visited[nX][nY] = true;
                dis[nX][nY] = dis[x][y] + 1;
                Q.offer(nX);
                Q.offer(nY);
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {  // FastReader 클래스 시작

        BufferedReader br;  // 입력을 받기 위한 BufferedReader
        StringTokenizer st;  // 입력된 문자열을 쪼개기 위한 StringTokenizer

        public FastReader() {  // FastReader 생성자 시작
            br = new BufferedReader(new InputStreamReader(System.in));  // 표준 입력(System.in)으로부터 BufferedReader 생성
        }  // FastReader 생성자 끝

        public String next() {  // 다음 문자열을 반환하는 next 메소드 시작
            while (st == null || !st.hasMoreElements()) {  // StringTokenizer가 null일 경우 or 입력이 남아있지 않은 경우 while문 실행
                try {  // try-catch 문 시작
                    st = new StringTokenizer(br.readLine());  // 입력을 받아 StringTokenizer 생성
                } catch (IOException e) {  // IOException 발생 시 처리
                    e.printStackTrace();  // 예외 상황 출력
                }  // try-catch 문 끝
            }
            return st.nextToken();  // StringTokenizer에서 다음 문자열 반환
        }  // 다음 문자열을 반환하는 next 메소드 끝

        public int nextInt() {  // 다음 정수형 값을 반환하는 nextInt 메소드 시작
            return Integer.parseInt(next());  // next 메소드를 사용하여 다음 문자열을 받고, Integer.parseInt를 사용하여 정수형으로 변환하여 반환
        }  // 다음 정수형 값을 반환하는 nextInt 메소드 끝

        public long nextLong() {  // 다음 long형 값을 반환하는 nextLong 메소드 시작
            return Long.parseLong(next());  // next 메소드를 사용하여 다음 문자열을 받고, Long.parseLong을 사용하여 long형으로 변환하여 반환
        }  // 다음 long형 값을 반환하는 nextLong 메소드 끝

        public double nextDouble() {  // 다음 double형 값을 반환하는 nextDouble 메소드 시작
            return Double.parseDouble(next());  // next 메소드를 사용하여 다음 문자열을 받고, Double.parseDouble을 사용하여 double형으로 변환하여 반환
        }  // 다음 double형 값을 반환하는 nextDouble 메소드 끝

        public String nextLine() {  // 다음 한 줄의 문자열을 반환하는 nextLine 메소드 시작
            String str = "";  // 반환할 문자열을 저장할 변수 선언 및 초기화
            try {  // try-catch 문 시작
                str = br.readLine();  // 입력 받아 str에 저장
            } catch (IOException e) {  // IOException 발생 시 처리
                e.printStackTrace();  // 예외 상황 출력
            }  // try-catch 문 끝
            return str;  // 저장된 문자열 반환
        }  // 다음 한 줄의 문자열을 반환하는 nextLine 메소드 끝
    }  // FastReader 클래스 끝

}

