import java.sql.*;

public class showtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. creating a connection
			String url="jdbc:mysql://localhost:3306/idfc";
			String username="root";
			String password="root";
			Connection con=DriverManager.getConnection(url,username,password);
			
			String query="select * from table1";
			Statement stmt =con.createStatement();
			ResultSet set=stmt.executeQuery(query);
			
			while(set.next()) {
				int id=set.getInt(1);
				String name=set.getString(2);
				String city=set.getString(3);
				System.out.println(id + "<>"+name+"<>"+city);
			}
			con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
