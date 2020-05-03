package com.nt.beans;

public class Printer2 {
	private static Printer2 Instance;
	private Printer2()
	{
		System.out.println("private constructor");
	}
	
	public static Printer2 getInstance()
	{
		if(Instance==null)
			synchronized (Printer.class) {
				if(Instance==null)
					Instance=new Printer2();
			}
		return Instance;
		
	}
}
