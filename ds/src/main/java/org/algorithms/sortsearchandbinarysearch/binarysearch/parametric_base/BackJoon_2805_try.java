package org.algorithms.sortsearchandbinarysearch.binarysearch.parametric_base;

import org.algorithms.sortsearchandbinarysearch.binarysearch.parametric_base.BackJoon_2805_Base.FastReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//나무 자르기
//원하는 길이 M 만큼을 얻을 수 있는 최대 높이는 얼마인가?
//해당 높이로 잘랐을 때, 원하는 길이 M만큼을 얻을 수 있는가? (YES/NO)

public class BackJoon_2805_try {
    static BackJoon_2805_Base.FastReader scan = new BackJoon_2805_Base.FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static boolean determination(int H) {
        // H 높이로 나무들을 잘랐을 때, M 만큼을 얻을 수 있으면 true, 없으면 false를 return하는 함수
        //: 자르기전에 해당 나무 길이가 H보다 큰지 확인 -> 작으면 애초에 잘라도 의미가 없음

        //계산 중에 범위인 21억 보다 클 경우가 필연적으로 존재하므로 long타입
        long sum=0;
        for(int i=1;i<=N;i++){
            if(A[i]>H) sum+=A[i]-H;
        }
        return sum>=M;
    }

    static void pro() {
        long L = 0, R = 2000000000, ans = 0;
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
        while(L<=R){
            long mid=(L+R)/2;
            if(determination((int)mid)){
                L=mid+1;
                ans=mid;
            }else{
                R=mid-1;
            }
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