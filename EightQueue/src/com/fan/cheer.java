//8皇后问题。在国际棋盘上放8个皇后，国际象棋共有8行8列，皇后可以吃掉与之同行同列以及同一对角线山的其他皇后。
// 为让他们共存，请编写算法找出各种放置方法。请用图形界面展示皇后的排列结果。

package com.fan;

public class cheer {
    private static int size = 8;
    private static int count = 1;
    private static int position[] = new int[size];
    private  static Print p = new Print();

    public static int getSize() {
        return size;
    }

    public static int getPosition(int i) {
        return position[i];
    }

    public  static void eightqueue(int row){
        int set, nextset;
        boolean flag = true;
        if(row == size){
            printcheer();
            return;
        }
        for(set=0;set<size;set++){
            position[row] = set;
            flag = true;
            for(nextset=0;nextset<row;nextset++){
                if(position[row] == position[nextset] || Math.abs(position[row] - position[nextset]) == (row - nextset))
                    flag = false;
            }
            if(flag)
                eightqueue(row+1);
        }
    }

    private static void printcheer(){
        try{
            p.repaint();
            Thread.currentThread().sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        eightqueue(0);
    }
}
