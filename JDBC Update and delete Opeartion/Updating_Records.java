package la_jdbc_D1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Updating_Records {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
		Statement st=con.createStatement();
		int i=st.executeUpdate("update product set price=4000 where pid=101");
		System.out.println("number of records updated"+ "="+i);
                con.close();
                st.close();
	}

}
