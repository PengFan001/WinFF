package changenumber;
import java.util.*;
public class ChangeNumber {
    public static void main (String[] arg){
        int number, count=0, i=0;
        Scanner input = new Scanner(System.in);
        System.out.println("输入一个整数");
        number = input.nextInt();
        int num[] = new int[100];
        while(number > 10){
            do{
                num[i] = number % 10;
                i++;
                number = number / 10;
            }while(number%10!=number);
            for(int j=0;j<i;j++){
                number = num[j] * number;
            }
            count++;
        }
        System.out.println("该整数经过"+count+"次变成一个个位数");
    }

}
