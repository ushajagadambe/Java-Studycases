package com.nacre.phs.adminfunctionalityImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.concurrent.*;
import java.util.Map;
import java.util.Scanner;
import com.nacre.phs.adminfunctionalityI.*;
import com.nacre.phs.customerfunctionalityImpl.CustomerImpl;
import com.nacre.phs.dto.MedicineDto;
import com.nacre.phs.exceptions.MedicianOutOfStockException;
import com.nacre.phs.exceptions.NoSuchMediCineExitException;
import com.nacre.phs.main.Mainclass;
public class AdminImpl implements AdminI{
	Scanner sc=new Scanner(System.in);
	
	public static Map<String,MedicineDto> medicineList=new ConcurrentHashMap<String,MedicineDto>();

   void adminTask()
   {
	  
	   System.out.println("\t 1-add medicine\n \t 2-romove medicine \n \t 3-view medicine in stock"
				+ "\n \t 4-view order from customer\n \t 5-logout\n \t 6-exits");
	   System.out.print("enter the choice:=");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:addMedicine();
		adminTask();
		break;
		case 2:removeMedicine();
		adminTask();
		break;
		case 3:viewMedicianInStock();
		adminTask();
		break;
		case 4:viewOrederFromCustomer();
		adminTask();
		break;
		case 5:logout();
		Mainclass.main(null);
		break;
		case 6:
		Mainclass.main(null);
		break;
		default:
			System.out.println("wrong input");
			adminTask();
		}
		 }
	
	public void login()  
	{
	String name=null;
	String pass=null;
	String uname=null,upass=null;
		
			System.out.print("\t enter the Adimn Name:= ");
			uname=sc.next();
			System.out.print("\t enter the password=");
			upass=sc.next();
			//System.out.println("user input\n");
			//System.out.println(uname+" "+upass);
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "usha");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from Admin");
		while(rs.next()) {
		name=rs.getString(1);
		pass=rs.getString(2);
		//System.out.println(name+" "+pass);
		if(name.equals(uname)&pass.equals(upass))
		{
		  System.out.println("Login Successfull.....");
		  System.out.println("-----welocome to admin----");
		  adminTask();
		  
		}
		else {
			  System.out.println("login failed plz. try again");
			  login();
		  }
		}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	  }
	  
		
	
		 
		 
	


	@Override
	public void addMedicine() {
		
		System.out.println("how many medicine u have to enter:=");
		int len=sc.nextInt();
	 for(int i=0;i<len;i++)
	 	{
		 MedicineDto mdto=new MedicineDto();
	 	int newqua=0;
	 	 
		System.out.println("enter the name");
		String name=sc.next();
		mdto.SetName(name);		
System.out.println("enter the manifactured  date");
		mdto.setEd(sc.next());
		System.out.println("enter the expairy date");
		mdto.setEd(sc.next());
		System.out.println("enter the power of medicine");
		mdto.setPower(sc.nextInt());
		System.out.println("enter the comapnay");
		mdto.setCompany(sc.next());
	 	
	 
		for(Map.Entry<String,MedicineDto> entery:medicineList.entrySet())
		{
			MedicineDto m=entery.getValue();
			if(m.getName().equals(name))
			{
				newqua=m.getQunatity();
			}
		}
		
		
		System.out.println("enter the qunatity");
		int newq=sc.nextInt();
		 mdto.setQunatity(newq+newqua);
		medicineList.put(name,mdto);
		System.out.println("medicine added successfully");
		
	
	 	}
		
	}

	@Override
	public synchronized void removeMedicine() {
		
		System.out.println("enter the name of medicine");
		String name=sc.next();
		
		int count=0;
		for(Map.Entry<String,MedicineDto> entery:medicineList.entrySet())
		{
			MedicineDto m=entery.getValue();
			if(m.getName().equals(name))
			{
				System.out.println("medicine removed");
				medicineList.remove(name, m);
				count++;
			}
		}
		if(count==0) {
			
		try {
			throw new NoSuchMediCineExitException("no such medicine exits");
		}catch(NoSuchMediCineExitException e)
		{
			e.printStackTrace();
		}
		
	}
	}

	@Override
	public void viewOrederFromCustomer() {
		CustomerImpl obj=new CustomerImpl();
		obj.viewOrder();
	}

	@Override
	public void viewMedicianInStock() {
		if(medicineList.isEmpty())
		{
		System.out.println("no medicines available");
		}
		else
		{
			for(Map.Entry<String,MedicineDto> entery:medicineList.entrySet())
			{
				MedicineDto m=entery.getValue();
	System.out.println("name="+m.getName()+"\tpower="+m.getPower()+"quantity="+m.getQunatity());
			}
		}
	}
	@Override
	public void logout() {
		System.out.println("logout sccessfull");
		
		Mainclass.main(null);
		
		
	}
	

}
