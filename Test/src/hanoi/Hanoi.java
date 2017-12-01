package hanoi;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;


public class Hanoi extends JFrame implements Runnable{

    public Thread thread1 = new Thread(this);
    public void Hanoi(){
        System.out.println("yes");
        init();
        System.out.println("yes");
        add(new Paints());
        System.out.println("yes");
        input();
        System.out.println("yes");
        thread1.start();
        System.out.println("yes");
    }

    public void init(){
        for(int i=0;i<Tower.tower_one.length;i++)
            Tower.tower_one[i] = i;
        for(int i=0;i<Tower.tower_two.length;i++)
            Tower.tower_two[i] = i;
        for(int i=0;i<Tower.tower_three.length;i++)
            Tower.tower_three[i] = i;
    }

    public void input(){
        String str = JOptionPane.showInputDialog("输入汉诺塔盘子的个数(盘子的个数在一个和二十个之间)");
        int number = (int)Float.parseFloat(str);
        if(number >= 1 && number <= 20){
            Tower.n = number;
            Tower.layer_one = number - 1;
            System.out.println(Tower.n);
        }
        else{
            JOptionPane.showInputDialog("请输入一到二十之间的整数");
            System.exit(0);
        }
    }

    public void moves(int tower_a, int tower_b){
        //moveobject表示要tower_a中要移动盘子的个数
        switch(tower_a){
            case 1: Tower.rectmid = 155; Tower.tower = Tower.tower_one; Tower.moveobject = Tower.layer_one; Tower.layer_one--; break;
            case 2: Tower.rectmid = 315; Tower.tower = Tower.tower_two; Tower.moveobject = Tower.layer_two; Tower.layer_two--; break;
            case 3: Tower.rectmid = 475; Tower.tower = Tower.tower_three; Tower.moveobject = Tower.layer_three; Tower.layer_three--; break;
        }

        //moveobjectto表示移动到tower_b上盘子的个数
        switch(tower_b){
            case 1: Tower.midtower_mid = 155; Tower.movobjectto = Tower.layer_one; break;
            case 2: Tower.midtower_mid = 315; Tower.movobjectto = Tower.layer_two; break;
            case 3: Tower.midtower_mid = 475; Tower.movobjectto = Tower.layer_three; break;
        }

        if(tower_a >= tower_b)
            Tower.bool = true;
        else
            Tower.bool = false;
        //得出盘子的左右坐标额要移动盘子的高度（即y轴坐标）
        Tower.rectleft = Tower.rectmid - (14 - Tower.tower[Tower.moveobject]) * 5;
        Tower.rectright = Tower.rectmid + (14 - Tower.tower[Tower.moveobject]) * 5;
        Tower.rectheight = 440 - Tower.moveobject * 5;

        //将要移动的盘子先向上移动
        while(Tower.rectheight >= 200){
            Tower.rectheight = Tower.rectheight - 10;
            repaint();
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        //将盘子移动到第二个塔上
        while(Tower.rectmid != Tower.midtower_mid){
            if(Tower.bool){
                Tower.rectmid = Tower.rectmid - 5;
                Tower.rectleft = Tower.rectmid - (14 - Tower.tower[Tower.moveobject]) * 5;
                Tower.rectright = Tower.rectmid + (14 - Tower.tower[Tower.moveobject]) * 5;
                repaint();
                try{
                    Thread.sleep(50);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            else{
                Tower.rectmid = Tower.rectmid + 5;
                Tower.rectleft = Tower.rectmid - (14 - Tower.tower[Tower.moveobject]) * 5;
                Tower.rectright = Tower.rectmid + (14 - Tower.tower[Tower.moveobject]) * 5;
                repaint();
                try{
                    Thread.sleep(50);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

        while(Tower.rectheight <= (430 - (Tower.movobjectto) * 5)){
            Tower.rectheight = Tower.rectheight + 10;
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            repaint();
        }

        switch(tower_b){
            case 1: Tower.layer_one++; Tower.tower_one[Tower.layer_one] = Tower.tower[Tower.moveobject]; repaint(); break;
            case 2: Tower.layer_two++; Tower.tower_two[Tower.layer_two] = Tower.tower[Tower.moveobject]; repaint(); break;
            case 3: Tower.layer_three++; Tower.tower_three[Tower.layer_three] = Tower.tower[Tower.moveobject]; repaint(); break;
        }
    }

    public void hanoi(int n, int one, int two, int three){
        if(n==1)
            moves(one, three);
        else{
            hanoi(n-1,one, three, two);
            moves(one, three);
            hanoi(n-1,two, one, three);
        }
    }

    public void run(){
        hanoi(Tower.n, 1, 2, 3);
    }

    public static void main(String[] args){
        Hanoi T = new Hanoi();
        T.Hanoi();

        T.setLocationRelativeTo(null);
        T.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        T.setSize(660, 550);
        T.setTitle("汉诺塔");
        T.setVisible(true);
        T.setResizable(false);
    }
}
