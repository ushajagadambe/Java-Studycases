package arraysProgram;

import java.util.Scanner;

public class LeftRoatationOfArray {
	public int[] leftRoatation(int b[],int d)
	{
		int n=b.length;int newindex=0;
		int res[]=new int[n];
		for(int i=0;i<b.length;i++)
		{
			newindex=(i+(n-d))%n;
			res[newindex]=b[i];
		}
		return res;
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of array");
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("enter the element of array");
		for(int i=0;i<a.length;i++)
		{
			a[i]=sc.nextInt();
		}
		System.out.println("enter left raotation value");
		int d=sc.nextInt();
		LeftRoatationOfArray obj=new LeftRoatationOfArray();
		int result[]=new int[n];
		result=obj.leftRoatation(a,d );
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]);
	}

}
