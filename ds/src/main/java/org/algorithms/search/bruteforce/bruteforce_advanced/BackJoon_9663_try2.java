package org.algorithms.search.bruteforce.bruteforce_advanced;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N-Queen
//: 중복 순열로 풀기 -> 불필요한 탐색을 줄이기
public class BackJoon_9663_try2 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        col = new int[N + 1];
    }

    static int N, ans;
    static int[] col;   //col[i] : i번 행의 퀸을 col[i]번 열에 두었다.

    private static boolean validity_check() {
        //모든 퀸이 서로를 공격하지 않는지 체크

        //퀸의 위치
        //: i번째 행, i번째 열 -> (i, col[i]);
        for(int i=1;i<=N;i++){
            for(int j=1;j<i;j++){
                //i보다 높은 행에 퀸이 존재하는지
                //: (j, col[j])
                if(attackable(i, col[i], j, col[j])) return false;
            }
        }
        return true;
    }

    static boolean attackable(int r1, int c1, int r2, int c2) {
        //퀸은 가로, 세로, 대각선으로 모든 방향의 일직선상에 존재하지 않아야 한다.
        if(c1==c2) return true;
        //같은 열에 있다.
        if(r1-c1==r2-c2) return true;
        //대각선의 방향 \ = 행-열 값이 같으면 왼쪽 대각선 관계
        if(r1+c1==r2+c2) return true;
        //대각선의 방향 / = 행+열 값이 같으면 오른쪽 대각선 관계

        return false;
    }

    //row번 ~ N번 행에 대해 가능한 퀸을 놓는 모든 경우의 수를 구한다.
    static void rec_func(int row) {
        //각 행마다 하나씩이 아닌,가능한 위치만 놓도록 바꾼다.
        //-> 같은 행 같은 열 같은 대각선 제외

        if (row == N + 1) { //1~N번 행에 공격하지 않도록 놓은 상태
            ans++;
        } else {
            for(int c=1; c<=N;c++){
                //row 행의 c열에 놓을 수 있는지 체크
                //: valid check (row, c)
                boolean possible=true;
                //: 퀸이 둘 수 있는지 여부를 체크하는 불리언값

                for(int i=1;i<=row-1;i++){
                    // (i, col[i])
                    if(attackable(row, c, i, col[i])) {
                        //공격가능한 위치이면
                        possible=false;
                        break;
                    }
                }
                //공격가능하지 않으면
                //즉, 한번도 possible이 false로 바뀐적 없으면
                if(possible){
                    col[row]=c;
                    rec_func(row+1);
                    col[row]=0;
                }
            }
        }
    }


    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1);
        System.out.println(ans);
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