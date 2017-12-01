package com.fan;

import java.util.Scanner;

public class nn {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入矩阵的阶数");
        int number = input.nextInt();
        int elem = 1;
        int a[][] = new int[number][number];
        for(int i=0;i<number;i++)
            for(int j=0;j<number;j++)
                a[i][j] = 0;
        for(int i=0;i<((number+1)/2);i++){
            for(int j=0;j<number;j++)
                if(a[j][i] == 0)
                    a[j][i] = elem;
            for(int j=0;j<number;j++)
                if(a[number-1-i][j] == 0)
                    a[number-1-i][j] = elem;
            for(int j=0;j<number;j++)
                if(a[number-1-j][number-1-i] == 0)
                    a[number-1-j][number-1-i] = elem;
            for(int j=0;j<number;j++)
                if(a[i][j] == 0)
                    a[i][j] = elem;
            elem++;
        }

        for(int i=0;i<number;i++){
            System.out.println();
            for(int j=0;j<number;j++){
                System.out.print(a[i][j]+"\t");
            }
        }
    }
}
