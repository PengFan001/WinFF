package com.fan;

import java.util.ArrayList;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数组中元素的个数");
        int num = input.nextInt();
        int a[] = new int[num];
        System.out.println("请依次输入数组中的元素");
        for(int i=0;i<num;i++)
           a[i]= input.nextInt();
        System.out.println("请输入定值m的值");
        int m = input.nextInt();
        int n;
        for(int i=0;i<a.length - 1;i++){
            for(int j=i+1;j<a.length;j++){
               n = a[i] + a[j];
               if(n == m){
                  System.out.print(a[i] +"\t" + a[j] + "\n");
               }
            }
        }
    }
}
