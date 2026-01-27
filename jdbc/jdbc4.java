package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbc4 {
	
	
	public static void main(String[] args) {
		
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con  = DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp", "postgres", "root");
			
			
			PreparedStatement ps = con.prepareStatement("insert into student values (?,?,?,?)");
			
			
			ps.setInt(1, 15);
			
			ps.setString(2, "amit");
			
			ps.setDouble(3, 24000000.0);
			
			ps.setLong(4, 7744872805l);
			
			
			
			ps.execute();
			System.out.println(ps);
			
			
			con.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
