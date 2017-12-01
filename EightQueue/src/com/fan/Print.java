package com.fan;

import javax.swing.*;
import java.awt.*;

public class Print extends JFrame {
    Print(){
        this.setSize(500, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    @Override
    public  void paint(Graphics g){
        g.clearRect(50, 50, 400, 400);
        g.drawRect(50, 50,400,400);
        for(int i=0;i<8;i++){
                g.drawLine(50*i+50, 50, 50*i+50, 450);
                g.drawLine(50, 50*i+50, 450, 50*i+50);
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(cheer.getPosition(i) == j)
                    g.fillRect(50*i+50, 50*j+50, 50, 50);
            }
        }
    }
}
