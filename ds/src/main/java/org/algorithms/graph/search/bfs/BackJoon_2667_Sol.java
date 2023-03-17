package org.algorithms.graph.search.bfs;

import java.awt.*;
import java.util.*;
import java.util.List;

public class BackJoon_2667_Sol {
    //좌표 이동을 위한 배열 {x,y}
    static int[][] direction= {
            {-1, 0}, {1,0}, {0,-1}, {0,1}
    };

    public static void main(String[] args) {
        //삽입
        Scanner in = new Scanner(System.in);
        int N = Integer.valueOf(in.nextLine());

        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for(int i=0;i <N;i++){
            String s = in.nextLine();
            for(int j=0;j<N;j++){
                //String to Int = String -'0' : 빼지 않으면 아스키코드값이 들어간다.
                map[i][j]= s.charAt(j)-'0';
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                //방문여부를 체크하면서 탐색하야하는 집에 방문한다.
                if(visitCheck(map,visited,i,j)){
                    result.add(bfs(N, map, visited, i,j));
                }

            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        result.forEach( i-> System.out.println(i));
    }

    public static boolean visitCheck(int[][] map,  boolean[][] visited, int x, int y){
        if(map[x][y]==1 && !visited[x][y]) return true;
        else return false;
    }
    public static boolean rangeCheck(int N, int x, int y){
        if(x>=0 && x<N && y>=0 && y<N) return true;
        else return false;
    }
    public static int bfs(int N, int[][] map, boolean[][] visited, int x, int y){
        int[][] round= {{0,1},{1,0}, {-1,0},{0,-1}};
        int size=1;
        Queue<Point> q = new LinkedList<>();
        Point p = new Point(x,y);
        q.offer(p);
        visited[x][y]=true;
        while(!q.isEmpty()){
            p = q.poll();

            for(int i=0;i<4;i++){
                Point np =new Point(p.x+round[i][0],p.y+round[i][1]);
                if(rangeCheck(N, np.x,np.y) && visitCheck(map, visited, np.x,np.y)){
                    size++;
                    visited[np.x][np.y]=true;
                    q.offer(np);
                }
            }
        }
        return size;
    }
}
