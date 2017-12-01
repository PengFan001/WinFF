//54张扑克牌，2个人轮流拿牌，每人每次最少取1张，最多取4张，谁拿最后一张谁输。编写模拟计算机先拿牌且必胜的算法。

package com.fan;

import java.util.Scanner;

public class Poke {

    public static int take(int poke){
        Scanner input = new Scanner(System.in);
        System.out.println("请你拿牌(最少一张，最多4张)");
        int num = input.nextInt();
        int cnum = 5 - num;
        if(num == 1 && poke == 1)
            System.out.println("你输了");
        if(cnum == 1 && poke == 1)
            System.out.println("你赢了");
        poke = poke - num;
        poke = poke - cnum;
        if(poke > 0) {
            System.out.println("此轮拿牌情况");
            System.out.print("你拿牌张数" + num + "\t" + "电脑拿牌张数" + cnum + "\t");
            System.out.print("剩余张数" + poke + "\n");
        }
        return poke;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int poke = 54;
        System.out.println("游戏开始，牌的张数" + poke);
        poke = poke - 3;
        System.out.println("电脑先拿3张，还剩" + poke);
        while(poke > 0){
            poke = take(poke);
        }
    }
}
