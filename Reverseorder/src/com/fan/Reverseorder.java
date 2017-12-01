package com.fan;

import java.util.Scanner;

public class Reverseorder {
    public static int sum=0;

    public static int  Reverse(int a[],int low, int high, boolean flag[]){
        if(low==high)
            flag[0] = false;
        else if(low == high-1)
            if(a[low]>a[high])
                flag[0] = true;
            else
                flag[0] = false;
        else{
            int mid=(low+high)/2;
            boolean lflag[] = {false};
            boolean rflag[] = {false};
            Reverse(a,low,mid,lflag);
            Reverse(a,mid,high,rflag);
            if(lflag[0])
                sum++;
            if(rflag[0])
                sum++;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数组元素的个数");
        int number = input.nextInt();
        int a[] = new int[number];
        System.out.println("请依次输入数组元素");
        for(int i=0;i<number;i++)
            a[i] = input.nextInt();
        boolean flag[] = {false};
        System.out.println("该数组中含有的逆序数对是"+Reverse(a,0,number-1,flag));
    }
}
