package com.fan;

import java.util.Scanner;

public class SecMax {

    public static int SecMax(int a[], int low, int high, int max[]){
        if(low == high)
            max[0] = a[low];
        else if(low == high-1)
            if(a[low] > a[high])
                max[0] = a[low];
            else
                max[0] = a[high];
        else{
            int mid = (low+high)/2;
            int lmax[] = {0};
            int rmax[] = {0};
            SecMax(a,low,mid,lmax);
            SecMax(a,mid+1,high,rmax);
            if(lmax[0]>rmax[0])
                max[0] = lmax[0];
            else
                max[0] = rmax[0];
        }

        return max[0];
    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数组的长度");
        int number = input.nextInt();
        int a[] = new int[number];
        int max[] = new int[1];
        max[0] = 0;
        System.out.println("请依次输入数组的值");
        for(int i=0;i<number;i++)
            a[i] = input.nextInt();
        int Max = SecMax(a,0,number-1,max);
        for(int i=0;i<number;i++){
            if(a[i] == Max){
                int temp = a[number-1];
                a[number-1] = a[i];
                a[i] = temp;
            }
        }
        max[0] = 0;
        Max = SecMax(a,0,number-2,max);
        System.out.println("该数组中第二大的元素是"+Max);
    }
}
