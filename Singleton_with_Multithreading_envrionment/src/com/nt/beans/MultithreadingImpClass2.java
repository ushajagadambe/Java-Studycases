package com.nt.beans;

public class MultithreadingImpClass2 implements Runnable{

	@Override
	public void run() {
	Printer2 p=null;
	p=Printer2.getInstance();
	System.out.println(p.hashCode());
		
	}

}
