package com.fan;
import java.util.Scanner;

public class Distance {
    public static int partition(int[] a, int low, int high){
        int key = a[low];
        while(low<high){
            while(a[high]>=key && high>low)
                high--;
            a[low]=a[high];
            while(a[low]<=key && low<high)
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

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数组的长度");
        int num = input.nextInt();
        int a[] = new int[num];
        System.out.println("请依次输入数组中的值");
        for(int i=0;i<num;i++)
            a[i] = input.nextInt();
        int distance[] = new int[num-1];
        for(int i=1;i<num;i++)
            distance[i-1] = Math.abs(a[i]-a[i-1]);
        sort(distance, 0, num-2);
        System.out.println(distance[0]);

    }
}
