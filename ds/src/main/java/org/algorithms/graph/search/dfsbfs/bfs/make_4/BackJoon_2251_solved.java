package org.algorithms.graph.search.dfsbfs.bfs.make_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//물통
// 물통의 현재 상태와 물을 붓는 행위를 관리하는 구조체
class State {
    int[] X;

    State(int[] _X) {
        X = new int[3];
        //from, to, 물의 양
        for (int i = 0; i < 3; i++) X[i] = _X[i];
    }

    State move(int from, int to, int[] Limit) {
        // from 물통에서 to 물통으로 물을 옮긴다.

        int[] nX = new int[]{X[0], X[1], X[2]};
        if (Limit[to] <= X[to] + X[from]) {
            nX[from] -= Limit[to] - X[to];
            nX[to] = Limit[to];
        } else {
            nX[to] += nX[from];
            nX[from] = 0;
        }

        return new State(nX);
    }
}

public class BackJoon_2251_solved {

    static FastReader scan = new FastReader();
        static StringBuilder sb = new StringBuilder();

        static int[] Limit;
        static boolean[] possible;
        static boolean[][][] visit;

        static void input() {
            Limit = new int[3];
            for (int i = 0; i < 3; i++) Limit[i] = scan.nextInt();
            visit = new boolean[205][205][205];
            possible = new boolean[205];
        }

        // 물통 탐색 시작~
        static void bfs(int x1, int x2, int x3) {
            Queue<State> Q = new LinkedList<>();

            // BFS 과정 시작
            //첫 번째 물통(용량이 A인)이 비어 있을 때, 세 번째 물통(용량이 C인)에 담겨있을 수 있는 물의 양
            Q.offer(new State(new int[]{x1, x2, x3}));
            visit[x1][x2][x3] = true;
            while (!Q.isEmpty()) {

                State tmp = Q.poll();
                //A가 빈경우 정답 체크
                if (tmp.X[0] == 0) possible[tmp.X[2]] = true;
                //to가 꽉차는 경우, from이 비는 경우를 만들기 위해 돈다.
                //1. 완전탐색
                for (int from = 0; from < 3; from++) {
                    for (int to = 0; to < 3; to++) {
                        //1. from==to일 땐 통과
                        if (from == to) continue;
                        //2. from, to,limit
                        State nSt = tmp.move(from, to, Limit);
                        //3. visit 체크
                        if (visit[nSt.X[0]][nSt.X[1]][nSt.X[2]]) continue;
                        else {
                            visit[nSt.X[0]][nSt.X[1]][nSt.X[2]] = true;
                            Q.offer(nSt);
                        }
                    }
                }
            }
        }

        static void pro() {
            bfs(0, 0, Limit[2]);
            // 정답 계산하기
            //: 정답은 C가 최대치보다 적을때만 존재하므로
            for (int i = 0; i <= Limit[2]; i++) {
                if (possible[i]) sb.append(i + " ");
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
