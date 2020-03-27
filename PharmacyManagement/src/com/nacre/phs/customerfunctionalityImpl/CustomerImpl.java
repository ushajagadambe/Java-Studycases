package com.nacre.phs.customerfunctionalityImpl;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import com.nacre.phs.adminfunctionalityImpl.AdminImpl;
import com.nacre.phs.customerfunctionalityI.*;
import com.nacre.phs.dto.CustomerDto;
import com.nacre.phs.dto.MedicineDto;
import com.nacre.phs.exceptions.MedicianOutOfStockException;
import com.nacre.phs.main.Mainclass;
public class CustomerImpl implements CustomerI {
	Scanner sc=new Scanner(System.in);
	static ConcurrentMap<CustomerDto,String> customerList=new ConcurrentHashMap<CustomerDto,String>();
	boolean regisration;
	List<MedicineDto> orderList=new ArrayList<MedicineDto>();

	
	void customerTask()
	{
		String ans;
		System.out.println("----welcome to customer----");
		do {
		
		System.out.println("1-placeOrderForMedicine\n2-view order\n3-logout\n4-exit");
		System.out.println("enter the choice");
		int ch=sc.nextInt();
		
		switch(ch)
		{
		case 1:placeOrderForMedician();
			break;
		case 2:viewOrder();
		break;
		case 3:logout();
		Mainclass.main(null);
		break;
		case 4:Mainclass.main(null);
		default:
			System.out.println("wrong input");
			customerTask();
		}
		System.out.println("do you want to continue if yes,press yes"+"for Quit press no");
		ans=sc.next();
		if(ans.equalsIgnoreCase("no"))
		{
			break;
		}
		}while(ans.equals("yes"));
		
		Mainclass.main(null);
		
	}
	public void registration() {
		CustomerDto c1=new CustomerDto();
		System.out.println("enter the customer-name");
		String name=sc.next();
		System.out.println("enter the password");
		String pass=sc.next();
		System.out.println("enter the address");
		String add=sc.next();
		System.out.println("enter teh phone number");
		int ph=sc.nextInt();
		c1.setName(name);
		c1.setPassword(pass);
		c1.setAddress(add);
		c1.setPhoneNumber(ph);
		
		for(Map.Entry<CustomerDto,String> entry:customerList.entrySet())
		{
			CustomerDto c=entry.getKey();
			if(c.getName().equals(name)&&c.getPassword().equals(pass))
			{
				System.out.println("----customer exits------already--login driectly---");
				firstTask();
			}
		}
		
		customerList.put(c1,name);
		regisration=true;
	
		customerTask();
		
		
		
		
	}
	
	public void firstTask()
	{
		System.out.println("1-login\n2-registration");
		System.out.println("enter the choice");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:login();
		break;
		case 2:registration();
		break;
		default:System.out.println("wrong input");
		firstTask();
		}
		
	}

	@Override
	public void login() {
		System.out.println("----login page-----");
		System.out.println("enter the customer-name");
		String username=sc.next();
		System.out.println("enter the password");
		String password=sc.next();
		
		//System.out.println(customerList);
		for(Map.Entry<CustomerDto,String> entry:customerList.entrySet())
		{
			CustomerDto c=entry.getKey();
			if(c.getName().equals(username)&&c.getPassword().equals(password))
			{
				System.out.println("----login successfull----");
				customerTask();
				
			}
		}
		
	
			if(regisration==true)
			{
				System.out.println("login failed--may be your password and username is login--");
				login();
			}
			else
			{
			System.out.println("----please go and first registration-----");	
			registration();
			}
			

	}

	@Override
	public void placeOrderForMedician() {
	if(AdminImpl.medicineList==null) {
		System.out.println("enter the name of medicine");
		String name=sc.next();
		MedicineDto order=new MedicineDto();
		order.SetName(name);

		int count=0;
	
		for(Map.Entry<String,MedicineDto> entery:AdminImpl.medicineList.entrySet())
		{
			MedicineDto m=entery.getValue();
		
			orderList.add(order);
			if(m.getName().equals(name))
			{
				System.out.println("medicine available");
				System.out.println("enter the qunatity of medicine");
				int quantity=sc.nextInt();
				order.setQunatity(quantity);
				if(quantity>m.getQunatity())
				{
					System.out.println("no enough medicine"+"avaiable stock="+m.getQunatity());
				}
				
				
				count++;
			}
			
		}
			
			
		
		
		if(count==0) {
			try {
				throw new MedicianOutOfStockException("medicine out of stack");
			} catch (MedicianOutOfStockException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		
	}
	else
	{
		System.out.println("No stock");
	}
	}

	@Override
	public void viewOrder() {
		int number=1;
		if(orderList.isEmpty())
		{
			System.out.println("no orders");
		}
		else
		{
		Iterator<MedicineDto> it=orderList.iterator();
		while(it.hasNext())
		{
			MedicineDto m=it.next();
			System.out.println(number+" "+m.getName()+" "+m.getQunatity());
			number++;
		}
		}
		
	}

	@Override
	public void logout() {
	System.out.println("-------logout sucessfull----");
		
	}

}
