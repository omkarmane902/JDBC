package packagejdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Driver {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc2", "postgres", "root");
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?)");
			ps.setInt(1, 1);
			ps.setString(2, "bapu");
			ps.setString(3, "20");
			ps.executeUpdate();
			con.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
