package org.algorithms.search.twopointers.twopointer_advanced;

import java.util.Arrays;
import java.util.Scanner;
//좋다
// : L을 먼저 이동해서 고정시키고, R을 이동시킨다.

public class BackJoon_1253_old {
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int p1 = 0;
            int p2 = arr.length - 1;

            while (p1 < p2) {
                int sum = arr[p1] + arr[p2];

                if (sum == arr[i]) {
                    if (i != p1 && i != p2) {
                        answer++;
                        break;
                    }

                    //같은 경우를 제외하므로, 증감 조건 분리해야한다.
                    else if (p1 == i) {
                        p1++;
                    } else if (p2 == i) {
                        p2--;
                    }
                } else if (sum > arr[i]) {
                    p2--;
                } else {
                    p1++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        BackJoon_1253_old T = new BackJoon_1253_old();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = kb.nextInt();
        System.out.println(T.solution(arr));
    }

}
