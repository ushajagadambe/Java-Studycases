package numbers;

import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number");
		int number=sc.nextInt();
		int i=0,res = 0,r;
		while(number!=0)
		{
			r=number%10;
			res=(int) (res+r*Math.pow(2, i));
			number=number/10;
			i++;
		}
System.out.println("result="+res);
	}

}
