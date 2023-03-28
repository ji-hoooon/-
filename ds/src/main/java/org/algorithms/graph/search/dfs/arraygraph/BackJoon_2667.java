package org.algorithms.graph.search.dfs.arraygraph;

import java.util.*;
//단지 번호 붙이기
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class BackJoon_2667 {
    static int n;
    static int[][] visited,arr;
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        n=in.nextInt();
        arr = new int[n][n];
        Queue<Point> raw = new LinkedList<>();
        for(int i=0;i<n;i++){
            String newtmp=in.next();
            for(int j=0;j<n;j++){
                arr[i][j]=Character.getNumericValue(newtmp.charAt(j));
                if(arr[i][j]==1) raw.offer(new Point(j,i));
            }
        }
        BackJoon_2667 backJoon2667 = new BackJoon_2667();
        ArrayList<Integer> list = backJoon2667.solution(arr,raw);
        System.out.println(list.size());
        for(int x: list) System.out.println(x);
    }
    public boolean isCheck(Point point){
        if(point.x>=0 && point.x<n&&point.y>=0&&point.y<n && arr[point.y][point.x]==1) return true;
        return false;
    }
    public boolean isVisited(Point point){
        if(visited[point.y][point.x]==1) return true;
        return false;
    }
    public ArrayList<Integer> solution(int[][] arr, Queue<Point> raw){

        int[][] round = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        visited=new int[arr.length][arr.length];
        int[][] result = new int[arr.length][arr.length];
        Queue<Point> q = new LinkedList<>();
        ArrayList<Integer> answer= new ArrayList<>();

        while(!raw.isEmpty()) {
            int cnt=0;
            q.offer(raw.poll());
            while(!q.isEmpty()) {
                Point point = q.poll();
                if (isCheck(point) && !isVisited(point)) {
                    cnt++;
                    visited[point.y][point.x] = 1;
                    result[point.y][point.x] = cnt;
                }
                for (int i = 0; i < 4; i++) {
                    Point newPoint = new Point(point.x + round[i][0], point.y + round[i][1]);
                    if (isCheck(newPoint) && !isVisited(newPoint)) {
                        cnt++;
                        q.offer(newPoint);
                        visited[newPoint.y][newPoint.x] = 1;
                        result[newPoint.y][newPoint.x] = cnt;
                    }
                }
            }
            if(cnt!=0) answer.add(cnt);
        }
        Collections.sort(answer);
        return answer;
    }
}