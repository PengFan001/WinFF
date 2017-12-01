package fishtank;
import java.util.*;
public class FishTank {
    public static boolean Eat(int afish, int bfish){
        if(2*bfish<=afish && afish<=10*bfish)
            return true;
        else
            return false;
    }

    public static void main (String[] arg){

        int  count, minsize, maxsize, number=0;
        Scanner input = new Scanner(System.in);
        System.out.println("要放入鱼的尺寸范围1<=minsize,maxisze<=1000");
        minsize = input.nextInt();
        maxsize = input.nextInt();

        System.out.println("鱼缸原来鱼的个数");
        count = input.nextInt();
        System.out.println("鱼缸中已有鱼的大小(1<=minsize,maxsize<=1000)");
        int fishsize[] = new int[100];
       // System.out.println(fishsize.length);
        for(int i=0;i<fishsize.length;i++){
            fishsize[i] = 1000;
        }
        for(int i=0;i<count;i++){
            fishsize[i] = input.nextInt();
        }
        Arrays.sort(fishsize);
        boolean flag = true;
        for(int i=minsize;i<=maxsize;i++){
            for(int j=0;j<count;j++){
                if(Eat(i, fishsize[j]) || Eat(fishsize[j], i)){
                    flag = false;
                    break;
                }

                else{
                    flag = true;
                }
            }
            if(flag){
                fishsize[count] = i;
                System.out.print(fishsize[count]+"\t");
                number++;
            }

            count++;
        }
        System.out.println("\n能够放入鱼缸中的鱼有以上"+ number + "种");
    }
}
