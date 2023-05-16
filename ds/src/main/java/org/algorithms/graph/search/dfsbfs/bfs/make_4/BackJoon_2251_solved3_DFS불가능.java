package org.algorithms.graph.search.dfsbfs.bfs.make_4;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//    class State {
//        int[] X;
//
//        State(int[] X) {
//            this.X = X;
//        }
//
//        State move(int from, int to, int[] Limit) {
//            //원래 상태인 걸로 만들어둬야 이동하지 않은 값들도 유지된다.
//            int[] nX = new int[]{X[0], X[1], X[2]};
//            if (X[from] + X[to] >= Limit[to]) {
//                nX[to] = Limit[to];
//                nX[from] = X[from] - (nX[to] - X[to]);
//            } else {
//                nX[to] = X[from] + X[to];
//                nX[from] = 0;
//            }
//
//            return new State(nX);
//        }
//    }

public class BackJoon_2251_solved3_DFS불가능 {
    static int[] Limit = new int[3];

    static StringBuilder sb = new StringBuilder();
    static boolean[][][] visited;
    static boolean[] answer;

    static void input() {
        Scanner scan = new Scanner(System.in);
        visited = new boolean[205][205][205];
        answer = new boolean[205];
        for (int i = 0; i < 3; i++) {
            Limit[i] = scan.nextInt();
        }
    }

    static void pro() {
        bfs(0, 0, Limit[2]);
        for (int i = 0; i <=Limit[2]; i++) {
            if (answer[i]) sb.append(i + " ");
        }
        System.out.println(sb);
    }

    //        static void dfs(int x1, int x2, int x3) {
//            if (x1 == 0) {
////            System.out.println(x1+" "+x2+" "+x3);
//                answer[x3] = true;
//            }
//            visited[x1][x2][x3] = true;
//            State st = new State(new int[]{x1, x2, x3});
//
//            for (int from = 0; from < 3; from++) {
//                for (int to = 0; to < 3; to++) {
//                    if (from == to) continue;
//                    State nst = st.move(from, to, Limit);
//                    if (visited[nst.X[0]][nst.X[1]][nst.X[2]]) continue;
//                    visited[nst.X[0]][nst.X[1]][nst.X[2]] = true;
//                    dfs(nst.X[0], nst.X[1], nst.X[2]);
//                }
//            }
//        }
    static void bfs(int x1, int x2, int x3) {
        Queue<State> Q = new LinkedList<>();
        Q.offer(new State(new int[]{x1, x2, x3}));
        visited[x1][x2][x3] = true;
        while (!Q.isEmpty()) {
            State st = Q.poll();
            if (st.X[0] == 0) answer[st.X[2]] = true;

            for(int from=0;from<3;from++){
                for(int to=0;to<3;to++){
                    if(from==to) continue;
                    State nst = st.move(from, to, Limit);
                    if (visited[nst.X[0]][nst.X[1]][nst.X[2]]) continue;
                    visited[nst.X[0]][nst.X[1]][nst.X[2]]=true;
                    Q.offer(nst);
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}