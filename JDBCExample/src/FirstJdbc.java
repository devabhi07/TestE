import java.sql.*;
public class FirstJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try 
		{
			//load the driver:
			Class.forName("com.mysql.cj.jdbc.Driver");
			//creating a connection
			String url="jdbc:mysql://localhost:3306/idfc";
			String username="root";
			String password="root";
			Connection con=DriverManager.getConnection(url,username,password);
			//check database connection
			if(con.isClosed())
			{
				System.out.println("Connection is Closed");
			}else
			{
				System.out.println("Connection created...");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
