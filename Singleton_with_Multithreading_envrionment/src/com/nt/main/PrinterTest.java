package com.nt.main;

import com.nt.beans.MultithreadingImpClass;
import com.nt.beans.Printer;

public class PrinterTest {
public static void main(String[] args) {
	MultithreadingImpClass p=null;
	Thread t1=null;
	Thread t2=null;
p=new MultithreadingImpClass();
	t1=new Thread(p);
	t2=new Thread(p);
	t1.start();
	t2.start();
}
}
