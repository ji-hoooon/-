package org.algorithms.search.sortsearch.sort_base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
//국영수

public class BackJoon_10825_solved {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Elem{

        public String name;
        public int korean, english, math;

//        @Override
//        public int compareTo(Elem other) {
//            // TODO
//            // 국어, 영어, 수학, 이름 값을 가지고 정렬 기준 정의 하기
//            return 0;
//        }
    }

    static int N;
    static Elem[] a;

    static void input() {
        N = scan.nextInt();
        a = new Elem[N];
        for (int i = 0; i < N; i++) {
            a[i] = new Elem();
            a[i].name = scan.next();
            a[i].korean = scan.nextInt();
            a[i].english = scan.nextInt();
            a[i].math = scan.nextInt();
        }
    }

    static void pro() {
        // TODO
        // 기준을 통해 정렬하기
        Arrays.sort(a, new Comparator<Elem>() {
            @Override
            public int compare(Elem o1, Elem o2) {
                if(o1.english==o2.english&&
                o1.korean==o2.korean&&
                o1.math==o2.math){
                    return o1.name.compareTo(o2.name);
                }else{
                    if(o1.english == o2.english&&
                            o1.korean==o2.korean){
                        return o2.math-o1.math;
                    }else if(o1.korean==o2.korean){
                        return o1.english-o2.english;
                    }else return o2.korean-o1.korean;
                }
            }
        });

        // 정답 출력하기
        for(Elem E : a){
            sb.append(E.name).append("\n");
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
