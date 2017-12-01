package com.fan;

import java.util.Scanner;

public class nlogn {
    public static int partition(int[] a, int low, int high){
        int key = a[low];
        while(low<high){
            while(a[high]>key && high>low)
                high--;
            a[low]=a[high];
            while(a[low]<key && low<high)
                low++;
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }
    public static void sort(int[] a, int low, int high){
        if(low<high) {
            int key = partition(a, low, high);
            sort(a, low, key - 1);
            sort(a, key + 1, high);
        }
    }

    public static void equle(int[] a, int sum){
        int i=0,j=a.length-1;
        while(i<j){
            int key = sum - (a[i] + a[j]);
            if(key>0)
                i++;
            else if (key==0) {
                System.out.print(a[i] + "\t" + a[j] + "\n");
                i++;
            }
            else
                j--;
        }
    }

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数组的长度");
        int length = input.nextInt();
        int a[] = new int[length];
        System.out.println("请依次输入数组的值");
        for(int i=0;i<length;i++)
            a[i] = input.nextInt();
        sort(a, 0, length-1);
        System.out.println("请输入定值m的值");
        int m = input.nextInt();
        equle(a, m);
    }
}
