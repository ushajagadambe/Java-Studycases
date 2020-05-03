package com.nt.beans;

public class Printer {
private static Printer Instance;
private Printer()
{
	System.out.println("private constructor");
}

  public static Printer getInstance() { 
  if(Instance==null) { Instance=new
  Printer(); } return Instance; }
  
 

}
