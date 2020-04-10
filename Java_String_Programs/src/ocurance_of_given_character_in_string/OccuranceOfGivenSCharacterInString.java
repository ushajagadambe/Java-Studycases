package ocurance_of_given_character_in_string;

import java.util.Scanner;

public class OccuranceOfGivenSCharacterInString {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the string");
	String str=sc.nextLine();
	char ch[]=str.toCharArray();
	int count;
	for(int i=0;i<ch.length;i++)
	{count=1;
		for(int j=i+1;j<ch.length;j++)
		{
			if(ch[i]==ch[j]) {
			count++;
			ch[j]='@';
			}
		}
	
		if(ch[i]!='@')
		{
			
			System.out.println(ch[i]+"="+count);
		}
	}
	}

}
