
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
public class CreateTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try 
		{
			//1. load the driver:
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. creating a connection
			String url="jdbc:mysql://localhost:3306/idfc";
			String username="root";
			String password="root";
			Connection con=DriverManager.getConnection(url,username,password);
			//3. create query
			String q="create table table1(tId int(20) primary key auto_increment,tName varchar(200) not null, tCity varchar(200))";
			
			
			//4. create a statement:
			Statement stmt=con.createStatement();
			stmt.executeUpdate(q);
			System.out.println("Table created in database>> ");
			con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
