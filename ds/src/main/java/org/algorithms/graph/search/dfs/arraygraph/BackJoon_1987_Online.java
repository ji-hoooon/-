package org.algorithms.graph.search.dfs.arraygraph;

import java.util.Scanner;

public class BackJoon_1987_Online {
        //세로, 가로 필수
        static int R, C;
        static char[][]board;
        static int[] dx = {-1,0,1,0};
        static int[] dy = {0,1,0,-1};
        static int max=Integer.MIN_VALUE;
        static boolean[] visited = new boolean[26];
        //A-'A' = 0
        //: 아스키코드로 바뀌기 때문에

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            R=sc.nextInt();
            C=sc.nextInt();
            board = new char[R][C];
            for(int i=0;i<R;i++){
                String s=sc.nextLine();
                board[i]=s.toCharArray();
            }
            //초기값
            dfs(0,0,1);
            System.out.println(max);
        }
        public static void dfs(int x, int y, int count){
            visited[board[x][y] - 'A'] = true;
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=0 && ny>=0 && nx<C&& ny<R&&!visited[board[nx][ny]-'A']){
                    dfs(nx,ny,count++);
                }

            }
            visited[board[x][y]-'A']=false;
            max=Math.max(count,max);
        }
    }