package com.nt.beans;

public class MultithreadingImpClass implements Runnable{

	@Override
	public void run() {
	Printer p=null;
	p=Printer.getInstance();
	System.out.println(p.hashCode());
		
	}

}
