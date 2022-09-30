import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class deletetable_data {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. creating a connection
			String url="jdbc:mysql://localhost:3306/idfc";
			String username="root";
			String password="root";
			Connection con=DriverManager.getConnection(url,username,password);
			String q="delete from table1 where tId=?";
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enetr Id:");
			int id=sc.nextInt();
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			System.out.println("Delete");
			con.close();
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
