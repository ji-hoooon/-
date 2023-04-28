package org.algorithms.search.sortsearch.sort.sort_advanced;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
//카드
//:2^62 -> 21억 넘으므로 Long
public class BackJoon_11652_Map {
    static int N;

    static Long MAX=Long.MIN_VALUE;
    static StringBuilder sb = new StringBuilder();
    static TreeMap<Long, Long> map= new TreeMap<>();
    static void input(){
        FastReader scan = new FastReader();
        N=scan.nextInt();
        for(int i=0;i<N;i++){
            Long tmp = scan.nextLong();
            map.put(tmp, map.getOrDefault(tmp,0L)+1);
        }
    }
    static void pro(){
        Long ans=0L;
        for(Entry<Long, Long> e : map.entrySet()){
            if(MAX<e.getValue().longValue()){
                MAX=e.getValue();
                ans=e.getKey();
            }
        }
        sb.append(ans);

    }
    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
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
