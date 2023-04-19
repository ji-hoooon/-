package org.algorithms.bruteforce.bruteforce_practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//암호 만들기
//조합
public class BackJoon_1759_solved {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        M = scan.nextInt();
        N = scan.nextInt();
        chars = new char[N + 1];
        selected = new int[M + 1];
        isUsed=new boolean[N+1];
        String[] tokens = scan.nextLine().split(" ");
        for (int i = 1; i <= N; i++) {
            chars[i] = tokens[i - 1].charAt(0);
        }
    }

    static int N, M;
    static char[] chars;
    static int[] selected;
    static boolean[] isUsed;

    static boolean isVowel(char x) {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }

    static void rec_func(int k) {
        if (k == M + 1) { // 1 ~ M 번째를 전부 다 골랐다
            int vowel = 0, consonant = 0;
            // 선택한 문자들이 조건을 만족하는 지 확인하자
            for(int x : selected){
                if(x!=0) {
                    if (isVowel(chars[x])) vowel++;
                    else consonant++;
                }
            }
            if(vowel>=1&&consonant>=2){
                for(int x: selected) {
                    if(x!=0) sb.append(chars[x]);
                }
                sb.append('\n');
            }
        } else {
            // 알파벳 순으로 증가하는 순서로 골라보기
            for(int i=k;i<=N;i++){
                if(isUsed[i] || selected[k-1]>=i) continue;
                //반드시 다음 번째 항이 이전 항보다 커야한다.
                selected[k]=i;
                isUsed[i]=true;

                rec_func(k+1);
                //다음 숫자 함수 호출
                //끝까지 다 돌았으니까 초기화
                selected[k]=0;
                isUsed[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞는 모든 방법을 찾아줘
        // chars 정렬해주기
        Arrays.sort(chars);
        rec_func(1);
        System.out.println(sb.toString());
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