package Lab_day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountRecordsUsingPreparedStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
		//String query = "select count(*) from tableName";
		PreparedStatement pst=con.prepareStatement("select count(*) from emp");
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
		 int numberOfRows = rs.getInt(1);
                 System.out.println("numberOfRows= " + numberOfRows);
			} 
		else { 
                System.out.println("error: could not get the record counts");
		}
	}
		
}
