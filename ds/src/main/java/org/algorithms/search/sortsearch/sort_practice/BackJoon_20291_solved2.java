package org.algorithms.search.sortsearch.sort_practice;

import org.io.FastReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//파일 정리
public class BackJoon_20291_solved2 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] a;

    static void input() {
        N = scan.nextInt();
        a = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            // 입력된 파일 이름을 . 을 기준으로 나눠서 확장자를 가져오기
            a[i]=scan.nextLine().split("\\.")[1];
        }
    }

    static void pro() {
        // TODO: 확장자마다 몇 번 나타났나 count 하기
        //1. 정렬 -> 문자의 오름차순 정렬(사전순)
        Arrays.sort(a, 1, N+1);
        //2. 정렬했을때 같으면 카운트 -> i를 증가시키지 않는다. 왜냐하면 다를 때는 j부터 시작해야하므로
        for(int i=1;i<=N;){
            int cnt=1;
            int j=i+1;

            //3. i를 기준으로 같은 경우가 있는지 j로 탐색해서 카운트
            for(;j<=N;j++) {
                //사전순이므로 같은경우엔 모두 붙어있다. -> 다르면 break;
                if (a[j].compareTo(a[i]) == 0) cnt++;
                else break;
            }
            sb.append(a[i]).append(' ').append(cnt).append('\n');

            // 4. a[j] 가 a[i]랑 다를 때는, 다음 i가 j 부터 시작한다.
            i = j;
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