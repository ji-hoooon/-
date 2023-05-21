package org.test.test1.test1_1;

import java.util.Scanner;

public class BackJoon_20164_solved1 {
    static int N, MAX, MIN;

    //각 자리수의 홀수의 개수 찾기
    //:최소와 최대는, 세자리수 이상일 때 위치를 나누는 방법에 따라 달라진다.
    static void pro() {
        int sum = 0;
        for (int k = 1; k < String.valueOf(N).length(); k++) {
            if (String.valueOf(N).charAt(k) % 2 != 0) sum++;
        }
        dfs(N, sum);
        System.out.println(MIN + " " + MAX);
    }

    static int count(int number, int oddCnt) {
        int tmp = 0;
        for (int k = 0; k < String.valueOf(number).length(); k++) {
            if (String.valueOf(number).charAt(k) % 2 != 0) tmp++;
        }
        return oddCnt + tmp;
    }

    static void dfs(int number, int oddCnt) {

        if (number < 10) {
            MAX = Math.max(oddCnt, MAX);
            MIN = Math.min(oddCnt, MIN);
            return;
        }

        if (number < 100) {
            String str = String.valueOf(number);
            int part1 = Integer.parseInt(String.valueOf(str.charAt(0)));
            int part2 = Integer.parseInt(String.valueOf(str.charAt(1)));

            int sum = part1 + part2;

            dfs(sum, count(sum, oddCnt));
            return;
        }
        //수가 세 자리 이상이면 임의의 위치에서 끊어서 3개의 수로 분할하고,
        // 3개를 더한 값을 새로운 수로 생각한다.
        String str = String.valueOf(number);
        int len = str.length();

        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int part1 = Integer.parseInt(str.substring(0, i));
                int part2 = Integer.parseInt(str.substring(i, j));
                int part3 = Integer.parseInt(str.substring(j));

                int sum = part1 + part2 + part3;
                dfs(sum, count(sum, oddCnt));
            }
        }
    }

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        MAX = Integer.MIN_VALUE;
        MIN = Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}