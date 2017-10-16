package Project;
import java.util.*;

public class Project {
	public static void main (String[] arg){
		int number, k;
		Scanner input = new Scanner(System.in);
		System.out.println("输入魔力手环上数字的个数");
		number = input.nextInt();
		int num[] = new int[number];
		System.out.println("依次输入魔力手环中各数的值");
		for(int i=0;i<number;i++){
			num[i] = input.nextInt();
		}
		System.out.println("输入魔力手环进行变换的次数");
		k = input.nextInt();
		
		for(int i=0;i<number;i++){
			if(num[i] >= 100)
				num[i] = num[i] % 10;
		}
		for(int j=0;j<k;j++){
			for(int i=0;i<number;i++){
				if(num[i] >= 100)
					num[i] = num[i] % 100;
			}
			
			int temp = num[0];
			for(int i=0;i<number-1;i++){
				num[i] = num[i] + num[i+1];
				if(num[i] >= 100)
					num[i] = num[i] % 100;
			}
			num[number-1] = num[number-1] + temp;
			if(num[number-1] >= 100)
				num[number-1] = num[number-1] % 100;
		}
		System.out.println("经过"+k+"次魔力变换后得到魔力手环上的数值为");
		for(int i=0;i<number;i++){
			System.out.print(num[i]+"\t");
		}
	}

}
