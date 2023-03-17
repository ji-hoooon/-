package org.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class Inflearn05_01 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str = in.next();
        Inflearn05_01 main = new Inflearn05_01();
        System.out.println(main.solution(str));
    }
    public String solution(String str){
        Stack<Character> stack = new Stack<>();

        for(char c:str.toCharArray()){
            if(c==')'&&!stack.isEmpty() && stack.peek()=='(') stack.pop();
            else stack.push(c);
        }
        if(!stack.isEmpty()) return "NO";

        return "YES";
    }
}