package com.fan;
import java.util.*;

public class Shoot {

    public static void shooting(int number, int score, int grade, int[] sort){
        if(number == 0)
            return;
        for(int i=0; i<11;i++){
            //grade = grade + i;
            int t = grade;
            grade = grade + i;
            sort[number-1] = i;
            shooting(number-1, score, grade, sort);
            if(grade == score){
                System.out.println();
                for(int j=0;j<sort.length;j++)
                    System.out.print(sort[j]+"\t");
            }
            grade = t;
        }
    }

    public static void main (String[] args){
        int grade=0;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你要射击的枪数");
        int number = input.nextInt();
        int sort[] = new int[number];
        //int grade[] = new int[number];
        System.out.println("请输入击中的环数");
        int score = input.nextInt();
        shooting(number, score, grade, sort);
    }
}
