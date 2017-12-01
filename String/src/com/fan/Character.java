package com.fan;

import java.util.Scanner;

public class Character {

    public  static boolean Judgement(String str, int length, int i){
        boolean flag = true;
        if(length<0)
            return flag;
        else{
            while(length >= 0) {
                if(str.charAt(i) == str.charAt(length)){
                    flag = true;
                    length--;
                    i++;
                    Judgement(str, length, i);
                }
                else{
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        String s;
        int i=0;
        System.out.println("请输入要判断的字符串");
        s = input.nextLine();
        System.out.println(Judgement(s, s.length()-1, i));
    }
}
