package org.algorithms.graph.search.bfs;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] startPositions=new int[n];
        int[] goalPositions=new int[n];
        for(int i=0;i<n;i++){
            startPositions[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
            goalPositions[i]=in.nextInt();
        }
        LadderGame ladderGame=new LadderGame(startPositions,goalPositions);
        System.out.println(ladderGame.getMinNumOfLadders());
    }

        public static class LadderGame {

            private int[] goalPositions;
            private int[] startPositions;
            private boolean[][] ladders;
            private int numOfLadders;

            public LadderGame(int[] startPositions, int[] goalPositions) {
                this.startPositions = startPositions;
                this.goalPositions = goalPositions;
                this.ladders = new boolean[startPositions.length-1][goalPositions.length];
                this.numOfLadders = 0;
            }

            public void addLadder(int i, int j) {
                ladders[i][j] = true;
                numOfLadders++;
            }

            public void removeLadder(int i, int j) {
                ladders[i][j] = false;
                numOfLadders--;
            }

            public boolean canSolve() {
                // 모든 출발점에 대해서 가능한지 확인한다.
                for(int i=0; i<startPositions.length; i++) {
                    if(!solve(startPositions[i], goalPositions[i])) {
                        return false;
                    }
                }
                return true;
            }

            public boolean solve(int start, int goal) {
                int curPos = start;
                for(int i=0; i<goalPositions.length; i++) {
                    // 현재 위치가 목표 위치에 도달하면 true를 반환한다.
                    if(curPos == goal) {
                        return true;
                    }
                    // 오른쪽으로 이동할 수 있는 경우
                    if(curPos < goalPositions.length-1 && ladders[curPos][i]) {
                        curPos++;
                    }
                    // 왼쪽으로 이동할 수 있는 경우
                    else if(curPos > 0 && ladders[curPos-1][i]) {
                        curPos--;
                    }
                }
                // 목표 위치에 도달하지 못하면 false를 반환한다.
                return false;
            }

            public int getMinNumOfLadders() {
                int minNumOfLadders = Integer.MAX_VALUE;

                // 가능한 모든 가로줄 조합을 생성하고, 해를 찾는다.
                for(int i=0; i<startPositions.length-1; i++) {
                    for(int j=0; j<goalPositions.length; j++) {
                        // 현재 위치에 이미 가로줄이 있는 경우
                        if(ladders[i][j] || (i > 0 && ladders[i-1][j]) || (i < startPositions.length-2 && ladders[i+1][j])) {
                            continue;
                        }

                        // 현재 위치에 가로줄을 추가한다.
                        addLadder(i, j);

                        // 현재 추가한 가로줄이 유효한 경우
                        if(canSolve()) {
                            minNumOfLadders = Math.min(minNumOfLadders, numOfLadders);
                        }

                        // 현재 위치에 추가한 가로줄을 제거한다.
                        removeLadder(i, j);
                    }
                }

                // 해가 없는 경우
                if(minNumOfLadders == Integer.MAX_VALUE) {
                    return -1;
                }

                // 최소 가로줄 개수 반환
                return minNumOfLadders;
            }
        }
}