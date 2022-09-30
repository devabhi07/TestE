import java.sql.*;

public class JDBC_Connection {
	
	public static void main(String[] args)throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2. creating a connection
		String url="jdbc:mysql://localhost:3306/idfc";
		String username="root";
		String password="root";
		Connection con=DriverManager.getConnection(url,username,password);
	}
	

}
