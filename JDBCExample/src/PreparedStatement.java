import java.sql.*;
import java.util.Scanner;
import java.io.*;

public class PreparedStatement {
	
	public static void main(String[] args) {
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
			String q="insert into table1(tName,tCity) values(?,?)";
			
			//get the PreparedStatement object
			//interface                  preparestatement
			java.sql.PreparedStatement pstmt=con.prepareStatement(q);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Name");
			String name=sc.next();
			System.out.println("Enetr City name");
			String city=sc.next();
			//set the values to query  static
			pstmt.setString(1,name);
			pstmt.setString(2,city);
			pstmt.executeUpdate();
			
			System.out.println("Inserted");
			con.close();
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
