package com.nt.main;

import com.nt.beans.MultithreadingImpClass;
import com.nt.beans.MultithreadingImpClass2;

public class PrinterTest2 {
public static void main(String[] args) {
	MultithreadingImpClass2 p=null;
	Thread t1=null;
	Thread t2=null;
p=new MultithreadingImpClass2();
	t1=new Thread(p);
	t2=new Thread(p);
	t1.start();
	t2.start();
}
}
