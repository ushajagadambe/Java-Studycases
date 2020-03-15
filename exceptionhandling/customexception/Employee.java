package customexception;

import java.util.Scanner;

public class Employee {
	int empyid;
	Role role;
	
	Employee(int empyid,Role role)
	{
		this.empyid=empyid;
		this.role=role;
	}
	
	void promoteTpCEo(String str)
	{
		String s=role.getRoleName(str);
		if(s==null||!(role.getRoleName(str).equals("manager")))
				{
			try {
				throw new CustomException("only manager can be promted");
			} catch (CustomException e) {
				e.printStackTrace();
			}
				}
			else
				System.out.println("ceo");
				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Role r=new Manger();
		Employee obj=new Employee(1001,r);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the roll name");
		String str=sc.next();
		obj.promoteTpCEo(str);
		
		
		

	}

}
