package org.test.test1.test1_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//중복 가능하고 순서가 존재하는 문자열 찾기
//: map이용해야한다, 미리 다 만들어서 넣어두고 해당 문자열의 개수를 꺼내둔다, 0 -> N, 0 -> M, N -> 0, M-> 0
//next()를 한번이라도 썼으면 다음 nextLine()을 사용하려면 nextLine()으로 반드시 비우고 사용해야한다.
public class BackJoon_20166_solved {
    //문자열 순서가 존재하고, 중복 가능
    //: 중복 순열
    static HashMap<String, Integer> map = new HashMap<>();
    static int N, M, K;
    static String[] strings;
    static int[][] dir = {{0, 1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {1, -1}, {1, 0}, {1, 1}};
    static Scanner scan = new Scanner(System.in);

//    static int dx[] = {0, 0, -1, -1, -1, 1, 1, 1};
//    static int dy[] = {1, -1, -1, 0, 1, -1, 0, 1};

//    static void bfs(int x, int y) {
////        1 ≤ 신이 좋아하는 문자열의 길이 ≤ 5 : 완탐으로 가능한 개수
//        Queue<String> Q = new LinkedList<>();
//        StringBuilder sb= new StringBuilder();
//        Q.offer(sb.append(strings[x].charAt(y - 1)).toString());
//        visited[x][y] = true;
//
//        while (!Q.isEmpty()) {
//            String str= Q.poll();
//            if(str.length()>5) return;
//
//            if(map.containsKey(str)) map.put(str, map.getOrDefault(str,0) + 1);
//
//            for (int k = 0; k < 8; k++) {
//                int nx = x + dir[k][0];
//                int ny = y + dir[k][1];
//
//                if (nx == 0) nx = N;
//                if (ny == 0) ny = M;
//                if (nx == N + 1) nx = 1;
//                if (ny == M + 1) ny = 1;
//
//                StringBuilder newSb = new StringBuilder(str);
//                newSb.append(strings[nx].charAt(ny - 1));
//                Q.offer(newSb.toString());
//            }
//        }
//    }

    static void dfs(int x, int y, String str, int len) {
//        1 ≤ 신이 좋아하는 문자열의 길이 ≤ 5 : 완탐으로 가능한 개수
        map.put(str, map.getOrDefault(str, 0) + 1);

        if (len == 5) return;


        for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx == 0) nx = N;
                if (ny == 0) ny = M;
                if (nx == N + 1) nx = 1;
                if (ny == M + 1) ny = 1;
//            int ni = (x + dir[k][0]) % N;
//            int nj = (y + dir[k][1]) % M;
//            if (ni < 1) ni += N;
//            if (nj < 1) nj += M;

//            dfs(ni, nj, str + strings[ni].charAt(nj - 1), len + 1);
            dfs(nx, ny, str + strings[nx].charAt(ny - 1), len + 1);
        }
    }


    static void pro() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dfs(i, j, Character.toString(strings[i].charAt(j - 1)), 1);
            }
        }

//        for (int value : map.values()) {
//            System.out.println(value);
//        }
        while (K-- > 0) {
            String chk = scan.nextLine();
            // 입력을 받으면 바로 Map 에서 정답을 가져온다
            if (map.containsKey(chk)) System.out.println(map.get(chk));
            else System.out.println(0);
        }

    }

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        strings = new String[N + 1];

        scan.nextLine();

        for (int i = 1; i <= N; i++) {
            strings[i] = scan.nextLine();
        }
//        for (int i = 0; i < K; i++) {
//            map.put(scan.nextLine(), 0);
//        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
