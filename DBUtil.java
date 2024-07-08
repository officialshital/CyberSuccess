package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public static Connection getConnect()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webProject","root","Shiv@2313");
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
}
