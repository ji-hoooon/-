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
public class BackJoon_16472_try {
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
        //문자열 a를 빼주면 아스키코드값 97를 빼기 때문에 a=0부터 계산 가능하다.
        cnt[x-'a']++;
    }

    static void erase(char x) {  // x 라는 알파벳 제거
        //문자열 a를 빼주면 아스키코드값 97를 빼기 때문에 a=0부터 계산 가능하다.
        cnt[x-'a']--;
    }

    static void pro() {
        int len = A.length(), ans = 0;
        for (int R = 0, L = 0; R < len; R++) {
            // R 번째 문자를 오른쪽에 추가
            add(A.charAt(R));

            // 불가능하면, 가능할 때까지 L을 이동
            //: 매번 kind를 0으로 초기화하고 cnt배열이 0이 아닌 개수를 세야한다.
            while(true){
                kind=0;
                for(int i=0;i<26;i++){
                    if(cnt[i]!=0) kind++;
                }
                if(kind<=N){
                    break;
                }
                erase(A.charAt(L++));
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