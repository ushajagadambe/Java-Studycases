package la_jdbc_D1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_Ex1 {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	Class.forName("oracle.jdbc.OracleDriver");
	System.out.println("driver class is loaded");
	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:XE","system","manager");
	System.out.println("executed");
	if(con!=null)
	{con.close();
		System.out.println("closed");
	}
}
}
