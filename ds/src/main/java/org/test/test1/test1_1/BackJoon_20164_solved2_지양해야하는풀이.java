package org.test.test1.test1_1;

import java.util.*;

public class BackJoon_20164_solved2_지양해야하는풀이 {
    static int N, MIN, MAX;

    static int count(int number, int oddCount) {
        int res=0;
        for (int i = 0; i < String.valueOf(number).length(); i++) {
            if (String.valueOf(number).charAt(i) % 2 != 0) res++;
        }
        return res+oddCount;
    }
    static void pro() {
        dfs(N, count(N,0));
        System.out.println(MIN + " " + MAX);
    }

    static void dfs(int number, int oddCount) {
        if (number < 10) {
            MAX = Math.max(MAX, oddCount);
            MIN = Math.min(MIN, oddCount);
            return;
        }
        if (number < 100) {
            String str = String.valueOf(number);
            int part1 = Integer.parseInt(String.valueOf(str.charAt(0)));
            int part2 = Integer.parseInt(String.valueOf(str.charAt(1)));
            number = part1 + part2;
            oddCount = count(number, oddCount);
//            dfs(number, count(number)+oddCount);
            dfs(number, oddCount);
            return;
        }
        String str = String.valueOf(number);
        int len = str.length();
        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int part1 = Integer.valueOf(str.substring(0, i));
                int part2 = Integer.valueOf(str.substring(i, j));
                int part3 = Integer.valueOf(str.substring(j));
                int sum = part1 + part2 + part3;

                dfs(sum, count(sum, oddCount));
            }
        }
    }

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        MIN = Integer.MAX_VALUE;
        MAX = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
