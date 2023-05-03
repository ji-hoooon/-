package org.algorithms.search.twopointers.twopointer_advanced;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//고냥이
//: R을 이동시켜서 고정시키고, L을 이동시킨다.

//R은 인식하고 싶은 구간의 오른쪽 끝
//L은 인식 가능한 가장 왼쪽의 위치
//cnt 배열은 알파벳의 방문 횟수를 세는 배열
//kind는 [L,R]사이의 알파벳 종류의 수로, cnt 배열에서 0이 아닌 것의 개수를 말한다.

//: 고냥이가 인식할 수 없는 상태(kind가 3인 상태)가 되면, 인식할 수 있도록 L을 땡겨준다(kind가 2이하).
//해당 상태가 R의 해당 위치의 최대 인식 가능한 구간의 왼쪽 끝인 상태가 된다. -> R=4일때 L=2
public class BackJoon_16472_solved {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, kind;
    static String A;
    static int[] cnt;

    static void input() {
        N = scan.nextInt();
        A = scan.nextLine();
        cnt = new int[26];
    }

    static void add(char x) {  // x 라는 알파벳 추가
        /* TODO */
        cnt[(int)x-97]++;
        int tmp=0;
        for(int i=0;i<cnt.length;i++){
            if(cnt[i]>0) tmp++;
        }
        kind=tmp;
    }

    static void erase(char x) {  // x 라는 알파벳 제거
        cnt[(int)x-97]--;
        int tmp=0;
        for(int i=0;i<cnt.length;i++){
            if(cnt[i]>0) tmp++;
        }
        kind=tmp;
    }

    static void pro() {
        int len = A.length(), ans = 0;
        for (int R = 0, L = 0; R < len; R++) {
            // R 번째 문자를 오른쪽에 추가
            char c = A.charAt(R);
            add(c);

            // 불가능하면, 가능할 때까지 L을 이동
            while(kind>N){
                c=A.charAt(L++);
                erase(c);
            }


            // 정답 갱신
            ans=Math.max(ans,R-L+1);
        }
        System.out.println(ans);
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