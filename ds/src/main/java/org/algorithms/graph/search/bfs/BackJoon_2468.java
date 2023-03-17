package org.algorithms.graph.search.bfs;
import java.util.*;

public class BackJoon_2468 {
    static boolean[][] visited;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[][] arr  = new int[n][n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int answer=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=in.nextInt();
                min=Math.min(arr[i][j], min);
                max=Math.max(arr[i][j], max);
            }
        }
        for(;max>=0; max--){
            ArrayList<int[]> list = new ArrayList<>();
            visited= new boolean[arr.length][arr.length];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(rangeCheck(arr, i,j) && arr[i][j]>max) list.add(new int[]{i,j});
                }
            }
            answer=Math.max(answer, bfs(arr, max, visited, list));
        }
        System.out.println(answer);
    }
    static boolean isCheck(int[][] arr, boolean[][] visited,int x, int y){
        if(arr.length>x&& arr.length>y && x>=0&&y>=0 && !visited[x][y])return true;
        return false;
    }
    static boolean rangeCheck(int[][] arr, int x, int y){
        if(arr.length>x&& arr.length>y && x>=0&&y>=0)return true;
        return false;
    }
    static int bfs(int[][] arr, int max,boolean[][] visited, ArrayList<int[]> list ){
        int[][] round = {{0,1}, {1,0},{-1,0},{0,-1}};
        int cnt=0;
        Queue<int[]> q = new LinkedList<>();
        for(int[] p : list) {
            if (isCheck(arr, visited, p[0], p[1])) {
                q.offer(p);
                cnt++;
                visited[p[0]][p[1]] = true;

                while (!q.isEmpty()) {
                    p=q.poll();
                    for (int i = 0; i < 4; i++) {
                        int[] np = new int[]{p[0] + round[i][0], p[1] + round[i][1]};
                        if (isCheck(arr, visited, np[0], np[1]) && arr[np[0]][np[1]]>max) {
                            visited[np[0]][np[1]] = true;
                            q.offer(np);
                        }
                    }
                }
            }
        }

        return cnt;
    }
}
