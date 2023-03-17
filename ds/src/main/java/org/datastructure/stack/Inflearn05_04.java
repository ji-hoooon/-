package org.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class Inflearn05_04 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str = in.next();
        Inflearn05_04 main = new Inflearn05_04();
        System.out.println(main.solution(str));
    }
    public int solution(String str){
        Stack<Integer> stack = new Stack<>();
        for(char c: str.toCharArray()){
            if(c=='+'){
                int c1=stack.pop();
                int c2=stack.pop();
                stack.push(c2+c1);
            }
            else if(c=='-'){
                int c1=stack.pop();
                int c2=stack.pop();
                stack.push(c2-c1);
            }
            else if(c=='*'){
                int c1=stack.pop();
                int c2=stack.pop();
                stack.push(c2*c1);
            }
            else if(c=='/'){
                int c1=stack.pop();
                int c2=stack.pop();
                stack.push(c2/c1);
            }
            else {

                stack.push(Character.getNumericValue(c));
            }
        }

        return stack.pop();
    }
}