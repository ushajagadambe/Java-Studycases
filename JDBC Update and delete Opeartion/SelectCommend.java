package la_jdbc_D1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectCommend {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select * from product");
                while(rs.next()) {
	System.out.println("id="+rs.getInt(1)+"name="+rs.getString(2));
}
	}

}
