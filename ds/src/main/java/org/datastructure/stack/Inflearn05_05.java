package org.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class Inflearn05_05 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str = in.next();
        Inflearn05_05 main = new Inflearn05_05();
        System.out.println(main.solution(str));
    }
    public int solution(String str){
        int answer=0;
        int tmp=0;
        Stack<Character> stack = new Stack<>();
        for(char c: str.toCharArray()){
            if(c==')'&&!stack.isEmpty() && stack.peek()=='('){
                tmp--;
                answer+=tmp;
                stack.push(c);
            }else if(c==')'){
                answer++;
                tmp--;
                //System.out.println(tmp);
            }
            else{
                tmp++;
                //System.out.println(tmp);
                stack.push(c);
            }
        }
        return answer;
    }
}