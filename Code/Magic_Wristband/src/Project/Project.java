package Project;
import java.util.*;

public class Project {
	public static void main (String[] arg){
		int number, k;
		Scanner input = new Scanner(System.in);
		System.out.println("����ħ���ֻ������ֵĸ���");
		number = input.nextInt();
		int num[] = new int[number];
		System.out.println("��������ħ���ֻ��и�����ֵ");
		for(int i=0;i<number;i++){
			num[i] = input.nextInt();
		}
		System.out.println("����ħ���ֻ����б任�Ĵ���");
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
		System.out.println("����"+k+"��ħ���任��õ�ħ���ֻ��ϵ���ֵΪ");
		for(int i=0;i<number;i++){
			System.out.print(num[i]+"\t");
		}
	}

}
