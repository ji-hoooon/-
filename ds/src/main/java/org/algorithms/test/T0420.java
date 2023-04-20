package org.algorithms.test;

import java.util.ArrayList;
import java.util.List;

public class T0420 {
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left=left;
            this.right=right;
        }
    }

    private static Node constructTournament(int[] winCnt, int start, int end) {
        if (start == end) {
            return new Node(start + 1);
        }

        int mid = (start + end) / 2;
        Node left = constructTournament(winCnt, start, mid);
        Node right = constructTournament(winCnt, mid + 1, end);

        if (winCnt[left.val - 1] > winCnt[right.val - 1]) {
            return new Node(left.val, left, right);
        } else {
            return new Node(right.val, left, right);
        }
    }

    private static void restoreTournament(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        restoreTournament(node.left, result);
        result.add(node.val);
        restoreTournament(node.right, result);
    }

    public static int[] solution(int n, int[] winCnt) {
        Node root = constructTournament(winCnt, 0, n - 1);
        List<Integer> result = new ArrayList<>();
        restoreTournament(root, result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] winCount = {0, 0, 2, 1};
        int[] result = solution(4, winCount);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
