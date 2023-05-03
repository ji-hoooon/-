package org.algorithms.search.twopointers.twopointer_advanced;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//kind를 for문을 돌려서 O(26)으로 찾지 말고
//O(1)로 찾는 방법은 어떤게 있을까?

//기준 : kind가 바뀌는 기점은 cnt라는 배열에 변화가 발생할 때
//접근 : add, erase 메서드 호출시 cnt라는 배열이 변화한다.
//구현 : add와 erase 메서드 호출했을 때,
// add의 경우, 파라미터에 해당하는 배열 값이 1이 될 때 -> 0에서 1로 변화했을때 kind++
// erase의 경우, 파라미터에 해당하는 배열 값이 0이 될 때 -> 1에서 0으로 변화했을때 kind--;

//고냥이
//: R을 이동시켜서 고정시키고, L을 이동시킨다.
public class BackJoon_16472_try2 {
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
        cnt[x - 'a']++;
        if (cnt[x - 'a'] == 1) {
            kind++;
        }
    }

    static void erase(char x) {  // x 라는 알파벳 제거
        //문자열 a를 빼주면 아스키코드값 97를 빼기 때문에 a=0부터 계산 가능하다.
        cnt[x - 'a']--;
        if (cnt[x - 'a'] == 0) {
            kind--;
        }
    }

    static void pro() {
        int len = A.length(), ans = 0;
        for (int R = 0, L = 0; R < len; R++) {
            // R 번째 문자를 오른쪽에 추가
            add(A.charAt(R));

            // 불가능하면, 가능할 때까지 L을 이동
            //: 매번 kind를 0으로 초기화하고 cnt배열이 0이 아닌 개수를 세야한다.
//            while(true){
//                if(kind<=N){
//                    break;
//                }
//                erase(A.charAt(L++));
//            }
            while (kind > N)
                erase(A.charAt(L++));

            // 정답 갱신
            ans = Math.max(ans, R - L + 1);
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