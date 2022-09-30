import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateTable {
	
	public static void main(String[] args) {
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. creating a connection
			String url="jdbc:mysql://localhost:3306/idfc";
			String username="root";
			String password="root";
			Connection con=DriverManager.getConnection(url,username,password);
			
			String q="update table1 set tName=?, tCity=? where tId=?";
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
			con.close();
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
