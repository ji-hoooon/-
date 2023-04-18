package org.algorithms.bruteforce_base;

import java.util.*;
import java.io.*;

public class BackJoon_15652_solved {
    static int N, M;
    static int[] selected;
    static StringBuilder sb= new StringBuilder();
    static boolean[] isUsed;

    static void input(){
        //N개중에 M개를 중복 허용하고, 순서를 생각하며 뽑는다.
        //: 중복이 존재하면서, 순서가 다르면 다른것
        //-> 다음 번째 수가 같거나 커야한다.
        FastReader scan = new FastReader();
        N=scan.nextInt();
        M=scan.nextInt();
        selected=new int[M+1];
    }
    public static void main(String[] args){
        input();
        rec_func(1);
        System.out.println(sb);
    }
    static void rec_func(int k){
        if(k==M+1){
            for(int i=1;i<=M;i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        }else{
            for(int i=1;i<=N;i++){
                if(i<selected[k-1]) continue;
                selected[k]=i;
                //k번째에 selected[k-1]보다 같거나 큰 i를 넣는다.
                rec_func(k+1);
                //다음 숫자 함수 호출
                //끝까지 다 돌았으니까 초기화
                selected[k]=0;
            }
        }
    }
    static class FastReader {  // FastReader 클래스 시작

        BufferedReader br;  // 입력을 받기 위한 BufferedReader
        StringTokenizer st;  // 입력된 문자열을 쪼개기 위한 StringTokenizer

        public FastReader() {  // FastReader 생성자 시작
            br = new BufferedReader(new InputStreamReader(System.in));  // 표준 입력(System.in)으로부터 BufferedReader 생성
        }  // FastReader 생성자 끝

        public String next() {  // 다음 문자열을 반환하는 next 메소드 시작
            while (st == null || !st.hasMoreElements()) {  // StringTokenizer가 null일 경우 or 입력이 남아있지 않은 경우 while문 실행
                try {  // try-catch 문 시작
                    st = new StringTokenizer(br.readLine());  // 입력을 받아 StringTokenizer 생성
                } catch (IOException e) {  // IOException 발생 시 처리
                    e.printStackTrace();  // 예외 상황 출력
                }  // try-catch 문 끝
            }
            return st.nextToken();  // StringTokenizer에서 다음 문자열 반환
        }  // 다음 문자열을 반환하는 next 메소드 끝

        public int nextInt() {  // 다음 정수형 값을 반환하는 nextInt 메소드 시작
            return Integer.parseInt(next());  // next 메소드를 사용하여 다음 문자열을 받고, Integer.parseInt를 사용하여 정수형으로 변환하여 반환
        }  // 다음 정수형 값을 반환하는 nextInt 메소드 끝

        public long nextLong() {  // 다음 long형 값을 반환하는 nextLong 메소드 시작
            return Long.parseLong(next());  // next 메소드를 사용하여 다음 문자열을 받고, Long.parseLong을 사용하여 long형으로 변환하여 반환
        }  // 다음 long형 값을 반환하는 nextLong 메소드 끝

        public double nextDouble() {  // 다음 double형 값을 반환하는 nextDouble 메소드 시작
            return Double.parseDouble(next());  // next 메소드를 사용하여 다음 문자열을 받고, Double.parseDouble을 사용하여 double형으로 변환하여 반환
        }  // 다음 double형 값을 반환하는 nextDouble 메소드 끝

        public String nextLine() {  // 다음 한 줄의 문자열을 반환하는 nextLine 메소드 시작
            String str = "";  // 반환할 문자열을 저장할 변수 선언 및 초기화
            try {  // try-catch 문 시작
                str = br.readLine();  // 입력 받아 str에 저장
            } catch (IOException e) {  // IOException 발생 시 처리
                e.printStackTrace();  // 예외 상황 출력
            }  // try-catch 문 끝
            return str;  // 저장된 문자열 반환
        }  // 다음 한 줄의 문자열을 반환하는 nextLine 메소드 끝
    }  // FastReader 클래스 끝

}