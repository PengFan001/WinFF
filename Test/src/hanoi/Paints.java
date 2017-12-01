package hanoi;
import java.awt.*;
import javax.swing.*;

public class Paints extends JPanel{
    protected void paintComponent(Graphics g){
        int i, rectheight;
        g.drawRect(80,450,150, 5);
        g.drawRect(240,450,150,5);
        g.drawRect(400,450,150,5);
        //rectmid1 = 115;
        rectheight = 440;
        g.drawRect(Tower.rectleft, Tower.rectheight, Tower.rectright - Tower.rectleft, 9);
        for(i=0;i<=Tower.layer_one;i++)
            g.drawRect(155 - (14 - Tower.tower_one[i])*5,rectheight - 10*i, (14 - Tower.tower_one[i])*10, 10 );
        for(i=0;i<=Tower.layer_two;i++)
            g.drawRect(315 - (14 - Tower.tower_two[i])*5,rectheight - 10*i, (14 - Tower.tower_two[i])*10, 10 );
        for(i=0;i<=Tower.layer_three;i++)
            g.drawRect(475 - (14 - Tower.tower_three[i])*5,rectheight - 10*i, (14 - Tower.tower_three[i])*10, 10 );
    }
}
