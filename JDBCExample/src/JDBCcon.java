import java.sql.*;

public class JDBCcon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
		
		 Class.forName("com.mysql.jdbc.Driver");
		
				 
		 String user="root";
			String password="root";
			String url="jdbc:mysql://localhost:3306/idfc";
			
			
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st=con.createStatement();
			String sql="select * from employee";
			ResultSet rs=st.executeQuery(sql);
			ResultSetMetaData rm=rs.getMetaData();
			int col =rm.getColumnCount();
			while(rs.next()) {
				for(int i=1;i<col;i++)
				{
					System.out.print(rs.getString(i)+" ");
				}
				System.out.println();
			}
//			System.out.println(rs.getString(2));
			con.close();
			
//			System.out.println("inserting record");
//			String sql="Insert into users(id) values(2)";
//			
//			stmt.executeUpdate(sql);
		 
		}catch (Exception e)
		{
			e.printStackTrace();
			
		}
		
		

	}

}
