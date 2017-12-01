package com.fan;

import java.util.Scanner;

public class Simplify {

    public static void judge(StringBuffer str){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '('){
                char c = str.charAt(i-1);
                if(c == '+'){
                    str.setCharAt(i,' ');
                    str.setCharAt(i+4, ' ');
                }
                if(c == '-'){
                    if(str.charAt(i+2) == '+')
                        str.setCharAt(i+2, '-');
                    else if(str.charAt(i+2) == '-')
                        str.setCharAt(i+2, '+');
                    str.setCharAt(i,' ');
                    str.setCharAt(i+4, ' ');
                }
            }
        }
    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入表达式");
        StringBuffer str = new StringBuffer(input.nextLine());
        judge(str);
        System.out.println(str);
    }
}
