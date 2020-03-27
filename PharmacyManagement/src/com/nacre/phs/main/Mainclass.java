package com.nacre.phs.main;

import java.util.Scanner;
import com.nacre.phs.adminfunctionalityImpl.*;
import com.nacre.phs.customerfunctionalityImpl.*;

public class Mainclass {
	
	public static void main(String[] args) {
		System.out.println("\t\t\t************* welcome to pharmacy Management *************");
		System.out.println("===================================================================================");
		Scanner sc=new Scanner(System.in);
		System.out.print("\t 1-Admin\n \t 2-customer\n \t 3-exit");
		System.out.print("\n enter the choice:=");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:AdminImpl ad=new AdminImpl();
		ad.login();
		break;
		case 2:CustomerImpl cusomter=new CustomerImpl();
		cusomter.firstTask();
			break;
		case 3:
			System.exit(0);
		break;
		default:System.out.println("wrong input---");
		Mainclass.main(null);
		}
		
		
		
	}
}
	
	
			

	


