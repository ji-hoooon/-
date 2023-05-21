package org.test.test1.test1_3;

import org.test.test1.test1_3.BackJoon_20166_Sol_Raw.FastReader;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon_20166_Sol {
    //문자열 순서가 존재하고, 중복 가능
    //: 중복 순열

    static int N, M, K;
    static String[] strings;
    //    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    static int dx[] = {0, 0, -1, -1, -1, 1, 1, 1};
    static int dy[] = {1, -1, -1, 0, 1, -1, 0, 1};
    static Map<String, Integer> map = new HashMap<String, Integer>();
//    static FastReader scan = new FastReader();
    static Scanner scan = new Scanner(System.in);

    static void dfs(int i, int j, String path, int len) {
//        1 ≤ 신이 좋아하는 문자열의 길이 ≤ 5 : 완탐으로 가능한 개수

        //path라는 문자열을 만들었음을 기록하기
        map.put(path, map.getOrDefault(path,0) + 1);
//        if (map.containsKey(path)a) map.put(path, map.get(path) + 1);
//        else map.put(path, 1);
        //최대 5개가 되었으니 종료
        if (len == 5) return;

        //8방향 이동
        for (int k = 0; k < 8; k++) {
            int ni = (i + dx[k]) % N;
            int nj = (j + dy[k]) % M;
            if (ni < 0) ni += N;
            if (nj < 0) nj += M;

            dfs(ni, nj, path + strings[ni].charAt(nj), len + 1);
        }
    }
    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        scan.nextLine();
        strings=new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = scan.nextLine();
        }

    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <M; j++) {
//                dfs(i, j, String.valueOf(strings[i].charAt(j)), 1);
                dfs(i, j, Character.toString(strings[i].charAt(j)), 1);
            }
        }

        while (K-- > 0) {
            String chk = scan.nextLine();
            // 입력을 받으면 바로 Map 에서 정답을 가져온다
            if (map.containsKey(chk)) System.out.println(map.get(chk));
            else System.out.println(0);
        }
    }



    public static void main(String[] args) {
        input();
        pro();
    }
}
