package com.fan;

import javax.swing.*;
import java.awt.*;

public class DrawBoard extends JFrame{
    private  static int size = CheerBoard.getSize();


    DrawBoard(){
        this.setSize(500,500);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    @Override
    public  void paint(Graphics g){
        g.clearRect(250-25*size,250-25*size,(250+25*size)-(250-25*size),(250+25*size)-(250-25*size));
        g.drawRect(250-25*size,250-25*size,(250+25*size)-(250-25*size),(250+25*size)-(250-25*size));
        for(int i=0;i<size;i++){
            g.drawLine((500-25*size)/2+50*i, 250-25*size, (500-25*size)/2+50*i, 250+25*size);
            g.drawLine(250-25*size, (500-25*size)/2+50*i, 250+25*size,(500-25*size)/2+50*i);
        }

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
               if(CheerBoard.getBoard(i,j)==0)
                   g.fillRect(250-25*size+50*j, 250-25*size+50*i,50, 50 );
            }
        }
    }
}
