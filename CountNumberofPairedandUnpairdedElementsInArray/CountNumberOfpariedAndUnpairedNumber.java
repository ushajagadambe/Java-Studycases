package arraysProgram;

import java.util.Scanner;

public class CountNumberOfpariedAndUnpairedNumber {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the size of array");
	int n=sc.nextInt();

	int a[]=new int[n];
	System.out.println("enter the array elements");
	for(int i=0;i<a.length;i++)
		a[i]=sc.nextInt();
	int nupair=0,paired=0;
	for(int i=0;i<a.length;i++)
	{
		int count=1;
		for(int j=i+1;j<a.length;j++)
		{
			if(a[i]==a[j])
				{count++;
				a[j]='@';
				}
				}
		if(a[i]!='@')
		{
			if(count%2!=0)
			  nupair++;
                       else
                          paired++;
			
		}
	
	}
	System.out.println("nupaired element="+nupair+"paired elements="+paired);
}
}
