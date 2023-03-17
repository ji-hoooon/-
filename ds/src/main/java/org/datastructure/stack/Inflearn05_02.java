package org.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class Inflearn05_02 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str = in.next();
        Inflearn05_02 main = new Inflearn05_02();
        System.out.println(main.solution(str));
    }
    public String solution(String str){
        String answer="";
        Stack<Character> stack = new Stack<>();
        for(char c: str.toCharArray()){
            if(c=='(') stack.push(c);
            else if(c==')'){
                while(!stack.isEmpty()&& stack.peek()!='(')
                    stack.pop();
                stack.pop();
            }
            else stack.push(c);
        }
        for(char c: stack) answer+=c;

        return answer;
    }
}