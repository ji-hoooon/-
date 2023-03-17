package org.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Inflearn05_08 {
    class Person{
        int num;
        int prior;
        Person(int num, int prior){
            this.num=num;
            this.prior=prior;
        }
    }
        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            int[]arr = new int[n];

            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            Inflearn05_08 main= new Inflearn05_08();
            System.out.println(main.solution(n,m,arr));
        }
        public int solution(int n, int m,int[]arr){
            int answer=1;
            Queue<Person> q =new LinkedList<>();
            for(int i=0;i<n;i++){
                q.offer(new Person(i,arr[i]));
            }

            e: while(!q.isEmpty()){
                Person p =q.poll();
                for(Person person : q){
                    if(person.prior>p.prior) {
                        q.offer(p);
                        continue e;
                    }
                }
                if(p.num==m) return answer;
                answer++;
            }

            return answer;
        }
    }