import java.io.InputStreamReader;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AllJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			//1. Load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. creating a connection
			String url="jdbc:mysql://localhost:3306/idfc";
			String username="root";
			String password="root";
			Connection con=DriverManager.getConnection(url,username,password);
			
			
			
			System.out.println("Welcome JDBC");
			Scanner sc1=new Scanner(System.in);
			System.out.println("Press 1 to create table ");
			System.out.println("Press 2 to Add User");
			System.out.println("Press 3 to User Display");
			System.out.println("Press 4 to User Update");
			System.out.println("Press 5 to User Delete");
			System.out.println("Press 6 to Exit");
			while(true)
				{
				int c=sc1.nextInt();
				
			    if(c==1)
			    {
				//create database table
				String q="create table table3(tId int(20) primary key auto_increment,tName varchar(200) not null, tCity varchar(200))";
				//4. create a statement:
				Statement stmt=con.createStatement();
				stmt.executeUpdate(q);
				System.out.println("Table created in database>> ");	
			}
			else if(c==2)
			{
				//add user
				// create query
				String q="insert into table3(tName,tCity) values(?,?)";
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
			}
			else if(c==3)
			{
				//user display
				String query="select * from table3";
				Statement stmt =con.createStatement();
				ResultSet set=stmt.executeQuery(query);
				while(set.next()) {
					int id=set.getInt(1);
					String name=set.getString(2);
					String city=set.getString(3);
					System.out.println(id + " : "+name+" : "+city);
				}	
			}
			else if(c==4)
			{
				//user update
				String q="update table3 set tName=?, tCity=? where tId=?";
				Scanner sc=new Scanner(System.in);
				System.out.println("Enetr new Name:");
				String name=sc.next();
				System.out.println("Enter new City name:");
				String city=sc.next();
				System.out.println("Enter the Id:");
				int id=sc.nextInt();
				PreparedStatement pstmt=con.prepareStatement(q);
				pstmt.setString(1, name);
				pstmt.setString(2,city);
				pstmt.setInt(3, id);
				pstmt.executeUpdate();
				System.out.println("Update");
				
			}else if(c==5) {
				String q="delete from table3 where tId=?";
				
				Scanner sc=new Scanner(System.in);
				System.out.println("Enetr Id:");
				int id=sc.nextInt();
				PreparedStatement pstmt=con.prepareStatement(q);
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
				System.out.println("Delete");	
			}
			else if(c==6) {
				System.out.println("Exit");
				break;
			}
			else {	
			}
		}
			con.close();
		System.out.println("Thank you");	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
