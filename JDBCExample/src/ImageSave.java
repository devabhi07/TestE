import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImageSave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			//1. load the driver:
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. creating a connection
			String url="jdbc:mysql://localhost:3306/idfc";
			String username="root";
			String password="root";
			Connection con=DriverManager.getConnection(url,username,password);
			String q="insert into images(pic) values(?)";
			
			PreparedStatement pstmt=con.prepareStatement(q);
			FileInputStream fis=new FileInputStream("doubly-link.jpg");
//			pstmt=setBinaryStream(1,fis,fis.available());
			pstmt.executeUpdate();
			System.out.println("Image inseart..");
			
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
