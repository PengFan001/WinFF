package com.fan;

import java.util.LinkedList;
import java.util.Scanner;

public class Ring {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入小朋友的个数");
        int person = input.nextInt();
        System.out.println("请输入开始报数的人的位置(起始点)");
        int start = input.nextInt();
        System.out.println("请输入圈数");
        int end = input.nextInt();
        LinkedList list = new LinkedList();
        for(int i=0;i<person;i++)
            list.add(1);
        int m = 0, n, count = 0;
        for(int i=start-1; i<list.size();i++){
            n = (int)list.get(i);
            m = m + n;
            if(m==end){
                list.set(i, 0);
                m = 0;
                count ++;
                System.out.print(i+1+"\t");
            }
        }
        while(true){
            for(int i=0;i<list.size();i++){
                n = (int)list.get(i);
                m = m + n;
                if(m==end){
                    list.set(i, 0);
                    m = 0;
                    count ++;
                    System.out.print(i+1+"\t");
                }
            }
            if(count == person - 1)
                break;
        }

        for(int i=0;i<list.size();i++){
            n = (int)list.get(i);
            if(n==1) {
                int set = i + 1;
                System.out.println("该学生原来的位置是" + set);
            }
        }
    }
}
