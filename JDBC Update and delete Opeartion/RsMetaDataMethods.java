package Lab_day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class RsMetaDataMethods {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("oracle.jdbc.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from product");
        ResultSetMetaData rm=rs.getMetaData();
int col=rm.getColumnCount();
for(int i=1;i<=col;i++)
{
	System.out.println(rm.getColumnName(i)+" "+rm.getColumnTypeName(i));
	String tableName = rm.getTableName(i);
	boolean caseSen = rm.isCaseSensitive(i);
	boolean writable = rm.isWritable(i);
	System.out.println("table name="+tableName);
	System.out.println("case sensitive="+caseSen);
	System.out.println("writable="+writable);
}
	}

}
