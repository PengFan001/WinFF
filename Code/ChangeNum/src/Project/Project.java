package Project;
import java.util.*;

public class Project {

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
		System.out.println("该数转换"+count+"次后变成个位数");
	}
}
