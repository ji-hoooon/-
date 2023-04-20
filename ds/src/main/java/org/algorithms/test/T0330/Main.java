package org.algorithms.test.T0330;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<String> splitByRepeatedChar(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            result.add("");
            result.add("");
            return result;
        }

        char prev = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(prev);
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == prev) {
                sb.append(curr);
            } else {
                result.add(sb.toString());
                sb = new StringBuilder();
                sb.append(curr);
                prev = curr;
            }
        }
        result.add(sb.toString());

        if (result.size() == 1) {
            result.add("");
        } else if (result.get(0).isEmpty()) {
            result.add(0, "");
        }

        if (result.get(result.size() - 1).isEmpty()) {
            result.add("");
        }

        return result;
    }


    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "aabcdddefggg";
        String s3 = "aabbb";
        String s4 = "pizza";
        String s5 = "abyyy";
        String s6 = "kkkkkkk";

        System.out.println(splitByRepeatedChar(s1)); // [a, b, c, d, e]
        System.out.println(splitByRepeatedChar(s2)); // [, bc, ef, ]
        System.out.println(splitByRepeatedChar(s3)); // [, ]
        System.out.println(splitByRepeatedChar(s4)); // [pi, a]
        System.out.println(splitByRepeatedChar(s5)); // [ab, ]
        System.out.println(splitByRepeatedChar(s6)); // [, ]

    }

}
