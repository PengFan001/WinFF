package com.fan;


import java.util.Scanner;

public class CheerBoard {
    private static int size = 1;
    private static int Board[][] =new int[100][100];
    private static int count = 0;

    public static int input(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入残缺棋盘的阶数：");
        int num = input.nextInt();
        for(int i=0;i<num;i++)
            size = size * 2;
        return size;
    }

    public static int getSize() {
        return size;
    }

    public static int getBoard(int i, int j) {
        return Board[i][j];
    }

    public static void cover(int trow, int tcols, int drow, int dcols, int size){
        int s, t;
        if(size < 2)
            return;
        count = count + 1;
        t = count;
        s = size / 2;
        if(drow<trow+s && dcols<tcols+s){
            cover(trow,tcols,drow,dcols,s);
            Board[trow+s-1][tcols+s] = t;
            Board[trow+s][tcols+s-1] = t;
            Board[trow+s][tcols+s] = t;
            cover(trow,tcols+s,trow+s-1,tcols+s,s);
            cover(trow+s,tcols,trow+s,tcols+s-1,s);
            cover(trow+s,tcols+s,trow+s,tcols+s,s);
        }
        else if(drow<trow+s && dcols>=tcols+s){
            cover(trow,tcols+s,drow,dcols,s);
            Board[trow+s-1][tcols+s-1] = t;
            Board[trow+s][tcols+s-1] = t;
            Board[trow+s][tcols+s] = t;
            cover(trow,tcols,trow+s-1,tcols+s-1,s);
            cover(trow+s,tcols,trow+s,tcols+s-1,s);
            cover(trow+s,tcols+s,trow+s,tcols+s,s);
        }
        else if(drow>=trow+s && dcols<tcols+s){
            cover(trow+s,tcols,drow,dcols,s);
            Board[trow+s-1][tcols+s-1] = t;
            Board[trow+s-1][tcols+s] = t;
            Board[trow+s][tcols+s] = t;
            cover(trow,tcols,trow+=s-1,tcols+s-1,s);
            cover(trow,tcols+s,trow+s-1,tcols+s,s);
            cover(trow+s,tcols+s,trow+s,tcols+s,s);
        }
        else if(drow>=trow+s && dcols>=tcols+s){
            cover(trow+s,tcols+s,drow,dcols,s);
            Board[trow+s-1][tcols+s-1] = t;
            Board[trow+s-1][tcols+s] = t;
            Board[trow+s][tcols+s-1] = t;
            cover(trow,tcols,trow+s-1,tcols+s-1,s);
            cover(trow,tcols+s,trow+s-1,tcols+s,s);
            cover(trow+s,tcols,trow+s,tcols+s-1,s);
        }
    }

    public static void OutputBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(Board[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int size = input();
        Scanner input = new Scanner(System.in);
        int drow, dcols;
        System.out.println("请输入残缺的位置");
        drow = input.nextInt();
        dcols = input.nextInt();
        cover(0,0,drow,dcols,size);
        OutputBoard();
        DrawBoard draw = new DrawBoard();
    }
}
