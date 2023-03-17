package org.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Inflearn05_07 {

        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            String str = in.next();
            String s= in.next();
            Inflearn05_07 main = new Inflearn05_07();
            System.out.println(main.solution(str, s));
        }
        public String solution(String str, String s){
            Queue<Character> q1 = new LinkedList<>();
            for(char c: str.toCharArray()){
                q1.offer(c);
            }
            for(char c:s.toCharArray()){
                if(q1.isEmpty()) return "YES";
                else if(c!=q1.peek() && q1.contains(c)){
                    return "NO";
                }else if(c==q1.peek()){
                    q1.poll();
                }
            }

            if(!q1.isEmpty()) return "NO";

            return "YES";
        }
    }