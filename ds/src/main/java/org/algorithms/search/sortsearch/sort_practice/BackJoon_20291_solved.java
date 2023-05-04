package org.algorithms.search.sortsearch.sort_practice;

import org.io.FastReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

//파일 정리
//특수문자의 경우 이스케이프 문자를 사용해야한다. -> '\\.'
public class BackJoon_20291_solved {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] a;
//    static TreeMap<String, Integer> map=new TreeMap<>(new Comparator<String>() {
//        @Override
//        public int compare(String o1, String o2) {
//            return o1.compareTo(o2);
//        }
//    });
    static TreeMap<String, Integer> map=new TreeMap<>((o1,o2)-> o1.compareTo(o2));

    static void input() {
        N = scan.nextInt();
        a = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            // 입력된 파일 이름을 . 을 기준으로 나눠서 확장자를 가져오기
            String t=scan.next();
            String[] tmp=t.split("\\.");
            map.put(tmp[1], map.getOrDefault(tmp[1], 0)+1);
        }
    }

    static void pro() {
        // TODO: 확장자마다 몇 번 나타났나 count 하기
        for(String str:map.keySet()){
            sb.append(str).append(" ").append(map.get(str)).append("\n");
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