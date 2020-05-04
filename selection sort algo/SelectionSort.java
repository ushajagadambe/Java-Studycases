package arraysProgram;

import java.util.Scanner;

public class SelectionSort {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the size of array");
	int n=sc.nextInt();
	int a[]=new int[n];
	System.out.println("enter the element of array");
	for(int i=0;i<n;i++)
		a[i]=sc.nextInt();
	int min=0,temp=0;
	for(int i=0;i<n;i++)
	{
		min=i;
		for(int j=i+1;j<n;j++)
		{
			if(a[j]<a[min])
				min=j;
		}
		temp=a[min];
		a[min]=a[i];
		a[i]=temp;
	}
	System.out.println("element after sort");
	for(int i=0;i<n;i++)
	{
		System.out.println(a[i]);
	}
}
}
