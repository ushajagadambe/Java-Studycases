package la_jdbc_D1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Inserting_ex3 {

	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		int number=0;
		
		try {
               Class.forName("oracle.jdbc.OracleDriver");	
	      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "system","manager");
		Statement st=con.createStatement();
		for(int i=0;i<4;i++) {
			System.out.println("enter the pid");
			int id=sc.nextInt();
			System.out.println("enter the name");
			String name=sc.next();
			System.out.println("enter the price");
			int price=sc.nextInt();
			System.out.println("enter the quantity");
			int qua=sc.nextInt();
		 number=st.executeUpdate("insert into product values("+id+",' "+name+"',"+price+","+qua+")");
		System.out.println("record inserted");
		
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
               }catch(ClassNotFoundException e)
              {
               e.printStackTrace();
               }

System.out.println("number of records updated="+number);
	

	}
}
